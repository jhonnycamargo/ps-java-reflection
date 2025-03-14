package org.example;

import org.example.model.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        String hello = "Hello";
        Class helloClass = hello.getClass();

        Class<?> helloClass2 = "Hello".getClass();
        Class<?> superClass = helloClass2.getSuperclass();
        Class<?>[] interfaces = helloClass2.getInterfaces();
        //Class<String> helloClass3 = "Hello".getClass(); Compile ERROR!!!
        //Class<Object> helloClass4 = "Hello".getClass(); Compile ERROR!!!
        Class<? extends String> helloClass5 = "Hello".getClass();
        Class<? extends Object> helloClass6 = "Hello".getClass();
        Class<?> stringClass = String.class;
        String className = "java.lang.String";
        Class<?> stringClass2 = Class.forName(className);

        System.out.println("Hello world!");

        Class<?> personClass = Person.class;
        Field[] fields = personClass.getFields();
        Field[] decFields = personClass.getDeclaredFields();

        Method setNameMethod = personClass.getMethod("setName", String.class);

        Method[] decMethods = personClass.getDeclaredMethods();
        Method[] methods = personClass.getMethods();

        Constructor<?> constructor = personClass.getConstructor();
        Constructor<?>[] decConstructors = personClass.getDeclaredConstructors();
        Constructor<?>[] constructors = personClass.getConstructors();

        Field nameField = personClass.getField("name");
        int modifiers = nameField.getModifiers();
        //boolean isPublic = modifiers & 0x00000001;
        boolean isPublic = Modifier.isPublic(modifiers);
        System.out.println("Wayira!");
    }
}
