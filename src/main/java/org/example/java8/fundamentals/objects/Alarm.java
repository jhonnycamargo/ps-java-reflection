package org.example.java8.fundamentals.objects;

import java.time.LocalDateTime;

public class Alarm {
    private boolean active;
    private final String message;
    private LocalDateTime snoozeUntil;

    Alarm() {
        this("Some default message");
    }

    Alarm(String message) {
        this.message = message;
        stopSnoozing();
    }

    Alarm(boolean active, String message) {
        this.active = active;
        this.message = message;
    }

    void snooze() {
        if (active) {
            snoozeUntil = LocalDateTime.now().plusMinutes(5);
        }
    }

    boolean isSnoozing() {
        return snoozeUntil.isAfter(LocalDateTime.now());
    }

    void stopSnoozing() {
        snoozeUntil = LocalDateTime.now().minusSeconds(1);
    }

    public void turnOn() {
        active = true;
        stopSnoozing();
    }

    void turnOff() {
        active = false;
        stopSnoozing();
    }

    String getReport() {
        return getReport(false);
    }

    String getReport(boolean uppercase) {
        if (active && !isSnoozing()) {
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

    public static void main(String[] args) throws InterruptedException {
        Alarm alarm = new Alarm("Temperature too high!");
        alarm.turnOn();
        alarm.snooze();
        Thread.sleep(60000 * 6);
        alarm.sendReport();
    }
}
