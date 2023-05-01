package framework;

import org.slf4j.LoggerFactory;
import org.testng.Reporter;

public class Logger extends Reporter {

    protected final static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    public static void info(String log) {
        logger.info(log);
        log(log + "</br>");
    }
}
