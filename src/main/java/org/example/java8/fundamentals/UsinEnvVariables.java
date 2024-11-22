package org.example.java8.fundamentals;

public class UsinEnvVariables {

    public static void main(String[] args) {
        System.getenv()
                .forEach((k, v) -> System.out.println(k + " : " + v));

        String userName = System.getenv("USERNAME");
        String home = System.getenv("HOME");

        System.out.println(userName);
        System.out.println(home);
    }
}
