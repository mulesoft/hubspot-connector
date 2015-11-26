/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
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

    private final Map<String, HubSpotClient> clients;

    public HubSpotClientsManager() {
        clients = new HashMap<String, HubSpotClient>();
    }

    public void addClient(final String userid, final HubSpotClient client) {
        clients.put(userid, client);
    }

    public HubSpotClient getClient(final String userid) {
        return clients.get(userid);
    }

    public boolean hasClient(final String userid) {
        return clients.containsKey(userid) && clients.get(userid) != null;
    }

    /*
     * When an operation is called this method will be invoked. Since the credentialsManager is an objectStore an can be saved in a DB, can exist the case where the credentials
     * exists and the client don't.
     */
    public HubSpotClient getOrCreateClient(final String userid, final OAuthCredentials credentials) {
        if (hasClient(userid)) {
            return getClient(userid);
        } else {
            final HubSpotClient client = new HubSpotClientImpl(HubSpotConnector.HUB_SPOT_URL_API, HubSpotConnector.HUB_SPOT_URL_AUTH, HubSpotConnector.API_VERSION,
                    credentials.getClientId(), null, null, null);

            addClient(userid, client);
            return client;
        }
    }
}
