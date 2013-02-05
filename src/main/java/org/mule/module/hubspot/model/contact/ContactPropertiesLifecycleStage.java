package org.mule.module.hubspot.model.contact;

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
	
	public String getValue() {
		return value;
	}
	
	
	static public ContactPropertiesLifecycleStage getFromString(String value) {
		for (ContactPropertiesLifecycleStage obj : ContactPropertiesLifecycleStage.values()) {
			if (obj.getValue().equalsIgnoreCase(value)) {
				return obj;
			}
		}
		return null;
	}
}
