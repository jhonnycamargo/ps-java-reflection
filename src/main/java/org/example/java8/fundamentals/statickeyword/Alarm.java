package org.example.java8.fundamentals.statickeyword;

public class Alarm {
    protected boolean active;

    public static String getDocumentation() {
        return "Use turnOn() to activate.";
    }

    public void turnOn() {
        active = true;
    }
}
