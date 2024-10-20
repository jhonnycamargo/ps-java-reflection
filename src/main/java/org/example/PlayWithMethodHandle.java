package org.example;

import org.example.model.Person;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class PlayWithMethodHandle {

    public static void main(String[] args) throws Throwable {
        Lookup lookup = MethodHandles.lookup();
        MethodType emptyConstructorMethodType = MethodType.methodType(void.class);
        MethodHandle emptyConstructor = lookup.findConstructor(Person.class, emptyConstructorMethodType);

        Person person = (Person) emptyConstructor.invoke();
        System.out.println(person);
    }
}
