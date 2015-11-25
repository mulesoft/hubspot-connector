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
public class ContactIdentity {

    private String type;
    private String value;
    private Long timestamp;

    @JsonProperty
    public String getType() {
        return type;
    }

    @JsonProperty
    public void setType(final String type) {
        this.type = type;
    }

    @JsonProperty
    public String getValue() {
        return value;
    }

    @JsonProperty
    public void setValue(final String value) {
        this.value = value;
    }

    @JsonProperty
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty
    public void setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
    }
}
