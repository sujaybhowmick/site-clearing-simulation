package com.sujay.simulator;

import com.sujay.simulator.command.Command;
import com.sujay.simulator.command.QuitCommand;
import com.sujay.simulator.event.SimulationEvent;
import com.sujay.simulator.sitemap.*;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class BullDozer {
    private final SiteMap siteMap;
    private final BlockingQueue<SimulationEvent> eventQueue;
    private final List<Command> commandHistory = new ArrayList<>();
    private final Set<Cell> visitedCells = new LinkedHashSet<>();
    private final Map<Cell, Integer> visitedCellsCount = new HashMap<>();
    private Cell currentCell = new Cell(CellType.START, new Coordinate(0, -1));
    private Orientation orientation = Orientation.EAST;

    public BullDozer(SiteMap siteMap, BlockingQueue<SimulationEvent> eventQueue) {
        this.siteMap = siteMap;
        this.eventQueue = eventQueue;
    }

    public void execute(Command command) {
        command.execute();
    }

    public Cell getCurrentPosition() {
        return currentCell;
    }

    public SiteMap getSiteMap() {
        return siteMap;
    }

    private void updateCurrentPosition(Cell currentCell) {
        this.currentCell = currentCell;
    }

    private void updateOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void addVisitedCell(Cell cell) {
        this.visitedCells.add(cell);
    }

    public void addEvent(SimulationEvent event) {
        try {
            this.eventQueue.put(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Orientation getOrientation() {
        return orientation;
    }

    public Set<Cell> getVisitedCells() {
        return visitedCells;
    }

    public void moveBullDozer(Command command) {
        try {
            commandHistory.add(command);
            Orientation orientation = getOrientation();
            switch (orientation) {
                case EAST:
                    advanceEast(command);
                    break;
                case WEST:
                    advanceWest(command);
                    break;
                case SOUTH:
                    advanceSouth(command);
                    break;
                case NORTH:
                    advanceNorth(command);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Wrong orientation %s provided in the command", orientation));
            }
        } catch (IllegalArgumentException e) {
            raiseQuitCommand(command);
        }
    }

    public void turnLeft(Command command) {
        try {
            this.commandHistory.add(command);
            Orientation orientation = getOrientation();
            switch (orientation) {
                case EAST:
                    updateOrientation(Orientation.NORTH);
                    break;
                case WEST:
                    updateOrientation(Orientation.SOUTH);
                    break;
                case NORTH:
                    updateOrientation(Orientation.WEST);
                    break;
                case SOUTH:
                    updateOrientation(Orientation.EAST);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Wrong orientation %s provided in the command", orientation));
            }
            raiseCommandEvent(command);
        } catch (IllegalArgumentException e) {
            raiseQuitCommand(command);
        }

    }

    public void turnRight(Command command) {
        try {
            this.commandHistory.add(command);
            Orientation currentOrientation = getOrientation();
            switch (currentOrientation) {
                case EAST:
                    updateOrientation(Orientation.SOUTH);
                    break;
                case WEST:
                    updateOrientation(Orientation.NORTH);
                    break;
                case NORTH:
                    updateOrientation(Orientation.EAST);
                    break;
                case SOUTH:
                    updateOrientation(Orientation.WEST);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Wrong orientation %s provided in the command", currentOrientation));
            }
            raiseCommandEvent(command);
        } catch (IllegalArgumentException e) {
            raiseQuitCommand(command);
        }
    }

    public void quit(Command command) {
        raiseQuitCommand(command);
    }

    private void advanceEast(Command command) {
        advanceEastOrWest(command, Orientation.EAST);
    }

    private void advanceWest(Command command) {
        advanceEastOrWest(command, Orientation.WEST);
    }

    private void advanceSouth(Command command) {
        advanceSouthOrNorth(command, Orientation.SOUTH);
    }

    private void advanceNorth(Command command) {
        advanceSouthOrNorth(command, Orientation.NORTH);
    }

    private void advanceEastOrWest(Command command, Orientation orientation) {
        Coordinate coordinate = getCurrentPosition().getCoordinate();
        for (int y = 1; y <= command.getArg(); y++) {
            int newY = 0;
            if (orientation == Orientation.EAST)
                newY = coordinate.getY() + y;
            else if (orientation == Orientation.WEST)
                newY = coordinate.getY() - y;

            Coordinate newCoordinate = new Coordinate(coordinate.getX(), newY);
            Cell newCell = siteMap.getCellAt(newCoordinate);
            this.visitedCells.add(newCell);
            incrementCellVisitCount(newCell);
            this.updateCurrentPosition(newCell);
            if (checkAndQuitIfRestrictedMove(newCell, command)) {
                break;
            } else {
                raiseCommandEvent(command);
            }
        }
    }

    private void advanceSouthOrNorth(Command command, Orientation orientation) {
        Coordinate coordinate = getCurrentPosition().getCoordinate();
        for (int x = 1; x <= command.getArg(); x++) {
            int newX = 0;
            if (orientation == Orientation.SOUTH)
                newX = coordinate.getX() + x;
            else if (orientation == Orientation.NORTH)
                newX = coordinate.getX() - x;
            Coordinate newCoordinate = new Coordinate(newX, coordinate.getY());
            Cell newCell = siteMap.getCellAt(newCoordinate);
            this.visitedCells.add(newCell);
            incrementCellVisitCount(newCell);
            this.updateCurrentPosition(newCell);
            if (checkAndQuitIfRestrictedMove(newCell, command)) {
                break;
            } else {
                raiseCommandEvent(command);
            }
        }
    }

    private void incrementCellVisitCount(Cell newCell) {
        if (this.visitedCellsCount.containsKey(newCell))
            this.visitedCellsCount.put(newCell, this.visitedCellsCount.get(newCell) + 1);
        else this.visitedCellsCount.put(newCell, 1);
    }

    private boolean checkAndQuitIfRestrictedMove(Cell newCell, Command command) {
        boolean isRestricted = newCell.getCellType() == CellType.PRESERVEDTREE;
        if (isRestricted)
            raiseQuitCommand(command);
        return isRestricted;
    }

    private void raiseQuitCommand(Command command) {
        this.commandHistory.add(command);
        this.addEvent(new SimulationEvent(new QuitCommand(command.getContext())));
    }

    private void raiseCommandEvent(Command command) {
        this.addEvent(new SimulationEvent(command));
    }

    public List<Command> getCommandHistory() {
        return commandHistory;
    }

    public Map<Cell, Integer> getVisitedCellsCount() {
        return visitedCellsCount;
    }

}
