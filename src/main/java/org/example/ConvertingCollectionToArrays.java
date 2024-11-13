package org.example;

import org.example.model.MyClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ConvertingCollectionToArrays {
    public static void main(String[] args) {
        ArrayList<MyClass> list = new ArrayList<>();
        list.add(new MyClass("v1", "abc"));
        list.add(new MyClass("v2", "xyz"));
        list.add(new MyClass("v3", "abc"));

        Object[] objArray = list.toArray();
        MyClass[] a1 = list.toArray(new MyClass[0]);
        MyClass[] a2 = new MyClass[3];
        MyClass[] a3 = list.toArray(a2);

        if (a2 == a3) {
            System.out.println("a2 & a3 reference the same array");
        }

        MyClass[] myArray = {
            new MyClass("v1", "abc"),
            new MyClass("v2", "xyz"),
            new MyClass("v3", "abc")
        };
        Collection<MyClass> list2 = Arrays.asList(myArray);
        list2.forEach(
            m -> System.out.println(m.getName()));
    }
}
