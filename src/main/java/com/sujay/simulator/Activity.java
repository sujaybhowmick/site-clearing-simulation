package com.sujay.simulator;

public enum Activity {
    CLEAR_PLAIN_LAND(1, "Clearing plain land"),
    CLEAR_ROCKY_LAND(2, "Clearing rocky land"),
    CLEAR_TREE_LAND(2, "Clearing land containing tree"),
    VISITING_CLEARED_LAND(1, "Visiting any land that has already been cleared");


    private final int fuelUnit;
    private final String description;

    Activity(int fuelUnit, String description) {
        this.fuelUnit = fuelUnit;
        this.description = description;
    }

    public int getFuelUnit() {
        return fuelUnit;
    }

    public String getDescription() {
        return description;
    }
}
