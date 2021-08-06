package com.sujay.simulator.command;

public interface Command {
    void execute();

    CommandType getCommandType();

    CommandContext getContext();

    int getArg();
}
