package org.example.java8.fundamentals.reflection;

public class DispatchInvocation {

    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount("1234");
        var dispatchInvocation = new DispatchInvocation();
        dispatchInvocation.startWork("org.example.java8.fundamentals.reflection.AccountWorker", acct1);
    }

    void startWork(String workerTypeName, Object workerTarget) {
        try {
            Class<?> workerType = Class.forName(workerTypeName);
            TaskWorker worker = (TaskWorker) workerType.newInstance();
            worker.setTarget(workerTarget);
            worker.doWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
