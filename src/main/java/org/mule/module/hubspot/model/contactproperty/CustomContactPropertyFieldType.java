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

public enum CustomContactPropertyFieldType {
	TEXTAREA("textarea"),
	SELECT("select"),
	TEXT("text"),
	DATE("date"),
	FILE("file"),
	NUMBER("number"),
	RADIO("radio"),
	CHECKBOX("checkbox");
	
	private String value;
	
	private CustomContactPropertyFieldType(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() {
		return value;
	}
	
	
	@JsonCreator
	static public CustomContactPropertyFieldType getFromString(String value) {
		for (CustomContactPropertyFieldType obj : CustomContactPropertyFieldType.values()) {
			if (obj.getValue().equalsIgnoreCase(value)) {
				return obj;
			}
		}
		return null;
	}
}
