import java.io.FileReader;
import java.io.IOException;
import java.lang.Exception;
import java.util.*;
import java.io.BufferedReader;

import Exceptions.*;
public class CommandCreator {
    private Map<String, String> command_names;
    //  private BufferedReader config_file;
    private static final String CONFIG_FILE_NAME = "./src/FabricConfig";

    public void load_commands() throws MyException, IOException {
        try (BufferedReader config_file = new BufferedReader(new FileReader(CONFIG_FILE_NAME))) {
            String line;
            while ((line = config_file.readLine()) != null) {
                System.out.println(line);
                String[] parts = line.split(" ");
                if (parts.length != 2) {
                    throw new MyException("Invalid config line: " + line);
                }
                command_names.put(parts[0],parts[1]);
                System.out.println(Arrays.toString(parts));
            }
        }
    }
}
