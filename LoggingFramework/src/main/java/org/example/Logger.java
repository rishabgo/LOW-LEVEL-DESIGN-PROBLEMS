package org.example;

import org.example.logappender.ConsoleAppender;

import java.time.LocalDateTime;

public final class Logger {
    private static Logger logger = null;
    private LogConfiguration logConfiguration;

    private Logger() {
        logConfiguration = LogConfiguration.newBuilder()
                .setLogLevel(LogLevel.INFO)
                .setLogAppender(new ConsoleAppender())
                .build();
    }

    public void setLogConfiguration(LogConfiguration logConfiguration) {
        this.logConfiguration = logConfiguration;
    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    private void log(LogLevel logLevel, String content) {
        LogMessage logMessage = LogMessage.newBuilder()
                .setMessage(content)
                .setDateTime(LocalDateTime.now())
                .setLogLevel(logLevel)
                .build();
        if (logConfiguration.getLogLevel().getVal() >= logLevel.getVal()) {
            logConfiguration.getLogAppender().logMessage(logMessage);
        }
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
