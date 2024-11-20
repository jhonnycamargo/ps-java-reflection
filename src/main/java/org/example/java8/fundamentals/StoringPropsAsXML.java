package org.example.java8.fundamentals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class StoringPropsAsXML {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("displayName", "Jim Wilson");
        props.setProperty("accountNumber", "123-45-6789");

        try (OutputStream out = Files.newOutputStream(Paths.get("props.xml"))) {
            props.storeToXML(out, "My comment");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}
