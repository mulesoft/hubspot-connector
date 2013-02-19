/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.contactproperty;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum CustomContactPropertyType {
	STRING("string"),
	NUMBER("number"),
	BOOL("bool"),
	DATETIME("datetime"),
	ENUMERATION("enumeration");
	
	private String value;
	
	private CustomContactPropertyType(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() {
		return value;
	}
	
	
	@JsonCreator
	static public CustomContactPropertyType getFromString(String value) {
		for (CustomContactPropertyType obj : CustomContactPropertyType.values()) {
			if (obj.getValue().equalsIgnoreCase(value)) {
				return obj;
			}
		}
		return null;
	}
}
