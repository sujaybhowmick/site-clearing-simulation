package com.sujay.simulator.costing;

import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.SiteMap;

import java.util.Set;

public class SiteClearingCostCalculator implements CostCalculator {
    @Override
    public CostReport calculate(Set<Cell> visitedCells, SiteMap siteMap) {
        Set<Cell> unvisitedCells = getUnvisitedCells(visitedCells, siteMap.getAllCells());
        return null;
    }

    private Set<Cell> getUnvisitedCells(Set<Cell> visitedCells, Set<Cell> allCells) {
        allCells.removeAll(visitedCells);
        return allCells;
    }
}
