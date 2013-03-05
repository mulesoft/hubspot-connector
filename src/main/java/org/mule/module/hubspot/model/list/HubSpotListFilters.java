/**
 *
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.module.hubspot.model.list;

import java.util.List;

public class HubSpotListFilters {
	
	private List<HubSpotListFilter> filters;

	public List<HubSpotListFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<HubSpotListFilter> filters) {
		this.filters = filters;
	}
}
