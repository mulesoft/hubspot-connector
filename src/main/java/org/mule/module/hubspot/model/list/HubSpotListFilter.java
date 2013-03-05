/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.list;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class HubSpotListFilter {

	private String operator;
	private String list;
	private String value;
	private String property;
	private String type;

	@JsonProperty
	public String getList() {
		return list;
	}
	
	@JsonProperty
	public void setList(String list) {
		this.list = list;
	}

	@JsonProperty
	public String getOperator() {
		return operator;
	}

	@JsonProperty
	public void setOperator(String operator) {
		this.operator = operator;
	}

	@JsonProperty
	public String getValue() {
		return value;
	}
	
	@JsonProperty
	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty
	public String getProperty() {
		return property;
	}

	@JsonProperty
	public void setProperty(String property) {
		this.property = property;
	}

	@JsonProperty
	public String getType() {
		return type;
	}

	
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
