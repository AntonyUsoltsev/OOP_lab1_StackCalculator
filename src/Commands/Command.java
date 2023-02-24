package Commands;
import Calculator.Calculator;

public abstract interface Command {
   public void action(String[]command_args, Calculator.Parameters parameters);
}
