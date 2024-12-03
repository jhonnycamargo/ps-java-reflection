package org.example.java8.fundamentals.objects;

public class Alarm {
    boolean active;
    String message = "Alarm is active";

    void turnOn() {
        active = true;
    }

    void turnOff() {
        active = false;
    }

    String getReport() {
        return message;
    }

    String getReport(boolean uppercase) {
        if (uppercase) {
            return message.toUpperCase();
        } else {
            return message;
        }
    }

    void sendReport() {
        System.out.println(getReport());
    }
}
