/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HubSpotListAddContactToListResponse {
	
	private List<Integer> discarded;
	private List<Integer> updated;
	
	@JsonProperty
	public List<Integer> getDiscarded() {
		return discarded;
	}
	
	@JsonProperty
	public void setDiscarded(List<Integer> discarded) {
		this.discarded = discarded;
	}
	
	@JsonProperty
	public List<Integer> getUpdated() {
		return updated;
	}
	
	@JsonProperty
	public void setUpdated(List<Integer> updated) {
		this.updated = updated;
	}
}
