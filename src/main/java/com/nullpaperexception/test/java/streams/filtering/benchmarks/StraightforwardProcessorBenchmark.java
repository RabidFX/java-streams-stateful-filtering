package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.processors.Processor;
import com.nullpaperexception.test.java.streams.filtering.processors.StraightforwardProcessor;

/**
 * Straightforward solution benchmarking class
 */
public class StraightforwardProcessorBenchmark extends Benchmarks {

    @Override
    protected Processor getTestedProcessor() {
        return new StraightforwardProcessor();
    }

}
