
package org.mule.module.hubspot.model.contactproperty.holders;

import java.util.List;
import javax.annotation.Generated;
import org.mule.module.hubspot.model.contactproperty.CustomContactProperty;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class CustomContactPropertyGroupExpressionHolder {

    protected Object name;
    protected String _nameType;
    protected Object displayName;
    protected String _displayNameType;
    protected Object displayOrder;
    protected Integer _displayOrderType;
    protected Object portalId;
    protected Long _portalIdType;
    protected Object properties;
    protected List<CustomContactProperty> _propertiesType;

    /**
     * Sets name
     * 
     * @param value Value to set
     */
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Retrieves name
     * 
     */
    public Object getName() {
        return this.name;
    }

    /**
     * Sets displayName
     * 
     * @param value Value to set
     */
    public void setDisplayName(Object value) {
        this.displayName = value;
    }

    /**
     * Retrieves displayName
     * 
     */
    public Object getDisplayName() {
        return this.displayName;
    }

    /**
     * Sets displayOrder
     * 
     * @param value Value to set
     */
    public void setDisplayOrder(Object value) {
        this.displayOrder = value;
    }

    /**
     * Retrieves displayOrder
     * 
     */
    public Object getDisplayOrder() {
        return this.displayOrder;
    }

    /**
     * Sets portalId
     * 
     * @param value Value to set
     */
    public void setPortalId(Object value) {
        this.portalId = value;
    }

    /**
     * Retrieves portalId
     * 
     */
    public Object getPortalId() {
        return this.portalId;
    }

    /**
     * Sets properties
     * 
     * @param value Value to set
     */
    public void setProperties(Object value) {
        this.properties = value;
    }

    /**
     * Retrieves properties
     * 
     */
    public Object getProperties() {
        return this.properties;
    }

}
