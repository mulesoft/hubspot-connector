/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.client;

import java.util.Map;

import org.mule.module.hubspot.exception.HubSpotConnectorAccessTokenExpiredException;
import org.mule.module.hubspot.exception.HubSpotConnectorException;
import org.mule.module.hubspot.exception.HubSpotConnectorNoAccessTokenException;
import org.mule.module.hubspot.model.OAuthCredentials;

public interface HubSpotClient {
	
	public String authenticate(String userId, Map<String, Object> headers) throws HubSpotConnectorException;
	
	public OAuthCredentials authenticateResponse(String inputRequest) throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException;
	
	public String getAllContacts(String accessToken, String userId, String count, String contactOffset) 
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String getRecentContacts(String accessToken, String userId, String count, String timeOffset, String contactOffset)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	
	public String getContactById(String accessToken, String userId, String contactId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String getContactByEmail(String accessToken, String userId, String contactEmail)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String getContactByUserToken(String accessToken, String userId, String contactUserToken)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String getContactsByQuery(String accessToken, String userId, String query, String count)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
		
	public String deleteContact(String accessToken, String userId, String contactId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String updateContact(String accessToken, String userId, String contactId, String contactJson)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String createContact(String accessToken, String userId, String contactJson)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String getContactStatistics(String accessToken, String userId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String getContactsLists(String accessToken, String userId, String count, String offset) 
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String getContactListById(String accessToken, String userId, String listId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String getDynamicContactLists(String accessToken, String userId, String count, String offset)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public String getContactsInAList(String accessToken, String userId, String listId, String count, String property, String offset)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
}
