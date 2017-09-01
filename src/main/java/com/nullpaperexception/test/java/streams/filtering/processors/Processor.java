package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.FruitType;
import java.util.List;

/**
 * Abstract class regrouping the non-critical aspects of the processors.
 */
public abstract class Processor {
    
    /**
     * Processes a List of Fruit to order them by size, remove the smallest pear, and keep only the X smallest. 
     * 
     * @param input A List of Fruit we want to process.
     * @param expected The number of fruits we want to keep in the end.
     * 
     * @return A processed List of Fruit.
     */
    public abstract List<Fruit> process(List<Fruit> input, int expected);
    
    /**
     * Simple method checking if a fruit is a pear.
     * 
     * @param fruit The checked fruit.
     * 
     * @return True if it's FruitType is PEAR, false otherwise.
     */
    protected boolean isPear(Fruit fruit) {
        return FruitType.PEAR.equals(fruit.getType());
    }
    
    /**
     * Simple fruit size comparator.
     * 
     * @param f1 The first fruit.
     * @param f2 the second fruit.
     * 
     * @return True if it's FruitType is PEAR, false otherwise.
     */
    protected int compareSize(Fruit f1, Fruit f2) {
        return f1 == null ? 1 : f2 == null ? -1 : f1.getSize().compareTo(f2.getSize());
    }
}
