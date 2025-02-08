package org.example.java8.fundamentals.reflection;

public class DispatchInvocation {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount("1234");
        AccountWorker aw = new AccountWorker(ba);
        aw.doWork();
    }
}
