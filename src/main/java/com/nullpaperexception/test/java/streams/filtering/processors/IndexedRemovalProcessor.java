package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Solution relying on the removal of a particular index, made from Holger's answer.
 */
public class IndexedRemovalProcessor extends Processor {

    @Override
    public List<Fruit> process(List<Fruit> input, int expected) {
        final List<Fruit> output = input.stream()
            .sorted(Processor::compareSize)
            .limit(expected + 1)
            .collect(Collectors.toCollection(ArrayList::new));
        int index = IntStream.range(0, output.size())
            .filter(ix -> isPear(output.get(ix)))
            .findFirst().orElse(expected);
        if (index < output.size()) {
            output.remove(index);
        }
        return output;
    }

    private static class OnlyOncePredicate<T> implements Predicate<T> {

        private final Predicate<T> innerPredicate;
        
        private boolean alreadyFiltered;

        public OnlyOncePredicate(Predicate<T> innerPredicate) {
            this.innerPredicate = innerPredicate;
            this.alreadyFiltered = false;
        }

        @Override
        public boolean test(T t) {
            if (alreadyFiltered) {
                return true;
            }
            boolean result = innerPredicate.test(t);
            alreadyFiltered = !result;
            return result;
        }
    }
}
