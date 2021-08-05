package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;

public class AdvanceCommand extends AbstractCommand {

    public AdvanceCommand(BullDozer bullDozer, int numberOfSquares) {
        super(bullDozer, numberOfSquares);
    }

    @Override
    public void execute() {
        // TODO: Move the bullDozer and check the type of cell it is and do accounting. Set the current position
    }
}
