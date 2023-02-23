import Commands.Command;
import Exceptions.MyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class Calculator {
    private final BufferedReader reader;
    private Stack<String> stack;
    private  Map<String, Double> variables;

    public Calculator(BufferedReader reader) {
        this.reader = reader;
        this.stack = new Stack<>();
        this.variables = new HashMap<>();
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
            Command command =  commandCreator.createCommands(parts[0]);
            command.action();
        }
    }

}
