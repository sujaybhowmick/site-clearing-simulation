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
        BullDozer bullDozer  = context.getBullDozer();
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
        Orientation currentOrientation = getOrientation();
        switch (currentOrientation){
            case EAST:
                return Orientation.SOUTH;
            case WEST:
                return Orientation.NORTH;
            case NORTH:
                return Orientation.EAST;
            case SOUTH:
                return Orientation.WEST;
            default:
                throw new IllegalArgumentException(String.format("Wrong orientation %s provided in the command", currentOrientation));
        }
    }

    @Override
    public String toString() {
        return commandType.toString();
    }
}
