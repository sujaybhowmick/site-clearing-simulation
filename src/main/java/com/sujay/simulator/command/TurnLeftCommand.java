package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;

public class TurnLeftCommand extends AbstractCommand {

    public TurnLeftCommand(BullDozer bullDozer) {
        super(bullDozer);
    }

    @Override
    public void execute() {
        // TODO: Turn bullDozer right i.e North
    }
}
