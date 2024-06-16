package org.example.logappender;

import org.example.LogMessage;

public class ConsoleAppender extends LogAppender {
    @Override
    public void logMessage(LogMessage logMessage) {
        System.out.println(logMessage);
    }
}
