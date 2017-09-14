package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.processors.Processor;
import com.nullpaperexception.test.java.streams.filtering.processors.ComparatorHackProcessor2;

/**
 * ComparatorHack2 benchmarking class
 */
public class ComparatorHackProcessor2Benchmark extends Benchmarks {

    @Override
    protected Processor getTestedProcessor() {
        return new ComparatorHackProcessor2();
    }

}
