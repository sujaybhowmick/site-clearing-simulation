package com.sujay.simulator;

import com.sujay.simulator.command.Command;
import com.sujay.simulator.event.SimulationEvent;
import com.sujay.simulator.sitemap.*;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class BullDozer implements Runnable {
    private final SiteMap siteMap;
    private final BlockingQueue<SimulationEvent> eventQueue;
    private final List<Cell> visitedCells = new ArrayList<>();
    private Queue<Command> commandQueue;
    private Cell currentCell = new Cell(CellType.START, new Coordinate(0, -1));
    private Orientation orientation = Orientation.EAST;

    public BullDozer(SiteMap siteMap, BlockingQueue<SimulationEvent> eventQueue) {
        this.siteMap = siteMap;
        this.eventQueue = eventQueue;
    }

    public void setCommandQueue(Queue<Command> commandQueue) {
        this.commandQueue = commandQueue;
    }

    private void execute(Command command) {
        command.execute();
    }

    public Cell getCurrentPosition() {
        return currentCell;
    }

    public SiteMap getSiteMap() {
        return siteMap;
    }

    public synchronized void updateCurrentPosition(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public synchronized void updateOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public synchronized void addVisitedCell(Cell cell) {
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

    public List<Cell> getVisitedCells() {
        return visitedCells;
    }

    @Override
    public void run() {
        if(this.commandQueue != null) {
            while(!this.commandQueue.isEmpty()) {
                execute(this.commandQueue.poll());
            }
        }
    }
}
