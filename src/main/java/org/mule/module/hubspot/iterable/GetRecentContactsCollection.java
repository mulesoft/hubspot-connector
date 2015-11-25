/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.iterable;

import java.util.Iterator;

import org.mule.module.hubspot.HubSpotConnector;
import org.mule.module.hubspot.model.contact.Contact;
import org.mule.module.hubspot.model.contact.ContactList;
import org.mule.modules.utils.pagination.PaginatedCollection;

public class GetRecentContactsCollection extends PaginatedCollection<Contact, ContactList> {

    private ContactList firstPage;
    private final HubSpotConnector connector;
    private final ContactList contactList;
    private final String userId;
    private final String count;

    public GetRecentContactsCollection(final HubSpotConnector connector, final ContactList contactList, final String userId, final String count) {
        super();
        this.connector = connector;
        this.contactList = contactList;
        this.userId = userId;
        this.count = count;
    }

    @Override
    public boolean isEmpty() {
        return size() != 0;
    }

    @Override
    public int size() {
        return -1;
    }

    @Override
    protected ContactList firstPage() {
        if (firstPage == null) {
            firstPage = contactList;
        }

        return firstPage;
    }

    @Override
    protected boolean hasNextPage(final ContactList contactList) {
        return contactList.getHasMore();
    }

    @Override
    protected ContactList nextPage(final ContactList contactList) {
        try {
            return connector.getRecentContacts(userId, count, contactList.getTimeOffset().toString(), contactList.getVidOffset().toString());
        } catch (final Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Iterator<Contact> pageIterator(final ContactList contactList) {
        return contactList.getContacts().iterator();
    }

    // This methods are added because the Debbuger in MuleStudio tries to convert to an array to show the data, ending in a UnsupportedOperationException
    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <Type> Type[] toArray(final Type[] a) {
        return null;
    }
}
