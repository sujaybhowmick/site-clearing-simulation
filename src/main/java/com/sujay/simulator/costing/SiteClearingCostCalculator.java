package com.sujay.simulator.costing;

import com.sujay.simulator.Activity;
import com.sujay.simulator.command.Command;
import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.CellType;
import com.sujay.simulator.sitemap.SiteMap;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SiteClearingCostCalculator implements CostCalculator {
    @Override
    public synchronized CostReport calculate(CalculatorContext context) {
        Set<Cell> visitedCells = context.getVisitedCells();
        CostReport costReport = new CostReport();
        costReport.addItem(calculateCommunicationOverheadCost(context.getCommands()));
        costReport.addItem(calculateFuelUsageCost(visitedCells, context.getVisitedCellsCount()));
        costReport.addItem(calculateUnclearedCellsCost(visitedCells, context.getSiteMap()));
        costReport.addItem(calculateProtectedTreeRemovalCost(visitedCells));
        costReport.addItem(calculatePaintDamageCost(visitedCells));
        return costReport;
    }

    private CostReportItem calculateFuelUsageCost(Set<Cell> visitedCells, Map<Cell, Integer> visitedCellsCount) {
        int totalFuelUsage = 0;
        for (Cell cell : visitedCells) {
            switch (cell.getCellType()) {
                case CLEAR:
                    totalFuelUsage = totalFuelUsage + Activity.CLEAR_PLAIN_LAND.getFuelUnit() +
                            getAlreadyClearedVisitedCellCost(cell, visitedCellsCount);
                    break;
                case ROCK:
                    totalFuelUsage = totalFuelUsage + Activity.CLEAR_ROCKY_LAND.getFuelUnit() +
                            getAlreadyClearedVisitedCellCost(cell, visitedCellsCount);
                    break;
                case REMOVEABLETREE:
                    totalFuelUsage = totalFuelUsage + Activity.CLEAR_TREE_LAND.getFuelUnit() +
                            getAlreadyClearedVisitedCellCost(cell, visitedCellsCount);
                    break;
            }
        }
        final CostCredit fuelCredit = CostCredit.FUEL;
        return new CostReportItem(CostCredit.FUEL.getItemDescription(), totalFuelUsage,
                fuelCredit.getCredit() * totalFuelUsage);
    }

    private CostReportItem calculateUnclearedCellsCost(Set<Cell> visitedCells, SiteMap siteMap) {
        final Set<Cell> unclearedCells = getUnvisitedCells(visitedCells, siteMap.getAllCells());
        final CostCredit unclearedCellCredit = CostCredit.UNCLEARED_CELL;
        int unclearedCellCount = unclearedCells.size();
        return new CostReportItem(unclearedCellCredit.getItemDescription(), unclearedCellCount,
                unclearedCellCount * unclearedCellCredit.getCredit());

    }

    private CostReportItem calculateCommunicationOverheadCost(List<Command> commands) {
        final CostCredit communicationOverheadCredit = CostCredit.COMMUNICATION_OVERHEAD;
        return new CostReportItem(communicationOverheadCredit.getItemDescription(),
                commands.size(), communicationOverheadCredit.getCredit() * commands.size());
    }

    private CostReportItem calculateProtectedTreeRemovalCost(Set<Cell> visitedCells) {
        CostCredit restrictedTreeCredit = CostCredit.DESTRUCTION_OF_PROTECTED_TREES;
        int restrictedTreeVisitCount = filterCellsByType(visitedCells, CellType.PRESERVEDTREE).size();
        return new CostReportItem(restrictedTreeCredit.getItemDescription(), restrictedTreeVisitCount,
                restrictedTreeVisitCount * restrictedTreeCredit.getCredit());
    }

    private CostReportItem calculatePaintDamageCost(Set<Cell> visitedCells) {
        CostCredit paintDamageCredit = CostCredit.PAINT_DAMAGE;
        int removableTreeCount = filterCellsByType(visitedCells, CellType.REMOVEABLETREE).size();
        return new CostReportItem(paintDamageCredit.getItemDescription(), removableTreeCount,
                removableTreeCount * paintDamageCredit.getCredit());
    }

    private int getAlreadyClearedVisitedCellCost(Cell cell, Map<Cell, Integer> visitedCells) {
        return visitedCells.containsKey(cell) && visitedCells.get(cell) > 1 ? Activity.VISITING_CLEARED_LAND.getFuelUnit() : 0;
    }

    private Set<Cell> getUnvisitedCells(Set<Cell> visitedCells, Set<Cell> allCells) {
        allCells.removeAll(visitedCells);
        allCells.removeAll(filterCellsByType(allCells, CellType.PRESERVEDTREE));
        return allCells;
    }

    private Set<Cell> filterCellsByType(Set<Cell> cells, CellType cellType) {
        return cells.stream().filter(cell ->
                cell.getCellType() == cellType).collect(Collectors.toSet());
    }
}
