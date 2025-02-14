package org.example.java8.fundamentals.metadata;


public final class HighVolumeAccount extends BankAccount implements Runnable {

    public HighVolumeAccount(String id, int balance) {
        super(id, balance);
    }

    private int[] readDailyDeposits() {
        return new int[] {5, 5, 5, 5, 5};
    }

    private int[] readDailyWithdrawals() {
        return new int[] {5, 5, 5, 5, 5};
    }

    public void run() {
        for (int depositAmt : readDailyDeposits()) {
            deposit(depositAmt);
        }

        for (int withdrawalAmt : readDailyWithdrawals()) {
            withdraw(withdrawalAmt);
        }
    }
}
