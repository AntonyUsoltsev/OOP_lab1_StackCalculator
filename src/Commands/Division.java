package Commands;

import Calculator.Calculator;
import Logging.MyLogger;


import java.util.logging.*;

public class Division implements Command {

    private final Logger LOGGER = new MyLogger().getLog();

    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        if (commandArgs.length != 1) {
            System.err.println("Unknown args in Division command.");
            LOGGER.log(Level.SEVERE, "Unknown args in Division command.\n");
            //  throw new IllegalArgumentException("Unknown args in DIVISION command.");
        } else if (parameters.getStack().size() < 2) {
            System.err.println("Stack must have at least two elements to perform the Division operation.");
            LOGGER.log(Level.SEVERE, "Stack must have at least two elements to perform the Division operation.\n");
            //throw new RuntimeException("Stack is less than two elements. Can not count division.");
        } else {
            //String str_val1 = parameters.getStack().pop();
            //String str_val2 = parameters.getStack().pop();
            double doubleVal1 = parameters.getStack().pop();
            double doubleVal2 = parameters.getStack().pop();
            if (doubleVal2 == 0) {
                System.err.println("Division by zero.");
                LOGGER.log(Level.SEVERE, "Division by zero.\n");
                return;
                //throw new RuntimeException("Division by zero");
            }
            double res = doubleVal1 / doubleVal2;
            LOGGER.log(Level.INFO, "Division: " + doubleVal1 + " / " + doubleVal2 + "\n");
            // parameters.getVariablesMap().put(Double.toString(res), res);
            parameters.getStack().push(res);
        }
    }
}
