/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.credential;

import java.util.Map;
import java.util.WeakHashMap;

import org.apache.commons.lang.StringUtils;
import org.mule.module.hubspot.exception.HubSpotConnectorNoAccessTokenException;
import org.mule.module.hubspot.model.OAuthCredentials;

/**
 * Class that handles the credentials of the users logged in through the HubSpot connector
 */
public class HubSpotCredentialsManager {

	private Map<String, OAuthCredentials> credentialsMap;
		
	public HubSpotCredentialsManager() {
		credentialsMap = new WeakHashMap<String, OAuthCredentials>();
	}
	
	/**
	 * Return the credentials corresponding to a user
	 *  
	 * @param userId The ID of the user of which we want to get the credentials
	 * @return The Credentials of the user {@link OAuthCredentials}
	 * @throws HubSpotConnectorNoAccessTokenException If the user does not have credentials, throw this exception
	 */
	public OAuthCredentials getCredentials(String userId) throws HubSpotConnectorNoAccessTokenException {
		OAuthCredentials oACreds = credentialsMap.get(userId);
		
		if (oACreds == null)
			throw new HubSpotConnectorNoAccessTokenException("The user with id " + userId + " does not have credentials");
		
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
	 */
	public void setCredentias(OAuthCredentials credentials) {
		this.credentialsMap.put(credentials.getUserId(), credentials);
	}
	
	/**
	 * Indicates if certain user has or not credentials
	 * 
	 * @param userId The ID of the user
	 * @return true if the user has credentials, false otherwise
	 */
	public boolean hasUserAccessToken(String userId) {
		OAuthCredentials credentials = credentialsMap.get(userId);
		return credentials != null && StringUtils.isNotEmpty(credentials.getAccessToken());
	}
}
