package com.sujay.simulator.sitemap.reader;

import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.CellType;
import com.sujay.simulator.sitemap.Coordinate;
import com.sujay.simulator.sitemap.SiteMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class SiteMapReaderTest {
    SiteMapReader.Builder builder;

    @BeforeEach
    void setUp() {
        this.builder = new SiteMapReader.Builder();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void readMap() {
        final String input = "oooo\noror\ntooT";
        final MapReader<SiteMap> reader = builder.reader(new StringReader(input)).build();
        SiteMap siteMap = reader.readMap();
        Coordinate coordinate11 = new Coordinate(1, 1);
        Cell cell11 = siteMap.getCellAt(coordinate11);
        assertThat(cell11).isNotNull();
        assertThat(cell11.getCellType()).isEqualTo(CellType.ROCK);
        assertThat(cell11.getCoordinate()).isEqualTo(coordinate11);

        Coordinate coordinate23 = new Coordinate(2, 3);
        Cell cell24 = siteMap.getCellAt(coordinate23);
        assertThat(cell24).isNotNull();
        assertThat(cell24.getCellType()).isEqualTo(CellType.PRESERVEDTREE);
        assertThat(cell24.getCoordinate()).isEqualTo(coordinate23);
    }

    @Test
    void readMapOutOfBounds() {
        final String input = "oooo\noror\ntooT";
        final MapReader<SiteMap> reader = builder.reader(new StringReader(input)).build();
        SiteMap siteMap = reader.readMap();
        Coordinate coordinate14 = new Coordinate(1, 4);
        try {
            Cell cell = siteMap.getCellAt(coordinate14);
            assertThat(cell).isNotNull();
            fail(String.format("Test failed as the bounds provided a cell value which is within bounds %s",
                    coordinate14));
        } catch (Exception iae) {
            assertThat(true).isTrue();
        }
    }

    @Test
    void printSiteMap() {
        final String input = "oooo\noror\ntooT";
        final MapReader<SiteMap> reader = builder.reader(new StringReader(input)).build();
        SiteMap siteMap = reader.readMap();
        siteMap.printMap();
    }
}
