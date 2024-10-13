package org.example.util;

import java.lang.reflect.Field;

public class PrimaryKeyField {
    private final Field field;

    public PrimaryKeyField(Field field) {
        this.field = field;
    }
}
