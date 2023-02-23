import Exceptions.MyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;


public class Calculator {
    BufferedReader reader;
    Stack<String> stack = new Stack<>();
    Map<String, Double> variables;

    public Calculator(BufferedReader reader) {
        this.reader = reader;
    }

    public void doCalculating() throws IOException, MyException {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            String[] parts = line.split(" ");
            System.out.println(Arrays.toString(parts));

        }
        CommandCreator commandCreator = new CommandCreator();
        commandCreator.load_commands();
    }

}
