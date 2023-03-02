package Commands;

import Calculator.Calculator;
import Logging.MyLogger;

import java.util.logging.*;
import java.util.logging.Level;

public class Plus implements Command {
    private final Logger LOGGER = new MyLogger().getLog();

    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        if (commandArgs.length != 1) {
            System.err.println("Unknown args in Plus command.");
            LOGGER.log(Level.SEVERE, "Unknown args in Plus command.\n");
            //throw new IllegalArgumentException("Invalid arguments for PLUS command.");
        } else if (parameters.getStack().size() < 2) {
            System.err.println("Stack must have at least two elements to perform the Plus operation.");
            LOGGER.log(Level.SEVERE, "Stack must have at least two elements to perform the Plus operation.\n");
            // throw new RuntimeException("Stack must have at least two elements to perform the PLUS operation.");
        } else {
            // String strVal1 = parameters.getStack().pop();
            //String strVal2 = parameters.getStack().pop();
            double doubleVal1 = parameters.getStack().pop();
            double doubleVal2 = parameters.getStack().pop();
            double res = doubleVal1 + doubleVal2;
            LOGGER.log(Level.INFO, "Plus: " + doubleVal1 + " + " + doubleVal2 + ".\n");
            // parameters.getVariablesMap().put(Double.toString(res), res);
            parameters.getStack().push(res);
        }
    }
}
