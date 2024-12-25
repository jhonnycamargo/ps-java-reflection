package org.example.java8.fundamentals.multithreading;

import java.util.concurrent.*;

public class RunningAdder {

    public static void main(String[] args) {
        String[] inFiles = {"./src/main/resources/file1.txt", "./src/main/resources/file2.txt", "./src/main/resources/file3.txt", "./src/main/resources/file4.txt", "./src/main/resources/file5.txt"};
        String[] outFiles = {"./src/main/resources/file1.out.txt", "./src/main/resources/file2.out.txt", "./src/main/resources/file3.out.txt", "./src/main/resources/file4.out.txt", "./src/main/resources/file5.out.txt"};

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i]);
            results[i] = es.submit(adder);
        }
        for (Future<Integer> result : results) {
            try {
                int value = result.get();
                System.out.println("Total: " + value);
            } catch (ExecutionException e) {
                Throwable adderEx = e.getCause();
            } catch (Exception e) {

            }

        }
        es.shutdown();
        //es.awaitTermination(60, TimeUnit.SECONDS);

    }
}
