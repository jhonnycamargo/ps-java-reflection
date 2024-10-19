package org.example;

import org.example.beanmanager.BeanManager;
import org.example.model.Person;
import org.example.orm.EntityManager;
import org.example.orm.ManagedEntityManager;

import java.sql.SQLException;
import java.util.Arrays;

public class WritingObjects {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        BeanManager beanManager = BeanManager.getInstance();
        EntityManager<Person> entityManager = beanManager.getInstance(ManagedEntityManager.class);

        Person linda = new Person("Linda", 31);
        Person james = new Person("James", 24);
        Person susan = new Person("Susan", 34);
        Person john = new Person("John", 33);

        System.out.println(linda);
        System.out.println(james);
        System.out.println(susan);
        System.out.println(john);

        System.out.println("Writing to DB");
        entityManager.persist(linda);
        entityManager.persist(james);
        entityManager.persist(susan);
        entityManager.persist(john);

        System.out.println(linda);
        System.out.println(james);
        System.out.println(susan);
        System.out.println(john);
    }
}
