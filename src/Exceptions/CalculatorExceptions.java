package Exceptions;

import Logging.MyLogger;

import java.util.logging.Logger;

public class CalculatorExceptions extends Exception {
    private final String expMessage;
    private final Logger LOGGER = MyLogger.getLogger();

    public CalculatorExceptions(String expMessage) {
        this.expMessage = expMessage;
    }
    public void printException() {
        System.err.println(expMessage);
        LOGGER.severe(expMessage + "\n");
    }

    public String getMessage(){
        return expMessage;
    }
}


