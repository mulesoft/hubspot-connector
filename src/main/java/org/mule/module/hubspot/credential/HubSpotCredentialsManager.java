/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
	private ObjectStore credentialsMap;
		
	@SuppressWarnings("rawtypes")
	public HubSpotCredentialsManager(ObjectStore objStore) {
		credentialsMap = objStore;
	}
	
	/**
	 * Return the credentials corresponding to a user
	 *  
	 * @param userId The ID of the user of which we want to get the credentials
	 * @return The Credentials of the user {@link OAuthCredentials}
	 * @throws HubSpotConnectorNoAccessTokenException If the user does not have credentials, throw this exception
	 */
	public OAuthCredentials getCredentials(String userId) throws HubSpotConnectorNoAccessTokenException {
		OAuthCredentials oACreds;

		try {
			oACreds = (OAuthCredentials) credentialsMap.retrieve(userId);
		} catch (ObjectStoreException e) {
			throw new HubSpotConnectorNoAccessTokenException("The user with id " + userId + " does not have credentials");
		}
				
		return oACreds;
	}
	
	/**
	 * Return the accessToken in the credentials corresponding to a user
	 * 
	 * @param userId The ID of the user of which we want to get the credentials
	 * @return The accessToken of the user 
	 * @throws HubSpotConnectorNoAccessTokenException If the user does not have credentials, throw this exception
	 */
	public String getCredentialsAccessToken(String userId) throws HubSpotConnectorNoAccessTokenException {
		return getCredentials(userId).getAccessToken();
	}
	
	/**
	 * Store the credentials for the user. The user ID is inside the Credentials object
	 *  
	 * @param credentials The credentials of the user {@link OAuthCredentials}
	 * @throws HubSpotConnectorException If the value cannot be saved or overwriten in the Object Store
	 */
	@SuppressWarnings("unchecked")
	public void setCredentias(OAuthCredentials credentials) throws HubSpotConnectorException {
		try {
			credentialsMap.store(credentials.getUserId(), credentials);
		} catch (ObjectAlreadyExistsException ex) { 
			try {
				credentialsMap.remove(credentials.getUserId());
				credentialsMap.store(credentials.getUserId(), credentials);
			} catch (ObjectStoreException e) {
				throw new HubSpotConnectorException("Error trying to overwrite credential", ex);
			}			
		} catch (ObjectStoreException e) {
			throw new HubSpotConnectorException("Error trying to store credential", e);
		}
	}
	
	/**
	 * Retrieves the clientId from the credentials for the tenant
	 * 
	 * @param userId The UserId that has the credentials
	 * @return The clientID
	 * @throws HubSpotConnectorNoAccessTokenException If the userId does not have credentials stored
	 */
	public String getCredentialsClientId(String userId) throws HubSpotConnectorNoAccessTokenException {
		return getCredentials(userId).getClientId();
	}
	
	public String getCredentialsHubId(String userId) throws HubSpotConnectorNoAccessTokenException {
		return getCredentials(userId).getHubId();
	}
	
	public Boolean getCredentialsOfflineScope(String userId) throws HubSpotConnectorNoAccessTokenException {
		return getCredentials(userId).getOfflineScope();
	}
	
	/**
	 * Indicates if certain user has or not credentials
	 * 
	 * @param userId The ID of the user
	 * @return true if the user has credentials, false otherwise
	 */
	public boolean hasUserAccessToken(String userId) {
		try {
			if (credentialsMap.contains(userId) && StringUtils.isNotEmpty(((OAuthCredentials)credentialsMap.retrieve(userId)).getAccessToken())) {
				return true;
			} else {
				return false;
			}
		} catch (ObjectStoreException e) {
			return false;
		}
	}
}
