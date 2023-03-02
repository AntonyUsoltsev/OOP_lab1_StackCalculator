package Commands;

import Calculator.Calculator;
import Exceptions.CommandExceptions;

import java.util.logging.Level;

public class Pop extends Command {
    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        try {
            if (commandArgs.length != 1) {
                throw new CommandExceptions("Invalid arguments for Pop command.");
            } else if (parameters.getStack().empty()) {
                throw new CommandExceptions("Stack must have at least one elements to perform the Pop operation.");
            } else {
                parameters.getStack().pop();
                LOGGER.log(Level.INFO, "Pop top element.\n");
            }
        } catch (CommandExceptions commExc) {
            commExc.printException();
        }
    }
}