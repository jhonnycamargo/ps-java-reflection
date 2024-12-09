package org.example.java8.fundamentals.objects;

public class TemporalObject {
    public static void main(String[] args) {
        Alarm alarm = new Alarm("Temperature too high");
        alarm.turnOn();
        alarm.snooze(1);
        System.out.println(alarm.getReport());

        HighVisibilityAlarm highVisibilityAlarm = new HighVisibilityAlarm("Temperature too high");
    }
}
