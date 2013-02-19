/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.contactproperty;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class CustomContactPropertyGroup {

	private String name;
	private String displayName;
	private Integer displayOrder;
	private Long portalId;
	private List<CustomContactProperty> properties;
	
	@JsonProperty
	public String getName() {
		return name;
	}
	
	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public String getDisplayName() {
		return displayName;
	}
	
	@JsonProperty
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	@JsonProperty
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	
	@JsonProperty
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
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
	public List<CustomContactProperty> getProperties() {
		return properties;
	}
	
	@JsonProperty
	public void setProperties(List<CustomContactProperty> properties) {
		this.properties = properties;
	}
}
