package com.sujay.simulator.costing;

public enum CostCredit {
    COMMUNICATION_OVERHEAD(1, "Communication overhead per command sent to bulldozer operator"),
    FUEL(1, "Fuel"),
    UNCLEARED_CELL(3, "Uncleared square at end of Simulation"),
    DESTRUCTION_OF_PROTECTED_TREES(10, "Destruction of protected trees"),
    PAINT_DAMAGE(2, "Repairing paint damage to bulldozer clearable tree");

    private final int credit;
    private final String itemDescription;

    CostCredit(int credit, String itemDescription) {
        this.credit = credit;
        this.itemDescription = itemDescription;
    }

    public int getCredit() {
        return credit;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
