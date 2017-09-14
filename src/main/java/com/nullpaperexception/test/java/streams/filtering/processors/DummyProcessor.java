package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import java.util.List;

/**
 * Dummy processor made to analyse overhead.
 */
public class DummyProcessor extends Processor {

    @Override
    public List<Fruit> process(List<Fruit> input, int expected) {
        return input;
    }
    
}
