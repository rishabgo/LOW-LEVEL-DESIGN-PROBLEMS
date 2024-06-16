package org.example;

public enum LogLevel {
    INFO(1), DEBUG(2), ERROR(3);

    private final int val;

    LogLevel(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
