package org.example.java8.fundamentals.statickeyword;

public class Example {

    static {
        System.out.println("Example static Initializer");
    }

    public Example() {
        System.out.println("Example Constructor");
    }
}
