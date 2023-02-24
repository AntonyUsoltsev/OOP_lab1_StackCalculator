package Commands;
import Calculator.Calculator;
public class Sqrt implements Command{
    @Override
    public void action(String[] command_args, Calculator.Parameters parameters) {
        if (command_args.length != 1) {
            throw new IllegalArgumentException("Unknown args in SQRT command");
        } else if (parameters.getStack() == null || parameters.getStack().empty()) {
            throw new RuntimeException("Stack is empty. Can not count square root");
        }
        String str_val1 = parameters.getStack().pop();
        double d_val1 = parameters.getVariablesMap().get(str_val1);
        if (d_val1 < 0){
            throw new RuntimeException("Square root from negative number");
        }
        double res = Math.sqrt(d_val1);
        parameters.getVariablesMap().put(Double.toString(res), res);
        parameters.getStack().push(Double.toString(res));
    }
}
