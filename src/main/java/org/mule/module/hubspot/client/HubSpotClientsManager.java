package org.mule.module.hubspot.client;

import java.util.HashMap;
import java.util.Map;

import org.mule.module.hubspot.HubSpotConnector;
import org.mule.module.hubspot.client.impl.HubSpotClientImpl;
import org.mule.module.hubspot.model.OAuthCredentials;

/**
 * Class that will hold all the clients of each tenant 
 */
public class HubSpotClientsManager {
	
	private Map<String, HubSpotClient> clients;
	
	public HubSpotClientsManager() {
		clients = new HashMap<String, HubSpotClient>();
	}
	
	public void addClient(String userid, HubSpotClient client) {
		clients.put(userid, client);
	}
	
	public HubSpotClient getClient(String userid) {
		return clients.get(userid);
	}
	
	public boolean hasClient(String userid) {
		return clients.containsKey(userid) && clients.get(userid) != null;
	}
	
	/*
	 * When an operation is called this method will be invoked.
	 * Since the credentialsManager is an objectStore an can be saved in a DB, can exist the case where
	 * the credentials exists and the client don't.
	 */
	public HubSpotClient getOrCreateClient(String userid, OAuthCredentials credentials) {
		if (hasClient(userid)) {
			return getClient(userid);
		} else {
			HubSpotClient client =  new HubSpotClientImpl(
					HubSpotConnector.HUB_SPOT_URL_API, 
					HubSpotConnector.HUB_SPOT_URL_AUTH, 
					HubSpotConnector.API_VERSION, 
					credentials.getClientId(), 
					null, 
					null, 
					null);
			
			addClient(userid, client);
			return client;
		}
	}
}
