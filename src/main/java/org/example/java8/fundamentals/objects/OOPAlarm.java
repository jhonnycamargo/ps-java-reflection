package org.example.java8.fundamentals.objects;

public class OOPAlarm {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        alarm.turnOn();
        alarm.sendReport();
        alarm.turnOff();
        alarm.sendReport();
    }
}
