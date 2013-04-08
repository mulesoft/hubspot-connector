/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.client.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.module.hubspot.client.HubSpotClient;
import org.mule.module.hubspot.client.HubSpotClientUtils;
import org.mule.module.hubspot.credential.HubSpotCredentialsManager;
import org.mule.module.hubspot.exception.HubSpotConnectorAccessTokenExpiredException;
import org.mule.module.hubspot.exception.HubSpotConnectorException;
import org.mule.module.hubspot.exception.HubSpotConnectorNoAccessTokenException;
import org.mule.module.hubspot.model.HubSpotWebResourceMethods;
import org.mule.module.hubspot.model.OAuthCredentials;
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
import org.mule.module.hubspot.model.email.EmailSubscriptionStatusUnsuscribeFromAll;
import org.mule.module.hubspot.model.list.HubSpotList;
import org.mule.module.hubspot.model.list.HubSpotListAddContactToList;
import org.mule.module.hubspot.model.list.HubSpotListAddContactToListResponse;
import org.mule.module.hubspot.model.list.HubSpotListFilter;
import org.mule.module.hubspot.model.list.HubSpotListFilters;
import org.mule.module.hubspot.model.list.HubSpotListLists;
import org.mule.module.hubspot.model.list.HubSpotNewList;
import org.mule.module.hubspot.model.token.RefreshTokenRequest;
import org.mule.module.hubspot.model.token.RefreshTokenResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class HubSpotClientImpl implements HubSpotClient {

	static final private Log logger = LogFactory.getLog(HubSpotClientImpl.class);
	
	static final private String PARAM_ACCESS_TOKEN = "access_token";

	private String urlAPI;
	private String urlAuth;
	private String APIVersion;
	
	private String clientId;
	private String hubId;
	private String scope;
	private String callbackUrl;
	
	private Client jerseyClient;
	
	public HubSpotClientImpl(String urlAPI, String urlAuth, String APIVersion, String clientId, String hubId, String scope, String callbackUrl) {
		this.urlAPI 		= StringUtils.isEmpty(urlAPI) 		? "http://hubapi.com" : urlAPI;
		this.urlAuth 		= StringUtils.isEmpty(urlAuth) 		? "https://app.hubspot.com/auth/authenticate" : urlAuth;
		this.APIVersion 	= StringUtils.isEmpty(APIVersion) 	? "v1" : APIVersion;
		this.clientId		= clientId;
		this.hubId			= hubId;
		this.scope			= scope;
		this.callbackUrl 	= callbackUrl; 
		
		jerseyClient = new Client();
	}
	
	
	private WebResource getWebResource(URI uri, String accessToken) throws HubSpotConnectorNoAccessTokenException {
		return jerseyClient.resource(uri).queryParam(PARAM_ACCESS_TOKEN, accessToken);
	}
	
	@Override
	public String authenticate(String userId, Map<String, Object> headers)
			throws HubSpotConnectorException {
		
		URI uri = UriBuilder.fromPath(urlAuth).build();
		WebResource wr = jerseyClient.resource(uri);
		
		String finalCallbackUrl = callbackUrl + (callbackUrl.indexOf('?') < 0 ? "?" : "&") + "userid=" + userId;
				
		wr = wr.queryParam("client_id", clientId)
				.queryParam("portalId", hubId)
				.queryParam("redirect_uri", finalCallbackUrl)
				.queryParam("scope", scope);
		
		String authUrl = wr.getURI().toString();
		
		headers.put("Location", authUrl);
		headers.put("http.status", "302");
		
		logger.debug("Ready for authentication. Redirecting (302) to: " + authUrl);
		
		return authUrl;
	}
	

	@Override
	public ContactList getAllContacts(String accessToken, String userId,
			String count, String contactOffset)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/lists/all/contacts/all").build(APIVersion);

		WebResource wr = getWebResource(uri, accessToken);		
		if (count != null) wr = wr.queryParam("count", count);		
		if (contactOffset != null) wr = wr.queryParam("vidOffset", contactOffset);
		
		logger.debug("Requesting allContacts to: " + wr.toString());		
		ContactList cl = HubSpotClientUtils.webResourceGet(ContactList.class, wr, userId, HubSpotWebResourceMethods.GET);
		
		return cl;
	}

	@Override
	public ContactList getRecentContacts(String accessToken, String userId,
			String count, String timeOffset, String contactOffset)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
				
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/lists/recently_updated/contacts/recent").build(APIVersion);
		
		WebResource wr = getWebResource(uri, accessToken);
		if (count != null) 			wr = wr.queryParam("count", count);
		if (timeOffset != null) 	wr = wr.queryParam("timeOffset", timeOffset);
		if (contactOffset != null) 	wr = wr.queryParam("vidOffset", contactOffset);
		
		logger.debug("Requesting recentContacts to:" + wr.toString());
		return HubSpotClientUtils.webResourceGet(ContactList.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public Contact getContactById(String accessToken, String userId,
			String contactId) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(contactId))
			throw new HubSpotConnectorException("The parameter contactId cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/contact/vid/{contactid}/profile").build(APIVersion, contactId);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting contactById to:" + wr.toString());
		
		return HubSpotClientUtils.webResourceGet(Contact.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public Contact getContactByEmail(String accessToken, String userId,
			String contactEmail) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(contactEmail))
			throw new HubSpotConnectorException("The parameter contactEmail cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/contact/email/{contactemail}/profile").build(APIVersion, contactEmail);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting contactByEmail to:" + wr.toString());
						
		return HubSpotClientUtils.webResourceGet(Contact.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public Contact getContactByUserToken(String accessToken, String userId,
			String contactUserToken) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(contactUserToken))
			throw new HubSpotConnectorException("The parameter contactUserToken cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/contact/utk/{contactusertoken}/profile").build(APIVersion, contactUserToken);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting contactByUserToken to: " +  wr.toString());
		return HubSpotClientUtils.webResourceGet(Contact.class, wr, userId, HubSpotWebResourceMethods.GET);		
	}

	@Override
	public ContactQuery getContactsByQuery(String accessToken, String userId,
			String query, String count) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(query))
			throw new HubSpotConnectorException("The parameter query cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/search/query").build(APIVersion);
		
		WebResource wr = getWebResource(uri, accessToken);
		wr = wr.queryParam("q", query);
		if (count != null) wr = wr.queryParam("count", count);
		
		logger.debug("Requesting contactsByQuery to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(ContactQuery.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public ContactDeleted deleteContact(String accessToken, String userId,
			String contactId) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(contactId))
			throw new HubSpotConnectorException("The parameter contactId cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/contact/vid/{contactid}").build(APIVersion, contactId);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting deleteContact to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(ContactDeleted.class, wr, userId, HubSpotWebResourceMethods.DELETE);
	}

	@Override
	public void updateContact(String accessToken, String userId,
			String contactId, ContactProperties contactProperties)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(contactId))
			throw new HubSpotConnectorException("The parameter contactId cannot be empty");
		if (contactProperties == null)
			throw new HubSpotConnectorException("The parameter contactProperties cannot be null");		
		
		Contact contact = new Contact();
		contact.setContactProperties(contactProperties);
		
		String contactJson = HubSpotClientUtils.transformObjectToJson(contact);
			
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/contact/vid/{contactid}/profile").build(APIVersion, contactId);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting updateContact to: " + wr.toString());
		HubSpotClientUtils.webResourceGet(wr, userId, HubSpotWebResourceMethods.POST, contactJson);
	}

	@Override
	public Contact createContact(String accessToken, String userId,
			ContactProperties contactProperties) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (contactProperties == null)
			throw new HubSpotConnectorException("The parameter contactProperties cannot be null");		
		if (StringUtils.isEmpty(contactProperties.getEmail()))
			throw new HubSpotConnectorException("The property email in contactProperties cannot be empty");
		
		Contact contact = new Contact();
		contact.setContactProperties(contactProperties);
		
		String contactJson = HubSpotClientUtils.transformObjectToJson(contact);
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/contact").build(APIVersion);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting createContact to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(Contact.class, wr, userId, HubSpotWebResourceMethods.POST, contactJson);
	}

	@Override
	public ContactStatistics getContactStatistics(String accessToken, String userId)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/contacts/statistics").build(APIVersion);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting contactStatistics to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(ContactStatistics.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public HubSpotListLists getContactsLists(String accessToken, String userId,
			String count, String offset) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/lists").build(APIVersion);
		
		WebResource wr = getWebResource(uri, accessToken);
		if (count != null) wr = wr.queryParam("count", count);
		if (offset != null) wr = wr.queryParam("offset", offset);
		
		logger.debug("Requesting contactsLists to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(HubSpotListLists.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public HubSpotList getContactListById(String accessToken, String userId,
			String listId) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {

		if (StringUtils.isEmpty(listId))
			throw new HubSpotConnectorException("The parameter listId cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/lists/{listid}").build(APIVersion, listId);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting contactListById to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(HubSpotList.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public HubSpotListLists getDynamicContactLists(String accessToken, String userId,
			String count, String offset) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/lists/dynamic").build(APIVersion);
		
		WebResource wr = getWebResource(uri, accessToken);
		if (count != null) wr = wr.queryParam("count", count);
		if (offset != null) wr = wr.queryParam("offset", offset);
		
		logger.debug("Requesting dynamicContactLists to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(HubSpotListLists.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public ContactList getContactsInAList(String accessToken, String userId,
			String listId, String count, String property, String offset)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(listId))
			throw new HubSpotConnectorException("The parameter listId cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/lists/{listid}/contacts/all").build(APIVersion, listId);
		
		WebResource wr = getWebResource(uri, accessToken);
		if (count != null) wr = wr.queryParam("count", count);
		if (property != null) wr = wr.queryParam("property", property);
		if (offset != null) wr = wr.queryParam("vidOffset", offset);
		
		logger.debug("Requesting getContactsInAList to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(ContactList.class, wr, userId, HubSpotWebResourceMethods.GET);
	}
	
	@Override
	public EmailSubscription getEmailSubscriptions(String accessToken,
			String userId, String hubId) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(hubId))
			throw new HubSpotConnectorException("The parameter hubId cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/email/{apiversion}/public/subscriptions").build(APIVersion);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		wr.queryParam("portalId", hubId);
		
		logger.debug("Requesting getEmailSubscriptions to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(EmailSubscription.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public EmailSubscriptionStatus getEmailSubscriptionStatus(
			String accessToken, String userId, String hubId, String email)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {

		if (StringUtils.isEmpty(email))
			throw new HubSpotConnectorException("The parameter email cannot be empty");
		
		if (StringUtils.isEmpty(hubId))
			throw new HubSpotConnectorException("The parameter hubId cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/email/{apiversion}/public/subscriptions/{email}").build(APIVersion, email);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		wr.queryParam("portalId", hubId);
		
		logger.debug("Requesting getEmailSubscriptionStatus to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(EmailSubscriptionStatus.class, wr, userId, HubSpotWebResourceMethods.GET);
	}

	@Override
	public EmailSubscriptionStatusResult updateEmailSubscriptionStatus(
			String accessToken, String userId, String hubId, String email,
			List<EmailSubscriptionStatusStatuses> statuses)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(email))
			throw new HubSpotConnectorException("The parameter email cannot be empty");
		
		if (StringUtils.isEmpty(hubId))
			throw new HubSpotConnectorException("The parameter hubId cannot be empty");
		
		if (statuses == null || statuses.size() == 0)
			throw new HubSpotConnectorException("The parameter statuses cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/email/{apiversion}/public/subscriptions/{email}").build(APIVersion, email);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		wr.queryParam("portalId", hubId);
		
		EmailSubscriptionStatus ess = new EmailSubscriptionStatus();
		ess.setSubscriptionStatuses(statuses);
		
		String json = HubSpotClientUtils.transformObjectToJson(ess);
		
		logger.debug("Requesting getEmailSubscriptionStatus to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(EmailSubscriptionStatusResult.class, wr, userId, HubSpotWebResourceMethods.POST, json);
	}
	

	@Override
	public EmailSubscriptionStatusResult updateEmailSubscriptionStatusUnsubscribeFromAll(String accessToken, String userId, String hubId, String email)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(email))
			throw new HubSpotConnectorException("The parameter email cannot be empty");
		
		if (StringUtils.isEmpty(hubId))
			throw new HubSpotConnectorException("The parameter hubId cannot be empty");
				
		URI uri = UriBuilder.fromPath(urlAPI).path("/email/{apiversion}/public/subscriptions/{email}").build(APIVersion, email);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		wr.queryParam("portalId", hubId);
		
		EmailSubscriptionStatusUnsuscribeFromAll essufa = new EmailSubscriptionStatusUnsuscribeFromAll();
		essufa.setUnsubscribeFromAll(true);
		
		String json = HubSpotClientUtils.transformObjectToJson(essufa);
		
		logger.debug("Requesting updateEmailSubscriptionStatusUnsubscribeFromAll to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(EmailSubscriptionStatusResult.class, wr, userId, HubSpotWebResourceMethods.PUT, json);
	}
	

	@Override
	public List<CustomContactProperty> getAllCustomProperties(String accessToken, String userId)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/properties").build(APIVersion);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting getAllProperties to: " + wr.toString());
		CustomContactProperty[] cpl = HubSpotClientUtils.webResourceGet(CustomContactProperty[].class, wr, userId, HubSpotWebResourceMethods.GET);
				
		return cpl != null ? Arrays.asList(cpl) : null;
	}


	@Override
	public CustomContactProperty createCustomProperty(String accessToken, String userId,
			CustomContactProperty contactProperty)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (contactProperty == null)
			throw new HubSpotConnectorException("The parameter contactProperty cannot be empty");
		
		if (StringUtils.isEmpty(contactProperty.getName()))
			throw new HubSpotConnectorException("The parameter contactProperty must have a name");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/properties/{propertyname}").build(APIVersion, contactProperty.getName());
		
		WebResource wr = getWebResource(uri, accessToken);
		
		String json = HubSpotClientUtils.transformObjectToJson(contactProperty);
		
		logger.debug("Requesting createCustomProperty to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(CustomContactProperty.class, wr, userId, HubSpotWebResourceMethods.PUT, json);
	}


	@Override
	public CustomContactProperty updateCustomProperty(String accessToken,
			String userId, String propertyName, CustomContactProperty contactProperty)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (contactProperty == null)
			throw new HubSpotConnectorException("The parameter contactProperty cannot be empty");
		
		if (StringUtils.isEmpty(propertyName))
			throw new HubSpotConnectorException("The parameter propertyName cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/properties/{propertyname}").build(APIVersion, propertyName);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		String json = HubSpotClientUtils.transformObjectToJson(contactProperty);
		
		logger.debug("Requesting updateCustomProperty to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(CustomContactProperty.class, wr, userId, HubSpotWebResourceMethods.POST, json);
	}


	@Override
	public void deleteCustomProperty(String accessToken, String userId,
			String contactPropertyName) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(contactPropertyName))
			throw new HubSpotConnectorException("The parameter contactPropertyName must have a name");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/properties/{propertyname}").build(APIVersion, contactPropertyName);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting deleteCustomProperty to: " + wr.toString());
		HubSpotClientUtils.webResourceGet(wr, userId, HubSpotWebResourceMethods.DELETE);
		
	}


	@Override
	public CustomContactPropertyGroup getCustomPropertyGroup(
			String accessToken, String userId, String groupName)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(groupName))
			throw new HubSpotConnectorException("The parameter groupName must have a name");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/groups/{groupname}").build(APIVersion, groupName);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting getCustomPropertyGroup to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(CustomContactPropertyGroup.class, wr, userId, HubSpotWebResourceMethods.GET);
	}


	@Override
	public CustomContactPropertyGroup createCustomPropertyGroup(
			String accessToken, String userId,
			CustomContactPropertyGroup customContactPropertyGroup)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {

		if (customContactPropertyGroup == null)
			throw new HubSpotConnectorException("The parameter customContactPropertyGroup cannot be empty");
		
		if (StringUtils.isEmpty(customContactPropertyGroup.getName()))
			throw new HubSpotConnectorException("The parameter customContactPropertyGroup must have a name");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/groups/{groupname}").build(APIVersion, customContactPropertyGroup.getName());
		
		WebResource wr = getWebResource(uri, accessToken);
		
		String json = HubSpotClientUtils.transformObjectToJson(customContactPropertyGroup);
		
		logger.debug("Requesting createCustomPropertyGroup to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(CustomContactPropertyGroup.class, wr, userId, HubSpotWebResourceMethods.PUT, json);
	}


	@Override
	public CustomContactPropertyGroup updateCustomPropertyGroup(
			String accessToken, String userId, String groupName,
			CustomContactPropertyGroup customContactPropertyGroup)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (customContactPropertyGroup == null)
			throw new HubSpotConnectorException("The parameter customContactPropertyGroup cannot be empty");
		
		if (StringUtils.isEmpty(groupName))
			throw new HubSpotConnectorException("The parameter groupName cannot be empty");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/groups/{groupname}").build(APIVersion, groupName);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		String json = HubSpotClientUtils.transformObjectToJson(customContactPropertyGroup);
		
		logger.debug("Requesting createCustomPropertyGroup to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(CustomContactPropertyGroup.class, wr, userId, HubSpotWebResourceMethods.POST, json);
		
	}
	

	@Override
	public HubSpotListAddContactToListResponse addExistingContactInAList(String accessToken, String userId, String listId, String contactId)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(listId))
			throw new HubSpotConnectorException("The parameter listId cannot be empty");
		
		if (StringUtils.isEmpty(contactId))
			throw new HubSpotConnectorException("The parameter contactId cannot be empty");
		
		int num = 0;
		try {
			num = Integer.parseInt(contactId);
		} catch (NumberFormatException e) {
			throw new HubSpotConnectorException("The parameter contactId must be a number", e);
		}
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/lists/{listid}/add").build(APIVersion, listId);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		HubSpotListAddContactToList hslactl = new HubSpotListAddContactToList();
		hslactl.setVids(new LinkedList<Integer>());
		hslactl.getVids().add(num);
		
		String json = HubSpotClientUtils.transformObjectToJson(hslactl);
		
		logger.debug("Requesting addExistingContactInAList to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(HubSpotListAddContactToListResponse.class, wr, userId, HubSpotWebResourceMethods.POST, json);
	}

	@Override
	public HubSpotList createContactList(String accessToken, String userId, HubSpotNewList list, List<HubSpotListFilters> filters)
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException {
		
		if (list == null)
			throw new HubSpotConnectorException("The parameter list cannot be empty");
		
		if (StringUtils.isEmpty(list.getName()))
			throw new HubSpotConnectorException("The parameter list must have a name");
		
		if (StringUtils.isEmpty(list.getPortalId()))
			throw new HubSpotConnectorException("The parameter list must have a portalId");
		
		if (list.getDynamic() && filters == null)
			throw new HubSpotConnectorException("A dynamic list must have filters");

		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/lists").build(APIVersion);

		// FIXME: Once the bug in devkit is fixed, the signature of the method must be changed to List<List<HubSpotFilter>> - Jira: http://www.mulesoft.org/jira/browse/DEVKIT-313
		
		// Pass the data of HubSpotNewList and filters to a HubSpotList object
		HubSpotList hbl = new HubSpotList();

		hbl.setPortalId(list.getPortalId());
		hbl.setListId(list.getListId());
		hbl.setInternalListId(list.getInternalListId());
		hbl.setCreatedAt(list.getCreatedAt());
		hbl.setUpdatedAt(list.getUpdatedAt());
		hbl.setDynamic(list.getDynamic());
		hbl.setDeleted(list.getDeleted());
		hbl.setName(list.getName());
		hbl.setInternal(list.getInternal());
		hbl.setMetaData(list.getMetaData());
		
		if (filters != null) {
			List<List<HubSpotListFilter>> fl = new LinkedList<List<HubSpotListFilter>>();
			
			for (HubSpotListFilters f : filters) {
				if (f.getFilters() != null) {
					fl.add(f.getFilters());
				}
			}
			
			hbl.setFilters(fl);
		}
		
		
		WebResource wr = getWebResource(uri, accessToken);
		
		String json = HubSpotClientUtils.transformObjectToJson(hbl);
		
		logger.debug("Requesting createContactList to: " + wr.toString());
		return HubSpotClientUtils.webResourceGet(HubSpotList.class, wr, userId, HubSpotWebResourceMethods.POST, json);
	}


	@Override
	public void deleteCustomPropertyGroup(String accessToken, String userId,
			String groupName) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (StringUtils.isEmpty(groupName))
			throw new HubSpotConnectorException("The parameter groupName must have a name");
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/groups/{groupname}").build(APIVersion, groupName);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting deleteCustomPropertyGroup to: " + wr.toString());
		HubSpotClientUtils.webResourceGet(wr, userId, HubSpotWebResourceMethods.DELETE);
	}


	@Override
	public synchronized void refreshToken(HubSpotCredentialsManager objectStoreCredentials, OAuthCredentials credentials, String userId) 
			throws HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, HubSpotConnectorAccessTokenExpiredException {
		
		if (credentials == null)
			throw new HubSpotConnectorAccessTokenExpiredException("Trying to refresh access token but the user doesn't have credentials stored");
		
		if (!credentials.getOfflineScope())
			throw new HubSpotConnectorAccessTokenExpiredException("Trying to refresh access token but the user doesn't have the required scope for the operation (offline)");
		
		String previousToken = credentials.getAccessToken();
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/auth/{apiversion}/refresh").build(APIVersion);
		
		WebResource wr = jerseyClient.resource(uri);
		
		RefreshTokenRequest rtreq = new RefreshTokenRequest();
		rtreq.setClientId(credentials.getClientId());
		rtreq.setRefreshToken(credentials.getRefreshToken());
		// This value MUST be "refresh_token" for now. In the future, we may enable more grant types, 
		// but for now, please set this parameter to "refresh_token".
		rtreq.setGrantType("refresh_token");
		
		String reqBody = rtreq.toString();
		
		logger.debug(String.format("Requesting refreshToken to: %s - User: %s", wr.toString(), userId));
		RefreshTokenResponse rtres = HubSpotClientUtils.webResourceGet(RefreshTokenResponse.class, wr, userId, HubSpotWebResourceMethods.REFRESH, reqBody);
		
		if (rtres == null || StringUtils.isEmpty(rtres.getRefreshToken()) || StringUtils.isEmpty(rtres.getAccessToken()))
			throw new HubSpotConnectorAccessTokenExpiredException("Trying to refresh access token but the service don't respond with the required data");
						
		// Establish the credentials with the new Access Token and Refresh Token
		credentials.setRefreshToken(rtres.getRefreshToken());
		credentials.setAccessToken(rtres.getAccessToken());
		
		objectStoreCredentials.setCredentias(credentials);
		
		logger.debug(String.format("Refresh successfull for %s - Previous token was: %s - New token is: %s", userId, previousToken, rtres.getAccessToken()));
	}
}