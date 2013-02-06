/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.contactproperty;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomContactProperty {

	private String name;
	private String label;
	private String description;
	private String groupName;
	private String type;
	private String fieldType;
	private String formField;
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
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public String getLabel() {
		return label;
	}
	
	@JsonProperty
	public void setLabel(String label) {
		this.label = label;
	}
	
	@JsonProperty
	public String getDescription() {
		return description;
	}
	
	@JsonProperty
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty
	public String getGroupName() {
		return groupName;
	}
	
	@JsonProperty
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@JsonProperty
	public String getType() {
		return type;
	}
	
	@JsonProperty
	public void setType(String type) {
		this.type = type;
	}
	
	@JsonProperty
	public String getFieldType() {
		return fieldType;
	}
	
	@JsonProperty
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	
	@JsonProperty
	public String getFormField() {
		return formField;
	}
	
	@JsonProperty
	public void setFormField(String formField) {
		this.formField = formField;
	}
	
	@JsonProperty
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	
	@JsonProperty
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	@JsonProperty
	public Boolean getReadOnlyValue() {
		return readOnlyValue;
	}
	
	@JsonProperty
	public void setReadOnlyValue(Boolean readOnlyValue) {
		this.readOnlyValue = readOnlyValue;
	}
	
	@JsonProperty
	public Boolean getReadOnlyDefinition() {
		return readOnlyDefinition;
	}
	
	@JsonProperty
	public void setReadOnlyDefinition(Boolean readOnlyDefinition) {
		this.readOnlyDefinition = readOnlyDefinition;
	}
	
	@JsonProperty
	public Boolean getHidden() {
		return hidden;
	}
	
	@JsonProperty
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}
	
	@JsonProperty
	public Boolean getMutableDefinitionNotDeletable() {
		return mutableDefinitionNotDeletable;
	}
	
	@JsonProperty
	public void setMutableDefinitionNotDeletable(
			Boolean mutableDefinitionNotDeletable) {
		this.mutableDefinitionNotDeletable = mutableDefinitionNotDeletable;
	}
	
	@JsonProperty
	public Boolean getFavorited() {
		return favorited;
	}
	
	@JsonProperty
	public void setFavorited(Boolean favorited) {
		this.favorited = favorited;
	}
	
	@JsonProperty
	public Integer getFavoritedOrder() {
		return favoritedOrder;
	}
	
	@JsonProperty
	public void setFavoritedOrder(Integer favoritedOrder) {
		this.favoritedOrder = favoritedOrder;
	}
	
	@JsonProperty
	public List<CustomContactPropertyOptions> getOptions() {
		return options;
	}
	
	@JsonProperty
	public void setOptions(List<CustomContactPropertyOptions> options) {
		this.options = options;
	}
}