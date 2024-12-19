package org.example.java8.fundamentals.polymorphism;

import org.example.java8.fundamentals.objects.Alarm;
import org.example.java8.fundamentals.objects.HighVisibilityAlarm;

public class Program {
    public static void main(String[] args) {
        HighVisibilityAlarm alarm = new HighVisibilityAlarm("Temperature too high");
        activate(alarm);
        printHelpText(alarm);
        saveItTwice(alarm);
    }

    private static void saveItTwice(PersistentObject persistentObject) {
        persistentObject.save();
        persistentObject.save();
    }

    private static void printHelpText(Widget widget) {
        System.out.println(widget.getHelpText());
    }

    private static void activate(Alarm alarm) {
        alarm.turnOn();
    }

    private static void showAlarmStatus(Alarm alarm) {
        System.out.println("Is Snoozing: " + alarm.isSnoozing());
    }

    public static void main(String[] args) {
        HighVisibilityAlarm alarm = new HighVisibilityAlarm("Temperature too high");
        activate(alarm);
        printHelpText(alarm);
    }
}
