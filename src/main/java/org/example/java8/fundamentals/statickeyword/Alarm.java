package org.example.java8.fundamentals.statickeyword;

public class Alarm {
    private static String documentation = "Use turnOn() to activate.";

    protected boolean active;

    public static String getDocumentation() {
        return documentation;
    }

    public void turnOn() {
        active = true;
    }
}
