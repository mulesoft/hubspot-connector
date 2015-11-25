/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.email;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class EmailSubscriptionStatus {
	
	private Boolean subscribed;
	private Boolean markedAsSpam;
	private Long portalId;
	private Boolean bounced;
	private String email;
	private List<EmailSubscriptionStatusStatuses> subscriptionStatuses;
	
	@JsonProperty
	public Boolean getSubscribed() {
		return subscribed;
	}
	
	@JsonProperty
	public void setSubscribed(Boolean subscribed) {
		this.subscribed = subscribed;
	}
	
	@JsonProperty
	public Boolean getMarkedAsSpam() {
		return markedAsSpam;
	}
	
	@JsonProperty
	public void setMarkedAsSpam(Boolean markedAsSpam) {
		this.markedAsSpam = markedAsSpam;
	}
	
	@JsonProperty
	public Long getPortalId() {
		return portalId;
	}
	
	@JsonProperty
	public void setPortalId(Long portalId) {
		this.portalId = portalId;
	}
	
	@JsonProperty
	public Boolean getBounced() {
		return bounced;
	}
	
	@JsonProperty
	public void setBounced(Boolean bounced) {
		this.bounced = bounced;
	}
	
	@JsonProperty
	public String getEmail() {
		return email;
	}
	
	@JsonProperty
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty
	public List<EmailSubscriptionStatusStatuses> getSubscriptionStatuses() {
		return subscriptionStatuses;
	}
	
	@JsonProperty
	public void setSubscriptionStatuses(
			List<EmailSubscriptionStatusStatuses> subscriptionStatuses) {
		this.subscriptionStatuses = subscriptionStatuses;
	}
}
