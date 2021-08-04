package com.sujay.simulator.sitemap.reader;

import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.CellType;
import com.sujay.simulator.sitemap.Coordinate;
import com.sujay.simulator.sitemap.SiteMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class SiteMapReader implements MapReader<SiteMap> {
    private final BufferedReader reader;

    private SiteMapReader(Builder builder) {
        assert builder.reader != null;
        this.reader = new BufferedReader(builder.reader);
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
                        siteMap.addCell(new Cell(CellType.ROCK, this.createCoordinate(row, col)));
                        break;
                    case 't':
                        siteMap.addCell(new Cell(CellType.TREE, this.createCoordinate(row, col)));
                        break;
                    default:
                        siteMap.addCell(new Cell(CellType.CLEAR, this.createCoordinate(row, col)));
                }
            }
        }
        return siteMap;
    }

    private Coordinate createCoordinate(int x, int y) {
        return new Coordinate(x, y);
    }

    static class Builder {
        private Reader reader;

        public Builder() {
        }

        public Builder reader(Reader reader) {
            this.reader = reader;
            return this;
        }

        public SiteMapReader build() {
            return new SiteMapReader(this);
        }
    }
}
