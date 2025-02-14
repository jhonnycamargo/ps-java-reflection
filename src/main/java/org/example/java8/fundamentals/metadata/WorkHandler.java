package org.example.java8.fundamentals.metadata;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface WorkHandler {
    boolean useThreadPool() default false;
}
