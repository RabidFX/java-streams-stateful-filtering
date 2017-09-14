package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.processors.Processor;
import com.nullpaperexception.test.java.streams.filtering.processors.ComparatorHackProcessor;

/**
 * ComparatorHack benchmarking class
 */
public class ComparatorHackProcessorBenchmark extends Benchmarks {

    @Override
    protected Processor getTestedProcessor() {
        return new ComparatorHackProcessor();
    }

}
