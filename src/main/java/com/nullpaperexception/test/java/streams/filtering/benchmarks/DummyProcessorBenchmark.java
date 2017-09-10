package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.processors.DummyProcessor;
import com.nullpaperexception.test.java.streams.filtering.processors.Processor;

/**
 * Temp class for test.
 */
public class DummyProcessorBenchmark extends Benchmarks {

    @Override
    protected Processor getTestedProcessor() {
        return new DummyProcessor();
    }
    
}
