/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.unit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mule.module.hubspot.model.contact.Contact;
import org.mule.module.hubspot.model.contact.ContactDeleted;
import org.mule.module.hubspot.model.contact.ContactIdentityProfiles;
import org.mule.module.hubspot.model.contact.ContactList;
import org.mule.module.hubspot.model.contact.ContactListMembership;
import org.mule.module.hubspot.model.contact.ContactProperties;
import org.mule.module.hubspot.model.contact.ContactStatistics;

public class ContactsApiJacksonParsingTest {
	
	private ObjectMapper objMapper;
	
	@Before
	public void initialization() {
		objMapper = new ObjectMapper();
	}
	
	@Test
	public void createContactInput() throws Exception {
		ContactProperties cp = new ContactProperties();
		cp.setEmail("myemail@mydomain.com");
		cp.setFirstname("myFirstName");
		cp.setLastname("myLastName");
		
		Contact c = new Contact();
		c.setProperties(cp);
		
		String json = objMapper.writeValueAsString(c);
		
		Assert.assertTrue(json.indexOf("myFirstName") >= 0);
		Assert.assertTrue(json.indexOf("myLastName") >= 0);
		Assert.assertTrue(json.indexOf("myemail@mydomain.com") >= 0);
		// Check that the properties parameters has an array and not an object
		Assert.assertTrue(json.indexOf("{\"properties\":[") >= 0);
	}
	
	@Test
	public void deleteContactOutput() throws JsonParseException, JsonMappingException, IOException {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContatPathFor("deleteContactOutput.json"));
		
		ContactDeleted cd = objMapper.readValue(input, ContactDeleted.class); 
		
		Assert.assertNotNull(cd);
		Assert.assertFalse(StringUtils.isEmpty(cd.getVid()));
		Assert.assertTrue(cd.getDeleted());
	}
	
	@Test
	public void getAllContactsOutput() throws JsonParseException, JsonMappingException, IOException {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContatPathFor("getAllContactsOutput.json"));
		
		ContactList cl = objMapper.readValue(input, ContactList.class); 
		Contact c = cl.getContacts().get(0);
		ContactProperties cp = c.getProperties();
		
		Assert.assertNotNull(cl);
		Assert.assertNotNull(c);
		Assert.assertNotNull(cp);
		Assert.assertFalse(StringUtils.isEmpty(cp.getFirstname()));
		Assert.assertFalse(StringUtils.isEmpty(cp.getLastname()));
	}
	
	@Test
	public void getContactByIdOutput() throws JsonParseException, JsonMappingException, IOException {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContatPathFor("getContactByIdOutput.json"));

		Contact c = objMapper.readValue(input, Contact.class); 
		ContactProperties cp = c.getProperties();
		ContactIdentityProfiles cip = c.getIdentityProfiles().get(0);
		ContactListMembership clm = c.getListMemberships().get(0);
		
		Assert.assertNotNull(c);
		Assert.assertNotNull(cp);
		Assert.assertNotNull(cip);
		Assert.assertNotNull(clm);
		
		Assert.assertFalse(StringUtils.isEmpty(cp.getFirstname()));
		Assert.assertFalse(StringUtils.isEmpty(cp.getLastname()));
		Assert.assertFalse(StringUtils.isEmpty(cp.getEmail()));
		
		Assert.assertTrue(cip.getVid() > 0);
		Assert.assertEquals(cip.getIdentities().size(), 2);
		Assert.assertEquals(cip.getIdentities().get(0).getType(), "EMAIL");
		
		Assert.assertEquals(c.getListMemberships().size(), 2);
		Assert.assertTrue(clm.getInternalListId() == 1);
	}
	
	@Test
	public void getContactStatisticsOutput() throws JsonParseException, JsonMappingException, IOException {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContatPathFor("getContactstatisticsOutput.json"));
		
		ContactStatistics cs = objMapper.readValue(input, ContactStatistics.class);
		
		Assert.assertNotNull(cs);
		Assert.assertTrue(cs.getContacts().equals(5l));
		Assert.assertTrue(cs.getLastNewContactAt().equals(1360095861638l));
	}
	
	private String getContatPathFor(String jsonFile) {
		return String.format("contacts%s%s", File.separator, jsonFile);
	}
}
