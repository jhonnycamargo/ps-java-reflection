package org.example.java8.fundamentals.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BankAccount {

    private final String id;
    private int balance = 0;

    public BankAccount(String id) {
        this.id = id;
    }

    public BankAccount(String id, int startBalance) {
        this.id = id;
        this.balance = startBalance;
    }

    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount("1234", 500);
        acct1.deposit(100);
        System.out.println(acct1);
        saveAccount(acct1, "account.dat");
    }

    private static void saveAccount(BankAccount ba, String fileName) {
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            os.writeObject(ba);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void deposit(int i) {
        balance += i;
    }

    BankAccount loadAccount(String fileName) {
        BankAccount ba = null;
        try (ObjectInputStream is = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            ba = (BankAccount) is.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ba;
    }
}
