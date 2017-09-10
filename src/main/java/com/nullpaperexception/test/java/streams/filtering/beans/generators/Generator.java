package com.nullpaperexception.test.java.streams.filtering.beans.generators;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.FruitType;
import com.nullpaperexception.test.java.streams.filtering.benchmarks.Benchmarks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Abstract class generating fruit lists.
 */
public abstract class Generator {
    
    // List types.
    public static final int SMALL_PEARLESS_LIST = 0;
    public static final int SMALL_MIXED_LIST = 1;
    public static final int SMALL_PEAR_LIST = 2;
    public static final int MEDIUM_PEARLESS_LIST = 3;
    public static final int MEDIUM_MIXED_LIST = 4;
    public static final int MEDIUM_PEAR_LIST = 5;
    public static final int LARGE_PEARLESS_LIST = 6;
    public static final int LARGE_MIXED_LIST = 7;
    public static final int LARGE_PEAR_LIST = 8;
    
    // Total number of list types.
    public static final int TOTAL_LIST_TYPES = 9;
    
    private static final Function<Integer, FruitType>[] FRUIT_TYPES_CALCULATORS = new Function[TOTAL_LIST_TYPES];
    private static final int[] EXPECTED_NUMBER_OF_FRUITS = new int[TOTAL_LIST_TYPES];
    
    static {
        
        final Function<Integer, FruitType> mixedFruitsCalculator = (i) -> i % 2 == 0 ? FruitType.PEAR : FruitType.OTHER;
        final Function<Integer, FruitType> noPearsCalculator = (i) -> FruitType.OTHER;
        final Function<Integer, FruitType> onlyPearsCalculator = (i) -> FruitType.PEAR;
        
        for (int i = 0; i < 9; i++) {
            FRUIT_TYPES_CALCULATORS[i] = i % 3 == 0 ? noPearsCalculator : (i - 1) % 3 == 0 ? mixedFruitsCalculator : onlyPearsCalculator;
            EXPECTED_NUMBER_OF_FRUITS[i] = i < 3 ? Benchmarks.SMALL_NUMBER_OF_FRUITS : i < 6 ? Benchmarks.MEDIUM_NUMBER_OF_FRUITS : Benchmarks.LARGE_NUMBER_OF_FRUITS;
        }    
    }
    
    /**
     * A method used to generate a fruit.
     * 
     * @param size The fruit Size we expect.
     * @param fruitType The fruit type we expect.
     * 
     * @return The expected fruit.
     */
    public abstract Fruit generateFruit(int size, FruitType fruitType);    
    
    /**
     * Generate an certain list of ordered fruits.
     * 
     * @param listType The expected list type. See Generator class for acceptable values.
     * 
     * @return An unmodifiable List of the generated Fruit
     */
    public List<Fruit> generate(int listType) {
        return Collections.unmodifiableList(innerGenerate(listType));
    }
    
    /**
     * Generate an certain list of unordered fruits.
     * 
     * @param listType The expected list type. See Generator class for acceptable values.
     * 
     * @return An unmodifiable List of the generated Fruit
     */
    public List<Fruit> generateShuffled(int listType) {
        final List<Fruit> list = innerGenerate(listType);
        Collections.shuffle(list);
        return Collections.unmodifiableList(list);
    }
    
    private List<Fruit> innerGenerate(int listType) {
        final int expected = EXPECTED_NUMBER_OF_FRUITS[listType];
        final List<Fruit> result = new ArrayList<>(expected);
        IntStream.range(1, expected).forEach(size -> result.add(generateFruit(size, FRUIT_TYPES_CALCULATORS[listType].apply(size))));
        return result;
    }

}
