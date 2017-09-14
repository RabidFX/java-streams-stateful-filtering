package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Straightforward filter made from Misha's answer.
 */
public class StraightforwardProcessor extends Processor {
    
    @Override
    public List<Fruit> process(List<Fruit> input, int expected) {
        
        final Optional<Fruit> smallestPear = input.stream()
            .filter(Processor::isPear)
            .min(Processor::compareSize);

        final Stream<Fruit> withoutSmallestPear = smallestPear
            .map(p -> input.stream().filter(f -> f != p))
            .orElseGet(input::stream);

        return withoutSmallestPear
            .sorted(Processor::compareSize)
            .limit(expected)
            .collect(Collectors.toList());
    }
    
}
