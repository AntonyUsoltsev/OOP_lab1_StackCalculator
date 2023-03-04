package Calculator;

import Commands.Command;
import Fabric.CommandCreator;
import Logging.MyLogger;
import MyExceptions.CalculatorExceptions;
import MyExceptions.FabricExceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;

// DONE: Make double Stack
// DONE : Logging commands
// DONE : My Exceptions
// DONE : Tests

public class Calculator {
    public static class Parameters {
        private final Stack<Double> stack;
        private final Map<String, Double> variablesMap;
        private final BufferedWriter outputStream;
        public Parameters(BufferedWriter outputStream) {
      this.stack = new Stack<>();
            this.variablesMap = new HashMap<>();
            this.outputStream = outputStream;
        }

        public Stack<Double> getStack() {
            return stack;
        }

        public Map<String, Double> getVariablesMap() {
            return variablesMap;
        }

        public BufferedWriter getOutputStream() {
            return outputStream;
        }
    }

    private final BufferedReader inputStream;
    private final BufferedWriter errorStream;
    private final Parameters parameters;
    private final Logger LOGGER;

    public Calculator(BufferedReader inputStream, BufferedWriter outputStream, BufferedWriter errorStream) {
        this.inputStream = inputStream;
        this.errorStream = errorStream;
        parameters = new Parameters(outputStream);
        LOGGER = MyLogger.getLogger();
        LOGGER.info("Calculator constructor success done.\n");
    }

    public void doCalculating() throws FabricExceptions, CalculatorExceptions {
        try {
            String line;
            CommandCreator commandCreator = new CommandCreator();

            while ((line = inputStream.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 0 || line.equals("")) {
                    LOGGER.severe("Unknown command:'" + line + "'.\n");
                    System.err.println("Unknown command:'" + line + "'.\n");
                    continue;
                }
                if (line.charAt(0) == '#') {
                    continue;
                }

                Command command = commandCreator.createCommands(parts[0], errorStream);
                if (command != null) {                  // command == null when we get unknown command.
                    command.action(parts, parameters, errorStream);
                }
            }
        } catch (IOException ioExc) {
            throw new CalculatorExceptions(ioExc.getMessage());
        }
    }

}
