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
    public static final int SMALL_NUMBER_OF_FRUITS = 10;
    public static final int MEDIUM_NUMBER_OF_FRUITS = 50;
    public static final int LARGE_NUMBER_OF_FRUITS = 500;
        
    // Fruit types.
    protected static final int SIMPLE_FRUIT_TYPE = 0;
    protected static final int COMPLEX_FRUIT_TYPE = 0;
    
    private Map<BenchType, List<Fruit>> testSuites;
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleSmallNoPear() {
        return getTestedProcessor().process(getTestSuite(Generator.SMALL_PEARLESS_LIST, SIMPLE_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleSmallAllPears() {
        return getTestedProcessor().process(getTestSuite(Generator.SMALL_PEAR_LIST, SIMPLE_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleSmallMixed() {
        return getTestedProcessor().process(getTestSuite(Generator.SMALL_MIXED_LIST, SIMPLE_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleMediumNoPear() {
        return getTestedProcessor().process(getTestSuite(Generator.MEDIUM_PEARLESS_LIST, SIMPLE_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleMediumAllPears() {
        return getTestedProcessor().process(getTestSuite(Generator.MEDIUM_PEAR_LIST, SIMPLE_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleMediumMixed() {
        return getTestedProcessor().process(getTestSuite(Generator.MEDIUM_MIXED_LIST, SIMPLE_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleLargeNoPear() {
        return getTestedProcessor().process(getTestSuite(Generator.LARGE_PEARLESS_LIST, SIMPLE_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleLargeAllPears() {
        return getTestedProcessor().process(getTestSuite(Generator.LARGE_PEAR_LIST, SIMPLE_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleLargeMixed() {
        return getTestedProcessor().process(getTestSuite(Generator.LARGE_MIXED_LIST, SIMPLE_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexSmallNoPear() {
        return getTestedProcessor().process(getTestSuite(Generator.SMALL_PEARLESS_LIST, COMPLEX_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexSmallAllPears() {
        return getTestedProcessor().process(getTestSuite(Generator.SMALL_PEAR_LIST, COMPLEX_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexSmallMixed() {
        return getTestedProcessor().process(getTestSuite(Generator.SMALL_MIXED_LIST, COMPLEX_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexMediumNoPear() {
        return getTestedProcessor().process(getTestSuite(Generator.MEDIUM_PEARLESS_LIST, COMPLEX_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexMediumAllPears() {
        return getTestedProcessor().process(getTestSuite(Generator.MEDIUM_PEAR_LIST, COMPLEX_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexDownsizeMixed() {
        return getTestedProcessor().process(getTestSuite(Generator.LARGE_MIXED_LIST, COMPLEX_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> simpleDownsizeMixed() {
        return getTestedProcessor().process(getTestSuite(Generator.LARGE_MIXED_LIST, SIMPLE_FRUIT_TYPE), SMALL_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexMediumMixed() {
        return getTestedProcessor().process(getTestSuite(Generator.MEDIUM_MIXED_LIST, COMPLEX_FRUIT_TYPE), MEDIUM_NUMBER_OF_FRUITS);
    } 
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexLargeNoPear() {
        return getTestedProcessor().process(getTestSuite(Generator.LARGE_PEARLESS_LIST, COMPLEX_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexLargeAllPears() {
        return getTestedProcessor().process(getTestSuite(Generator.LARGE_PEAR_LIST, COMPLEX_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
    }
    
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public List<Fruit> complexLargeMixed() {
        return getTestedProcessor().process(getTestSuite(Generator.LARGE_MIXED_LIST, COMPLEX_FRUIT_TYPE), LARGE_NUMBER_OF_FRUITS);
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
