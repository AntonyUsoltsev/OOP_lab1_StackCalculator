package Commands;

import Calculator.Calculator;
import Exceptions.CommandExceptions;

public class Define extends Command {
    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        try {
            if (commandArgs.length != 3) {
                throw new CommandExceptions("Invalid arguments for Define command.");
            } else if (commandArgs[1].matches("^[0-9]*[.,]?[0-9]+$")) {
                throw new CommandExceptions("Wrong type of first definitive value.");
            } else if ((parameters.getVariablesMap().containsKey(commandArgs[1]))) {
                throw new CommandExceptions("The variable \"" + commandArgs[1] + "\" has been defined earlier.");
            } else {
                try {
                    double value = Double.parseDouble(commandArgs[2]);
                    parameters.getVariablesMap().put(commandArgs[1], value);
                    LOGGER.info("The variable \"" + commandArgs[1] + "\" has defined by " + value + ".\n");
                } catch (NumberFormatException exp) {    // Parse double will throw NumberFormatException
                    throw new CommandExceptions("Wrong type of second definitive value.");
                }
            }
        } catch (CommandExceptions commExc) {
            commExc.printException();
        }
    }
}
