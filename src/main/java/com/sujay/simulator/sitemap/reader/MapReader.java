package com.sujay.simulator.sitemap.reader;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public interface MapReader<T> {
    T readMap();

}
