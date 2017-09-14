package com.nullpaperexception.test.java.streams.filtering.processors;

import com.nullpaperexception.test.java.streams.filtering.beans.Fruit;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Custom filtering in the collector, made from Eugene's answer.
 */
public class CustomCollectorProcessor extends Processor {

    @Override
    public List<Fruit> process(List<Fruit> input, int expected) {
        return input.stream().collect(exceptFirstCollector(f -> this.isPear(f), expected, (f1, f2) -> this.compareSize(f1, f2)));
    }

    private static <T> Collector<T, ?, List<T>> exceptFirstCollector(Predicate<T> predicate, int size, Comparator<T> comparator) {

        class Acc {

            private final TreeSet<T> matches = new TreeSet<>(comparator);
            private final TreeSet<T> doesNot = new TreeSet<>(comparator);

            void accumulate(T t) {
                if (predicate.test(t)) {
                    matches.add(t);
                } else {
                    doesNot.add(t);
                }
            }

            Acc combine(Acc other) {

                matches.addAll(other.matches);
                doesNot.addAll(other.doesNot);
                return this;
            }

            List<T> finisher() {
                if (!matches.isEmpty()) {
                    matches.remove(matches.first());
                }

                matches.addAll(doesNot);
                return matches.stream().limit(size).collect(Collectors.toList());
            }

        }
        return Collector.of(Acc::new, Acc::accumulate, Acc::combine, Acc::finisher);
    }
}
