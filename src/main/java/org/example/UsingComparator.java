package org.example;

import org.example.model.MyClass;
import org.example.model.util.MyComparator;

import java.util.TreeSet;

public class UsingComparator {
    public static void main(String... args) {
        TreeSet<MyClass> tree = new TreeSet<>(new MyComparator());
        tree.add(new MyClass("2222", "ghi"));
        tree.add(new MyClass("3333", "abc"));
        tree.add(new MyClass("1111", "def"));

        tree.forEach(System.out::println);
    }
}
