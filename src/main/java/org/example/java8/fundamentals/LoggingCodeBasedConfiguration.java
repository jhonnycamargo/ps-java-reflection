package org.example.java8.fundamentals;

import java.util.logging.*;

public class LoggingCodeBasedConfiguration {
    static Logger logger = Logger.getLogger("org.example.java8.fundamentals.LoggingCodeBasedConfiguration");

    public static void main(String[] args) {
        Handler h = new ConsoleHandler();
        h.setLevel(Level.ALL);
        h.setFormatter(new SimpleFormatter());
        logger.addHandler(h);
        logger.setLevel(Level.ALL);
        logger.log(Level.ALL, "We're Logging!");
    }
}
