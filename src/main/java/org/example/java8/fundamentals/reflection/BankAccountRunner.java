package org.example.java8.fundamentals.reflection;

public class BankAccountRunner {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234");
    }

    void showName(Class<?> theClass) {
        System.out.println(theClass.getSimpleName());
    }

    void doWork(Object obj) {
        Class<?> theClass = obj.getClass();
        showName(theClass);
    }
}
