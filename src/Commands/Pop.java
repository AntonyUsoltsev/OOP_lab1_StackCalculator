package Commands;
import Calculator.Calculator;
public class Pop implements Command {
    @Override
    public void action(String[] command_args, Calculator.Parameters parameters) {
        if (command_args.length != 1) {
            throw new IllegalArgumentException("Unknown args in POP command");
        } else if (parameters.getStack().empty()) {
            throw new RuntimeException("Stack is empty. Can not pop element");
        } else {
            parameters.getStack().pop();
        }
    }
}
