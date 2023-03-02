package Commands;

import Calculator.Calculator;
import Exceptions.CommandExceptions;

public class Push extends Command {
    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        try {
            if (commandArgs.length != 2) {
                throw new CommandExceptions("Invalid arguments for Push command.");
            } else if (parameters.getVariablesMap().containsKey(commandArgs[1])) {
                parameters.getStack().push(parameters.getVariablesMap().get(commandArgs[1]));
            } else {
                try {
                    double num = Double.parseDouble(commandArgs[1]);
                    parameters.getStack().push(num);
                    LOGGER.info( "Push element on stack: " + num + "\n");
                } catch (NumberFormatException e) {     // Parse double will throw NumberFormatException
                    throw new CommandExceptions("Pushing variable hasn't been defined.");
                }
            }
        } catch (CommandExceptions commExc) {
            commExc.printException();
        }
    }
}
