package com.sujay.simulator.costing;

import com.sujay.simulator.command.Command;
import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.SiteMap;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CalculatorContext {
    private final List<Command> commands;
    private final Set<Cell> visitedCells;
    private final Map<Cell, Integer> visitedCellsCount;
    private final SiteMap siteMap;

    public CalculatorContext(List<Command> commands,
                             Set<Cell> visitedCells,
                             Map<Cell, Integer> visitedCellsCount,
                             SiteMap siteMap) {
        this.commands = commands;
        this.visitedCells = visitedCells;
        this.visitedCellsCount = visitedCellsCount;
        this.siteMap = siteMap;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Set<Cell> getVisitedCells() {
        return visitedCells;
    }

    public SiteMap getSiteMap() {
        return siteMap;
    }

    public Map<Cell, Integer> getVisitedCellsCount() {
        return visitedCellsCount;
    }
}
