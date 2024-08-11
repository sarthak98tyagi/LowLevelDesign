package LoggingSystem;

public class InfoLogger extends Logger{

    public InfoLogger(Logger nextLevel) {
        super(nextLevel);
    }

    @Override
    public void log(LogLevel level, String message) {
        if(level==LogLevel.INFO){
            System.out.println("INFO: "+message);
        }
        else{
            super.log(level,message);
        }
    }

}
