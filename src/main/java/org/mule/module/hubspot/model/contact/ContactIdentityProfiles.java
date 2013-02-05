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

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactIdentityProfiles {
	private Long vid;
	private List<ContactIdentity> identities;
	
	@JsonProperty
	public Long getVid() {
		return vid;
	}
	
	@JsonProperty
	public void setVid(Long vid) {
		this.vid = vid;
	}
	
	@JsonProperty
	public List<ContactIdentity> getIdentities() {
		return identities;
	}
	
	@JsonProperty
	public void setIdentities(List<ContactIdentity> identities) {
		this.identities = identities;
	}
}
