/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model;

import java.io.Serializable;

public class OAuthCredentials implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clientId;
    private String hubId;
    private String userId;
    private String accessToken;
    private String expiresAt;
    private String refreshToken;
    private Boolean offlineScope;

    public OAuthCredentials() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(final String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public String getHubId() {
        return hubId;
    }

    public void setHubId(final String hubId) {
        this.hubId = hubId;
    }

    public Boolean getOfflineScope() {
        return offlineScope;
    }

    public void setOfflineScope(final Boolean offlineScope) {
        this.offlineScope = offlineScope;
    }
}