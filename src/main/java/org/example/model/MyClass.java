package org.example.model;

import java.util.Objects;

public class MyClass {

    private String name;
    private String description;

    public MyClass() {
    }

    public MyClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return Objects.equals(description, myClass.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description);
    }
}
