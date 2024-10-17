package org.example.util;

import org.example.annotation.PrimaryKey;

import java.lang.reflect.Field;

public class PrimaryKeyField {
    private final Field field;
    private PrimaryKey primaryKey;

    public PrimaryKeyField(Field field) {
        this.field = field;
        this.primaryKey = field.getAnnotation(PrimaryKey.class);
    }

    public String getName() {
        return primaryKey.name();
    }

    public Class<?> getType() {
        return field.getType();
    }

    public Field getField() {
        return this.field;
    }
}
