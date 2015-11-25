/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.integration.utils;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.store.ObjectDoesNotExistException;
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.mule.config.i18n.CoreMessages;
import org.mule.util.store.SimpleMemoryObjectStore;

/**
 * This class uses the SimpleObjectStore class, but instead returning an instance of the object
 * contained in the store, it clones it and returns the new instance.
 * This is to simulate the behavior of the ObjectStore in CloudHub (stateless)
 *
 * @author gustavoalberola
 *
 */
public class ObjectStoreWithClone<T extends Serializable> implements ObjectStore<T> {

	private SimpleMemoryObjectStore<T> objectStore;

	public ObjectStoreWithClone() {
		objectStore = new SimpleMemoryObjectStore<T>();
	}

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
    public boolean contains(final Serializable key) throws ObjectStoreException {
		if (key == null) {
			throw new ObjectStoreException(CoreMessages.objectIsNull("key"));
		}
		return objectStore.contains(key);
	}

	@Override
    public void store(final Serializable key, final T value) throws ObjectStoreException {
		if (key == null) {
			throw new ObjectStoreException(CoreMessages.objectIsNull("key"));
		}

		if (contains(key)) {
			remove(key);
		}

		objectStore.store(key, value);
	}

	@Override
    @SuppressWarnings("unchecked")
	public T retrieve(final Serializable key) throws ObjectStoreException {
		if (key == null) {
			throw new ObjectStoreException(CoreMessages.objectIsNull("key"));
		}

		if (contains(key) == false) {
			String message = "Key does not exist: " + key;
			throw new ObjectDoesNotExistException(CoreMessages.createStaticMessage(message));
		}


		T obj = objectStore.retrieve(key);
		return obj != null ? (T) CloneGenerator.clone(obj) : null;
	}

	@Override
    public T remove(final Serializable key) throws ObjectStoreException {
		if (key == null) {
			throw new ObjectStoreException(CoreMessages.objectIsNull("key"));
		}

		if (contains(key) == false) {
			throw new ObjectDoesNotExistException();
		}

		return objectStore.remove(key);
	}

	@Override
	public boolean isPersistent() {
		return false;
	}

    @Override
    public void clear() throws ObjectStoreException {
        objectStore.clear();
    }
}