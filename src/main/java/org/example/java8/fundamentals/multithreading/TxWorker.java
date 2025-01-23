package org.example.java8.fundamentals.multithreading;

public class TxWorker implements Runnable {

    protected BankAccount account;
    protected char txType;
    protected int amt;

}
