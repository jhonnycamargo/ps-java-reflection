package org.example.java8.fundamentals;

import java.util.logging.*;

public class ParameterizedMessageMethods {
    private static final Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {

        logger.log(Level.INFO, "{0} is my favorite", "Java");
        logger.log(Level.INFO, "{0} is {1} days from {2}", new Object[]{"Wed", 2, "Fri"});

        doWork("Jim", "Wilson");
    }

    private static void doWork(String left, String right) {
        logger.entering("com.jwhh.support.Other", "doWork", new Object[]{left, right});

    }
}
