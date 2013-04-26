/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.iterable;

import java.util.Iterator;

import org.mule.module.hubspot.HubSpotConnector;
import org.mule.module.hubspot.model.contact.Contact;
import org.mule.module.hubspot.model.contact.ContactList;
import org.mule.modules.utils.pagination.PaginatedCollection;

public class GetRecentContactsCollection extends PaginatedCollection<Contact, ContactList> {

	private ContactList firstPage;
	private HubSpotConnector connector;
	private ContactList contactList;
	private String userId;
	private String count;
	
	public GetRecentContactsCollection(HubSpotConnector connector, ContactList contactList, String userId, String count) {
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
		if (firstPage == null) 
			firstPage = contactList;
		
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
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected Iterator<Contact> pageIterator(final ContactList contactList) {
		return contactList.getContacts().iterator();
	}

	// This methods are added because the Debbuger in MuleStudio tries to convert to an array to show the data, ending in a UnsupportedOperationException
	@Override
    public Object[] toArray() { return null; }

    @Override
    public <Type> Type[] toArray(Type[] a) { return null; }
}
