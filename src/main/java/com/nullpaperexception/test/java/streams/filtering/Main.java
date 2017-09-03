package com.nullpaperexception.test.java.streams.filtering;

import com.nullpaperexception.test.java.streams.filtering.benchmarks.Benchmarks;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Main calss used to launch the benchmarks.
 */
public class Main {
    
    public static void main(String[] args) throws RunnerException {
        final Options opt = new OptionsBuilder()
                .include(Benchmarks.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
    
}
