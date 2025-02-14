package org.example.java8.fundamentals.metadata;

import org.example.java8.fundamentals.reflection.TaskWorker;

public class AccessingAnnotations {

    void startWork(String workerTypeName, Object workerTarget) throws Exception {
        Class<?> workerType = Class.forName(workerTypeName);
        TaskWorker worker = (TaskWorker) workerType.newInstance();
        worker.setTarget(workerTarget);

        worker.doWork();
    }
}
