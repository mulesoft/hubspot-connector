/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.integration;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.mule.api.ConnectionException;
import org.mule.module.hubspot.HubSpotConnector;
import org.mule.module.hubspot.exception.HubSpotConnectorException;
import org.mule.module.hubspot.exception.HubSpotConnectorNoAccessTokenException;

public class HubSpotConnectorIT {

	static final private String USER_ID = "1";

	private HubSpotConnector connector;

	@Before
	public void setUp() throws IOException, ConnectionException,
			HubSpotConnectorException, HubSpotConnectorNoAccessTokenException {
		// Load the .properties
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader
				.getResourceAsStream("hubspotconnectorit.properties");
		prop.load(stream);

		// Save the props in the class attributes
		String authResult = prop.getProperty("hubspot.it.authresult");
		
		connector = new HubSpotConnector();
		connector.setClientId(prop.getProperty("hubspot.it.clientid"));
		connector.setHubId(prop.getProperty("hubspot.it.hubid"));
		connector.setScope(prop.getProperty("hubspot.it.scope"));
		connector.setCallbackUrl(prop.getProperty("hubspot.it.callbackurl"));
		connector.initialize();
		
		if (StringUtils.isEmpty(authResult)) {
			
			Map<String, Object> m = new HashMap<String, Object>();
			String url = connector.authenticate(USER_ID, m);
			
			throw new RuntimeException(
					"Call this url and gather the response as the authresult: "
							+ url);
		} else {
			connector.authenticateResponse(authResult);
		}
	}
}