package org.example.java8.fundamentals.objects;

public class Alarm {
    boolean active;
    final String message;

    Alarm() {
        active = false;
        message = "Alarm is off";
    }

    Alarm(String message) {
        this.message = message;
    }

    Alarm(boolean active, String message) {
        this.active = active;
        this.message = message;
    }

    void turnOn() {
        active = true;
    }

    void turnOff() {
        active = false;
    }

    String getReport() {
        return getReport(false);
    }

    String getReport(boolean uppercase) {
        if (active) {
            if (uppercase) {
                return message.toUpperCase();
            } else {
                return message;
            }
        } else {
            return "";
        }
    }

    void sendReport() {
        System.out.println(getReport(true));
    }
}
