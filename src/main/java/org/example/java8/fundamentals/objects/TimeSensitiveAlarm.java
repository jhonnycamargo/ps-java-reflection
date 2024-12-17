package org.example.java8.fundamentals.objects;

import java.awt.*;
import java.time.LocalDateTime;

public final class TimeSensitiveAlarm extends Alarm {
    public TimeSensitiveAlarm(String message) {
        super(message);
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public String getReport(boolean uppercase) {
        String report = super.getReport(uppercase);
        if (report.isEmpty()) {
            return report;
        } else {
            return LocalDateTime.now() + ": " + report;
        }
    }
}
