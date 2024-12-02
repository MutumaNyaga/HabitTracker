package com.example.habittracker;

public class Habit {
    private String name;
    private String reminderTime;
    private boolean isCompleted;

    public Habit(String name, String reminderTime, boolean isCompleted) {
        this.name = name;
        this.reminderTime = reminderTime;
        this.isCompleted = isCompleted;
    }

    public String getName() {
        return name;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
