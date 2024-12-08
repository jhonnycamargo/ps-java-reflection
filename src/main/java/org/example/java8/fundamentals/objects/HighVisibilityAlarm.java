package org.example.java8.fundamentals.objects;

public class HighVisibilityAlarm extends Alarm {

    public HighVisibilityAlarm(String message) {
        super(message);
    }

    public String getReport(boolean uppercase) {
        if (active && !isSnoozing()) {
            if (uppercase) {
                return message.toUpperCase() + "!";
            } else {
                return message + "!";
            }
        } else {
            return "";
        }
    }
}
