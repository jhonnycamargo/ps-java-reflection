package org.example.java8.fundamentals.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DispatchingTransactions {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        TxWorker[] workers = new TxWorker[5];

        for (TxWorker worker : workers) {
            es.submit(worker);
        }
    }
}
