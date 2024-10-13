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

    }
}
