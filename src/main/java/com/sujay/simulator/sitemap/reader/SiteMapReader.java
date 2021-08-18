package com.sujay.simulator.sitemap.reader;

import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.CellType;
import com.sujay.simulator.sitemap.Coordinate;
import com.sujay.simulator.sitemap.SiteMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class SiteMapReader implements MapReader {
    private final BufferedReader reader;

    public SiteMapReader(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    @Override
    public SiteMap readMap() {
        StringBuilder content = new StringBuilder();
        String line;
        while (true) {
            try {
                if ((line = this.reader.readLine()) != null) content.append(line).append('\n');
                else break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buildSiteMap(String.valueOf(content));
    }

    private SiteMap buildSiteMap(String content) {
        String[] lines = content.split("\n");
        int rows = lines.length;
        int cols = lines[0].length();
        final SiteMap siteMap = new SiteMap(rows, cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                switch (lines[row].charAt(col)) {
                    case 'r':
                        siteMap.addCell(this.createCell(CellType.ROCK, row, col));
                        break;
                    case 't':
                        siteMap.addCell(this.createCell(CellType.REMOVEABLETREE, row, col));
                        break;
                    case 'T':
                        siteMap.addCell(this.createCell(CellType.PRESERVEDTREE, row, col));
                        break;
                    default:
                        siteMap.addCell(this.createCell(CellType.CLEAR, row, col));
                }
            }
        }
        return siteMap;
    }

    private Cell createCell(CellType cellType, int row, int col) {
        return new Cell(cellType, this.createCoordinate(row, col));
    }

    private Coordinate createCoordinate(int x, int y) {
        return new Coordinate(x, y);
    }

}
