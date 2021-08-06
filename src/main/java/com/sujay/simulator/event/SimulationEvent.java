package com.sujay.simulator.event;

import com.sujay.simulator.command.Command;

public class SimulationEvent {
    private final Command command;


    public SimulationEvent(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
