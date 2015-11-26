/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.credential;

import org.apache.commons.lang.StringUtils;
import org.mule.api.store.ObjectAlreadyExistsException;
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.mule.module.hubspot.exception.HubSpotConnectorException;
import org.mule.module.hubspot.exception.HubSpotConnectorNoAccessTokenException;
import org.mule.module.hubspot.model.OAuthCredentials;

/**
 * Class that handles the credentials of the users logged in through the HubSpot connector
 */
public class HubSpotCredentialsManager {

    @SuppressWarnings("rawtypes")
    private final ObjectStore credentialsMap;

    @SuppressWarnings("rawtypes")
    public HubSpotCredentialsManager(final ObjectStore objStore) {
        credentialsMap = objStore;
    }

    /**
     * Return the credentials corresponding to a user
     * 
     * @param userId
     *            The ID of the user of which we want to get the credentials
     * @return The Credentials of the user {@link OAuthCredentials}
     * @throws HubSpotConnectorNoAccessTokenException
     *             If the user does not have credentials, throw this exception
     */
    public OAuthCredentials getCredentials(final String userId) throws HubSpotConnectorNoAccessTokenException {
        OAuthCredentials oACreds;

        try {
            oACreds = (OAuthCredentials) credentialsMap.retrieve(userId);
        } catch (final ObjectStoreException e) {
            throw new HubSpotConnectorNoAccessTokenException("The user with id " + userId + " does not have credentials");
        }

        return oACreds;
    }

    /**
     * Return the accessToken in the credentials corresponding to a user
     * 
     * @param userId
     *            The ID of the user of which we want to get the credentials
     * @return The accessToken of the user
     * @throws HubSpotConnectorNoAccessTokenException
     *             If the user does not have credentials, throw this exception
     */
    public String getCredentialsAccessToken(final String userId) throws HubSpotConnectorNoAccessTokenException {
        return getCredentials(userId).getAccessToken();
    }

    /**
     * Store the credentials for the user. The user ID is inside the Credentials object
     * 
     * @param credentials
     *            The credentials of the user {@link OAuthCredentials}
     * @throws HubSpotConnectorException
     *             If the value cannot be saved or overwriten in the Object Store
     */
    @SuppressWarnings("unchecked")
    public void setCredentias(final OAuthCredentials credentials) throws HubSpotConnectorException {
        try {
            credentialsMap.store(credentials.getUserId(), credentials);
        } catch (final ObjectAlreadyExistsException ex) {
            try {
                credentialsMap.remove(credentials.getUserId());
                credentialsMap.store(credentials.getUserId(), credentials);
            } catch (final ObjectStoreException e) {
                throw new HubSpotConnectorException("Error trying to overwrite credential", ex);
            }
        } catch (final ObjectStoreException e) {
            throw new HubSpotConnectorException("Error trying to store credential", e);
        }
    }

    /**
     * Retrieves the clientId from the credentials for the tenant
     * 
     * @param userId
     *            The UserId that has the credentials
     * @return The clientID
     * @throws HubSpotConnectorNoAccessTokenException
     *             If the userId does not have credentials stored
     */
    public String getCredentialsClientId(final String userId) throws HubSpotConnectorNoAccessTokenException {
        return getCredentials(userId).getClientId();
    }

    public String getCredentialsHubId(final String userId) throws HubSpotConnectorNoAccessTokenException {
        return getCredentials(userId).getHubId();
    }

    public Boolean getCredentialsOfflineScope(final String userId) throws HubSpotConnectorNoAccessTokenException {
        return getCredentials(userId).getOfflineScope();
    }

    /**
     * Indicates if certain user has or not credentials
     * 
     * @param userId
     *            The ID of the user
     * @return true if the user has credentials, false otherwise
     */
    public boolean hasUserAccessToken(final String userId) {
        try {
            if (credentialsMap.contains(userId) && StringUtils.isNotEmpty(((OAuthCredentials) credentialsMap.retrieve(userId)).getAccessToken())) {
                return true;
            } else {
                return false;
            }
        } catch (final ObjectStoreException e) {
            return false;
        }
    }
}
