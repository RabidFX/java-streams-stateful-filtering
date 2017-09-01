package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.Generator;
import com.nullpaperexception.test.java.streams.filtering.beans.generators.SimpleFruitGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test class for Straightforward processor.
 */
public class StraightforwardProcessorTest {
    
    private static final int EXPECTED = 20;
    
    @Test
    public void testProcessSize() {
        
        final Generator generator = new SimpleFruitGenerator();
        final List<Fruit> input = generator.generateOrderedNoPear(EXPECTED * 2);
        final List<Fruit> oracle = new ArrayList<>(input).subList(0, EXPECTED);
        Collections.shuffle(input);
        
        final List<Fruit> output = new StraightforwardProcessor().process(input, EXPECTED);
        
        assertEquals(oracle, output);   
    }
    
}
