package org.example.model;

import java.util.Objects;

public class MyClass implements Comparable<MyClass> {

    private String name;
    private String description;

    public MyClass() {
    }

    public MyClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        MyClass other = (MyClass) o;
        return description.equalsIgnoreCase(other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description);
    }

    @Override
    public String toString() {
        return name + " | " + description;
    }

    @Override
    public int compareTo(MyClass o) {
        return description.compareToIgnoreCase(o.description);
    }
}
