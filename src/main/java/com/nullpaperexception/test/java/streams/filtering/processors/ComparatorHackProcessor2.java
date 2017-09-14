package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import com.nullpaperexception.test.java.streams.filtering.beans.FruitType;
import com.nullpaperexception.test.java.streams.filtering.beans.SimpleFruit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Solution relying on a custom sort with dummy pear, made from yegodm's answer.
 */
public class ComparatorHackProcessor2 extends Processor {

    @Override
    public List<Fruit> process(List<Fruit> input, int expected) {
        final Fruit dummy = new SimpleFruit(-1, FruitType.PEAR);
        return Stream.concat(input.stream(), Stream.of(dummy))
            .sorted(Comparator.<Fruit>comparingInt(
                // arrange the dummy to always be the last 
                // among other pears but before other types 
                f -> (f == dummy ? 0 : isPear(f) ? -1 : 1)
                )
                .thenComparing(Processor::compareSize))
            // skip the smallest pear
            .skip(1)
            // filter out the dummy
            .filter(f -> f != dummy)
            // sort again the rest by size
            .sorted(Processor::compareSize)
            .limit(expected)
            .collect(Collectors.toList());
    }

}
