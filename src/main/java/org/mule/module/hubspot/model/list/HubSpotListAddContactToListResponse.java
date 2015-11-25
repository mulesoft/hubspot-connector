/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
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
