package org.example.java8.fundamentals.objects;

public class HighVisibilityAlarm extends Alarm {

    public HighVisibilityAlarm(String message) {
        super(message);
    }

    public String getReport(boolean uppercase) {
        String report = super.getReport(uppercase);
        if (report.isEmpty()) {
            return report;
        } else {
            return report + "!";
        }
    }

    public static void main(String[] args) {
        HighVisibilityAlarm alarm = new HighVisibilityAlarm("Temperature too high");
        alarm.turnOn();
        alarm.sendReport();
    }
}
