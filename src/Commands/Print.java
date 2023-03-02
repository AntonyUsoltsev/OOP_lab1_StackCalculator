package Commands;

import Calculator.Calculator;
import Exceptions.CommandExceptions;

import java.util.logging.Level;

public class Print extends Command {
    @Override
    public void action(String[] commandArgs, Calculator.Parameters parameters) {
        try {
            if (commandArgs.length != 1) {
                throw new CommandExceptions("Invalid arguments for Print command.");
            } else if (parameters.getStack().empty()) {
                throw new CommandExceptions("Stack must have at least one elements to perform the Print operation.");
            } else {
                double printValue = parameters.getStack().peek();
                System.out.println(printValue);
                LOGGER.log(Level.INFO, "Print top element of stack: " + printValue + "\n");
            }
        } catch (CommandExceptions commExc) {
            commExc.printException();
        }
    }
}
