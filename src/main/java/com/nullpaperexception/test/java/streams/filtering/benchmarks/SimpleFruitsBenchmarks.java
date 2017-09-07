package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.beans.generators.Generator;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.SimpleFruitGenerator;
import com.nullpaperexception.test.java.streams.filtering.processors.StraightforwardProcessor;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * Benchmarking class
 */
@State(Scope.Benchmark)
public class SimpleFruitsBenchmarks extends Benchmarks {

    private static final Generator GENERATOR = new SimpleFruitGenerator();
    
    @Override
    protected Generator getGenerator() {
        return GENERATOR;
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void straightforwardSmallNoPear() {
        new StraightforwardProcessor().process(SMALL_PEARLESS_LIST, SMALL_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void straightforwardSmallAllPears() {
        new StraightforwardProcessor().process(SMALL_PEAR_LIST, SMALL_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void straightforwardSmallMixed() {
        new StraightforwardProcessor().process(SMALL_MIXED_LIST, SMALL_NUMBER_OF_FRUITS);
    } 

}
