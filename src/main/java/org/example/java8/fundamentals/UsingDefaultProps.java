package org.example.java8.fundamentals;

import java.util.Properties;

public class UsingDefaultProps {

    public static void main(String[] args) {
        Properties defaults = new Properties();
        defaults.setProperty("position", "1");
        Properties props = new Properties(defaults);
        String nextPos = props.getProperty("position");
        System.out.println("Next position: " + nextPos);
        int iPos = Integer.parseInt(nextPos);
        props.setProperty("position", Integer.toString(++iPos));
        System.out.println("Next position: " + props.getProperty("position"));
    }
}
