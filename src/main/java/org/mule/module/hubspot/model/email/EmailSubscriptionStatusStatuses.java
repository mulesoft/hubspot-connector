/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.email;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class EmailSubscriptionStatusStatuses {

	private Long id;
	private Boolean subscribed;
	
	@JsonProperty
	public Long getId() {
		return id;
	}
	
	@JsonProperty
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty
	public Boolean getSubscribed() {
		return subscribed;
	}
	
	@JsonProperty
	public void setSubscribed(Boolean subscribed) {
		this.subscribed = subscribed;
	}	
}
