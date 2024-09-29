package org.example;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
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
    }
}