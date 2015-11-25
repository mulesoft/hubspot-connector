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
    public void setPortalId(final String portalId) {
        this.portalId = portalId;
    }

    @JsonProperty
    public String getListId() {
        return listId;
    }

    @JsonProperty
    public void setListId(final String listId) {
        this.listId = listId;
    }

    @JsonProperty
    public String getInternalListId() {
        return internalListId;
    }

    @JsonProperty
    public void setInternalListId(final String internalListId) {
        this.internalListId = internalListId;
    }

    @JsonProperty
    public Long getCreatedAt() {
        return createdAt;
    }

    @JsonProperty
    public void setCreatedAt(final Long createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty
    public Long getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty
    public void setUpdatedAt(final Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty
    public Boolean getDynamic() {
        return dynamic;
    }

    @JsonProperty
    public void setDynamic(final Boolean dynamic) {
        this.dynamic = dynamic;
    }

    @JsonProperty
    public Boolean getDeleted() {
        return deleted;
    }

    @JsonProperty
    public void setDeleted(final Boolean deleted) {
        this.deleted = deleted;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(final String name) {
        this.name = name;
    }

    @JsonProperty
    public Boolean getInternal() {
        return internal;
    }

    @JsonProperty
    public void setInternal(final Boolean internal) {
        this.internal = internal;
    }

    @JsonProperty
    public HubSpotListMetadata getMetaData() {
        return metaData;
    }

    @JsonProperty
    public void setMetaData(final HubSpotListMetadata metaData) {
        this.metaData = metaData;
    }

    @JsonProperty
    public List<List<HubSpotListFilter>> getFilters() {
        return filters;
    }

    @JsonProperty
    public void setFilters(final List<List<HubSpotListFilter>> filters) {
        this.filters = filters;
    }
}