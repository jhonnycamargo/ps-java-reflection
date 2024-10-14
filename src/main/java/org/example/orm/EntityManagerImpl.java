package org.example.orm;

import org.example.util.Metamodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

public class EntityManagerImpl<T> implements EntityManager<T> {

    private AtomicLong idGenerator = new AtomicLong(0L);

    @Override
    public void persist(T t) {
        Metamodel metamodel = Metamodel.of(t.getClass());
        String sql = metamodel.buildInsertRequest();
        PreparedStatement statement = prepareStatementWith(sql).andParameters(t);
        statement.executeUpdate();

    }

    private PreparedStatementWrapper prepareStatementWith(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/Development/Study/Pluralsight/ps-java-reflection/db-flies/", "sa", "");
        PreparedStatement statement = connection.prepareStatement(sql);
        return new PreparedStatementWrapper(statement);
    }

    private class PreparedStatementWrapper {
        private final PreparedStatement statement;

        public PreparedStatementWrapper(PreparedStatement statement) {
            this.statement = statement;
        }

        public PreparedStatement andParameters(T t) throws SQLException {
            Metamodel metamodel = Metamodel.of(t.getClass());
            Class<?> primaryKeyTyp = metamodel.getPrimaryKey().getType();
            if (primaryKeyTyp == long.class) {
                statement.setLong(1, idGenerator.incrementAndGet());
            }
            return null;
        }
    }
}
