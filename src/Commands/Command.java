package Commands;
import Calculator.Calculator;
import Logging.MyLogger;
import Exceptions.CommandExceptions;
import java.util.logging.Logger;

public abstract class Command {

    protected final Logger LOGGER = MyLogger.getLogger();
    abstract public void action(String[] command_args, Calculator.Parameters parameters);
}
