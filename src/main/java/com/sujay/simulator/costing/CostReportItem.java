package com.sujay.simulator.costing;

public final class CostReportItem {
    private final String description;
    private final int quantity;
    private final int cost;

    public CostReportItem(String description, int quantity, int cost) {
        this.description = description;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCost() {
        return cost;
    }
}
