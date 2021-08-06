package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;

public class CommandContext {
    private final BullDozer bullDozer;
    private final String commandString;

    public CommandContext(BullDozer context, String commandString) {
        this.bullDozer = context;
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }

    public BullDozer getBullDozer() {
        return bullDozer;
    }
}
