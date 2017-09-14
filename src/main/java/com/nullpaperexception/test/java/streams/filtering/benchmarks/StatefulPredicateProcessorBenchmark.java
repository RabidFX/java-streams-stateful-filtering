package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.processors.Processor;
import com.nullpaperexception.test.java.streams.filtering.processors.StatefulPredicateProcessor;

/**
 * StatefulPredicate benchmarking class
 */
public class StatefulPredicateProcessorBenchmark extends Benchmarks {

    @Override
    protected Processor getTestedProcessor() {
        return new StatefulPredicateProcessor();
    }

}
