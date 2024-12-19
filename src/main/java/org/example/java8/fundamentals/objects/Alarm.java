package org.example.java8.fundamentals.objects;

import org.example.java8.fundamentals.polymorphism.PersistentObject;
import org.example.java8.fundamentals.polymorphism.Widget;

import java.awt.*;
import java.time.LocalDateTime;

public abstract class Alarm
        implements Widget, PersistentObject {
    protected boolean active;
    private final String message;
    private LocalDateTime snoozeUntil;

    public Alarm() {
        this("Some default message");
    }

    public Alarm(String message) {
        this.message = message;
        stopSnoozing();
    }

    public Alarm(boolean active, String message) {
        this.active = active;
        this.message = message;
    }

    public abstract Color getColor();

    public LocalDateTime getSnoozeUntil() {
        return snoozeUntil;
    }

    public void snooze(int minutes) {
        if (active) {
            snoozeUntil = LocalDateTime.now().plusMinutes(minutes);
        }
    }

    public boolean isSnoozing() {
        return snoozeUntil.isAfter(LocalDateTime.now());
    }

    private void stopSnoozing() {
        snoozeUntil = LocalDateTime.now().minusSeconds(1);
    }

    public void turnOn() {
        active = true;
        stopSnoozing();
    }

    public void turnOff() {
        active = false;
        stopSnoozing();
    }

    public String getReport() {
        return getReport(false);
    }

    public String getReport(boolean uppercase) {
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

    public void sendReport() {
        System.out.println(getReport(true));
    }

    public static void main(String[] args) throws InterruptedException {
        Alarm alarm = new PrioritizedAlarm("Temperature too high", 42);
        System.out.println(alarm.getColor());
        alarm.turnOn();
        alarm.snooze(5);
        Thread.sleep(6 * 6);
        alarm.sendReport();
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getReport();
    }

    @Override
    public void save() {
        System.out.println("Saving alarm: " + this);
    }

    @Override
    public String getHelpText() {
        return "An alarm that can be turned on and off, snoozed, and sent a report.";
    }
}
