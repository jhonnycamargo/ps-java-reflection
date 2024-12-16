package org.example.java8.fundamentals.polymorphism;

import org.example.java8.fundamentals.objects.Alarm;
import org.example.java8.fundamentals.objects.HighVisibilityAlarm;
import org.example.java8.fundamentals.objects.PrioritizedAlarm;
import org.example.java8.fundamentals.objects.TimeSensitiveAlarm;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {
    private final List<Alarm> allAlarms = new ArrayList<>();

    public void add(Alarm alarm) {
        alarm.turnOn();
        allAlarms.add(alarm);
    }

    public void printBigReport() {
        for (Alarm alarm : allAlarms) {
            System.out.println(alarm.getReport(true));
        }
    }

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();

        dashboard.add(new PrioritizedAlarm("Temperature too high", 42));
        dashboard.add(new HighVisibilityAlarm("Pressure low"));
        dashboard.add(new TimeSensitiveAlarm("Never mind the other alarms, you're late for dinner"));

        dashboard.printBigReport();
    }
}
