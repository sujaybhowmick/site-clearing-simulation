package com.sujay.simulator.sitemap;

public enum Orientation {
    NORTH('N'), SOUTH('S'), EAST('E'), WEST('W');

    private final char orientation;

    Orientation(char orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return String.valueOf(this.orientation);
    }
}

