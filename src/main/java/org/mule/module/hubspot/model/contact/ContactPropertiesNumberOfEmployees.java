/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.contact;

public enum ContactPropertiesNumberOfEmployees {
	_1_5("1-5"),
	_5_25("5-25"),
	_25_50("25-50"),
	_50_100("50-100"),
	_100_500("100-500"),
	_500_1000("500-1000"),
	_1000plus("1000+");
	
	private String value;
	
	private ContactPropertiesNumberOfEmployees(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	/**
	 * Transforms a number to a corresponding enum within range
	 * 
	 * @param number The number to use as reference
	 * @return The enum containing the number in range, or null if the number does not match any range
	 */
	static public ContactPropertiesNumberOfEmployees getFromInteger(Integer number) {
		if (number >= 1 && number <= 5) {
			return ContactPropertiesNumberOfEmployees._1_5;
		} else if (number > 5 && number <= 25) {
			return ContactPropertiesNumberOfEmployees._5_25;
		} else if (number > 25 && number <= 50) {
			return ContactPropertiesNumberOfEmployees._25_50;
		} else if (number > 50 && number <= 100) {
			return ContactPropertiesNumberOfEmployees._50_100;
		} else if (number > 100 && number <= 500) {
			return ContactPropertiesNumberOfEmployees._100_500;
		} else if (number > 500 && number <= 1000) {
			return ContactPropertiesNumberOfEmployees._500_1000;
		} else if (number > 1000) {
			return ContactPropertiesNumberOfEmployees._1000plus;
		} else {
			return null;
		}
	}
	
	static public ContactPropertiesNumberOfEmployees getFromString(String value) {
		for (ContactPropertiesNumberOfEmployees obj : ContactPropertiesNumberOfEmployees.values()) {
			if (obj.getValue().equalsIgnoreCase(value)) {
				return obj;
			}
		}
		return null;
	}
}
