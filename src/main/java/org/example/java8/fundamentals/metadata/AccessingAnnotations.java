package org.example.java8.fundamentals.metadata;

import org.example.java8.fundamentals.reflection.TaskWorker;

public class AccessingAnnotations {

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
}
