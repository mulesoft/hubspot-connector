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

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class HubSpotListLists {

	private Integer offset;
	private Boolean hasMore;
	private List<HubSpotList> lists;
	
	@JsonProperty
	public Integer getOffset() {
		return offset;
	}
	
	@JsonProperty
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	@JsonProperty("has-more")
	public Boolean getHasMore() {
		return hasMore;
	}
	
	@JsonProperty("has-more")
	public void setHasMore(Boolean hasMore) {
		this.hasMore = hasMore;
	}
	
	@JsonProperty
	public List<HubSpotList> getLists() {
		return lists;
	}
	
	@JsonProperty
	public void setLists(List<HubSpotList> lists) {
		this.lists = lists;
	}
}
