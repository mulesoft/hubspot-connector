
package org.mule.module.hubspot.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.hubspot.model.contact.holders.ContactPropertiesExpressionHolder;
import org.mule.module.hubspot.processors.UpdateContactMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser.ParseDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class UpdateContactDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateContactDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateContactMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-contact] within the connector [hubspot] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-contact] within the connector [hubspot] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateContact");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [update-contact] within the connector [hubspot] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        parseProperty(builder, element, "userId", "userId");
        parseProperty(builder, element, "contactId", "contactId");
        if (!parseObjectRef(element, builder, "contact-properties", "contactProperties")) {
            BeanDefinitionBuilder contactPropertiesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ContactPropertiesExpressionHolder.class.getName());
            Element contactPropertiesChildElement = DomUtils.getChildElementByTagName(element, "contact-properties");
            if (contactPropertiesChildElement!= null) {
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "firstname", "firstname");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "lastname", "lastname");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "salutation", "salutation");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "email", "email");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "phone", "phone");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "fax", "fax");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "address", "address");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "city", "city");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "state", "state");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "zip", "zip");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "country", "country");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "jobtitle", "jobtitle");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "message", "message");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "closedate", "closedate");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "lifecyclestage", "lifecyclestage");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "company", "company");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "website", "website");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "numemployees", "numemployees");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "annualrevenue", "annualrevenue");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "industry", "industry");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "twitterhandle", "twitterhandle");
                parseProperty(contactPropertiesBuilder, contactPropertiesChildElement, "twitterprofilephoto", "twitterprofilephoto");
                parseMapAndSetProperty(contactPropertiesChildElement, contactPropertiesBuilder, "customProperties", "custom-properties", "custom-property", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                builder.addPropertyValue("contactProperties", contactPropertiesBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
