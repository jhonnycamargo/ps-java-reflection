package org.example.java8.fundamentals;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ParameterizedMessageMethods {
    private static final Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        logger.log(Level.INFO, "{0} is my favorite", "Java");
        logger.log(Level.INFO, "{0} is {1} days from {2}", new Object[]{"Wed", 2, "Fri"});
    }
}
