package com.sujay.simulator.costing;

import java.util.LinkedHashSet;
import java.util.Set;

public final class CostReport {
    private final Set<CostReportItem> items;

    public CostReport(Set<CostReportItem> items) {
        this.items = items;
    }

    public CostReport() {
        this.items = new LinkedHashSet<>();
    }

    public void addItem(CostReportItem item) {
        this.items.add(item);
    }

    public Set<CostReportItem> getItems() {
        return items;
    }
}
