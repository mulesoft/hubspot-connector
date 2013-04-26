/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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

	public boolean contains(Serializable key) throws ObjectStoreException {
		if (key == null) {
			throw new ObjectStoreException(CoreMessages.objectIsNull("key"));
		}
		return objectStore.contains(key);
	}

	public void store(Serializable key, T value) throws ObjectStoreException {
		if (key == null) {
			throw new ObjectStoreException(CoreMessages.objectIsNull("key"));
		}

		if (contains(key)) {
			remove(key);
		}

		objectStore.store(key, value);
	}

	@SuppressWarnings("unchecked")
	public T retrieve(Serializable key) throws ObjectStoreException {
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

	public T remove(Serializable key) throws ObjectStoreException {
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
}