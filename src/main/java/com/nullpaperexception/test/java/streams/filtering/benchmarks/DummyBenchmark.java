package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.processors.DummyProcessor;
import com.nullpaperexception.test.java.streams.filtering.processors.Processor;

/**
 * Dummy processor benchmark made to analyse overhead.
 */
public class DummyBenchmark extends Benchmarks {

    @Override
    protected Processor getTestedProcessor() {
        return new DummyProcessor();
    }
    
}
