package org.example.model.util;

import org.example.model.MyClass;

import java.util.Comparator;

public class MyComparator implements Comparator<MyClass> {
    @Override
    public int compare(MyClass x, MyClass y) {
        return x.getName().compareToIgnoreCase(y.getName());
    }
}
