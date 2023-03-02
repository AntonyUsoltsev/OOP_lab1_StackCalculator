package Commands;

import Calculator.Calculator;
import Logging.MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Sqrt implements Command {
    private final Logger LOGGER = new MyLogger().getLog();

    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        if (commandArgs.length != 1) {
            System.err.println("Unknown args in SQRT command.");
            LOGGER.log(Level.SEVERE, "Unknown args in SQRT command.\n");
            // throw new IllegalArgumentException("Unknown args in SQRT command.");
        } else if (parameters.getStack() == null || parameters.getStack().empty()) {
            System.err.println("Stack must have at least one elements to perform the Sqrt operation.");
            LOGGER.log(Level.SEVERE, "Stack must have at least two elements to perform the Sqrt operation.\n");
            //throw new RuntimeException("Stack is empty. Can not count square root.");
        }
        //String str_val1 = parameters.getStack().pop();
        double doubleVal = parameters.getStack().pop();
        if (doubleVal < 0) {
            System.err.println("Square root from negative number.");
            LOGGER.log(Level.SEVERE, "Square root from negative number.\n");
            //throw new RuntimeException("Square root from negative number.");
        }
        double res = Math.sqrt(doubleVal);
        LOGGER.log(Level.INFO, "Square root from " + doubleVal + ".\n");
        //parameters.getVariablesMap().put(Double.toString(res), res);
        parameters.getStack().push(res);
    }
}
