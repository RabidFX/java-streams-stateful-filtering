package com.nullpaperexception.test.java.streams.filtering.beans.generators;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.FruitType;
import com.nullpaperexception.test.java.streams.filtering.beans.SimpleFruit;

/**
 * A Generator of SimpleFruit.
 */
public class SimpleFruitGenerator extends Generator {

    @Override
    public Fruit generateFruit(int size, FruitType fruitType) {
        return new SimpleFruit(size, fruitType);
    }
    
}
