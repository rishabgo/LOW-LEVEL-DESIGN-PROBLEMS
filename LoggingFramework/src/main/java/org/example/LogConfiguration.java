package org.example;

import org.example.logappender.LogAppender;

public class LogConfiguration {
    private final LogLevel logLevel;
    private final LogAppender logAppender;

    private LogConfiguration(LogLevel logLevel, LogAppender logAppender) {
        this.logLevel = logLevel;
        this.logAppender = logAppender;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public LogAppender getLogAppender() {
        return logAppender;
    }

    public static LogConfigurationBuilder newBuilder() {
        return new LogConfigurationBuilder();
    }

    public static class LogConfigurationBuilder {
        private LogLevel logLevel;
        private LogAppender logAppender;

        public LogConfigurationBuilder setLogLevel(LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public LogConfigurationBuilder setLogAppender(LogAppender logAppender) {
            this.logAppender = logAppender;
            return this;
        }

        public LogConfiguration build() {
            return new LogConfiguration(logLevel, logAppender);
        }
    }
}
