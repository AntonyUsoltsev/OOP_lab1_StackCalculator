package Commands;
import Calculator.Calculator;
public class Plus implements Command {
    @Override
    public void action(String[] command_args, Calculator.Parameters parameters) {
        if (command_args.length != 1) {
            throw new IllegalArgumentException("Unknown args in PLUS command");
        } else if (parameters.getStack().size() < 2) {
            throw new RuntimeException("Stack is less than two elements. Can not count summa");
        }
        String str_val1 = parameters.getStack().pop();
        String str_val2 = parameters.getStack().pop();
        double d_val1 = parameters.getVariablesMap().get(str_val1);
        double d_val2 = parameters.getVariablesMap().get(str_val2);
        double res = d_val1 + d_val2;
        parameters.getVariablesMap().put(Double.toString(res), res);
        parameters.getStack().push(Double.toString(res));
    }
}
