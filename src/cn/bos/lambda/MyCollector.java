package cn.bos.lambda;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @classname: MyCollector
 * @description: default
 * @author: pyethel
 * @create: 2021/10/14 09:38
 */
public class MyCollector<T> implements Collector<T, Map<T, Integer>, Set<T>> {
    /**
     * A function that creates and returns a new mutable result container.
     *
     * @return a function which returns a new, mutable result container
     */
    @Override
    public Supplier<Map<T, Integer>> supplier() {
        System.out.println("MyCollector.supplier()");
        return () -> {
            System.out.println("----------supplier lambda执行");
            return new ConcurrentHashMap<>(16);
        };
    }

    /**
     * A function that folds a value into a mutable result container.
     *
     * @return a function which folds a value into a mutable result container
     */
    @Override
    public BiConsumer<Map<T, Integer>, T> accumulator() {
        System.out.println("MyCollector.accumulator()");
        return (map, item) -> {
            System.out.println("result: " + map + " accumulator.for: " + Thread.currentThread().getName());
            map.merge(item, 1, Integer::sum);
        };
    }

    /**
     * A function that accepts two partial results and merges them.  The
     * combiner function may fold state from one argument into the other and
     * return that, or may return a new result container.
     *
     * @return a function which combines two partial results into a combined
     * result
     */
    @Override
    public BinaryOperator<Map<T, Integer>> combiner() {
        System.out.println("MyCollector.combiner()");
        return (map1, map2) -> {
            map2.forEach((key, value) -> {
                Integer newValue = value;
                if (map1.get(key) != null) {
                    newValue = map1.get(key) + value;
                }
                map1.put(key, newValue);
            });
            System.out.println("after map1 = " + map1);
            return map1;
        };
    }

    /**
     * Perform the final transformation from the intermediate accumulation type
     * {@code A} to the final result type {@code R}.
     *
     * <p>If the characteristic {@code IDENTITY_TRANSFORM} is
     * set, this function may be presumed to be an identity transform with an
     * unchecked cast from {@code A} to {@code R}.
     *
     * @return a function which transforms the intermediate result to the final
     * result
     */
    @Override
    public Function<Map<T, Integer>, Set<T>> finisher() {
        return map -> {
            System.out.println("MyCollector.finisher()");
            Set<T> set = new HashSet<>();
            Integer integer = map.values().stream().distinct().max(Integer::compareTo).orElse(null);
            map.entrySet().stream().filter(e -> e.getValue().equals(integer)).forEach(e -> set.add(e.getKey()));
            return set;
        };
    }

    /**
     * Returns a {@code Set} of {@code Collector.Characteristics} indicating
     * the characteristics of this Collector.  This set should be immutable.
     *
     * @return an immutable set of collector characteristics
     */
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("MyCollector.characteristics()");
        return new HashSet<>();
    }
}
