package org.example.java8.fundamentals.polymorphism;

import org.example.java8.fundamentals.objects.Alarm;
import org.example.java8.fundamentals.objects.HighVisibilityAlarm;
import org.example.java8.fundamentals.objects.PrioritizedAlarm;

public class Program {
    public static void main(String[] args) {
        HighVisibilityAlarm alarm = new HighVisibilityAlarm("Pressure low");
        alarm.turnOn();
        String report = alarm.getReport();
        System.out.println(report);

        Alarm alarm2 = new PrioritizedAlarm("Pressure low", 1);

        PrioritizedAlarm myAlarm = new PrioritizedAlarm("Pressure low", 1);
        showAlarmStatus(myAlarm);
    }

    private static void showAlarmStatus(Alarm alarm) {
        System.out.println("Is Snoozing: " + alarm.isSnoozing());
    }
}
