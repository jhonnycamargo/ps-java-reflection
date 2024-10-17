package org.example.util;

import org.example.annotation.Column;
import org.example.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Metamodel {
    private final Class<?> clss;

    public static Metamodel of(Class<?> clss) {
        return new Metamodel(clss);
    }

    public Metamodel(Class<?> clss) {
        this.clss = clss;
    }

    public PrimaryKeyField getPrimaryKey() {

        Field[] fields = clss.getDeclaredFields();
        for (Field field : fields) {
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            if (primaryKey != null) {
                PrimaryKeyField primaryKeyField = new PrimaryKeyField(field);
                return primaryKeyField;
            }
        }
        throw new IllegalArgumentException("No primary key found in class " + clss.getSimpleName());
    }

    public List<ColumnField> getColumns() {

        List<ColumnField> columnFields = new ArrayList<>();
        Field[] fields = clss.getDeclaredFields();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                ColumnField columnField = new ColumnField(field);
                columnFields.add(columnField);
            }
        }
        return columnFields;
    }

    public String buildInsertRequest() {
        String columnElement = buildColumnNames();

        String questionMarksElements = buildQuestionMarksElement();

        return "insert into " + this.clss.getSimpleName() + " (" + columnElement + ") values (" + questionMarksElements + ")";
    }

    private String buildQuestionMarksElement() {
        int numberOfColumns = getColumns().size() + 1;
        return IntStream.range(0, numberOfColumns).mapToObj(i -> "?").collect(Collectors.joining(", "));
    }

    public String buildSelectRequest() {
        String columnElement = buildColumnNames();
        return "select " + columnElement + " from " + this.clss.getSimpleName() + " where " + getPrimaryKey().getName() + " = ?";
    }

    private String buildColumnNames() {
        String primaryKeyColumnName = getPrimaryKey().getName();
        var columnNames = getColumns().stream().map(ColumnField::getName).collect(Collectors.toList());
        columnNames.addFirst(primaryKeyColumnName);
        return String.join(", ", columnNames);
    }
}
