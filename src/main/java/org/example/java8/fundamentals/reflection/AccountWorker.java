package org.example.java8.fundamentals.reflection;

public class AccountWorker implements Runnable, TaskWorker {
    BankAccount ba;
    HighVolumeAccount hva;

    public AccountWorker(BankAccount ba) {
        this.ba = ba;
    }

    public AccountWorker(HighVolumeAccount hva) {
        this.hva = hva;
    }

    public void doWork() {
        Thread t = new Thread(hva != null ? hva : this);
        t.start();
    }

    public void run() {
        char txType = 'w';
        int amt = 5;
        if (txType == 'w') {
            ba.withdraw(amt);
        } else {
            ba.deposit(amt);
        }
    }
}
