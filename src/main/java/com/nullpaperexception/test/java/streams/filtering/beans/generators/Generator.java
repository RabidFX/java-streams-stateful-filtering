package com.nullpaperexception.test.java.streams.filtering.beans.generators;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.FruitType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Abstract class generating fruit lists.
 */
public abstract class Generator {

    /**
     * A method used to generate a fruit.
     * 
     * @param size The fruit Size we expect.
     * @param fruitType TThe fruit type we expect.
     * 
     * @return The expected fruit.
     */
    public abstract Fruit generateFruit(int size, FruitType fruitType);    
    
    /**
     * Generate an expected number of ordered non-pear fruits.
     * 
     * @param expected The number of Fruit expected.
     * 
     * @return A List of the generated Fruit
     */
    public List<Fruit> generateOrderedNoPear(int expected) {
        return generateOrderedList(expected, (i) -> FruitType.OTHER);
    }

    /**
     * Generate an expected number of ordered pears.
     * 
     * @param expected The number of pears expected.
     * 
     * @return A List of the generated Fruit
     */
    public List<Fruit> generateOrderedAllPears(int expected) {
        return generateOrderedList(expected, (i) -> FruitType.PEAR);
    }
    
    
    /**
     * Generate an expected number of assorted fruits.
     * 
     * @param expected The number of fruits expected.
     * 
     * @return A List of the generated Fruit
     */
    public List<Fruit> generateOrderedMixed(int expected) {
        return generateOrderedList(expected, (i) -> i % 2 == 0 ? FruitType.PEAR : FruitType.OTHER);
    }
    
    /**
     * Common method for list generation.
     * 
     * @param expected The number of expected fruits.
     * @param typeCalculator A Function determining the type of fruits we want based on the position in the list.
     * 
     * @return A List of the genrated Fruit
     */
    private List<Fruit> generateOrderedList(int expected, Function<Integer, FruitType> typeCalculator) {
        final List<Fruit> result = new ArrayList<>(expected);
        IntStream.range(1, expected).forEach(size -> result.add(generateFruit(size, typeCalculator.apply(size))));
        return Collections.unmodifiableList(result);
    }
}
