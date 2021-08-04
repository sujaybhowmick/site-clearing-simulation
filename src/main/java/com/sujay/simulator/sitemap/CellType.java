package com.sujay.simulator.sitemap;

public enum CellType {
    ROCK('r'), CLEAR('o'), TREE('t');

    private final char type;
    CellType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.valueOf(this.type);
    }
}
