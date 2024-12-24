package org.example.java8.fundamentals.multithreading;

import java.io.*;

public class Adder implements Runnable{
    private String inFile, outFile;

    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() throws IOException {

    }

    @Override
    public void run() {
        try {
            doAdd();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
