package Commands;

import Calculator.Calculator;
import Logging.MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Define implements Command {

    private final Logger LOGGER = MyLogger.getLog();

    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        if (commandArgs.length != 3) {
            System.err.println("Unknown args in DEFINE command.");
            LOGGER.log(Level.SEVERE, "Unknown args in DEFINE command.\n");
            return;
            //  throw new IllegalArgumentException("Unknown args in DEFINE command.");
        }

        if (commandArgs[1].matches("^[0-9]*[.,]?[0-9]+$")) {
            System.err.println("Wrong type of first definitive value.");
            LOGGER.log(Level.SEVERE, "Wrong type of first definitive value.\n");
            // throw new IllegalArgumentException("Wrong type of first definitive value");
        } else {
            try {
                if (parameters.getVariablesMap().containsKey(commandArgs[1])) {
                    System.err.println("The variable \"" + commandArgs[1] + "\" has been defined earlier.");
                    LOGGER.log(Level.SEVERE, "The variable \"" + commandArgs[1] + "\" has been defined earlier.\n");
                    return;
                    // throw new IllegalArgumentException("The variable \"" + command_args[1] + "\" has been defined");
                }

                double value = Double.parseDouble(commandArgs[2]);
                parameters.getVariablesMap().put(commandArgs[1], value);
                LOGGER.log(Level.INFO, "The variable \"" + commandArgs[1] + "\" has defined by " + value + ".\n");

            } catch (NumberFormatException exp) { // Parse double will throw exception
                System.err.println("Wrong type of second definitive value.");
                LOGGER.log(Level.SEVERE, "Wrong type of second definitive value.\n");
                // throw new IllegalArgumentException("Wrong type of second definitive value");
            }

        }
    }
}
