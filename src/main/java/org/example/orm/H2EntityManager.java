package org.example.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2EntityManager<T> extends ManagedEntityManager<T> {


    public Connection buildConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/Development/Study/Pluralsight/ps-java-reflection/db-flies/db-pluralsight", "sa", "");
    }
}
