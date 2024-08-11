package LoggingSystem;

public abstract class Logger {

    Logger nextLevel;

    public Logger(Logger nextLevel){
        this.nextLevel = nextLevel;
    }

    public void log(LogLevel level, String message){
        if(nextLevel!=null){
            nextLevel.log(level,message);
        }
        else{
            System.out.println("LOG: "+message);
        }
    }
}
