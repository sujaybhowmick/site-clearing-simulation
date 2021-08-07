package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;
import com.sujay.simulator.event.SimulationEvent;
import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.Coordinate;
import com.sujay.simulator.sitemap.Orientation;

public class TurnRightCommand extends AbstractCommand {
    public final CommandType commandType = CommandType.RIGHT;

    public TurnRightCommand(CommandContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.getBullDozer().turnRight(this);
    }

    @Override
    public CommandType getCommandType() {
        return commandType;
    }

    @Override
    public String toString() {
        return commandType.toString();
    }
}
