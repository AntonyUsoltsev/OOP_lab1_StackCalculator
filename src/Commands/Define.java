package Commands;
import Calculator.Calculator;
public class Define implements Command {
    @Override
    public void action(String[] command_args, Calculator.Parameters parameters) {
        if (command_args.length != 3) {
            throw new IllegalArgumentException("Unknown args in DEFINE command");
        }

        try {
            double value = Double.parseDouble(command_args[1]);
            throw new IllegalArgumentException("Wrong type of first definitive value");
        } catch (NumberFormatException e) {
            try {
                double value = Double.parseDouble(command_args[2]);
                parameters.getVariablesMap().put(command_args[1], value);
            } catch (NumberFormatException exp) {
                throw new IllegalArgumentException("Wrong type of second definitive value");
            }
        }
    }
}
