package Calculator;

import Fabric.CommandCreator;
import Commands.Command;
import Logging.MyLogger;

import java.io.BufferedReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO : Make double Stack
// TODO : Logging commands
// TODO : My Exceptions

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
        LOGGER = MyLogger.getLog();
        LOGGER.log(Level.INFO, "Calculator constructor success done.\n");
    }

    public void doCalculating() throws Exception {
        String line;
        CommandCreator commandCreator = new CommandCreator();

        while ((line = reader.readLine()) != null) {
            if (line.charAt(0) == '#') {
                continue;
            }
            String[] parts = line.split(" ");
            if (parts.length == 0) {
                LOGGER.log(Level.SEVERE, "Unknown command:'" + line + "' while reading commands.\n");
                throw new IllegalArgumentException("Unknown command:'" + line + '\'');
            }
            Command command = commandCreator.createCommands(parts[0]);
            command.action(parts, parameters);
        }
       // LOGGER.log(Level.INFO, "Create commands: success\n");
    }

}
