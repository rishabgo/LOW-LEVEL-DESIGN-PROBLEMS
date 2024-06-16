package org.example;

import java.time.LocalDateTime;

public class LogMessage {
    private final String message;
    private final LocalDateTime dateTime;
    private final LogLevel logLevel;

    private LogMessage(String message, LocalDateTime dateTime, LogLevel logLevel) {
        this.message = message;
        this.dateTime = dateTime;
        this.logLevel = logLevel;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "message='" + message + '\'' +
                ", dateTime=" + dateTime +
                ", logLevel=" + logLevel +
                '}';
    }

    public static LogMessageBuilder newBuilder() {
        return new LogMessageBuilder();
    }

    public static class LogMessageBuilder {
        private String message;
        private LocalDateTime dateTime;
        private LogLevel logLevel;

        public LogMessageBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public LogMessageBuilder setLogLevel(LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public LogMessageBuilder setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public LogMessage build() {
            return new LogMessage(message, dateTime, logLevel);
        }
    }


}
