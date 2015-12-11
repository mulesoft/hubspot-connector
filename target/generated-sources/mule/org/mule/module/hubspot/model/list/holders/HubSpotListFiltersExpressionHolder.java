
package org.mule.module.hubspot.model.list.holders;

import java.util.List;
import javax.annotation.Generated;
import org.mule.module.hubspot.model.list.HubSpotListFilter;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class HubSpotListFiltersExpressionHolder {

    protected Object filters;
    protected List<HubSpotListFilter> _filtersType;

    /**
     * Sets filters
     * 
     * @param value Value to set
     */
    public void setFilters(Object value) {
        this.filters = value;
    }

    /**
     * Retrieves filters
     * 
     */
    public Object getFilters() {
        return this.filters;
    }

}
