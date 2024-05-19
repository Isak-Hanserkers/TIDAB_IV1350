package se.kth.iv1350.seminar4.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This is the class responsible for the log, based on the code in listing 8.25
 * on page 189 of the course literature book.
 */
public class LogManager {

    private static final String LOG_FILE_NAME = "developer_log.txt";

    private PrintWriter logFile;

    /**
     * This is the constructor for the class responsible for the log.
     *
     * @throws java.io.IOException if something goes wrong.
     */
    public LogManager() throws IOException {
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
    }

    /**
     * This a method that writes to the log about what exception ocurred and
     * where, as well as the time when it happened.
     *
     * @param exception is the specific exception that occured.
     */
    public void logException(Exception exception) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);

    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
