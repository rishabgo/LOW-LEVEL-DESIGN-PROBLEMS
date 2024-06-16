package org.example;

import org.example.logappender.ConsoleAppender;

public class AppClient {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.info("Hello World");
        logger.debug("This is my first message");

        LogConfiguration config = LogConfiguration.newBuilder()
                .setLogLevel(LogLevel.DEBUG)
                .setLogAppender(new ConsoleAppender())
                .build();
        logger.setLogConfiguration(config);
        logger.debug("This is my second message");
    }
}
