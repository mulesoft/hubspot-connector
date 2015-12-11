
package org.mule.module.hubspot.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/hubspot</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class HubspotNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(HubspotNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [hubspot] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [hubspot] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new HubSpotConnectorConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("authenticate", new AuthenticateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("authenticate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("authenticate-response", new AuthenticateResponseDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("authenticate-response", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("has-user-access-token", new HasUserAccessTokenDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("has-user-access-token", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-contacts", new GetAllContactsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-contacts", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-recent-contacts", new GetRecentContactsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-recent-contacts", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-recent-contacts-paginated", new GetRecentContactsPaginatedDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-recent-contacts-paginated", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-contacts-updated-after", new GetAllContactsUpdatedAfterDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-contacts-updated-after", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contact-by-id", new GetContactByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contact-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contact-by-email", new GetContactByEmailDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contact-by-email", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contact-by-user-token", new GetContactByUserTokenDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contact-by-user-token", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contacts-by-query", new GetContactsByQueryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contacts-by-query", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-contact", new DeleteContactDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-contact", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-contact", new UpdateContactDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-contact", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-contact", new CreateContactDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-contact", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contact-statistics", new GetContactStatisticsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contact-statistics", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contacts-lists", new GetContactsListsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contacts-lists", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contact-list-by-id", new GetContactListByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contact-list-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-dynamic-contact-lists", new GetDynamicContactListsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-dynamic-contact-lists", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contacts-in-a-list", new GetContactsInAListDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contacts-in-a-list", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-email-subscriptions", new GetEmailSubscriptionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-email-subscriptions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-email-subscription-status", new GetEmailSubscriptionStatusDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-email-subscription-status", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-email-subscription-status", new UpdateEmailSubscriptionStatusDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-email-subscription-status", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-email-subscription-status-unsubscribe-from-all", new UpdateEmailSubscriptionStatusUnsubscribeFromAllDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-email-subscription-status-unsubscribe-from-all", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-custom-properties", new GetAllCustomPropertiesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-custom-properties", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-custom-property", new CreateCustomPropertyDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-custom-property", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-custom-property", new UpdateCustomPropertyDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-custom-property", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-custom-property", new DeleteCustomPropertyDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-custom-property", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-custom-property-group", new GetCustomPropertyGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-custom-property-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-custom-property-group", new CreateCustomPropertyGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-custom-property-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-custom-property-group", new UpdateCustomPropertyGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-custom-property-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-custom-property-group", new DeleteCustomPropertyGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-custom-property-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-existing-contact-in-a-list", new AddExistingContactInAListDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-existing-contact-in-a-list", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-contact-list", new CreateContactListDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-contact-list", "@Processor", ex);
        }
    }

}
