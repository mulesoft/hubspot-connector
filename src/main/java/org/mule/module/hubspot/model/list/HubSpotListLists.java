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

@JsonIgnoreProperties(ignoreUnknown = true)
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
