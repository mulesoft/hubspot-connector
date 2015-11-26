/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
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
    public void setSize(final Integer size) {
        this.size = size;
    }

    @JsonProperty
    public Long getLastSizeChangeAt() {
        return lastSizeChangeAt;
    }

    @JsonProperty
    public void setLastSizeChangeAt(final Long lastSizeChangeAt) {
        this.lastSizeChangeAt = lastSizeChangeAt;
    }

    @JsonProperty
    public String getProcessing() {
        return processing;
    }

    @JsonProperty
    public void setProcessing(final String processing) {
        this.processing = processing;
    }

    @JsonProperty
    public Long getLastProcessingStateChangeAt() {
        return lastProcessingStateChangeAt;
    }

    @JsonProperty
    public void setLastProcessingStateChangeAt(final Long lastProcessingStateChangeAt) {
        this.lastProcessingStateChangeAt = lastProcessingStateChangeAt;
    }

    @JsonProperty
    public String getError() {
        return error;
    }

    @JsonProperty
    public void setError(final String error) {
        this.error = error;
    }
}
