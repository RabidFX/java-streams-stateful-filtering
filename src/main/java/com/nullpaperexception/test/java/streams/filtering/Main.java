package com.nullpaperexception.test.java.streams.filtering;

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
                .include(".*Benchmark")
                .warmupIterations(3)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
    
}
