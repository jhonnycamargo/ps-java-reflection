package org.example.java8.fundamentals;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LoggingWithFileHandler {
    static Logger logger = Logger.getLogger("org.example.java8.fundamentals.LoggingWithFileHandler");

    public static void main(String[] args) throws IOException {
        FileHandler h = new FileHandler("%h/myapp_%g.log", 1000, 4);

        h.setFormatter(new java.util.logging.SimpleFormatter());
        logger.addHandler(h);

        logger.info("Hello");
    }
}
