/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.model.contactproperty;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum CustomContactPropertyFieldType {
    TEXTAREA("textarea"),
    SELECT("select"),
    TEXT("text"),
    DATE("date"),
    FILE("file"),
    NUMBER("number"),
    RADIO("radio"),
    BOOLEANCHECKBOX("booleancheckbox"),
    CHECKBOX("checkbox");

    private String value;

    private CustomContactPropertyFieldType(final String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    static public CustomContactPropertyFieldType getFromString(final String value) {
        for (final CustomContactPropertyFieldType obj : CustomContactPropertyFieldType.values()) {
            if (obj.getValue().equalsIgnoreCase(value)) {
                return obj;
            }
        }
        return null;
    }
}
