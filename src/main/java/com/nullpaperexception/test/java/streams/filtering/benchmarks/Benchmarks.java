package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.SimpleFruitGenerator;
import com.nullpaperexception.test.java.streams.filtering.processors.StraightforwardProcessor;
import java.util.List;
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
public class Benchmarks {

    private static final int SMALL_NUMBER_OF_FRUITS = 20;

    private final List<Fruit> SMALL_PEARLESS_LIST = new SimpleFruitGenerator().generateOrderedNoPear(SMALL_NUMBER_OF_FRUITS);

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void straightforwardSimpleFruit() {
        new StraightforwardProcessor().process(SMALL_PEARLESS_LIST, SMALL_NUMBER_OF_FRUITS);
    }    

}
