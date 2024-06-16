package org.example.logappender;

import org.example.LogMessage;

public abstract class LogAppender {
    public abstract void logMessage(LogMessage logMessage);
}
