package org.example.java8.fundamentals;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MakingLogCalls {
    public static void main(String[] args) {
        LogManager lm = LogManager.getLogManager();
        Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.INFO, "This is a log message");
        logger.log(Level.WARNING, "This is a warning message");
    }
}
