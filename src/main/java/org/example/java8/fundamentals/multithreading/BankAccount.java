package org.example.java8.fundamentals.multithreading;

public class BankAccount {
    private int balance;
    public BankAccount(int startBalance) {
        this.balance = startBalance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
