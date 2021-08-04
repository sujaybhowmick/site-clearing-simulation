package com.sujay.simulator.sitemap.reader;

import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.Coordinate;
import com.sujay.simulator.sitemap.SiteMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.StringReader;

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
    void readMap() throws Exception {
        final String input = "oooo\noror\ntoot";
        final MapReader<SiteMap> reader = builder.reader(new StringReader(input)).build();
        SiteMap siteMap = reader.readMap();
        Cell cell = siteMap.getCellAt(new Coordinate(1, 2));
    }
}