import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    // logger constructor to prevent direct instantization
    private Logger(){

    }

    // sonngletonholder class
    private static class SingletonHolder{
        private static final Logger instance = new Logger();
    }
    //public methood for single instance
    public static Logger getInstance(){
        return SingletonHolder.instance;
    }

    
    //to print timestamped messages.
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss");
        String timestamp = now.format(formatter);
        System.out.println("[" + timestamp + "] " + message);
    }


    //demostarting singleton behaviour
    public static void main(String [] args){
        System.out.println("----- Singleton pattern Demonstartion ------\n");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));
        System.out.println("logger1 == logger3: " + (logger1 == logger3));

        System.out.println("\n---- log() Testing  ----");
        logger1.log("Hello there this Message is from logger1");
        logger2.log("Hello there this Message is from logger2");
        logger3.log("Hello there this Message is from logger3");

    }

}