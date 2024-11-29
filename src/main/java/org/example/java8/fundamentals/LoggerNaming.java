package org.example.java8.fundamentals;

import java.util.logging.Logger;

public class LoggerNaming {

    static Logger pkgLogger = Logger.getLogger("com.ps.training");
    static Logger logger = Logger.getLogger("com.ps.training.LoggerNaming");

    public static void main(String[] args) {
        pkgLogger.info("Package Logger");
        logger.info("Class Logger");
    }
}
