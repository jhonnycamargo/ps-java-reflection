package org.example.java8.fundamentals.objects;

public class PrioritizedAlarm extends Alarm{
    private final int priority;

    public PrioritizedAlarm() {
        super();
        priority = 0;
    }

    public PrioritizedAlarm(int priority) {
        super();
        this.priority = priority;
    }

    public PrioritizedAlarm(String message) {
        super(message);
        priority = 0;
    }

    public PrioritizedAlarm(boolean active, String message) {
        super(active, message);
        priority = 0;
    }

    public PrioritizedAlarm(boolean active, String message, int priority) {
        super(active, message);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
