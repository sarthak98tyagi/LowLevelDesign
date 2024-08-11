package LoggingSystem;

public class DebugLogger extends Logger {

    public DebugLogger(Logger nextLevel) {
        super(nextLevel);
    }

    @Override
    public void log(LogLevel level, String message) {
        if(level==LogLevel.DEBUG){
            System.out.println("DEBUG: "+message);
        }
        else{
            super.log(level,message);
        }
    }
}
