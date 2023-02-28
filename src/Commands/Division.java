package Commands;

import Calculator.Calculator;
import Logging.MyLogger;
import java.util.*;
import java.util.logging.*;

public class Division implements Command {

    private final Logger LOGGER = new MyLogger().getLog();
    @Override
    public void action(String[] command_args, Calculator.Parameters parameters) {
        if (command_args.length != 1) {
            throw new IllegalArgumentException("Unknown args in DIVISION command.");
        } else if (parameters.getStack().size() < 2) {
            throw new RuntimeException("Stack is less than two elements. Can not count division.");
        }
        String str_val1 = parameters.getStack().pop();
        String str_val2 = parameters.getStack().pop();
        double d_val1 = parameters.getVariablesMap().get(str_val1);
        double d_val2 = parameters.getVariablesMap().get(str_val2);
        if (d_val2 == 0) {
            throw new RuntimeException("Division by zero");
        }
        double res = d_val1 / d_val2;
        LOGGER.log(Level.INFO,"Division "+d_val1 +" on " + d_val2+"\n");
        parameters.getVariablesMap().put(Double.toString(res), res);
        parameters.getStack().push(Double.toString(res));
    }
}
