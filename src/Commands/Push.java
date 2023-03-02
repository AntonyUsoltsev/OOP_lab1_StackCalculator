package Commands;

import Calculator.Calculator;
import Logging.MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Push implements Command {
    private final Logger LOGGER = new MyLogger().getLog();

    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        if (commandArgs.length != 2) {
            System.err.println("Unknown args in PUSH command.");
            LOGGER.log(Level.SEVERE, "Unknown args in PUSH command.\n");
            //    throw new IllegalArgumentException("Unknown args in PUSH command");
        }
        if (parameters.getVariablesMap().containsKey(commandArgs[1])) {
            parameters.getStack().push(parameters.getVariablesMap().get(commandArgs[1]));
        } else {
            try {
                double num = Double.parseDouble(commandArgs[1]);
                parameters.getStack().push(num);
                LOGGER.log(Level.INFO, "Push element on stack: " + num + "\n");
                //parameters.getVariablesMap().put(Double.toString(num), num);
            } catch (NumberFormatException e) {
                System.err.println("Pushing variable hasn't been defined.");
                LOGGER.log(Level.SEVERE, "Pushing variable hasn't been defined.\n");
                //   throw new IllegalArgumentException("Pushing variable hasn't been defined.");
            }
        }

    }
}
