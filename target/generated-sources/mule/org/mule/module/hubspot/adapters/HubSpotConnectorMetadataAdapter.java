
package org.mule.module.hubspot.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.module.hubspot.HubSpotConnector;


/**
 * A <code>HubSpotConnectorMetadataAdapter</code> is a wrapper around {@link HubSpotConnector } that adds support for querying metadata about the extension.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class HubSpotConnectorMetadataAdapter
    extends HubSpotConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "HubSpot";
    private final static String MODULE_VERSION = "3.0.0";
    private final static String DEVKIT_VERSION = "3.7.2";
    private final static String DEVKIT_BUILD = "3.7.x.2633.51164b9";
    private final static String MIN_MULE_VERSION = "3.7";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

}
