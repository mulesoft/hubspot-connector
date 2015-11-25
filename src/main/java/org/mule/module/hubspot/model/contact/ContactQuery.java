/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.contact;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class ContactQuery {

    private List<Contact> contacts;
    private Boolean hasMore;
    private Long offset;
    private Integer results;
    private String query;

    @JsonProperty("has-more")
    public Boolean getHasMore() {
        return hasMore;
    }

    @JsonProperty("has-more")
    public void setHasMore(final Boolean hasMore) {
        this.hasMore = hasMore;
    }

    @JsonProperty
    public List<Contact> getContacts() {
        return contacts;
    }

    @JsonProperty
    public void setContacts(final List<Contact> contacts) {
        this.contacts = contacts;
    }

    @JsonProperty
    public Long getOffset() {
        return offset;
    }

    @JsonProperty
    public void setOffset(final Long offset) {
        this.offset = offset;
    }

    @JsonProperty
    public Integer getResults() {
        return results;
    }

    @JsonProperty
    public void setResults(final Integer results) {
        this.results = results;
    }

    @JsonProperty
    public String getQuery() {
        return query;
    }

    @JsonProperty
    public void setQuery(final String query) {
        this.query = query;
    }

}
