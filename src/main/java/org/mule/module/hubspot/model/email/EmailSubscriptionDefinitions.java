/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
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
