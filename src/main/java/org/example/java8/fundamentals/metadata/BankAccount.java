package org.example.java8.fundamentals.metadata;

@ProcessedBy(AccountWorker.class)
public class BankAccount {
    private final String id;
    private int balance = 0;

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

    @Override
    public String toString() {
        return "BankAccount{id='" + id + "', balance=" + balance + "}";
    }
}
