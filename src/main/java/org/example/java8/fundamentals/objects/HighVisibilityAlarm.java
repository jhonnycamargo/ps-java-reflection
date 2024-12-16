package org.example.java8.fundamentals.objects;

import java.awt.*;

public final class HighVisibilityAlarm extends Alarm {

    public HighVisibilityAlarm(String message) {
        super(message);
    }

    @Override
    public String getReport(boolean uppercase) {
        String report = super.getReport(uppercase);
        if (report.isEmpty()) {
            return report;
        } else {
            return report + "!";
        }
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    public static void main(String[] args) {
        HighVisibilityAlarm alarm = new HighVisibilityAlarm("Temperature too high");
        alarm.turnOn();
        alarm.sendReport();
    }
}
