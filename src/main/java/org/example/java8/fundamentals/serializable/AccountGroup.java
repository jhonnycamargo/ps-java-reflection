package org.example.java8.fundamentals.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class AccountGroup {
    private Map<String, BankAccount> accountMap = new HashMap<>();
    private transient int totalBalance;
    public int getTotalBalance() {
        return totalBalance;
    }

    public void addAccount(BankAccount account) {
        totalBalance += account.getBalance();
        accountMap.put(account.getId(), account);
    }

    public static void main(String[] args) {
        AccountGroup group = new AccountGroup();
        BankAccount account1 = new BankAccount("1234", 500);
        BankAccount account2 = new BankAccount("9876", 750);
        group.addAccount(account1);
        group.addAccount(account2);
        System.out.println("Total balance: " + group.getTotalBalance());
        group.saveGroup(group, "group.dat");

        AccountGroup group2 = group.loadGroup("group.dat");
        System.out.println("Total balance: " + group2.getTotalBalance());
    }

    void saveGroup(AccountGroup group, String fileName) {
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            os.writeObject(group);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    AccountGroup loadGroup(String fileName) {
        AccountGroup group = null;
        try (ObjectInputStream is = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            group = (AccountGroup) is.readObject();
            readObject(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return group;
    }

    void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();
        totalBalance = 0;
        accountMap.values().forEach(account -> totalBalance += account.getBalance());
    }
}
