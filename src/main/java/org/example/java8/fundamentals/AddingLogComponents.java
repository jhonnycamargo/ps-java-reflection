package org.example.java8.fundamentals;

import java.util.logging.*;

public class AddingLogComponents {
    static Logger logger = Logger.getLogger("com.pluralsight");

    public static void main(String[] args) {
        Handler h = new ConsoleHandler();
        Formatter f = new SimpleFormatter();
        h.setFormatter(f);
        logger.addHandler(h);

        logger.log(Level.INFO, "Hello");
    }
}
