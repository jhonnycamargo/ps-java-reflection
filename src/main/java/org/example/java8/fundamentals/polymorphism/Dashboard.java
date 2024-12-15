package org.example.java8.fundamentals.polymorphism;

import org.example.java8.fundamentals.objects.Alarm;

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
}
