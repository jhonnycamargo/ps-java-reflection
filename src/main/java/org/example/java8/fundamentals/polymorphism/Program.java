package org.example.java8.fundamentals.polymorphism;

import org.example.java8.fundamentals.objects.Alarm;
import org.example.java8.fundamentals.objects.HighVisibilityAlarm;
import org.example.java8.fundamentals.objects.PrioritizedAlarm;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Alarm alarm = new HighVisibilityAlarm("Your hair is on fire");
        alarm.turnOn();
        System.out.println(alarm);
    }

    private static void showAlarmStatus(Alarm alarm) {
        System.out.println("Is Snoozing: " + alarm.isSnoozing());
    }
}
