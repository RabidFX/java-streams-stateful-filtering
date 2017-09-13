package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.ComplexFruitGenerator;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.Generator;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.SimpleFruitGenerator;
import com.nullpaperexception.test.java.streams.filtering.processors.Processor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * Abstract class contraining some common code for benchmarks.
 */
@State(Scope.Benchmark)
public abstract class Benchmarks {
    
    // Reasonable amounts to select in a list of fruits of similar size.
    public static final int SMALL_NUMBER_OF_FRUITS = 20;
    public static final int MEDIUM_NUMBER_OF_FRUITS = 200;
    public static final int LARGE_NUMBER_OF_FRUITS = 2000;
        
    // Fruit types.
    protected static final int SIMPLE_FRUIT_TYPE = 0;
    protected static final int COMPLEX_FRUIT_TYPE = 0;
    
    private Map<BenchType, List<Fruit>> testSuites;
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleSmallNoPear() {
        getTestedProcessor().process(getTestSuite(Generator.SMALL_PEARLESS_LIST, SIMPLE_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleSmallAllPears() {
        getTestedProcessor().process(getTestSuite(Generator.SMALL_PEAR_LIST, SIMPLE_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleSmallMixed() {
        getTestedProcessor().process(getTestSuite(Generator.SMALL_MIXED_LIST, SIMPLE_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleMediumNoPear() {
        getTestedProcessor().process(getTestSuite(Generator.MEDIUM_PEARLESS_LIST, SIMPLE_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleMediumAllPears() {
        getTestedProcessor().process(getTestSuite(Generator.MEDIUM_PEAR_LIST, SIMPLE_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleMediumMixed() {
        getTestedProcessor().process(getTestSuite(Generator.MEDIUM_MIXED_LIST, SIMPLE_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleLargeNoPear() {
        getTestedProcessor().process(getTestSuite(Generator.LARGE_PEARLESS_LIST, SIMPLE_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleLargeAllPears() {
        getTestedProcessor().process(getTestSuite(Generator.LARGE_PEAR_LIST, SIMPLE_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void simpleLargeMixed() {
        getTestedProcessor().process(getTestSuite(Generator.LARGE_MIXED_LIST, SIMPLE_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void complexSmallNoPear() {
        getTestedProcessor().process(getTestSuite(Generator.SMALL_PEARLESS_LIST, COMPLEX_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void complexSmallAllPears() {
        getTestedProcessor().process(getTestSuite(Generator.SMALL_PEAR_LIST, COMPLEX_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void complexSmallMixed() {
        getTestedProcessor().process(getTestSuite(Generator.SMALL_MIXED_LIST, COMPLEX_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void complexMediumNoPear() {
        getTestedProcessor().process(getTestSuite(Generator.MEDIUM_PEARLESS_LIST, COMPLEX_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void complexMediumAllPears() {
        getTestedProcessor().process(getTestSuite(Generator.MEDIUM_PEAR_LIST, COMPLEX_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void complexMediumMixed() {
        getTestedProcessor().process(getTestSuite(Generator.MEDIUM_MIXED_LIST, COMPLEX_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void complexLargeNoPear() {
        getTestedProcessor().process(getTestSuite(Generator.LARGE_PEARLESS_LIST, COMPLEX_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void complexLargeAllPears() {
        getTestedProcessor().process(getTestSuite(Generator.LARGE_PEAR_LIST, COMPLEX_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void complexLargeMixed() {
        getTestedProcessor().process(getTestSuite(Generator.LARGE_MIXED_LIST, COMPLEX_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    }
    
    @Setup
    public void setup() {
        
        // Size of the map is number of list types * number of generators.
        testSuites = new HashMap<>(2 * Generator.TOTAL_LIST_TYPES);
               
        final Generator simpleGenerator = new SimpleFruitGenerator();
        for (int i = 0; i < Generator.TOTAL_LIST_TYPES; i++) {
            testSuites.put(new BenchType(i, SIMPLE_FRUIT_TYPE), simpleGenerator.generateShuffled(i));
        }
        final Generator complexGenerator = new ComplexFruitGenerator();
        for (int i = 0; i < Generator.TOTAL_LIST_TYPES; i++) {
            testSuites.put(new BenchType(i, COMPLEX_FRUIT_TYPE), complexGenerator.generateShuffled(i));
        }
    }
    
    protected abstract Processor getTestedProcessor();

    /**
     * Returns a pre-computed test suite according to their fruit and list type.
     * 
     * @param listType The expected list type. See possible int values in the Generator class.
     * @param fruitType The expected fruit type. See possible int values in the Benchmark class.
     * 
     * @return A pre-computed, immutable and unordered List of Fruit.
     */
    private List<Fruit> getTestSuite(int listType, int fruitType) {
        return testSuites.get(new BenchType(listType, fruitType));
    }
    
    private static class BenchType {
        
        private final int listType;
        private final int fruitType;

        public BenchType(int listType, int fruitType) {
            this.listType = listType;
            this.fruitType = fruitType;
        }

        @Override
        public int hashCode() {
            return this.fruitType << 16 + this.listType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final BenchType other = (BenchType) obj;
            if (this.listType != other.listType) {
                return false;
            }
            return this.fruitType == other.fruitType;
        }
        
    }
}
