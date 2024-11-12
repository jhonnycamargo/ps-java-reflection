package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleCollection {

    public static void main(String[] args) {
        // Create a collection
        Collection<String> collection = new ArrayList<>();
        collection.add("Java");
        collection.add("Kotlin");
        collection.add("Scala");
        collection.add("Groovy");

        // Iterate over the collection
        for (String element : collection) {
            System.out.println(element);
        }

        // Remove an element
        collection.remove("Scala");

        // Iterate over the collection
        for (String element : collection) {
            System.out.println(element);
        }
    }
}
