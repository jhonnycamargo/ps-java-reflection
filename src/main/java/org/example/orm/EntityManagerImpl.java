package org.example.orm;

import org.example.util.Metamodel;

import java.sql.PreparedStatement;

public class EntityManagerImpl<T> implements EntityManager<T> {
    @Override
    public void persist(T t) {
        Metamodel metamodel = Metamodel.of(t.getClass());
        String sql = metamodel.buildInsertRequest();
        PreparedStatement statement = prepareStatementWith(sql).andParameters(t);
        statement.executeUpdate();

    }
}
