package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;
import com.sujay.simulator.event.SimulationEvent;
import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.Coordinate;
import com.sujay.simulator.sitemap.Orientation;
import com.sujay.simulator.sitemap.SiteMap;

public class AdvanceCommand extends AbstractCommand {
    public final CommandType commandType = CommandType.ADVANCE;

    public AdvanceCommand(CommandContext context, int numberOfSquares) {
        super(context, numberOfSquares);
    }

    @Override
    public void execute() {
        Cell currentCell = getCurrentPosition();
        BullDozer bullDozer = context.getBullDozer();
        try {
            Cell newCell = calculateAndGetNewCellCoordinates(currentCell);
            bullDozer.addVisitedCell(newCell);
            bullDozer.updateCurrentPosition(newCell);
            bullDozer.addEvent(new SimulationEvent(this));
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal advance command, ending simulation");
            bullDozer.addEvent(new SimulationEvent(new QuitCommand(context)));
        }
    }

    @Override
    public CommandType getCommandType() {
        return commandType;
    }

    private Cell calculateAndGetNewCellCoordinates(Cell currentCell) {
        Orientation orientation = getOrientation();
        Coordinate coordinate = currentCell.getCoordinate();
        SiteMap siteMap = context.getBullDozer().getSiteMap();

        switch (orientation) {
            case EAST:
                return getCellFromCoordinate(siteMap,
                        new Coordinate(coordinate.getX(), coordinate.getY() + this.arg));
            case WEST:
                return getCellFromCoordinate(siteMap,
                        new Coordinate(coordinate.getX(), coordinate.getY() - this.arg));
            case NORTH:
                return getCellFromCoordinate(siteMap,
                        new Coordinate(coordinate.getX() - this.arg, coordinate.getY()));
            case SOUTH:
                return getCellFromCoordinate(siteMap,
                        new Coordinate(coordinate.getX() + this.arg, coordinate.getY()));
            default:
                throw new IllegalArgumentException(String.format("Wrong orientation %s provided in the command", orientation));
        }
    }

    private Cell getCellFromCoordinate(SiteMap siteMap, Coordinate coordinate) {
        return siteMap.getCellAt(coordinate);
    }

    @Override
    public String toString() {
        return commandType + " " + arg;
    }
}
