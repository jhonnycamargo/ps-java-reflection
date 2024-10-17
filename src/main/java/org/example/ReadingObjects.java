package org.example;

import org.example.model.Person;
import org.example.orm.EntityManager;

public class ReadingObjects {
    public static void main(String[] args) {

        EntityManager<Person> entityManager = EntityManager.of(Person.class);

        Person linda = entityManager.find(Person.class, 1L);
        Person james = entityManager.find(Person.class, 2L);
        Person susan = entityManager.find(Person.class, 3L);
        Person john = entityManager.find(Person.class, 4L);
    }
}
