
package org.mule.module.hubspot.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.hubspot.model.list.holders.HubSpotListFilterExpressionHolder;
import org.mule.module.hubspot.model.list.holders.HubSpotListFiltersExpressionHolder;
import org.mule.module.hubspot.model.list.holders.HubSpotListMetadataExpressionHolder;
import org.mule.module.hubspot.model.list.holders.HubSpotNewListExpressionHolder;
import org.mule.module.hubspot.processors.CreateContactListMessageProcessor;
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
public class CreateContactListDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateContactListDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateContactListMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-contact-list] within the connector [hubspot] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-contact-list] within the connector [hubspot] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createContactList");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-contact-list] within the connector [hubspot] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        parseProperty(builder, element, "userId", "userId");
        if (!parseObjectRef(element, builder, "list", "list")) {
            BeanDefinitionBuilder listBuilder = BeanDefinitionBuilder.rootBeanDefinition(HubSpotNewListExpressionHolder.class.getName());
            Element listChildElement = DomUtils.getChildElementByTagName(element, "list");
            if (listChildElement!= null) {
                parseProperty(listBuilder, listChildElement, "portalId", "portalId");
                parseProperty(listBuilder, listChildElement, "listId", "listId");
                parseProperty(listBuilder, listChildElement, "internalListId", "internalListId");
                parseProperty(listBuilder, listChildElement, "createdAt", "createdAt");
                parseProperty(listBuilder, listChildElement, "updatedAt", "updatedAt");
                parseProperty(listBuilder, listChildElement, "dynamic", "dynamic");
                parseProperty(listBuilder, listChildElement, "deleted", "deleted");
                parseProperty(listBuilder, listChildElement, "name", "name");
                parseProperty(listBuilder, listChildElement, "internal", "internal");
                if (!parseObjectRef(listChildElement, listBuilder, "meta-data", "metaData")) {
                    BeanDefinitionBuilder _metaDataBuilder = BeanDefinitionBuilder.rootBeanDefinition(HubSpotListMetadataExpressionHolder.class.getName());
                    Element _metaDataChildElement = DomUtils.getChildElementByTagName(listChildElement, "meta-data");
                    if (_metaDataChildElement!= null) {
                        parseProperty(_metaDataBuilder, _metaDataChildElement, "size", "size");
                        parseProperty(_metaDataBuilder, _metaDataChildElement, "lastSizeChangeAt", "lastSizeChangeAt");
                        parseProperty(_metaDataBuilder, _metaDataChildElement, "processing", "processing");
                        parseProperty(_metaDataBuilder, _metaDataChildElement, "lastProcessingStateChangeAt", "lastProcessingStateChangeAt");
                        parseProperty(_metaDataBuilder, _metaDataChildElement, "error", "error");
                        listBuilder.addPropertyValue("metaData", _metaDataBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("list", listBuilder.getBeanDefinition());
            }
        }
        parseListAndSetProperty(element, builder, "filters", "filters", "filter", new ParseDelegate<BeanDefinition>() {


            public BeanDefinition parse(Element element) {
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(HubSpotListFiltersExpressionHolder.class);
                parseListAndSetProperty(element, builder, "filters", "filters", "filter", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(HubSpotListFilterExpressionHolder.class);
                        parseProperty(builder, element, "operator", "operator");
                        parseProperty(builder, element, "list", "list");
                        parseProperty(builder, element, "value", "value");
                        parseProperty(builder, element, "property", "property");
                        parseProperty(builder, element, "type", "type");
                        return builder.getBeanDefinition();
                    }

                }
                );
                return builder.getBeanDefinition();
            }

        }
        );
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
