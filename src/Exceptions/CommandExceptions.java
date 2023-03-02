package Exceptions;

import Logging.MyLogger;

import java.util.logging.Logger;
import java.util.logging.Level;

public class CommandExceptions extends Exception {
    private final String exp_message;
    private final Logger LOGGER = MyLogger.getLogger();

    public CommandExceptions(String exp_message) {
        this.exp_message = exp_message;
    }

    public void printException() {
        System.err.println(exp_message);
        LOGGER.severe(exp_message + "\n");
    }
}



