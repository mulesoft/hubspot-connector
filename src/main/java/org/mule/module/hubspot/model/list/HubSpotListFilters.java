/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.list;

import java.util.List;

public class HubSpotListFilters {

    private List<HubSpotListFilter> filters;

    public List<HubSpotListFilter> getFilters() {
        return filters;
    }

    public void setFilters(final List<HubSpotListFilter> filters) {
        this.filters = filters;
    }
}
