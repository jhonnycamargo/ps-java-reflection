package org.example.java8.fundamentals.multithreading;

public class RunningAdder {

    public static void main(String[] args) {
        String[] inFiles = {"./src/main/resources/file1.txt", "./src/main/resources/file2.txt", "./src/main/resources/file3.txt", "./src/main/resources/file4.txt", "./src/main/resources/file5.txt"};
        String[] outFiles = {"./src/main/resources/file1.out.txt", "./src/main/resources/file2.out.txt", "./src/main/resources/file3.out.txt", "./src/main/resources/file4.out.txt", "./src/main/resources/file5.out.txt"};

        try {
            Thread[] threads = new Thread[inFiles.length];
            for (int i = 0; i < inFiles.length; i++) {
                Adder adder = new Adder(inFiles[i], outFiles[i]);
                threads[i] = new Thread(adder);
                threads[i].start();
            }
            for (Thread thread : threads) {
                thread.join();;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
