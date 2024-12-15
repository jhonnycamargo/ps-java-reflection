package org.example.java8.fundamentals.polymorphism;

import java.util.List;

public class Archive {
    List<Recording> recordings;

    public Archive() {

    }

    public void store(Recording recording) {
        recordings.add(recording);
    }
}
