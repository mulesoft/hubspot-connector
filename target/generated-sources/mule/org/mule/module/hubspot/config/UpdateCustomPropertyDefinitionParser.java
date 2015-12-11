
package org.mule.module.hubspot.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.hubspot.model.contactproperty.holders.CustomContactPropertyExpressionHolder;
import org.mule.module.hubspot.model.contactproperty.holders.CustomContactPropertyOptionsExpressionHolder;
import org.mule.module.hubspot.processors.UpdateCustomPropertyMessageProcessor;
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
public class UpdateCustomPropertyDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateCustomPropertyDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateCustomPropertyMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-custom-property] within the connector [hubspot] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-custom-property] within the connector [hubspot] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateCustomProperty");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [update-custom-property] within the connector [hubspot] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        parseProperty(builder, element, "userId", "userId");
        parseProperty(builder, element, "propertyName", "propertyName");
        if (!parseObjectRef(element, builder, "contact-property", "contactProperty")) {
            BeanDefinitionBuilder contactPropertyBuilder = BeanDefinitionBuilder.rootBeanDefinition(CustomContactPropertyExpressionHolder.class.getName());
            Element contactPropertyChildElement = DomUtils.getChildElementByTagName(element, "contact-property");
            if (contactPropertyChildElement!= null) {
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "name", "name");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "label", "label");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "description", "description");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "groupName", "groupName");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "type", "type");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "fieldType", "fieldType");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "formField", "formField");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "displayOrder", "displayOrder");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "readOnlyValue", "readOnlyValue");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "readOnlyDefinition", "readOnlyDefinition");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "hidden", "hidden");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "mutableDefinitionNotDeletable", "mutableDefinitionNotDeletable");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "favorited", "favorited");
                parseProperty(contactPropertyBuilder, contactPropertyChildElement, "favoritedOrder", "favoritedOrder");
                parseListAndSetProperty(contactPropertyChildElement, contactPropertyBuilder, "options", "options", "option", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CustomContactPropertyOptionsExpressionHolder.class);
                        parseProperty(builder, element, "label", "label");
                        parseProperty(builder, element, "value", "value");
                        parseProperty(builder, element, "displayOrder", "displayOrder");
                        return builder.getBeanDefinition();
                    }

                }
                );
                builder.addPropertyValue("contactProperty", contactPropertyBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
