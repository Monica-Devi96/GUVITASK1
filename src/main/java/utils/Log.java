package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
    static Logger logger = Logger.getLogger(Log.class);

    public static void startTestCase(String testCaseName) {
        PropertyConfigurator.configure("log4j.properties");
        logger.info("\n==================== " + testCaseName + " ====================");
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void endTestCase() {
        logger.info("==================== END ====================\n");
    }
}
