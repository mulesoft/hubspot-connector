/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.contactproperty;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class CustomContactProperty {

    private String name;
    private String label;
    private String description;
    private String groupName;
    private CustomContactPropertyType type;
    private CustomContactPropertyFieldType fieldType;
    private Boolean formField;
    private Integer displayOrder;
    private Boolean readOnlyValue;
    private Boolean readOnlyDefinition;
    private Boolean hidden;
    private Boolean mutableDefinitionNotDeletable;
    private Boolean favorited;
    private Integer favoritedOrder;
    private List<CustomContactPropertyOptions> options;

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(final String name) {
        this.name = name;
    }

    @JsonProperty
    public String getLabel() {
        return label;
    }

    @JsonProperty
    public void setLabel(final String label) {
        this.label = label;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public void setDescription(final String description) {
        this.description = description;
    }

    @JsonProperty
    public String getGroupName() {
        return groupName;
    }

    @JsonProperty
    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }

    @JsonProperty
    public Boolean getFormField() {
        return formField;
    }

    @JsonProperty
    public void setFormField(final Boolean formField) {
        this.formField = formField;
    }

    @JsonProperty
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    @JsonProperty
    public void setDisplayOrder(final Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    @JsonProperty
    public Boolean getReadOnlyValue() {
        return readOnlyValue;
    }

    @JsonProperty
    public void setReadOnlyValue(final Boolean readOnlyValue) {
        this.readOnlyValue = readOnlyValue;
    }

    @JsonProperty
    public Boolean getReadOnlyDefinition() {
        return readOnlyDefinition;
    }

    @JsonProperty
    public void setReadOnlyDefinition(final Boolean readOnlyDefinition) {
        this.readOnlyDefinition = readOnlyDefinition;
    }

    @JsonProperty
    public Boolean getHidden() {
        return hidden;
    }

    @JsonProperty
    public void setHidden(final Boolean hidden) {
        this.hidden = hidden;
    }

    @JsonProperty
    public Boolean getMutableDefinitionNotDeletable() {
        return mutableDefinitionNotDeletable;
    }

    @JsonProperty
    public void setMutableDefinitionNotDeletable(final Boolean mutableDefinitionNotDeletable) {
        this.mutableDefinitionNotDeletable = mutableDefinitionNotDeletable;
    }

    @JsonProperty
    public Boolean getFavorited() {
        return favorited;
    }

    @JsonProperty
    public void setFavorited(final Boolean favorited) {
        this.favorited = favorited;
    }

    @JsonProperty
    public Integer getFavoritedOrder() {
        return favoritedOrder;
    }

    @JsonProperty
    public void setFavoritedOrder(final Integer favoritedOrder) {
        this.favoritedOrder = favoritedOrder;
    }

    @JsonProperty
    public List<CustomContactPropertyOptions> getOptions() {
        return options;
    }

    @JsonProperty
    public void setOptions(final List<CustomContactPropertyOptions> options) {
        this.options = options;
    }

    @JsonProperty
    public CustomContactPropertyType getType() {
        return type;
    }

    @JsonProperty
    public void setType(final CustomContactPropertyType type) {
        this.type = type;
    }

    @JsonProperty
    public CustomContactPropertyFieldType getFieldType() {
        return fieldType;
    }

    @JsonProperty
    public void setFieldType(final CustomContactPropertyFieldType fieldType) {
        this.fieldType = fieldType;
    }
}