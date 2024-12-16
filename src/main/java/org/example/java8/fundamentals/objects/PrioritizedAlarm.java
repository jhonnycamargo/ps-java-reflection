package org.example.java8.fundamentals.objects;

import java.awt.*;

public final class PrioritizedAlarm extends Alarm{
    private final int priority;

    public PrioritizedAlarm() {
        super();
        priority = 0;
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    public PrioritizedAlarm(String message, int priority) {
        super(message);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static void main(String[] args) {
        PrioritizedAlarm alarm = new PrioritizedAlarm("Temperature too high", 42);
        alarm.turnOn();
        alarm.snooze(1);
        System.out.println(alarm.getReport());
    }
}
