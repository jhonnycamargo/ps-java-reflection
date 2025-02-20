package org.example.java8.fundamentals.serializable;

import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BankAccount {

    private final String id;
    private int balance = 0;

    public BankAccount(String id) {
        this.id = id;
    }

    public BankAccount(String id, int startBalance) {
        this.id = id;
        this.balance = startBalance;
    }

    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount("1234", 500);
        acct1.deposit(100);
        System.out.println(acct1);
        saveAccount(acct1, "account.dat");
    }

    private static void saveAccount(BankAccount ba, String fileName) {
        new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));

    }

    private void deposit(int i) {
        balance += i;
    }
}
