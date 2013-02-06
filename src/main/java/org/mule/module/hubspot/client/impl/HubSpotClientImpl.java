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
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.module.hubspot.client.HubSpotClient;
import org.mule.module.hubspot.client.HubSpotClientUtils;
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
import org.mule.module.hubspot.model.list.HubSpotList;
import org.mule.module.hubspot.model.list.HubSpotListLists;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class HubSpotClientImpl implements HubSpotClient {

	static final private Log logger = LogFactory.getLog(HubSpotClientImpl.class);
	
	static final private String PARAM_ACCESS_TOKEN = "access_token";

	static final private Pattern PATTERN_ACCESS_TOKEN 	= Pattern.compile("access_token=([^&]+)&?");
	static final private Pattern PATTERN_EXPIRES_AT 	= Pattern.compile("expires_in=([^&]+)&?");
	static final private Pattern PATTERN_REFRESH_TOKEN 	= Pattern.compile("refresh_token=([^&]+)&?");
	static final private Pattern PATTERN_USERID 		= Pattern.compile("userid=([^&]+)&?");
	static final private Pattern PATTERN_ERROR 			= Pattern.compile("error=([^&]+)&?");

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
	public OAuthCredentials authenticateResponse(String inputRequest)
			throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException {
		
		if (StringUtils.isEmpty(inputRequest))
			throw new HubSpotConnectorException("The parameter inputRequest can not be empty");
		
		OAuthCredentials oACreds = new OAuthCredentials();
		
		// Check if the service does not respond with an error
		Matcher m = PATTERN_ERROR.matcher(inputRequest);
		if (m.find()) {
			String errDesc = m.group(1);
			if (errDesc.equals("invalid_scope")) {
				throw new HubSpotConnectorException("The configuration is requesting a scope that the service application does not have available.");
			} else {
				throw new HubSpotConnectorException("The service has responded with an error message: " + errDesc);
			}
		}

		// Save the parameters that appear in the input
		m = PATTERN_USERID.matcher(inputRequest);
		if (m.find()) {
			oACreds.setUserId(m.group(1));
		}

		m = PATTERN_ACCESS_TOKEN.matcher(inputRequest);
		if (m.find()) {
			oACreds.setAccessToken(m.group(1));
		}
		
		m = PATTERN_EXPIRES_AT.matcher(inputRequest);
		if (m.find()) {
			oACreds.setExpiresAt(m.group(1));
		}
		
		m = PATTERN_REFRESH_TOKEN.matcher(inputRequest);
		if (m.find()) {
			oACreds.setRefreshToken(m.group(1));
		}		
		
		// The access token is the only parameter that is absolutely required 
		if (oACreds.getAccessToken() == null) {
			logger.error("Cannot find the access_token in the response:" + inputRequest);
			throw new HubSpotConnectorNoAccessTokenException("The response of the authentication process does not have an access token. Url:" + inputRequest);
		}
		
		logger.debug("Recived credentials for user:" + oACreds.getUserId());
		
		return oACreds;
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
		contact.setProperties(contactProperties);
		
		String contactJson = HubSpotClientUtils.transformObjectToJson(contact);
			
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/contact/vid/{contactid}/profile").build(APIVersion, contactId);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting updateContact to: " + wr.toString());
		HubSpotClientUtils.webResourceGet(wr, userId, HubSpotWebResourceMethods.POST, contactJson);
	}

	@Override
	public void createContact(String accessToken, String userId,
			ContactProperties contactProperties) throws HubSpotConnectorException,
			HubSpotConnectorNoAccessTokenException,
			HubSpotConnectorAccessTokenExpiredException {
		
		if (contactProperties == null)
			throw new HubSpotConnectorException("The parameter contactProperties cannot be null");		
		if (StringUtils.isEmpty(contactProperties.getEmail()))
			throw new HubSpotConnectorException("The property email in contactProperties cannot be empty");
		
		Contact contact = new Contact();
		contact.setProperties(contactProperties);
		
		String contactJson = HubSpotClientUtils.transformObjectToJson(contact);
		
		URI uri = UriBuilder.fromPath(urlAPI).path("/contacts/{apiversion}/contact").build(APIVersion);
		
		WebResource wr = getWebResource(uri, accessToken);
		
		logger.debug("Requesting createContact to: " + wr.toString());
		HubSpotClientUtils.webResourceGet(wr, userId, HubSpotWebResourceMethods.POST, contactJson);
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
	
	private WebResource getWebResource(URI uri, String accessToken) throws HubSpotConnectorNoAccessTokenException {
		return jerseyClient.resource(uri).queryParam(PARAM_ACCESS_TOKEN, accessToken);
	}
}