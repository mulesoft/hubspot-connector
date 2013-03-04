/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.client;

import java.util.List;
import java.util.Map;

import org.mule.module.hubspot.exception.HubSpotConnectorAccessTokenExpiredException;
import org.mule.module.hubspot.exception.HubSpotConnectorException;
import org.mule.module.hubspot.exception.HubSpotConnectorNoAccessTokenException;
import org.mule.module.hubspot.model.contact.Contact;
import org.mule.module.hubspot.model.contact.ContactDeleted;
import org.mule.module.hubspot.model.contact.ContactList;
import org.mule.module.hubspot.model.contact.ContactProperties;
import org.mule.module.hubspot.model.contact.ContactQuery;
import org.mule.module.hubspot.model.contact.ContactStatistics;
import org.mule.module.hubspot.model.contactproperty.CustomContactProperty;
import org.mule.module.hubspot.model.contactproperty.CustomContactPropertyGroup;
import org.mule.module.hubspot.model.email.EmailSubscription;
import org.mule.module.hubspot.model.email.EmailSubscriptionStatus;
import org.mule.module.hubspot.model.email.EmailSubscriptionStatusResult;
import org.mule.module.hubspot.model.email.EmailSubscriptionStatusStatuses;
import org.mule.module.hubspot.model.list.HubSpotList;
import org.mule.module.hubspot.model.list.HubSpotListAddContactToListResponse;
import org.mule.module.hubspot.model.list.HubSpotListLists;

public interface HubSpotClient {
	
	public String authenticate(String userId, Map<String, Object> headers) throws HubSpotConnectorException;
	
	public ContactList getAllContacts(String accessToken, String userId, String count, String contactOffset) 
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public ContactList getRecentContacts(String accessToken, String userId, String count, String timeOffset, String contactOffset)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	
	public Contact getContactById(String accessToken, String userId, String contactId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public Contact getContactByEmail(String accessToken, String userId, String contactEmail)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public Contact getContactByUserToken(String accessToken, String userId, String contactUserToken)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public ContactQuery getContactsByQuery(String accessToken, String userId, String query, String count)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
		
	public ContactDeleted deleteContact(String accessToken, String userId, String contactId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public void updateContact(String accessToken, String userId, String contactId, ContactProperties contactProperties)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public Contact createContact(String accessToken, String userId, ContactProperties contactProperties)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public ContactStatistics getContactStatistics(String accessToken, String userId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public HubSpotListLists getContactsLists(String accessToken, String userId, String count, String offset) 
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public HubSpotList getContactListById(String accessToken, String userId, String listId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public HubSpotListLists getDynamicContactLists(String accessToken, String userId, String count, String offset)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public ContactList getContactsInAList(String accessToken, String userId, String listId, String count, String property, String offset)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public HubSpotListAddContactToListResponse addExistingContactInAList(String accessToken, String userId, String listId, String contactId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
		
	public EmailSubscription getEmailSubscriptions(String accessToken, String userId, String hubId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public EmailSubscriptionStatus getEmailSubscriptionStatus(String accessToken, String userId, String hubId, String email)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public EmailSubscriptionStatusResult updateEmailSubscriptionStatus(String accessToken, String userId, String hubId, String email, List<EmailSubscriptionStatusStatuses> statuses)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public EmailSubscriptionStatusResult updateEmailSubscriptionStatusUnsubscribeFromAll(String accessToken, String userId, String hubId, String email) 
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public List<CustomContactProperty> getAllCustomProperties(String accessToken, String userId) 
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public CustomContactProperty createCustomProperty(String accessToken, String userId, CustomContactProperty contactProperty)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public CustomContactProperty updateCustomProperty(String accessToken, String userId, String propertyName, CustomContactProperty contactProperty)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public void deleteCustomProperty(String accessToken, String userId, String contactPropertyName)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;

	public CustomContactPropertyGroup getCustomPropertyGroup(String accessToken, String userId, String groupName)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public CustomContactPropertyGroup createCustomPropertyGroup(String accessToken, String userId, CustomContactPropertyGroup customContactPropertyGroup)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public CustomContactPropertyGroup updateCustomPropertyGroup(String accessToken, String userId, String groupName, CustomContactPropertyGroup customContactPropertyGroup)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
	
	public void deleteCustomPropertyGroup(String accessToken, String userId, String groupName)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException;
}
