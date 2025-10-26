package dev.clonopoly.utils;

import dev.clonopoly.ui.DebugWindow;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance = null;
    private DebugWindow debugWindow;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setDebugWindow(DebugWindow window) {
        this.debugWindow = window;
    }

    private String getTimestamp() {
        return "[" + LocalDateTime.now().format(TIME_FORMATTER) + "]";
    }

    public void log(String message) {
        String timestampedMessage = getTimestamp() + " " + message;
        if (debugWindow != null) {
            debugWindow.logMessage(timestampedMessage);
        } else {
            System.out.println(timestampedMessage);
        }
    }

    public void logError(String message) {
        log("[ERROR] " + message);
    }

    public void logInfo(String message) {
        log("[INFO] " + message);
    }

    public void logDebug(String message) {
        log("[DEBUG] " + message);
    }
}