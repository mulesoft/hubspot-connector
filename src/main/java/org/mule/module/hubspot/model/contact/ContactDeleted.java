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
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class ContactDeleted {
	
	private Boolean deleted;
	private String vid;
	
	@JsonProperty
	public Boolean getDeleted() {
		return deleted;
	}
	
	@JsonProperty
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	@JsonProperty
	public String getVid() {
		return vid;
	}
	
	@JsonProperty
	public void setVid(String vid) {
		this.vid = vid;
	}
	
	
}
