package Commands;

import Calculator.Calculator;
import Logging.MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Print implements Command {
    private final Logger LOGGER = new MyLogger().getLog();

    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        if (commandArgs.length != 1) {
            System.err.println("Unknown args in PRINT command.");
            LOGGER.log(Level.SEVERE, "Unknown args in PRINT command.\n");
            //  throw new IllegalArgumentException("Unknown args in PRINT command.");
        } else if (parameters.getStack() == null || parameters.getStack().empty()) {
            System.err.println("Stack is empty. Top element can not be print.");
            LOGGER.log(Level.SEVERE, "Stack is empty. Top element can not be print.\n");
            // throw new RuntimeException("Stack is empty. Top element can not be print.");
        } else {
            double printValue = parameters.getStack().peek();
            System.out.println(printValue);
            LOGGER.log(Level.INFO, "Print top element of stack: " + printValue + "\n");
        }
    }
}
