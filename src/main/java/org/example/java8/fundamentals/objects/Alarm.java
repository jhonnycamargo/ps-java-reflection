package org.example.java8.fundamentals.objects;

import java.time.LocalDateTime;

public class Alarm {
    private boolean active;
    final String message;
    LocalDateTime snoozeUntil;

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

    void snooze() {
        snoozeUntil = LocalDateTime.now().plusMinutes(5);
    }

    boolean isSnoozing() {
        return snoozeUntil.isAfter(LocalDateTime.now());

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
