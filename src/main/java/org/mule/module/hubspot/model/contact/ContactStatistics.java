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
public class ContactStatistics {

    private Long lastNewContactAt;
    private Long contacts;

    @JsonProperty
    public Long getLastNewContactAt() {
        return lastNewContactAt;
    }

    @JsonProperty
    public void setLastNewContactAt(final Long lastNewContactAt) {
        this.lastNewContactAt = lastNewContactAt;
    }

    @JsonProperty
    public Long getContacts() {
        return contacts;
    }

    @JsonProperty
    public void setContacts(final Long contacts) {
        this.contacts = contacts;
    }
}