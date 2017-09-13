package com.nullpaperexception.test.java.streams.filtering.beans.generators;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.FruitType;
import com.nullpaperexception.test.java.streams.filtering.beans.ComplexFruit;

/**
 * A Generator of ComplexFruit.
 */
public class ComplexFruitGenerator extends Generator {

    @Override
    public Fruit generateFruit(int size, FruitType fruitType) {
        return new ComplexFruit(size, fruitType);
    }
    
}
