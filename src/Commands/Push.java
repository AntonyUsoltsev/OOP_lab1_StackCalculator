package Commands;

import Calculator.Calculator.Parameters;
import MyExceptions.CommandExceptions;

import java.io.BufferedWriter;
import java.io.IOException;

public class Push extends Command {
    @Override
    public void action(String[] commandArgs, Parameters parameters, BufferedWriter errorStream) throws IOException {
        try {
            if (commandArgs.length != 2) {
                throw new CommandExceptions("Invalid arguments for Push command.");
            } else if (parameters.getVariablesMap().containsKey(commandArgs[1])) {
                double pushValue = parameters.getVariablesMap().get(commandArgs[1]);
                parameters.getStack().push(pushValue);
            } else {
                try {
                    double num = Double.parseDouble(commandArgs[1]);
                    parameters.getStack().push(num);
                    LOGGER.info("Push element on stack: " + num + "\n");
                } catch (NumberFormatException e) {     // Parse double will throw NumberFormatException
                    throw new CommandExceptions("Pushing variable hasn't been defined.");
                }
            }
        } catch (CommandExceptions commExc) {
            commExc.printException(errorStream);
        }
    }
}
