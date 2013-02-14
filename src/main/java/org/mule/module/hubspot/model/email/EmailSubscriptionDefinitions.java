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
public class EmailSubscriptionDefinitions {
	
	private Boolean active;
	private Long portalId;
	private String description;
	private Long id;
	private String name;
	
	@JsonProperty
	public Boolean getActive() {
		return active;
	}
	
	@JsonProperty
	public void setActive(Boolean active) {
		this.active = active;
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
	public String getDescription() {
		return description;
	}
	
	@JsonProperty
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty
	public Long getId() {
		return id;
	}
	
	@JsonProperty
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty
	public String getName() {
		return name;
	}
	
	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}
}
