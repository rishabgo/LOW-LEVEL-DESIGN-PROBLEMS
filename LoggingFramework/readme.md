Logging Framework System Design

Requirements
1. System should support multiple log levels like info, debug, error.
2. System should log message with content, timestamp, log level.
3. System should allow multiple sinks where logs will be appended like console, file, database.
4. System should allow user to set custom configuration like setting log level and log output destination.
5. It should be extensible to accommodate new log level and output destination in the future.
6. If log level is set to lower level, all logs which have log level greater in hierarchy will be displayed.
7. System should be thread safe to handle concurrent logging from multiple threads.