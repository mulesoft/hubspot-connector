/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.contact;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class ContactListMembership {

    private Integer internalListId;
    private Long timestamp;
    private Long vid;

    @JsonProperty("internal-list-id")
    public Integer getInternalListId() {
        return internalListId;
    }

    @JsonProperty("internal-list-id")
    public void setInternalListId(final Integer internalListId) {
        this.internalListId = internalListId;
    }

    @JsonProperty
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty
    public void setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty
    public Long getVid() {
        return vid;
    }

    @JsonProperty
    public void setVid(final Long vid) {
        this.vid = vid;
    }
}
