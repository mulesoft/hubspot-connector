
package org.mule.module.hubspot.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.module.hubspot.HubSpotConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>HubSpotConnectorProcessAdapter</code> is a wrapper around {@link HubSpotConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class HubSpotConnectorProcessAdapter
    extends HubSpotConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<HubSpotConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, HubSpotConnectorCapabilitiesAdapter> getProcessTemplate() {
        final HubSpotConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,HubSpotConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, HubSpotConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, HubSpotConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
