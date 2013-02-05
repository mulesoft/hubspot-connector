package org.mule.module.hubspot.model.contact;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactList {

	private List<Contact> contacts;
	private Boolean hasMore;
	private Long vidOffset;
	private Long timeOffset;

	public ContactList() {
	}

	@JsonProperty("has-more")
	public Boolean getHasMore() {
		return hasMore;
	}

	@JsonProperty("has-more")
	public void setHasMore(Boolean hasMore) {
		this.hasMore = hasMore;
	}

	@JsonProperty("vid-offset")
	public Long getVidOffset() {
		return vidOffset;
	}

	@JsonProperty("vid-offset")
	public void setVidOffset(Long vidOffset) {
		this.vidOffset = vidOffset;
	}

	@JsonProperty
	public List<Contact> getContacts() {
		return contacts;
	}

	@JsonProperty
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@JsonProperty("time-offset")
	public Long getTimeOffset() {
		return timeOffset;
	}

	@JsonProperty("time-offset")
	public void setTimeOffset(Long timeOffset) {
		this.timeOffset = timeOffset;
	}
}