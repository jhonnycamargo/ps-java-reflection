package org.example.java8.fundamentals.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Adder {
    private String inFile, outFile;
    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() throws IOException {
        // Add contents of inFile and write to outFile
        int total = 0;
        String line = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while ((line = reader.readLine()) != null) {
                total += Integer.parseInt(line);
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))) {
            writer.write("Total: " + total);
        }
    }

    public static void main(String[] args) throws IOException {
        String[] inFiles = {"./file1.txt", "./file2.txt", "./file3.txt"};
        String[] outFiles = {"./file1.out.txt", "./file2.out.txt", "./file3.out.txt"};

        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            adder.doAdd();
        }
    }

}
