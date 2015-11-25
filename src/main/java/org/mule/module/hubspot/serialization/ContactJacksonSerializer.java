/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
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

		if (value == null) return;
		
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
				
				// For custom properties
				if ("customProperties".equals(pd.getName())) {
					if (value.getCustomProperties() != null) {
						for (String key : value.getCustomProperties().keySet()) {
							jgen.writeStartObject();
							jgen.writeStringField("property", key);
							jgen.writeStringField("value", value.getCustomProperties().get(key));
							jgen.writeEndObject();
						}
					}
				} else {
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
		}	
		
		jgen.writeEndArray();
	}

}