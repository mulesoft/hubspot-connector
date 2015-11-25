/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.exception;

public class HubSpotConnectorException extends Exception {

	private static final long serialVersionUID = 1L;

	public HubSpotConnectorException() {
		super();
	}
	
	public HubSpotConnectorException(String message) {
		super(message);
	}
	
	public HubSpotConnectorException(Throwable causedBy) {
		super(causedBy);
	}
	
	public HubSpotConnectorException(String message, Throwable causedBy) {
		super(message, causedBy);
	}
}
