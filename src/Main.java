import Calculator.Calculator;
import Exceptions.CalculatorExceptions;
import Exceptions.FabricExceptions;
import Logging.MyLogger;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = MyLogger.getLogger();

    public static void main(String[] args) {
        try (BufferedReader reader = getReader(args)) {

            Calculator calculator = new Calculator(reader);

            calculator.doCalculating();

            LOGGER.log(Level.INFO, "End of all calculating.");

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Commands file not found, thrown exception:" + e.getMessage() + "\n");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
        } catch (FabricExceptions exc) {
            exc.printException();
            System.err.println(Arrays.toString(exc.getStackTrace()));
        } catch (CalculatorExceptions exc) {
            exc.printException();
            System.err.println(Arrays.toString(exc.getStackTrace()));
        }
    }

    private static BufferedReader getReader(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            LOGGER.log(Level.INFO, "Commands will be read from file\n");
            return new BufferedReader(new FileReader(args[0]));
        } else {
            LOGGER.log(Level.INFO, "Commands will be read from System.in\n");
            return new BufferedReader(new InputStreamReader(System.in));
        }
    }
}
