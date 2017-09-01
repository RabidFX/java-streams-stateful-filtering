package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.beans.generators.Generator;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.SimpleFruitGenerator;
import com.nullpaperexception.test.java.streams.filtering.processors.StraightforwardProcessor;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * Benchmarking class
 */
public class Benchmarks {

    @Benchmark
    public void straightforwardSimpleFruit() {
        final Generator generator = new SimpleFruitGenerator();
        final int SMALL_NUMBER_OF_FRUITS = 20;
        new StraightforwardProcessor().process(generator.generateOrderedNoPear(SMALL_NUMBER_OF_FRUITS), SMALL_NUMBER_OF_FRUITS);
    }    

}
