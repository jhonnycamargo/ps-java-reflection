package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class AddingMembers {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Java");
        list1.add("Kotlin");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Scala");
        list2.add("Groovy");

        list1.addAll(list2);

        for (String element : list1) {
            System.out.println(element);
        }
    }
}
