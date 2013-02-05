package org.mule.module.hubspot.model.contact;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.mule.module.hubspot.serialization.ContactJacksonDeserializer;
import org.mule.module.hubspot.serialization.ContactJacksonSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

	private ContactProperties properties;
	private String vid;
	private Long addedAt;
	
	public Contact() {}

	@JsonProperty("properties")
	@JsonSerialize(using = ContactJacksonSerializer.class)
	public ContactProperties getProperties() {
		return properties;
	}

	@JsonProperty("properties")	
	@JsonDeserialize(using = ContactJacksonDeserializer.class)
	public void setProperties(ContactProperties properties) {
		this.properties = properties;
	}

	@JsonProperty
	public String getVid() {
		return vid;
	}

	@JsonProperty
	public void setVid(String vid) {
		this.vid = vid;
	}

	@JsonProperty
	public Long getAddedAt() {
		return addedAt;
	}

	@JsonProperty
	public void setAddedAt(Long addedAt) {
		this.addedAt = addedAt;
	}
}