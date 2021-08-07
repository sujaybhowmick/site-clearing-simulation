package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;
import com.sujay.simulator.event.SimulationEvent;
import com.sujay.simulator.sitemap.*;

public class AdvanceCommand extends AbstractCommand {
    public final CommandType commandType = CommandType.ADVANCE;

    public AdvanceCommand(CommandContext context, int numberOfSquares) {
        super(context, numberOfSquares);
    }

    @Override
    public void execute() {
        context.getBullDozer().moveBullDozer(this);
    }

    @Override
    public CommandType getCommandType() {
        return commandType;
    }

    @Override
    public String toString() {
        return commandType + " " + arg;
    }
}
