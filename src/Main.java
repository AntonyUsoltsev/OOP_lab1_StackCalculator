import Calculator.Calculator;
import MyExceptions.CalculatorExceptions;
import MyExceptions.FabricExceptions;
import Logging.MyLogger;
import CreateStreams.CreateStreams;

import java.io.*;
import java.util.Arrays;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = MyLogger.getLogger();

    public static void main(final String[] args) throws IOException {
        BufferedWriter outputStream = null;
        BufferedWriter errorStream = null;
        BufferedReader inputStream = null;

        try {
            outputStream = CreateStreams.getOutputStream(args);
            errorStream = CreateStreams.getErrorStream(args);
            inputStream = CreateStreams.getInputStream(args);

            Calculator calculator = new Calculator(inputStream, outputStream, errorStream);

            calculator.doCalculating();

            LOGGER.info("End of all calculating.");

        } catch (FileNotFoundException ioExc) {
            LOGGER.severe("Commands file not found, thrown exception:" + ioExc.getMessage() + "\n");
            if (errorStream != null) {
                errorStream.write(ioExc.getMessage() + '\n');
                errorStream.write(Arrays.toString(ioExc.getStackTrace()));
                errorStream.flush();
            } else {
                System.err.println("Commands file not found, thrown exception:" + ioExc.getMessage() + "\n");
            }

        } catch (FabricExceptions | CalculatorExceptions exc) {
            exc.printException(errorStream);
            errorStream.write(Arrays.toString(exc.getStackTrace()) );
            errorStream.flush();

        } finally {
            try {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
                if (errorStream != null) errorStream.close();
            } catch (IOException e) {
                System.err.println("Error closing stream: " + e.getMessage());
            }

        }
        //catch (IOException e) {
//            LOGGER.severe(e.getMessage() + "\n");
//            BufferedWriter errorStream = CreateStreams.getErrorStream(args);
//            errorStream.write(e.getMessage());
        // }
////            errorStream.write(Arrays.toString(e.getStackTrace()));
//        } catch (FileNotFoundException fe) {
//            System.err.println("ji2");
////            System.err.flush();
////            System.out.println("hh");
////            System.out.flush();
//
//        }
    }
}
