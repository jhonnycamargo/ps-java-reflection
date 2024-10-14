package org.example;

import org.example.model.Person;
import org.example.util.ColumnField;
import org.example.util.Metamodel;
import org.example.util.PrimaryKeyField;

import java.util.List;

public class PlayWithMetamodel {

    public static void main(String... args) {
        Metamodel metamodel = Metamodel.of(Person.class);

        PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
        List<ColumnField> columnFields = metamodel.getColumns();

        System.out.println("Primary key name = " + primaryKeyField.getName() + ", type = " + primaryKeyField.getType().getSimpleName());

        for (ColumnField columnField : columnFields) {
            System.out.println("Column name = " + columnField.getName() + ", type = " + columnField.getType().getSimpleName());
        }

    }
}
