/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.token;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefreshTokenResponse {

	private String portalId;
	private Long expiresIn;
	private String refreshToken;
	private String accessToken;
	
	@JsonProperty("portal_id")
	public String getPortalId() {
		return portalId;
	}
	
	@JsonProperty("portal_id")
	public void setPortalId(String portalId) {
		this.portalId = portalId;
	}
	
	@JsonProperty("expires_in")
	public Long getExpiresIn() {
		return expiresIn;
	}
	
	@JsonProperty("expires_in")
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}
	
	@JsonProperty("refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}
	
	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}	
}
