package Commands;

import Calculator.Calculator;
import Logging.MyLogger;

import java.util.logging.*;
import java.util.logging.Level;

public class Pop implements Command {
    private final Logger LOGGER = new MyLogger().getLog();

    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        if (commandArgs.length != 1) {
            System.err.println("Unknown args in Pop command.");
            LOGGER.log(Level.SEVERE, "Unknown args in Pop command.\n");
            //throw new IllegalArgumentException("Unknown args in POP command.");
        } else if (parameters.getStack().empty()) {
            System.err.println("Stack must have at least one elements to perform the Pop operation.");
            LOGGER.log(Level.SEVERE, "Stack must have at least one elements to perform the Pop operation.\n");
           // throw new RuntimeException("Stack is empty. Can not pop element.");
        } else {
            parameters.getStack().pop();
            LOGGER.log(Level.INFO, "Pop top element.\n");
        }
    }
}
