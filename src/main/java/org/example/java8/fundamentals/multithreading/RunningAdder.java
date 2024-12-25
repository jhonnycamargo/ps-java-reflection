package org.example.java8.fundamentals.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunningAdder {

    public static void main(String[] args) {
        String[] inFiles = {"./src/main/resources/file1.txt", "./src/main/resources/file2.txt", "./src/main/resources/file3.txt", "./src/main/resources/file4.txt", "./src/main/resources/file5.txt"};
        String[] outFiles = {"./src/main/resources/file1.out.txt", "./src/main/resources/file2.out.txt", "./src/main/resources/file3.out.txt", "./src/main/resources/file4.out.txt", "./src/main/resources/file5.out.txt"};

        try {
            ExecutorService es = Executors.newFixedThreadPool(3);
            for (int i = 0; i < inFiles.length; i++) {
                Adder adder = new Adder(inFiles[i], outFiles[i]);
                es.submit(adder);
            }
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
