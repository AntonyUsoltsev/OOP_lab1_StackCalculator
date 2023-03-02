package Commands;

import Calculator.Calculator;
import Logging.MyLogger;

import java.util.logging.*;
import java.util.logging.Level;

public class Minus implements Command {

    private final Logger LOGGER = new MyLogger().getLog();
    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        if (commandArgs.length != 1) {
            System.err.println("Unknown args in Minus command.");
            LOGGER.log(Level.SEVERE, "Unknown args in Minus command.\n");
            //throw new IllegalArgumentException("Invalid arguments for PLUS command.");
        } else if (parameters.getStack().size() < 2) {
            System.err.println("Stack must have at least two elements to perform the Minus operation.");
            LOGGER.log(Level.SEVERE, "Stack must have at least two elements to perform the Minus operation.\n");
            // throw new RuntimeException("Stack must have at least two elements to perform the PLUS operation.");
        } else {
            //String str_val1 = parameters.getStack().pop();
            //String str_val2 = parameters.getStack().pop();
            double doubleVal1 = parameters.getStack().pop();
            double doubleVal2 = parameters.getStack().pop();
            double res = doubleVal1 - doubleVal2;
            LOGGER.log(Level.INFO, "Minus: " + doubleVal1 + "-" + doubleVal2 + ".\n");
            // parameters.getVariablesMap().put(Double.toString(res), res);
            parameters.getStack().push(res);
        }
    }
}
