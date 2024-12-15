package org.example.java8.fundamentals.polymorphism;

public class Laboratory {
    private final Archive archive = new Archive();
    private final Recorder recorder = new Recorder();

    public void captureAnimalSound(Animal animal) {
        Recording recording = recorder.record(animal);
        archive.store(recording);
    }

    public static void main(String[] args) {
        Laboratory lab = new Laboratory();
        Cat freaky = new Cat();
        lab.captureAnimalSound(freaky);
    }
}
