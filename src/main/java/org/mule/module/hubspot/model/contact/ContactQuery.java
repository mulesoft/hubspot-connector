/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
	public void setHasMore(Boolean hasMore) {
		this.hasMore = hasMore;
	}

	@JsonProperty
	public List<Contact> getContacts() {
		return contacts;
	}

	@JsonProperty
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@JsonProperty
	public Long getOffset() {
		return offset;
	}

	@JsonProperty
	public void setOffset(Long offset) {
		this.offset = offset;
	}

	@JsonProperty
	public Integer getResults() {
		return results;
	}

	@JsonProperty
	public void setResults(Integer results) {
		this.results = results;
	}

	@JsonProperty
	public String getQuery() {
		return query;
	}

	@JsonProperty
	public void setQuery(String query) {
		this.query = query;
	}
	
}
