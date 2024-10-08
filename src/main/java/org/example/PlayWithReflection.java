package org.example;

import java.util.Arrays;

public class PlayWithReflection {

    public static void main(String[] args) throws ClassNotFoundException {
        String personClassName = "org.example.model.Person";
        Class<?> personClass = Class.forName(personClassName);

        System.out.println("Person class = " + personClass);
    }
}
