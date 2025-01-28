package org.example.java8.fundamentals.reflection;

public class BankAccountRunner {

    public static void main(String[] args) throws ClassNotFoundException {
        var bankAccountRunner = new BankAccountRunner();
        BankAccount account = new BankAccount("1234");
        bankAccountRunner.doWork(account);

        Class<?> c = Class.forName("org.example.java8.fundamentals.reflection.BankAccount");
        bankAccountRunner.showName(c);

        bankAccountRunner.showName(BankAccount.class);
    }

    void showName(Class<?> theClass) {
        System.out.println(theClass.getSimpleName());
    }

    void doWork(Object obj) {
        Class<?> theClass = obj.getClass();
        showName(theClass);
    }
}
