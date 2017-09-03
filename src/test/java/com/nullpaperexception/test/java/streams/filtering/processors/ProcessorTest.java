package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.FruitType;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.Generator;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.SimpleFruitGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Testing superclass used to glue some parts together.
 */
public abstract class ProcessorTest {
        
    private static final int EXPECTED = 20;
    
    private Generator generator = new SimpleFruitGenerator();
    protected Processor processor;
    
    @Test
    public void testProcessNoPear() {

        final List<Fruit> immutable = generator.generateOrderedNoPear(EXPECTED * 2);
        final List<Fruit> oracle = new ArrayList<>(immutable).subList(0, EXPECTED);
        final List<Fruit> input = new ArrayList<>(immutable);
        Collections.shuffle(input);
        
        final List<Fruit> output = processor.process(input, EXPECTED);
        
        assertEquals(oracle, output);   
    }
    
    @Test
    public void testProcessAllPears() {

        final List<Fruit> immutable = generator.generateOrderedAllPears(EXPECTED * 2);
        final List<Fruit> oracle = new ArrayList<>(immutable).subList(1, EXPECTED + 1);
        final List<Fruit> input = new ArrayList<>(immutable);
        Collections.shuffle(input);
        
        final List<Fruit> output = processor.process(input, EXPECTED);
        
        assertEquals(oracle, output);   
    }
    
    @Test
    public void testProcessOneSmallPear() {

        final List<Fruit> immutable = generator.generateOrderedNoPear(EXPECTED * 2);
        final List<Fruit> oracle = new ArrayList<>(immutable).subList(0, EXPECTED);
        final List<Fruit> input = new ArrayList<>(immutable);
        input.add(generator.generateFruit(1, FruitType.PEAR));
        Collections.shuffle(input);
        
        final List<Fruit> output = processor.process(input, EXPECTED);
        
        assertEquals(oracle, output);   
    }
    
}
