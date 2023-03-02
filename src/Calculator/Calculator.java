package Calculator;

import Exceptions.CalculatorExceptions;
import Exceptions.FabricExceptions;
import Fabric.CommandCreator;
import Commands.Command;
import Logging.MyLogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// DO : Make double Stack
// DO : Logging commands
// TODO : My Exceptions
// TODO : Tests

public class Calculator {
    public static class Parameters {
        private final Stack<Double> stack;
        private final Map<String, Double> variablesMap;

        public Parameters() {
            this.stack = new Stack<>();
            this.variablesMap = new HashMap<>();
        }

        public Stack<Double> getStack() {
            return stack;
        }

        public Map<String, Double> getVariablesMap() {
            return variablesMap;
        }
    }

    private final BufferedReader reader;
    private final Parameters parameters;
    private final Logger LOGGER;

    public Calculator(BufferedReader reader) {
        this.reader = reader;
        parameters = new Parameters();
        LOGGER = MyLogger.getLogger();
        LOGGER.info("Calculator constructor success done.\n");
    }

    public void doCalculating() throws FabricExceptions, CalculatorExceptions {
        try {
            String line;
            CommandCreator commandCreator = new CommandCreator();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 0 || line.equals("")) {
                    LOGGER.severe("Unknown command:'" + line + "'.\n");
                    System.err.println("Unknown command:'" + line + "'.\n");
                    continue;
                }
                if (line.charAt(0) == '#') {
                    continue;
                }

                Command command = commandCreator.createCommands(parts[0]);
                if (command != null) {                  // command == null when we get unknown command.
                    command.action(parts, parameters);
                }
            }
        } catch (IOException ioExc) {
            throw new CalculatorExceptions(ioExc.getMessage());
        }
    }

}
