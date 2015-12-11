
package org.mule.module.hubspot.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.hubspot.model.contactproperty.holders.CustomContactPropertyExpressionHolder;
import org.mule.module.hubspot.model.contactproperty.holders.CustomContactPropertyGroupExpressionHolder;
import org.mule.module.hubspot.model.contactproperty.holders.CustomContactPropertyOptionsExpressionHolder;
import org.mule.module.hubspot.processors.CreateCustomPropertyGroupMessageProcessor;
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
public class CreateCustomPropertyGroupDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateCustomPropertyGroupDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateCustomPropertyGroupMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-custom-property-group] within the connector [hubspot] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-custom-property-group] within the connector [hubspot] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createCustomPropertyGroup");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-custom-property-group] within the connector [hubspot] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        parseProperty(builder, element, "userId", "userId");
        if (!parseObjectRef(element, builder, "custom-contact-property-group", "customContactPropertyGroup")) {
            BeanDefinitionBuilder customContactPropertyGroupBuilder = BeanDefinitionBuilder.rootBeanDefinition(CustomContactPropertyGroupExpressionHolder.class.getName());
            Element customContactPropertyGroupChildElement = DomUtils.getChildElementByTagName(element, "custom-contact-property-group");
            if (customContactPropertyGroupChildElement!= null) {
                parseProperty(customContactPropertyGroupBuilder, customContactPropertyGroupChildElement, "name", "name");
                parseProperty(customContactPropertyGroupBuilder, customContactPropertyGroupChildElement, "displayName", "displayName");
                parseProperty(customContactPropertyGroupBuilder, customContactPropertyGroupChildElement, "displayOrder", "displayOrder");
                parseProperty(customContactPropertyGroupBuilder, customContactPropertyGroupChildElement, "portalId", "portalId");
                parseListAndSetProperty(customContactPropertyGroupChildElement, customContactPropertyGroupBuilder, "properties", "properties", "property", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CustomContactPropertyExpressionHolder.class);
                        parseProperty(builder, element, "name", "name");
                        parseProperty(builder, element, "label", "label");
                        parseProperty(builder, element, "description", "description");
                        parseProperty(builder, element, "groupName", "groupName");
                        parseProperty(builder, element, "type", "type");
                        parseProperty(builder, element, "fieldType", "fieldType");
                        parseProperty(builder, element, "formField", "formField");
                        parseProperty(builder, element, "displayOrder", "displayOrder");
                        parseProperty(builder, element, "readOnlyValue", "readOnlyValue");
                        parseProperty(builder, element, "readOnlyDefinition", "readOnlyDefinition");
                        parseProperty(builder, element, "hidden", "hidden");
                        parseProperty(builder, element, "mutableDefinitionNotDeletable", "mutableDefinitionNotDeletable");
                        parseProperty(builder, element, "favorited", "favorited");
                        parseProperty(builder, element, "favoritedOrder", "favoritedOrder");
                        parseListAndSetProperty(element, builder, "options", "options", "option", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CustomContactPropertyOptionsExpressionHolder.class);
                                parseProperty(builder, element, "label", "label");
                                parseProperty(builder, element, "value", "value");
                                parseProperty(builder, element, "displayOrder", "displayOrder");
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        return builder.getBeanDefinition();
                    }

                }
                );
                builder.addPropertyValue("customContactPropertyGroup", customContactPropertyGroupBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
