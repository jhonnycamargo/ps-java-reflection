package org.example.java8.fundamentals;

public class UsingSystemProperties {

    public static void main(String[] args) {
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        String osArchitecture = System.getProperty("os.arch");
        String javaVendor = System.getProperty("java.vendor");

        System.out.println(userName);
        System.out.println(userHome);
        System.out.println(osArchitecture);
        System.out.println(javaVendor);
    }
}
