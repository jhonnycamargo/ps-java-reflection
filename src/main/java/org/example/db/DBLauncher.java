package org.example.db;

import org.h2.tools.Server;

import java.sql.SQLException;

public class DBLauncher {

    public static void main(String[] args) throws SQLException {
        Server.main("-baseDir", "~/Development/Study/Pluralsight/ps-java-reflection/db-flies",
                "-ifNotExists"
        );
        System.out.println("DB Launched");
    }
}
