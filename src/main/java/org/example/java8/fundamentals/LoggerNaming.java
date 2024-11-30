package org.example.java8.fundamentals;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerNaming {

    static Logger pkgLogger = Logger.getLogger("com.ps.training");
    static Logger logger = Logger.getLogger("com.ps.training.LoggerNaming");

    public static void main(String[] args) {
        logger.entering("com.ps.training", "LoggerNaming");
        logger.log(Level.INFO,"We're Logging!");
        logger.exiting("com.ps.training", "LoggerNaming");

        logger.info("We're Logging!");
        logger.warning("We're Logging!");
        logger.severe("We're Logging!");

    }
}
