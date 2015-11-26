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
public class HubSpotListFilter {

    private String operator;
    private String list;
    private String value;
    private String property;
    private String type;

    @JsonProperty
    public String getList() {
        return list;
    }

    @JsonProperty
    public void setList(final String list) {
        this.list = list;
    }

    @JsonProperty
    public String getOperator() {
        return operator;
    }

    @JsonProperty
    public void setOperator(final String operator) {
        this.operator = operator;
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
    public String getProperty() {
        return property;
    }

    @JsonProperty
    public void setProperty(final String property) {
        this.property = property;
    }

    @JsonProperty
    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

}
