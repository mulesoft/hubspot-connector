/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.contact;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactIdentity {
	private String type;
	private String value;
	private Long timestamp;
	
	@JsonProperty
	public String getType() {
		return type;
	}
	
	@JsonProperty
	public void setType(String type) {
		this.type = type;
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
	public Long getTimestamp() {
		return timestamp;
	}
	
	@JsonProperty
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
