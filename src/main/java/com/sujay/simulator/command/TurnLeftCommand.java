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
        BullDozer bullDozer = context.getBullDozer();
        Cell cell = getCurrentPosition();
        Coordinate coordinate = cell.getCoordinate();
        bullDozer.updateCurrentPosition(new Cell(cell.getCellType(),
                new Coordinate(coordinate.getX(), coordinate.getY())));
        bullDozer.updateOrientation(getNewOrientation());
        bullDozer.addEvent(new SimulationEvent(this));
    }

    @Override
    public CommandType getCommandType() {
        return commandType;
    }

    private Orientation getNewOrientation() {
        Orientation orientation = getOrientation();
        switch (orientation) {
            case EAST:
                return Orientation.NORTH;
            case WEST:
                return Orientation.SOUTH;
            case NORTH:
                return Orientation.WEST;
            case SOUTH:
                return Orientation.EAST;
            default:
                throw new IllegalArgumentException(String.format("Wrong orientation %s provided in the command", orientation));
        }
    }

    @Override
    public String toString() {
        return commandType.toString();
    }
}

