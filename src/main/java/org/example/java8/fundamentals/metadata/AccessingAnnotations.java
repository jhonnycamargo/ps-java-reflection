package org.example.java8.fundamentals.metadata;

import org.example.java8.fundamentals.reflection.TaskWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccessingAnnotations {

    ExecutorService pool = Executors.newFixedThreadPool(5);

    void startWork(String workerTypeName, Object workerTarget) throws Exception {
        Class<?> workerType = Class.forName(workerTypeName);
        TaskWorker worker = (TaskWorker) workerType.newInstance();
        worker.setTarget(workerTarget);
        WorkHandler wh = workerType.getAnnotation(WorkHandler.class);
        if (wh == null) {
            throw new RuntimeException("No WorkHandler annotation found on class " + workerTypeName);
        }

        if (wh.useThreadPool()) {
            pool.submit(new Runnable() {
                public void run() {
                    worker.doWork();
                }
            });
        } else {
            worker.doWork();
        }
    }

    public static void main(String[] args) throws Exception {
        AccessingAnnotations aa = new AccessingAnnotations();
        aa.startWork("org.example.java8.fundamentals.metadata.AccountWorker", new BankAccount("1234", 500));

        aa.startWorkSelfContained(new BankAccount("1234", 500));
    }

    private void startWorkSelfContained(Object workerTarget) throws InstantiationException, IllegalAccessException {
        Class<?> targetType = workerTarget.getClass();
        ProcessedBy pb = targetType.getAnnotation(ProcessedBy.class);
        Class<?> workerType = pb.value();
        TaskWorker worker = (TaskWorker) workerType.newInstance();
        worker.setTarget(workerTarget);
        WorkHandler wh = workerType.getAnnotation(WorkHandler.class);
        if (wh == null) {
            throw new RuntimeException("No WorkHandler annotation found on class ");
        }

        if (wh.useThreadPool()) {
            pool.submit(new Runnable() {
                public void run() {
                    worker.doWork();
                }
            });
        } else {
            worker.doWork();
        }
    }
}
