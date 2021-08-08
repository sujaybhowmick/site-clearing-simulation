package com.sujay.simulator.costing;

import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.SiteMap;

import java.util.Set;

public interface CostCalculator {
    CostReport calculate(Set<Cell> visitedCell, SiteMap siteMap);
}
