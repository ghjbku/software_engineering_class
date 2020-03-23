package pkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.error("this is an error message");
        logger.warn("a warning");
        logger.info("its an info message");
        logger.debug("debug message");
        logger.trace("trace message");
        logger.info("user's name is {}",System.getProperty("user.name"));
        logger.error("something is wrong!", new RuntimeException("omg"));
    }
}
