/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.contact;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum ContactPropertiesLifecycleStage {
	SUBSCRIBER("subscriber"),
	LEAD("lead"),
	MARKETING_QUALIFIED_LEAD("marketingqualifiedlead"),
	SALES_QUALIFIED_LEAD("salesqualifiedlead"),
	OPORTUNITY("opportunity"),
	CUSTOMER("customer"),
	EVANGELIST("evangelist"),
	OTHER("other");
	
	private String value;
	
	private ContactPropertiesLifecycleStage(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() {
		return value;
	}
	
	
	@JsonCreator
	static public ContactPropertiesLifecycleStage getFromString(String value) {
		for (ContactPropertiesLifecycleStage obj : ContactPropertiesLifecycleStage.values()) {
			if (obj.getValue().equalsIgnoreCase(value)) {
				return obj;
			}
		}
		return null;
	}
}
