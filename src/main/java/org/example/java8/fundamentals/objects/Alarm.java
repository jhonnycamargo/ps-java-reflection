package org.example.java8.fundamentals.objects;

public class Alarm {
    private boolean active;
    final String message;

    Alarm() {
        this("Some default message");
    }

    Alarm(String message) {
        this.message = message;
    }

    Alarm(boolean active, String message) {
        this.active = active;
        this.message = message;
    }

    public void turnOn() {
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
