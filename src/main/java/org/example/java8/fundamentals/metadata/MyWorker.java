package org.example.java8.fundamentals.metadata;

public class MyWorker {

    @SuppressWarnings("deprecation")
    void doSomeWork() {
        Doer d = new Doer();
        d.doItThisWay();
    }

    @SuppressWarnings("deprecation")
    void doDoubleWork() {
        Doer d1 = new Doer();
        Doer d2 = new Doer();
        d1.doItThisWay();
        d2.doItThisWay();
    }
}
