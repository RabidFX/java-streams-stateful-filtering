package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution relying on a custom sort, made from xenteros' answer.
 */
public class ComparatorHackProcessor extends Processor {

    @Override
    public List<Fruit> process(List<Fruit> input, int expected) {
        return input.stream()
            .sorted(Processor::compareSize)
            .limit(expected + 1)
            .sorted(CUSTOM_FRUIT_COMPARATOR)
            .limit(expected)
            .sorted(Processor::compareSize)
            .collect(Collectors.toList());
    }

    /**
     * Custom fruit comparator meant to store Pears at the end in reverse order.
     */
    private static final Comparator<Fruit> CUSTOM_FRUIT_COMPARATOR = (o1, o2) -> {
        // Reverse order of Pears
        if (isPear(o1) && isPear(o2)) {
            return o2.getSize().compareTo(o1.getSize()); 
        }
        if (isPear(o1)) {
            return 1;
        }
        if (isPear(o2)) {
            return -1;
        }
        return o1.getSize().compareTo(o2.getSize());
    };
}
