package org.example.java8.fundamentals.reflection;

public final class HighVolumeAccount extends BankAccount {

    public HighVolumeAccount(String id) {
        super(id);
    }

    public HighVolumeAccount(String id, int balance) {
        super(id, balance);
    }

    private int[] readDailyDeposits() {
        return new int[] {5, 5, 5, 5, 5};
    }

    private int[] readDailyWithdrawals() {
        return new int[] {5, 5, 5, 5, 5};
    }

    public String run() {
        for (int depositAmt : readDailyDeposits()) {
            deposit(depositAmt);
        }

        for (int withdrawalAmt : readDailyWithdrawals()) {
            withdraw(withdrawalAmt);
        }

        return "High volume account processed";
    }
}
