package org.example.java8.fundamentals.polymorphism;

import org.example.java8.fundamentals.objects.HighVisibilityAlarm;

public class Program {
    public static void main(String[] args) {
        HighVisibilityAlarm alarm = new HighVisibilityAlarm("Pressure low");
        alarm.turnOn();
        alarm.snooze(1);
        System.out.println(alarm.getReport());

        alarm.turnOff();
    }
}
