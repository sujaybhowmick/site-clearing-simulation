package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;
import com.sujay.simulator.event.SimulationEvent;
import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.Coordinate;
import com.sujay.simulator.sitemap.Orientation;

public class TurnLeftCommand extends AbstractCommand {
    public final CommandType commandType = CommandType.LEFT;

    public TurnLeftCommand(CommandContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.getBullDozer().turnLeft(this);
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

