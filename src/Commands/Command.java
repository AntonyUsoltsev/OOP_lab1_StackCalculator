package Commands;

import Calculator.Calculator;

import Logging.MyLogger;

import java.util.logging.Logger;

public abstract interface Command {
//    final Logger LOGGER = null;
    public void action(String[] command_args, Calculator.Parameters parameters);
}
