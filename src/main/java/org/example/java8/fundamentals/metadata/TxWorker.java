package org.example.java8.fundamentals.metadata;

import org.example.java8.fundamentals.reflection.BankAccount;

public class TxWorker {
    protected BankAccount account;
    protected char txType;
    protected int amt;

    public TxWorker(BankAccount account, char txType, int amt) {
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }

    public void run() {
        if (txType == 'w') {
            account.withdraw(amt);
        } else {
            account.deposit(amt);
        }
    }
}
