package org.example.java8.fundamentals.metadata;

public class Doer {

    @Deprecated
    void doItThisWay() {
        System.out.println("Doing it this way");
    }

    void doItThisNewWay() {
        System.out.println("Doing it that way");
    }
}
