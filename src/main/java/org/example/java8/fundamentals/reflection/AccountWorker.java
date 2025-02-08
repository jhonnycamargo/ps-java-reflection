package org.example.java8.fundamentals.reflection;

public class AccountWorker implements Runnable, TaskWorker {
    BankAccount ba;

    public void setTarget(Object target) {
        if (BankAccount.class.isInstance(target)) {
            ba = (BankAccount) target;
        } else {
            throw new IllegalArgumentException("Target is not an instance of BankAccount");
        }
    }

    public void doWork() {
        Thread t = new Thread(HighVolumeAccount.class.isInstance(ba) ? (HighVolumeAccount) ba : this);
        t.start();
    }

    HighVolumeAccount hva;

    public AccountWorker(BankAccount ba) {
        this.ba = ba;
    }

    public AccountWorker(HighVolumeAccount hva) {
        this.hva = hva;
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
