package org.example.java8.fundamentals.polymorphism;

public class Recorder {
    public Recording record(Animal animal) {
        return new Recording(animal.vocalize());
    }
}
