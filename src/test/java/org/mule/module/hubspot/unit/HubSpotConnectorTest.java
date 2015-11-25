/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.unit;

import java.io.Serializable;

import junit.framework.Assert;

import org.junit.Test;
import org.mule.api.store.ObjectStoreException;
import org.mule.api.transformer.TransformerException;
import org.mule.module.hubspot.HubSpotConnector;
import org.mule.module.hubspot.exception.HubSpotConnectorException;
import org.mule.module.hubspot.exception.HubSpotConnectorNoAccessTokenException;
import org.mule.module.hubspot.model.contact.ContactPropertiesNumberOfEmployees;
import org.mule.transformer.simple.SerializableToByteArray;
import org.mule.util.store.SimpleMemoryObjectStore;

public class HubSpotConnectorTest {

	@Test
	public void checkContactPropertiesNumberOfEmployees_getValueFrom() {
		Assert.assertEquals(null, ContactPropertiesNumberOfEmployees.getFromInteger(0));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._1_5, ContactPropertiesNumberOfEmployees.getFromInteger(1));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._1_5, ContactPropertiesNumberOfEmployees.getFromInteger(5));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._5_25, ContactPropertiesNumberOfEmployees.getFromInteger(7));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._5_25, ContactPropertiesNumberOfEmployees.getFromInteger(23));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._25_50, ContactPropertiesNumberOfEmployees.getFromInteger(47));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._50_100, ContactPropertiesNumberOfEmployees.getFromInteger(68));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._50_100, ContactPropertiesNumberOfEmployees.getFromInteger(100));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._100_500, ContactPropertiesNumberOfEmployees.getFromInteger(200));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._100_500, ContactPropertiesNumberOfEmployees.getFromInteger(500));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._500_1000, ContactPropertiesNumberOfEmployees.getFromInteger(750));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._500_1000, ContactPropertiesNumberOfEmployees.getFromInteger(1000));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._1000plus, ContactPropertiesNumberOfEmployees.getFromInteger(1001));
		Assert.assertEquals(ContactPropertiesNumberOfEmployees._1000plus, ContactPropertiesNumberOfEmployees.getFromInteger(1000001));
	}

	@Test
	public void serializeObjectStore() throws TransformerException, HubSpotConnectorException, HubSpotConnectorNoAccessTokenException, ObjectStoreException {

		HubSpotConnector connector = new HubSpotConnector();
		connector.setClientId("");
		connector.setHubId("");
		connector.setScope("");
		connector.setCallbackUrl("");
		connector.setObjectStore(new SimpleMemoryObjectStore<Serializable>());
		connector.initialize();
		try {
			connector.authenticate("1", null, null, null, null, null);
		} catch (Throwable e) {} // Expected exception because we are not passing a map for the headers. Only intention is to initialize the client

		connector.authenticateResponse("http://localhost:8090/authresponse?userid=1&access_token=9&expires_in=28800");

		SerializableToByteArray serializer = new SerializableToByteArray();
		Object result = serializer.doTransform(connector.getObjectStore().retrieve("1"), "UTF-8");

		Assert.assertNotNull(result);
	}
}
