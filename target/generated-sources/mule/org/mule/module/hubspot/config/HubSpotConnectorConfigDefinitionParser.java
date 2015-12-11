
package org.mule.module.hubspot.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.hubspot.adapters.HubSpotConnectorProcessAdapter;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class HubSpotConnectorConfigDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(HubSpotConnectorConfigDefinitionParser.class);

    public String moduleName() {
        return "HubSpot";
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        parseConfigName(element);
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.setScope(BeanDefinition.SCOPE_SINGLETON);
        parseProperty(builder, element, "clientId", "clientId");
        parseProperty(builder, element, "hubId", "hubId");
        parseProperty(builder, element, "scope", "scope");
        parseProperty(builder, element, "callbackUrl", "callbackUrl");
        if (hasAttribute(element, "objectStore-ref")) {
            if (element.getAttribute("objectStore-ref").startsWith("#")) {
                builder.addPropertyValue("objectStore", element.getAttribute("objectStore-ref"));
            } else {
                builder.addPropertyValue("objectStore", new RuntimeBeanReference(element.getAttribute("objectStore-ref")));
            }
        }
        setInitMethodIfNeeded(builder, HubSpotConnectorProcessAdapter.class);
        setDestroyMethodIfNeeded(builder, HubSpotConnectorProcessAdapter.class);
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        return definition;
    }

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(HubSpotConnectorProcessAdapter.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the configuration [config] within the connector [hubspot] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the configuration [config] within the connector [hubspot] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

}
