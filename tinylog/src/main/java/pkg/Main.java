package pkg;

import org.tinylog.Logger;

public class Main {

    public static void main(String[] args) {
        Logger.error("error message");
        Logger.warn("warn message");
        Logger.info("info message");
        Logger.debug("a debug message");
        Logger.trace("trace message");
        Logger.info("user's name: {}", System.getProperty("user.name"));
        Logger.error(new RuntimeException("oops"), "Something happened");
    }
}
