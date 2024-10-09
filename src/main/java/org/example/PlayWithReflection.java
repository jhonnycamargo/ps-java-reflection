package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PlayWithReflection {

    public static void main(String[] args) throws ClassNotFoundException {
        String personClassName = "org.example.model.Person";
        Class<?> personClass = Class.forName(personClassName);

        System.out.println("Person class = " + personClass);

        Field[] fields = personClass.getFields();
        System.out.println("Fields = " + Arrays.toString(fields));

        Field[] declaredFields = personClass.getDeclaredFields();
        System.out.println("Fields = " + Arrays.toString(declaredFields));

        System.out.println("Methods: ");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("Declared Methods: ");
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        System.out.println("Static Declared Methods: ");
        Arrays.stream(declaredMethods)
                .filter(method -> Modifier.isStatic(method.getModifiers()))
                .forEach(System.out::println);
    }
}
