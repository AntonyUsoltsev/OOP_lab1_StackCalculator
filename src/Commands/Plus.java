package Commands;

import Calculator.Calculator;

public class Plus implements Command {
    @Override
    public void action(String[] command_args, Calculator.Parameters parameters) {
        if (command_args.length != 1) {
            throw new IllegalArgumentException("Invalid arguments for PLUS command.");
        } else if (parameters.getStack().size() < 2) {
            throw new RuntimeException("Stack must have at least two elements to perform the PLUS operation.");
        }
        String strVal1 = parameters.getStack().pop();
        String strVal2 = parameters.getStack().pop();
        double doubleVal1 = parameters.getVariablesMap().get(strVal1);
        double doubleVal2 = parameters.getVariablesMap().get(strVal2);
        double res = doubleVal1 + doubleVal2;
        parameters.getVariablesMap().put(Double.toString(res), res);
        parameters.getStack().push(Double.toString(res));
    }
}
