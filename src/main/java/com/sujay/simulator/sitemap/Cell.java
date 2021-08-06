package com.sujay.simulator.sitemap;

import java.util.Objects;

public class Cell {
    private final CellType cellType;
    private final Coordinate coordinate;

    public Cell(CellType cellType, Coordinate coordinate) {
        this.cellType = cellType;
        this.coordinate = coordinate;
    }

    public CellType getCellType() {
        return cellType;
    }


    public Coordinate getCoordinate() {
        return coordinate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return getCellType() == cell.getCellType() && getCoordinate().equals(cell.getCoordinate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCellType(), getCoordinate());
    }

    @Override
    public String toString() {
        return "{" +
                "Cell Type:" + cellType +
                ", Coordinates (x, y):(" +
                coordinate.getX() + ", " +
                coordinate.getY() + ")}";
    }
}

