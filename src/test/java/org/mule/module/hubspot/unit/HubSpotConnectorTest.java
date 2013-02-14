/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.unit;

import org.junit.Test;
import org.mule.module.hubspot.model.contact.ContactPropertiesNumberOfEmployees;

import junit.framework.Assert;

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
}
