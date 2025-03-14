package org.example.java8.fundamentals.multithreading;

public class Worker implements Runnable {
    private BankAccount account;

    public Worker(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int startBalance = account.getBalance();
            synchronized (account) {
                account.deposit(10);
            }

            int endBalance = account.getBalance();
        }
    }
}
