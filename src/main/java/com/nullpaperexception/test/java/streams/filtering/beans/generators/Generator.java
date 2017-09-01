package com.nullpaperexception.test.java.streams.filtering.beans.generators;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.FruitType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Abstract class generating fruit lists.
 */
public abstract class Generator {

    /**
     * Generate an expected number of ordered non-pear fruits.
     * 
     * @param expected The number of Fruit expected.
     * 
     * @return A List of the genrated Fruit
     */
    public List<Fruit> generateOrderedNoPear(int expected) {
        final List<Fruit> result = new ArrayList<>(expected);
        IntStream.range(1, expected).forEach(size -> result.add(generateFruit(size, FruitType.OTHER)));
        return result;
    }

    public abstract Fruit generateFruit(int size, FruitType fruitType);    
}
