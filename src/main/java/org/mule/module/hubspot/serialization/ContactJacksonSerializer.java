/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.serialization;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.mule.module.hubspot.model.contact.ContactProperties;
import org.mule.module.hubspot.model.contact.ContactPropertiesLifecycleStage;
import org.mule.module.hubspot.model.contact.ContactPropertiesNumberOfEmployees;


public class ContactJacksonSerializer extends JsonSerializer<ContactProperties> {

	@Override
	public void serialize(ContactProperties value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		PropertyDescriptor[] propertyDescriptor;
		try {
			propertyDescriptor = Introspector.getBeanInfo(ContactProperties.class).getPropertyDescriptors();
		} catch (IntrospectionException e) {
			throw new IOException(e);
		}
		
		Object propVal;

		jgen.writeStartArray();
		
		for (PropertyDescriptor pd : propertyDescriptor) {			
			// Check that has a read method for properties
			if (pd.getReadMethod() != null && !"class".equals(pd.getName())) {
				try {
					propVal = pd.getReadMethod().invoke(value);
				} catch (Exception e) {
					throw new IOException(e);
				}
				
				if (propVal != null) {
					jgen.writeStartObject();
					jgen.writeStringField("property", pd.getName());
					
					if (propVal instanceof Long) {						
						jgen.writeNumberField("value", (Long) propVal);
					} else if (propVal instanceof String) {
						jgen.writeStringField("value", (String) propVal);
					} else if (propVal instanceof ContactPropertiesLifecycleStage) {
						jgen.writeStringField("value", ((ContactPropertiesLifecycleStage) propVal).getValue());
					} else if (propVal instanceof ContactPropertiesNumberOfEmployees) {
						jgen.writeStringField("value", ((ContactPropertiesNumberOfEmployees) propVal).getValue());
					} 
					
					jgen.writeEndObject();
				}
			}
		}	
		
		jgen.writeEndArray();
	}

}