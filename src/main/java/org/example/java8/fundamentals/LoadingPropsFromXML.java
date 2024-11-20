package org.example.java8.fundamentals;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoadingPropsFromXML {

    public static void main(String[] args) {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("props.xml"))) {
            props.loadFromXML(in);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("displayName: " + props.getProperty("displayName"));
        System.out.println("accountNumber: " + props.getProperty("accountNumber"));
    }
}
