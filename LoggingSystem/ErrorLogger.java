package LoggingSystem;

public class ErrorLogger extends Logger{

    public ErrorLogger(Logger nextLevel) {
        super(nextLevel);
    }

    @Override
    public void log(LogLevel level, String message) {
        if(level == LogLevel.ERROR){
            System.out.println("ERROR: "+message);
        }
        else{
            super.log(level,message);
        }
    }

}
