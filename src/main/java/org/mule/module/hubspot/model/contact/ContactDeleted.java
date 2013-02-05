package org.mule.module.hubspot.model.contact;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactDeleted {
	
	private Boolean deleted;
	private String vid;
	
	@JsonProperty
	public Boolean getDeleted() {
		return deleted;
	}
	
	@JsonProperty
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	@JsonProperty
	public String getVid() {
		return vid;
	}
	
	@JsonProperty
	public void setVid(String vid) {
		this.vid = vid;
	}
	
	
}
