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
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class ContactIdentityProfiles {

    private Long vid;
    private List<ContactIdentity> identities;

    @JsonProperty
    public Long getVid() {
        return vid;
    }

    @JsonProperty
    public void setVid(final Long vid) {
        this.vid = vid;
    }

    @JsonProperty
    public List<ContactIdentity> getIdentities() {
        return identities;
    }

    @JsonProperty
    public void setIdentities(final List<ContactIdentity> identities) {
        this.identities = identities;
    }
}
