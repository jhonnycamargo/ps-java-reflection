package org.example.java8.fundamentals.multithreading;

public class TxWorker implements Runnable {

    protected BankAccount account;
    protected char txType;
    protected int amt;

    public TxWorker(BankAccount account, char txType, int amt) {
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }

    @Override
    public void run() {
        if (txType == 'w') {
            account.withdraw(amt);
        } else if (txType == 'd') {
            account.deposit(amt);
        }
    }
}
