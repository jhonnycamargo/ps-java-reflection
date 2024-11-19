package org.example.java8.fundamentals;

public class SimpleCommandLineProcessing {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No arguments passed");
        } else {
            for (String arg : args) {
                System.out.println(arg);
            }
        }
    }
}
