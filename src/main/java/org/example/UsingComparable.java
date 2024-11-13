package org.example;

import org.example.model.MyClass;

import java.util.Arrays;
import java.util.TreeSet;

public class UsingComparable {

    public static void main(String[] args) {
        TreeSet<MyClass> tree = new TreeSet<>();
        tree.add(new MyClass("2222", "ghi"));
        tree.add(new MyClass("3333", "abc"));
        tree.add(new MyClass("1111", "def"));

        tree.forEach(System.out::println);
    }
}
