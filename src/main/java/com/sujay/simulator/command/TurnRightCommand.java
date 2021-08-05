package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;

public class TurnRightCommand extends AbstractCommand {

    public TurnRightCommand(BullDozer bullDozer) {
        super(bullDozer);
    }

    @Override
    public void execute() {
        // TODO: Turn bulldozer to right direction from current orientation
    }
}
