/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
