/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.email;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class EmailSubscriptionStatusUnsuscribeFromAll {

	private Boolean unsubscribeFromAll;

	@JsonProperty
	public Boolean getUnsubscribeFromAll() {
		return unsubscribeFromAll;
	}

	@JsonProperty
	public void setUnsubscribeFromAll(Boolean unsubscribeFromAll) {
		this.unsubscribeFromAll = unsubscribeFromAll;
	}
}
