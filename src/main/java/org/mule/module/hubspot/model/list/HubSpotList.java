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
public class HubSpotList {

	private String portalId;
	private String listId;
	private String internalListId;
	private Long createdAt;
	private Long updatedAt;
	private Boolean dynamic;
	private Boolean deleted;
	private String name;
	private Boolean internal;
	private HubSpotListMetadata metaData;
	private List<List<HubSpotListFilter>> filters;
	
	@JsonProperty
	public String getPortalId() {
		return portalId;
	}
	
	@JsonProperty
	public void setPortalId(String portalId) {
		this.portalId = portalId;
	}
	
	@JsonProperty
	public String getListId() {
		return listId;
	}
	
	@JsonProperty
	public void setListId(String listId) {
		this.listId = listId;
	}
	
	@JsonProperty
	public String getInternalListId() {
		return internalListId;
	}
	
	@JsonProperty
	public void setInternalListId(String internalListId) {
		this.internalListId = internalListId;
	}
	
	@JsonProperty
	public Long getCreatedAt() {
		return createdAt;
	}
	
	@JsonProperty
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	
	@JsonProperty
	public Long getUpdatedAt() {
		return updatedAt;
	}
	
	@JsonProperty
	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@JsonProperty
	public Boolean getDynamic() {
		return dynamic;
	}
	
	@JsonProperty
	public void setDynamic(Boolean dynamic) {
		this.dynamic = dynamic;
	}
	
	@JsonProperty
	public Boolean getDeleted() {
		return deleted;
	}
	
	@JsonProperty
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	@JsonProperty
	public String getName() {
		return name;
	}
	
	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public Boolean getInternal() {
		return internal;
	}
	
	@JsonProperty
	public void setInternal(Boolean internal) {
		this.internal = internal;
	}

	@JsonProperty
	public HubSpotListMetadata getMetaData() {
		return metaData;
	}

	@JsonProperty
	public void setMetaData(HubSpotListMetadata metaData) {
		this.metaData = metaData;
	}	
	
	@JsonProperty
	public List<List<HubSpotListFilter>> getFilters() {
		return filters;
	}

	@JsonProperty
	public void setFilters(List<List<HubSpotListFilter>> filters) {
		this.filters = filters;
	}	
}