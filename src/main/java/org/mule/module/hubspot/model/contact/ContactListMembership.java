/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.contact;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactListMembership {
	private Integer internalListId;
	private Long timestamp;
	private Long vid;
	
	
	@JsonProperty("internal-list-id")
	public Integer getInternalListId() {
		return internalListId;
	}
	
	@JsonProperty("internal-list-id")
	public void setInternalListId(Integer internalListId) {
		this.internalListId = internalListId;
	}
	
	@JsonProperty
	public Long getTimestamp() {
		return timestamp;
	}
	
	@JsonProperty
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	@JsonProperty
	public Long getVid() {
		return vid;
	}
	
	@JsonProperty
	public void setVid(Long vid) {
		this.vid = vid;
	}
}
