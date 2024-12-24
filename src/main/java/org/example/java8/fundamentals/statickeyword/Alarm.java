package org.example.java8.fundamentals.statickeyword;

public class Alarm {
    public static final String DOCUMENTATION = "Use turnOn() to activate.";

    protected boolean active;

    public static String getDocumentation() {
        return DOCUMENTATION;
    }

    public void turnOn() {
        active = true;
    }

    public static void main(String[] args) {
        String s = Alarm.getDocumentation();
        System.out.println(s);
    }
}
