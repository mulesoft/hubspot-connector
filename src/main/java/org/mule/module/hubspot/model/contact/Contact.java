/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
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

    public Contact() {
    }

    @JsonProperty("properties")
    @JsonSerialize(using = ContactJacksonSerializer.class)
    public ContactProperties getContactProperties() {
        return contactProperties;
    }

    @JsonProperty("properties")
    @JsonDeserialize(using = ContactJacksonDeserializer.class)
    public void setContactProperties(final ContactProperties contactProperties) {
        this.contactProperties = contactProperties;
    }

    @JsonProperty
    public String getVid() {
        return vid;
    }

    @JsonProperty
    public void setVid(final String vid) {
        this.vid = vid;
    }

    @JsonProperty
    public Long getAddedAt() {
        return addedAt;
    }

    @JsonProperty
    public void setAddedAt(final Long addedAt) {
        this.addedAt = addedAt;
    }

    @JsonProperty("list-memberships")
    public List<ContactListMembership> getListMemberships() {
        return listMemberships;
    }

    @JsonProperty("list-memberships")
    public void setListMemberships(final List<ContactListMembership> listMemberships) {
        this.listMemberships = listMemberships;
    }

    @JsonProperty("identity-profiles")
    public List<ContactIdentityProfiles> getIdentityProfiles() {
        return identityProfiles;
    }

    @JsonProperty("identity-profiles")
    public void setIdentityProfiles(final List<ContactIdentityProfiles> identityProfiles) {
        this.identityProfiles = identityProfiles;
    }

    @JsonProperty("portal-id")
    public Long getPortalId() {
        return portalId;
    }

    @JsonProperty("portal-id")
    public void setPortalId(final Long portalId) {
        this.portalId = portalId;
    }

    @JsonProperty("profile-token")
    public String getProfileToken() {
        return profileToken;
    }

    @JsonProperty("profile-token")
    public void setProfileToken(final String profileToken) {
        this.profileToken = profileToken;
    }

    @JsonProperty("profile-url")
    public String getProfileUrl() {
        return profileUrl;
    }

    @JsonProperty("profile-url")
    public void setProfileUrl(final String profileUrl) {
        this.profileUrl = profileUrl;
    }
}