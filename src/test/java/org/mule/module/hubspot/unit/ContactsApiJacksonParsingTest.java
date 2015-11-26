/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.unit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

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
import org.mule.module.hubspot.model.contactproperty.CustomContactProperty;
import org.mule.module.hubspot.model.list.HubSpotList;
import org.mule.module.hubspot.model.list.HubSpotListFilter;
import org.mule.module.hubspot.model.list.HubSpotListLists;

public class ContactsApiJacksonParsingTest {

    private ObjectMapper objMapper;

    @Before
    public void initialization() {
        objMapper = new ObjectMapper();
    }

    @Test
    public void createContactInput() throws Exception {
        final ContactProperties cp = new ContactProperties();
        cp.setEmail("myemail@mydomain.com");
        cp.setFirstname("myFirstName");
        cp.setLastname("myLastName");

        final Contact c = new Contact();
        c.setContactProperties(cp);

        final String json = objMapper.writeValueAsString(c);

        Assert.assertTrue(json.indexOf("myFirstName") >= 0);
        Assert.assertTrue(json.indexOf("myLastName") >= 0);
        Assert.assertTrue(json.indexOf("myemail@mydomain.com") >= 0);

        System.out.println("json = " + json);
        // Check that the properties parameters has an array and not an object
        Assert.assertTrue(json.indexOf("\"properties\":[") >= 0);
    }

    @Test
    public void deleteContactOutput() throws JsonParseException, JsonMappingException, IOException {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContatPathFor("deleteContactOutput.json"));

        final ContactDeleted cd = objMapper.readValue(input, ContactDeleted.class);

        Assert.assertNotNull(cd);
        Assert.assertFalse(StringUtils.isEmpty(cd.getVid()));
        Assert.assertTrue(cd.getDeleted());
    }

    @Test
    public void getAllContactsOutput() throws JsonParseException, JsonMappingException, IOException {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContatPathFor("getAllContactsOutput.json"));

        final ContactList cl = objMapper.readValue(input, ContactList.class);
        final Contact c = cl.getContacts().get(0);
        final ContactProperties cp = c.getContactProperties();

        Assert.assertNotNull(cl);
        Assert.assertNotNull(c);
        Assert.assertNotNull(cp);
        Assert.assertFalse(StringUtils.isEmpty(cp.getFirstname()));
        Assert.assertFalse(StringUtils.isEmpty(cp.getLastname()));
    }

    @Test
    public void getContactByIdOutput() throws JsonParseException, JsonMappingException, IOException {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContatPathFor("getContactByIdOutput.json"));

        final Contact c = objMapper.readValue(input, Contact.class);
        final ContactProperties cp = c.getContactProperties();
        final ContactIdentityProfiles cip = c.getIdentityProfiles().get(0);
        final ContactListMembership clm = c.getListMemberships().get(0);

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
    public void getContactByIdOutput2() throws JsonParseException, JsonMappingException, IOException {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContatPathFor("getContactByIdOutput2.json"));

        final Contact c = objMapper.readValue(input, Contact.class);
        final ContactProperties cp = c.getContactProperties();
        final Map<String, String> customProperties = cp.getCustomProperties();

        Assert.assertNotNull(c);
        Assert.assertNotNull(cp);
        Assert.assertFalse(StringUtils.isEmpty(cp.getFirstname()));
        Assert.assertFalse(StringUtils.isEmpty(cp.getLastname()));
        Assert.assertFalse(StringUtils.isEmpty(cp.getEmail()));

        Assert.assertTrue(customProperties.size() >= 2);
        Assert.assertEquals("valueOfCustomTwo", customProperties.get("customTwo"));
    }

    @Test
    public void getContactStatisticsOutput() throws JsonParseException, JsonMappingException, IOException {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContatPathFor("getContactstatisticsOutput.json"));

        final ContactStatistics cs = objMapper.readValue(input, ContactStatistics.class);

        Assert.assertNotNull(cs);
        Assert.assertTrue(cs.getContacts().equals(5l));
        Assert.assertTrue(cs.getLastNewContactAt().equals(1360095861638l));
    }

    @Test
    public void getContactListsOutput() throws JsonParseException, JsonMappingException, IOException {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getListPathFor("getContactListsOutput.json"));

        final HubSpotListLists hbll = objMapper.readValue(input, HubSpotListLists.class);
        final HubSpotListFilter hblf = hbll.getLists().get(1).getFilters().get(0).get(0);

        Assert.assertNotNull(hbll);
        Assert.assertEquals(hbll.getLists().size(), 3);
        Assert.assertEquals(hbll.getLists().get(0).getListId(), "1");

        Assert.assertNotNull(hblf);
        Assert.assertEquals(hblf.getOperator(), "IN_LIST");
        Assert.assertEquals(hblf.getList(), "1");
    }

    @Test
    public void getContactListByIdOutput() throws JsonParseException, JsonMappingException, IOException {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getListPathFor("getContactListByIdOutput.json"));

        final HubSpotList hbl = objMapper.readValue(input, HubSpotList.class);

        Assert.assertNotNull(hbl);
        Assert.assertEquals(hbl.getPortalId(), "237093");
        Assert.assertFalse(hbl.getDeleted());
    }

    @Test
    public void getDynamicContactListsOutput() throws JsonParseException, JsonMappingException, IOException {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getListPathFor("getDynamicContactListsOutput.json"));

        final HubSpotListLists hbll = objMapper.readValue(input, HubSpotListLists.class);
        final HubSpotList hbl = hbll.getLists().get(0);
        final HubSpotListFilter hblf = hbl.getFilters().get(0).get(0);

        Assert.assertNotNull(hbll);
        Assert.assertNotNull(hbl);
        Assert.assertEquals(hbl.getPortalId(), "237093");
        Assert.assertFalse(hbl.getDeleted());

        Assert.assertNotNull(hblf);
        Assert.assertEquals(hblf.getOperator(), "IN_LIST");
        Assert.assertEquals(hblf.getList(), "1");
    }

    @Test
    public void getAllContactPropertiesFromAPortalOutput() throws JsonParseException, JsonMappingException, IOException {
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(getContactPropertyPathFor("getAllContactPropertiesOutput.json"));

        final CustomContactProperty[] lcp = objMapper.readValue(input, CustomContactProperty[].class);
        final CustomContactProperty cp = lcp[0];

        Assert.assertNotNull(lcp);
        Assert.assertTrue(lcp.length > 0);
        Assert.assertNotNull(cp);
        Assert.assertEquals(cp.getName(), "billing_address1");
    }

    private String getContatPathFor(final String jsonFile) {
        return String.format("contacts%s%s", File.separator, jsonFile);
    }

    private String getListPathFor(final String jsonFile) {
        return String.format("lists%s%s", File.separator, jsonFile);
    }

    private String getContactPropertyPathFor(final String jsonFile) {
        return String.format("contactproperty%s%s", File.separator, jsonFile);
    }
}
