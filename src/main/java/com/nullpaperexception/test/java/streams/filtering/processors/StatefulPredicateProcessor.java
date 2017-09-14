package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Solution relying on a stateful predicate, made from pedromss' answer.
 */
public class StatefulPredicateProcessor extends Processor {

    @Override
    public List<Fruit> process(List<Fruit> input, int expected) {
        return input.stream()
            .sorted(Processor::compareSize)
            .filter(new OnlyOncePredicate<>(Processor::isNotPear))
            .limit(expected)
            .collect(Collectors.toList());
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
