package Exceptions;

import Logging.MyLogger;

import java.util.logging.Logger;

public class CreateCommandsExceptions extends Exception {
    private final String expMessage;
    private final Logger LOGGER = MyLogger.getLogger();

    public CreateCommandsExceptions(String expMessage) {
        this.expMessage = expMessage;
    }

    public void printException() {
        System.err.println(expMessage);
        LOGGER.severe(expMessage + "\n");
    }
}



