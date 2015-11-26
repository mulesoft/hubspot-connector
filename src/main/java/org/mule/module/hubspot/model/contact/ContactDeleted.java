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
public class ContactDeleted {

    private Boolean deleted;
    private String vid;

    @JsonProperty
    public Boolean getDeleted() {
        return deleted;
    }

    @JsonProperty
    public void setDeleted(final Boolean deleted) {
        this.deleted = deleted;
    }

    @JsonProperty
    public String getVid() {
        return vid;
    }

    @JsonProperty
    public void setVid(final String vid) {
        this.vid = vid;
    }

}
