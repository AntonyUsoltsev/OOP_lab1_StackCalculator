package Fabric;

import java.io.*;
import java.util.*;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Commands.Command;
import Exceptions.*;
import Logging.MyLogger;

public class CommandCreator {
    private final Map<String, Class<? extends Commands.Command>> commandClassesMap;
    private static final String CONFIG_FILE_NAME = "FabricConfig";
    private final Logger LOGGER = MyLogger.getLog();

    public CommandCreator() throws IOException {
        commandClassesMap = new HashMap<>();
        loadCommands();
    }

    private void loadCommands() throws IOException {
        try (InputStream inputStream = CommandCreator.class.getResourceAsStream(CONFIG_FILE_NAME);
             BufferedReader configFile = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = configFile.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 2) {
                    LOGGER.log(Level.SEVERE, "Invalid fabric config line: " + line + ". Thrown exception.\n");
                    throw new IllegalArgumentException("Invalid fabric config line: " + line);
                }
                String fullClassName = "Commands." + parts[1];

                Class<? extends Command> cur_class = loadCommandClass(fullClassName);
                commandClassesMap.put(parts[0], cur_class);
            }
            LOGGER.log(Level.INFO, "Command creator has created commands.\n");
        }
    }

    private Class<? extends Command> loadCommandClass(String className) {
        try {
            Class<?> cur_class = Class.forName(className);
            if (!Command.class.isAssignableFrom(cur_class)) {
                LOGGER.log(Level.SEVERE, className + " does not implement Command interface.\n");
                throw new IllegalArgumentException(className + " does not implement Command interface.");
            }
            return cur_class.asSubclass(Command.class);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, className + " hasn't been found.\n");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Commands.Command createCommands(String commandName) throws NoSuchMethodException, InvocationTargetException {
        Class<? extends Command> commandClass = commandClassesMap.get(commandName);
        if (commandClass == null) {
            LOGGER.log(Level.SEVERE, "Unknown command:'" + commandName + "' while creating command.\n");
            throw new IllegalArgumentException("Unknown command:'" + commandName + '\'');
        }
        try {
            return commandClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.log(Level.SEVERE, "Failed to create command: " + commandName + "' while creating command.\n");
            throw new RuntimeException("Failed to create command: '" + commandName + '\'', e);
        }
    }
}
