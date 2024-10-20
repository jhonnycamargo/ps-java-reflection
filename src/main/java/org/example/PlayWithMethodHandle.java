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

        MethodType constructorMethodType = MethodType.methodType(void.class, String.class, int.class);
        MethodHandle constructor = lookup.findConstructor(Person.class, constructorMethodType);

        Person person2 = (Person) constructor.invoke("James", 25);
        System.out.println(person2);

        MethodType nameGetterMethodType = MethodType.methodType(String.class);
        MethodHandle nameGetter = lookup.findVirtual(Person.class, "getName", nameGetterMethodType);

        String name = (String) nameGetter.invoke(person2);
        System.out.println(name);

        MethodType nameSetterMethodType = MethodType.methodType(void.class, String.class);
        MethodHandle nameSetter = lookup.findVirtual(Person.class, "setName", nameSetterMethodType);

        nameSetter.invoke(person2, "Linda");
        System.out.println(person2);
    }
}
