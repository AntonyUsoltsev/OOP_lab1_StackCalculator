package Logging;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
 public  class  MyLogger {
    private static final Logger LOGGER = java.util.logging.Logger.getLogger(Logger.class.getName());

    static {
        try(FileInputStream configFile = new FileInputStream("src/Logging/log_config")) {
            LogManager.getLogManager().readConfiguration(configFile);
            LOGGER.log(Level.CONFIG, "Read log file\n");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error loading logger configuration file", e);

        }
    }
    public static Logger getLog(){
        return LOGGER;
    }


//    public MyLogger() {
//        try(FileInputStream configFile = new FileInputStream("src/Logging/log_config")) {
//            LogManager.getLogManager().readConfiguration(configFile);
//            LOGGER.log(Level.CONFIG, "Read log file");
//        }
//        catch (IOException e){
//            LOGGER.log(Level.SEVERE, "Can not read log file:" + e);
//        }
//    }

}
