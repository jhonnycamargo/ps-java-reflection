package org.example;

import org.example.model.MyClass;

import java.util.ArrayList;

public class UsingForEach {
    public static void main(String... args) {
        ArrayList<MyClass> list = new ArrayList<>();

        MyClass v1 = new MyClass("v1", "abc");
        MyClass v2 = new MyClass("v2", "xyz");
        MyClass v3 = new MyClass("v3", "abc");

        list.add(v1);
        list.add(v2);
        list.add(v3);

        list.forEach(
                m -> System.out.println(m.getName()));

        list.removeIf(
                m -> m.getDescription().equals("abc"));

        list.forEach(
                m -> System.out.println(m.getName()));
    }
}
