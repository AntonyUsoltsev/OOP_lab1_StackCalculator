package Commands;

import Calculator.Calculator;

public class Print implements Command {
    @Override
    public void action(String[] command_args, Calculator.Parameters parameters) {
        if (command_args.length != 1) {
            throw new IllegalArgumentException("Unknown args in PRINT command.");
        } else if (parameters.getStack() == null || parameters.getStack().empty()) {
            throw new RuntimeException("Stack is empty. Top element can not be print.");
        } else {
            System.out.println(parameters.getStack().peek());
        }
    }
}
