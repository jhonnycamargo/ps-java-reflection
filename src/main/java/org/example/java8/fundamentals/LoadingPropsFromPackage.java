package org.example.java8.fundamentals;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class LoadingPropsFromPackage {

    public static void main(String[] args) {
        new LoadingPropsFromPackage().extracted();
    }

    private void extracted() {
        try {
            Properties defaultProps = new Properties();
            try (InputStream in = getClass().getResourceAsStream("MyDefaultValues.xml")) {
                defaultProps.loadFromXML(in);
            }
            Properties userProps = new Properties(defaultProps);
            loadUserProps(userProps);

            String displayName = userProps.getProperty("displayName");
            String appName = userProps.getProperty("app.name");

            System.out.println("displayName: " + displayName);
            System.out.println("app.name: " + appName);
        } catch (IOException e) {
            System.out.println("Exception <" + e.getClass().getSimpleName() + "> " + e.getMessage());
        }
    }

    private void loadUserProps(Properties userProps) throws IOException {
        Path userFile = Paths.get("props.xml");
        if (Files.exists(userFile)) {
            try (InputStream in = Files.newInputStream(userFile)) {
                userProps.loadFromXML(in);
            }
        }
    }
}
