package MyExceptions;

import java.io.BufferedWriter;
import java.io.IOException;

public class CreateCommandsExceptions extends MyExceptions {
    public CreateCommandsExceptions(String expMessage) {
        super(expMessage);
    }

    public void printException(BufferedWriter errorStream) throws IOException {
        errorStream.write(expMessage + '\n');
        errorStream.flush();
      //  System.err.println(expMessage);
        LOGGER.severe(expMessage + "\n");
    }
}