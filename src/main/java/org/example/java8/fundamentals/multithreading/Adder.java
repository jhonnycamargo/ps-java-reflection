package org.example.java8.fundamentals.multithreading;

import java.io.*;

public class Adder {
    private String inFile, outFile;

    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() throws IOException {
        int total = 0;
        String line = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(inFile))) {
            while ((line = reader.readLine()) != null) {
                total += Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            writer.write("Total: " + total);
        } catch (IOException e) {
            e.printStackTrace();

}
