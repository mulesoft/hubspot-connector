/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mule.module.hubspot.exception.HubSpotConnectorAccessTokenExpiredException;
import org.mule.module.hubspot.exception.HubSpotConnectorException;
import org.mule.module.hubspot.model.HubSpotWebResourceMethods;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class HubSpotClientUtils {
	
	static final private ObjectMapper jacksonMapper = new ObjectMapper();
	
	
	static public String transformObjectToJson(Object o) throws HubSpotConnectorException {
		try {
			return jacksonMapper.writeValueAsString(o);
		} catch (JsonGenerationException e) {
			throw new HubSpotConnectorException("Cannot generate the Json from object", e);
		} catch (JsonMappingException e) {
			throw new HubSpotConnectorException("Cannot map the Json from object", e);
		} catch (IOException e) {
			throw new HubSpotConnectorException(e);
		}
	}
	
	static public String webResourceGet(WebResource wr, String userId, HubSpotWebResourceMethods method) 
			throws HubSpotConnectorAccessTokenExpiredException, HubSpotConnectorException {
		return webResourceGet(String.class, wr, userId, method); 
	}
	
	static public String webResourceGet(WebResource wr, String userId, HubSpotWebResourceMethods method, String requestBody) 
			throws HubSpotConnectorAccessTokenExpiredException, HubSpotConnectorException {
		return webResourceGet(String.class, wr, userId, method, requestBody); 
	}
	
	/**
	 * Method used to eliminate boilerplate handling exceptions when calling get(String.class) from a WebResource
	 * 
	 * @param wr The WebResource to call get
	 * @param userId The userId from the session used
	 * @return The response of the service in String format
	 * @throws HubSpotConnectorAccessTokenExpiredException If the service responded with a 401 means that the session has expired
	 * @throws HubSpotConnectorException If is not a 401 it will throw this exception
	 */
	static public <T> T webResourceGet(Class<T> type, WebResource wr, String userId, HubSpotWebResourceMethods method) 
			throws HubSpotConnectorAccessTokenExpiredException, HubSpotConnectorException {
		return webResourceGet(type, wr, userId, method, null);
	}
	
	
	@SuppressWarnings("unchecked")
	static public <T> T webResourceGet(Class<T> type, WebResource wr, String userId, HubSpotWebResourceMethods method, String requestBody) 
			throws HubSpotConnectorAccessTokenExpiredException, HubSpotConnectorException {
		try {
			String res = webResourceCallByEnumType(wr, method, requestBody);
			
			if (type.equals(String.class)) {
				return (T)res;
			} else {
				InputStream is = new ByteArrayInputStream(res.getBytes());
				return jacksonMapper.readValue(is, type);
			}
		} catch (UniformInterfaceException e) {
			int statusCode = e.getResponse().getStatus();
			
			// The code 204 is returned as a successful operation with no response, but as the expected parameter is a String.class it throws a UniformInterfaceException.
			if (statusCode == 204) {
				return null;
			} else if (statusCode == 401) {
				// FEATURE: Add verification if it has a refresh token. If it has it call refresh process and then make again the get() call
				throw new HubSpotConnectorAccessTokenExpiredException("The access token for the userId " + userId + "has expired", e);
			} else {
				throw new HubSpotConnectorException("ERROR - statusCode: " + statusCode, e);
			}
		} catch (JsonParseException e) {
			throw new HubSpotConnectorException("ERROR - Error Parsing the JSON", e);
		} catch (JsonMappingException e) {
			throw new HubSpotConnectorException("ERROR - Error Mapping the JSON", e);
		} catch (IOException e) {
			throw new HubSpotConnectorException(e);
		}
	}
	
	static private String webResourceCallByEnumType(WebResource wr, HubSpotWebResourceMethods method, String requestBody) {
		if (HubSpotWebResourceMethods.GET.equals(method)) {
			return wr.get(String.class);
		} else if (HubSpotWebResourceMethods.POST.equals(method)) {
			return wr.type(MediaType.APPLICATION_JSON_TYPE).post(String.class, requestBody);
		} else if (HubSpotWebResourceMethods.PUT.equals(method)) {
			return wr.put(String.class);
		} else if (HubSpotWebResourceMethods.DELETE.equals(method)) {
			return wr.delete(String.class);
		} else {
			return null;
		}
	}
}
