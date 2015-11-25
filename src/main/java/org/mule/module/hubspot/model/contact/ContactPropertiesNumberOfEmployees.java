/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.contact;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum ContactPropertiesNumberOfEmployees {
    _1_5("1-5"),
    _5_25("5-25"),
    _25_50("25-50"),
    _50_100("50-100"),
    _100_500("100-500"),
    _500_1000("500-1000"),
    _1000plus("1000+");

    private String value;

    private ContactPropertiesNumberOfEmployees(final String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    /**
     * Transforms a number to a corresponding enum within range
     * 
     * @param number
     *            The number to use as reference
     * @return The enum containing the number in range, or null if the number does not match any range
     */
    static public ContactPropertiesNumberOfEmployees getFromInteger(final Integer number) {
        if (number >= 1 && number <= 5) {
            return ContactPropertiesNumberOfEmployees._1_5;
        } else if (number > 5 && number <= 25) {
            return ContactPropertiesNumberOfEmployees._5_25;
        } else if (number > 25 && number <= 50) {
            return ContactPropertiesNumberOfEmployees._25_50;
        } else if (number > 50 && number <= 100) {
            return ContactPropertiesNumberOfEmployees._50_100;
        } else if (number > 100 && number <= 500) {
            return ContactPropertiesNumberOfEmployees._100_500;
        } else if (number > 500 && number <= 1000) {
            return ContactPropertiesNumberOfEmployees._500_1000;
        } else if (number > 1000) {
            return ContactPropertiesNumberOfEmployees._1000plus;
        } else {
            return null;
        }
    }

    @JsonCreator
    static public ContactPropertiesNumberOfEmployees getFromString(final String value) {
        for (final ContactPropertiesNumberOfEmployees obj : ContactPropertiesNumberOfEmployees.values()) {
            if (obj.getValue().equalsIgnoreCase(value)) {
                return obj;
            }
        }
        return null;
    }
}
