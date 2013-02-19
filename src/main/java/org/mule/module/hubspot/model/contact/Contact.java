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
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.mule.module.hubspot.serialization.ContactJacksonDeserializer;
import org.mule.module.hubspot.serialization.ContactJacksonSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class Contact {

	private ContactProperties contactProperties;
	private List<ContactListMembership> listMemberships;
	private List<ContactIdentityProfiles> identityProfiles;
	private String vid;
	private Long addedAt;
	private Long portalId;
	private String profileToken;
	private String profileUrl;
	
	public Contact() {}

	@JsonProperty("properties")
	@JsonSerialize(using = ContactJacksonSerializer.class)
	public ContactProperties getContactProperties() {
		return contactProperties;
	}

	@JsonProperty("properties")	
	@JsonDeserialize(using = ContactJacksonDeserializer.class)
	public void setContactProperties(ContactProperties contactProperties) {
		this.contactProperties = contactProperties;
	}

	@JsonProperty
	public String getVid() {
		return vid;
	}

	@JsonProperty
	public void setVid(String vid) {
		this.vid = vid;
	}

	@JsonProperty
	public Long getAddedAt() {
		return addedAt;
	}

	@JsonProperty
	public void setAddedAt(Long addedAt) {
		this.addedAt = addedAt;
	}

	@JsonProperty("list-memberships")
	public List<ContactListMembership> getListMemberships() {
		return listMemberships;
	}

	@JsonProperty("list-memberships")
	public void setListMemberships(List<ContactListMembership> listMemberships) {
		this.listMemberships = listMemberships;
	}

	@JsonProperty("identity-profiles")
	public List<ContactIdentityProfiles> getIdentityProfiles() {
		return identityProfiles;
	}

	@JsonProperty("identity-profiles")
	public void setIdentityProfiles(List<ContactIdentityProfiles> identityProfiles) {
		this.identityProfiles = identityProfiles;
	}

	@JsonProperty("portal-id")
	public Long getPortalId() {
		return portalId;
	}

	@JsonProperty("portal-id")
	public void setPortalId(Long portalId) {
		this.portalId = portalId;
	}

	@JsonProperty("profile-token")
	public String getProfileToken() {
		return profileToken;
	}

	@JsonProperty("profile-token")
	public void setProfileToken(String profileToken) {
		this.profileToken = profileToken;
	}

	@JsonProperty("profile-url")
	public String getProfileUrl() {
		return profileUrl;
	}

	@JsonProperty("profile-url")
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}	
}