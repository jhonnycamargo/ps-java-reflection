package org.example.java8.fundamentals;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingConfigurationFile {
    static Logger logger = Logger.getLogger("com.pluralsight");

    public static void main(String[] args) {
        logger.log(Level.ALL, "We're Logging!");
    }
}
