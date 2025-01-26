package org.example.java8.fundamentals.reflection;

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

    public String getId() {
        return id;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        balance -= amount;
    }
}
