package com.nullpaperexception.test.java.streams.filtering.benchmarks;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.Generator;
import java.util.List;

/**
 * Abstract class contraining some common code for benchmarks.
 */
public abstract class Benchmarks {
    
    protected static final int SMALL_NUMBER_OF_FRUITS = 20;
    protected static final int MEDIUM_NUMBER_OF_FRUITS = 200;
    protected static final int LARGE_NUMBER_OF_FRUITS = 2000;

    protected final List<Fruit> SMALL_PEARLESS_LIST = getGenerator().generateOrderedNoPear(SMALL_NUMBER_OF_FRUITS);
    protected final List<Fruit> SMALL_MIXED_LIST = getGenerator().generateOrderedMixed(SMALL_NUMBER_OF_FRUITS);
    protected final List<Fruit> SMALL_PEAR_LIST = getGenerator().generateOrderedAllPears(SMALL_NUMBER_OF_FRUITS);
    protected final List<Fruit> MEDIUM_PEARLESS_LIST = getGenerator().generateOrderedNoPear(MEDIUM_NUMBER_OF_FRUITS);
    protected final List<Fruit> MEDIUM_MIXED_LIST = getGenerator().generateOrderedMixed(MEDIUM_NUMBER_OF_FRUITS);
    protected final List<Fruit> MEDIUM_PEAR_LIST = getGenerator().generateOrderedAllPears(MEDIUM_NUMBER_OF_FRUITS);
    protected final List<Fruit> LARGE_PEARLESS_LIST = getGenerator().generateOrderedNoPear(LARGE_NUMBER_OF_FRUITS);
    protected final List<Fruit> LARGE_MIXED_LIST = getGenerator().generateOrderedMixed(LARGE_NUMBER_OF_FRUITS);
    protected final List<Fruit> LARGE_PEAR_LIST = getGenerator().generateOrderedAllPears(LARGE_NUMBER_OF_FRUITS);

    protected abstract Generator getGenerator();    
    
}
