package Commands;

import Calculator.Calculator;
import Exceptions.CommandExceptions;

import java.util.logging.Level;

public class Plus extends Command {
    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        try {
            if (commandArgs.length != 1) {
                throw new CommandExceptions("Invalid arguments for Plus command.");
            } else if (parameters.getStack().size() < 2) {
                throw new CommandExceptions("Stack must have at least two elements to perform the Plus operation.");
            } else {
                double doubleVal1 = parameters.getStack().pop();
                double doubleVal2 = parameters.getStack().pop();
                double res = doubleVal1 + doubleVal2;
                LOGGER.log(Level.INFO, "Plus: " + doubleVal1 + " + " + doubleVal2 + ".\n");
                parameters.getStack().push(res);
            }
        } catch (CommandExceptions commExc) {
            commExc.printException();
        }
    }
}
