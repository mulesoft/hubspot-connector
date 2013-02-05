package org.mule.module.hubspot.model.contact;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactStatistics {
	private Long lastNewContactAt;
	private Long contacts;
	
	@JsonProperty
	public Long getLastNewContactAt() {
		return lastNewContactAt;
	}
	
	@JsonProperty
	public void setLastNewContactAt(Long lastNewContactAt) {
		this.lastNewContactAt = lastNewContactAt;
	}
	
	@JsonProperty
	public Long getContacts() {
		return contacts;
	}
	
	@JsonProperty
	public void setContacts(Long contacts) {
		this.contacts = contacts;
	}
}