package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.processors.Processor;
import com.nullpaperexception.test.java.streams.filtering.processors.CustomCollectorProcessor;

/**
 * CustomCollector benchmarking class
 */
public class CustomCollectorProcessorBenchmark extends Benchmarks {

    @Override
    protected Processor getTestedProcessor() {
        return new CustomCollectorProcessor();
    }

}
