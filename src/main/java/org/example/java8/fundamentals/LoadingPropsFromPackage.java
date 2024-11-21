package org.example.java8.fundamentals;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class LoadingPropsFromPackage {

    public static void main(String[] args) {
        try {

        } catch (IOException e) {
            System.out.println("Exception <" + e.getClass().getSimpleName() + "> " + e.getMessage());
        }
    }

    private static Properties loadUserProps(Properties userProps) throws IOException {
        Path userFile = Paths.get("props.xml");
        if (Files.exists(userFile)) {
            try (InputStream in = Files.newInputStream(userFile)) {
                userProps.loadFromXML(in);
            }
        }

        return userProps;
    }
}
