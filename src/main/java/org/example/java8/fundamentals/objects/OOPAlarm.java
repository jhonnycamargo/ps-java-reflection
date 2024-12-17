package org.example.java8.fundamentals.objects;

public class OOPAlarm {
    public static void main(String[] args) {
        Alarm alarm = new HighVisibilityAlarm("Temperature too high");
        alarm.turnOn();
        alarm.sendReport();
        alarm.snooze(25);
    }
}
