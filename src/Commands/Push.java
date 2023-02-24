package Commands;
import Calculator.Calculator;
public class Push implements Command{
    @Override
    public void action(String[] command_args, Calculator.Parameters parameters) {
        if (command_args.length != 2) {
            throw new IllegalArgumentException("Unknown args in PUSH command");
        }
        if (parameters.getVariablesMap().containsKey(command_args[1])){
            parameters.getStack().push(command_args[1]);
        }
        else {
            try {
                double num = Double.parseDouble(command_args[1]);
                parameters.getStack().push(Double.toString(num));
                parameters.getVariablesMap().put(Double.toString(num),num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Pushing variable hasn't been defined");
            }
        }

    }
}
