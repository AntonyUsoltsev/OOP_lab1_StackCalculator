package Calculator;
import Fabric.CommandCreator;
import Commands.Command;
import java.io.BufferedReader;
import java.util.*;
import java.util.logging.*;
public class Calculator {
    public class Parameters{
        private Stack<String> stack;
        private  Map<String, Double> variablesMap;
        public Parameters() {
            this.stack = new Stack<>();;
            this.variablesMap = new HashMap<>();
        }
        public Stack<String> getStack() {
            return stack;
        }
        public Map<String, Double> getVariablesMap() {
            return variablesMap;
        }

    }
    private Parameters parameters;
    private final BufferedReader reader;

    public Calculator(BufferedReader reader) {
        this.reader = reader;
        parameters = new Parameters();
    }

    public void doCalculating() throws Exception {
        String line;
        CommandCreator commandCreator = new CommandCreator();
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            if (line.charAt(0) == '#'){
                continue;
            }
            String[] parts = line.split(" ");
            if (parts.length == 0){
                throw new IllegalArgumentException("Unknown command:'" + line + '\'');
            }
           // System.out.println(Arrays.toString(parts));
            Command command = commandCreator.createCommands(parts[0]);
            command.action(parts, parameters);
        }
    }

}
