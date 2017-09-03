package com.nullpaperexception.test.java.streams.filtering.beans.generators;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.FruitType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
     * @return A List of the genrated Fruit
     */
    public List<Fruit> generateOrderedNoPear(int expected) {
        return generateOrderedList(expected, FruitType.OTHER);
    }

    /**
     * Generate an expected number of ordered pears.
     * 
     * @param expected The number of pears expected.
     * 
     * @return A List of the genrated Fruit
     */
    public List<Fruit> generateOrderedAllPears(int expected) {
        return generateOrderedList(expected, FruitType.PEAR);
    }
    
    
    /**
     * Common method for list generation.
     * 
     * @param expected The number of expected fruits.
     * @param type The type of the expected fruits.
     * 
     * @return A List of the genrated Fruit
     */
    private List<Fruit> generateOrderedList(int expected, FruitType type) {
        final List<Fruit> result = new ArrayList<>(expected);
        IntStream.range(1, expected).forEach(size -> result.add(generateFruit(size, type)));
        return Collections.unmodifiableList(result);
    }
}
