package com.sujay.simulator.sitemap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SiteMap {
    private final Cell[][] grid;

    public SiteMap(int rows, int cols) {
        this.grid = new Cell[rows][cols];
    }

    public void addCell(Cell cell) {
        grid[cell.getCoordinate().getX()][cell.getCoordinate().getY()] = cell;
    }

    public void printMap() {
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public Cell getCellAt(Coordinate coordinate) {
        ensureBounds(coordinate);
        return this.grid[coordinate.getX()][coordinate.getY()];
    }

    public Set<Cell> getAllCells() {
        return Arrays.stream(this.grid)
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());
    }


    private void ensureBounds(Coordinate coordinate) {
        final String message = String.format("Coordinates %s are out of bounds", coordinate);
        if (coordinate.getX() < 0 || coordinate.getX() >= this.grid.length) throw new IllegalArgumentException(message);
        if ((coordinate.getY() < 0 || coordinate.getY() >= this.grid[0].length))
            throw new IllegalArgumentException(message);
    }
}
