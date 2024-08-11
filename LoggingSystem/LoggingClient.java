package LoggingSystem;

public class LoggingClient {

    public static void main(String[] args) {
        Logger logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
        logger.log(LogLevel.INFO,"Process Initiated");
        logger.log(LogLevel.DEBUG, "Returning meta-data");
        logger.log(LogLevel.ERROR, "Null Pointer Exception");
    }
}
