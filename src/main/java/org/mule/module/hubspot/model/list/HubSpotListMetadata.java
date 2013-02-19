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
public class HubSpotListMetadata {
	
	private Integer size;
	private Long lastSizeChangeAt;
	private String processing;
	private Long lastProcessingStateChangeAt;
	private String error;
	
	@JsonProperty
	public Integer getSize() {
		return size;
	}
	
	@JsonProperty
	public void setSize(Integer size) {
		this.size = size;
	}
	
	@JsonProperty
	public Long getLastSizeChangeAt() {
		return lastSizeChangeAt;
	}
	
	@JsonProperty
	public void setLastSizeChangeAt(Long lastSizeChangeAt) {
		this.lastSizeChangeAt = lastSizeChangeAt;
	}
	
	@JsonProperty
	public String getProcessing() {
		return processing;
	}
	
	@JsonProperty
	public void setProcessing(String processing) {
		this.processing = processing;
	}
	
	@JsonProperty
	public Long getLastProcessingStateChangeAt() {
		return lastProcessingStateChangeAt;
	}
	
	@JsonProperty
	public void setLastProcessingStateChangeAt(Long lastProcessingStateChangeAt) {
		this.lastProcessingStateChangeAt = lastProcessingStateChangeAt;
	}
	
	@JsonProperty
	public String getError() {
		return error;
	}
	
	@JsonProperty
	public void setError(String error) {
		this.error = error;
	}
}
