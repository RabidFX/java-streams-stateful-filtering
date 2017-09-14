package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.processors.Processor;
import com.nullpaperexception.test.java.streams.filtering.processors.IndexedRemovalProcessor;

/**
 * StatefulPredicate benchmarking class
 */
public class IndexedRemovalProcessorBenchmark extends Benchmarks {

    @Override
    protected Processor getTestedProcessor() {
        return new IndexedRemovalProcessor();
    }

}
