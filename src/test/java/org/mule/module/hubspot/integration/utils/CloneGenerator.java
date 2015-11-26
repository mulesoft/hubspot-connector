/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.hubspot.integration.utils;

import java.lang.reflect.Field;

public class CloneGenerator {

    public static Object clone(final Object o) {
        Object clone = null;

        try {
            clone = o.getClass().newInstance();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }

        // Walk up the superclass hierarchy
        for (Class<?> obj = o.getClass(); !obj.equals(Object.class); obj = obj.getSuperclass()) {
            final Field[] fields = obj.getDeclaredFields();
            for (final Field field : fields) {
                field.setAccessible(true);
                try {
                    // for each class/suerclass, copy all fields
                    // from this object to the clone
                    field.set(clone, field.get(o));
                } catch (final IllegalArgumentException e) {
                } catch (final IllegalAccessException e) {
                }
            }
        }

        return clone;
    }
}
