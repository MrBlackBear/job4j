package ru.job4j.nonblock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class NonBlockingCache<T extends Item> {
    /**
     * Map.
     */
    private ConcurrentHashMap<Integer, T> map = new ConcurrentHashMap<>();

    /**
     * Add to map.
     *
     * @param item item.
     */
    public void add(T item) {
        map.putIfAbsent(item.getId(), item);
    }

    /**
     * Update value with same ID.
     *
     * @param newValue T.
     * @throws MyException
     */
    public void update(T newValue) {
        map.computeIfPresent(newValue.getId(), new BiFunction<Integer, T, T>() {
            @Override
            public T apply(Integer integer, T t) {
                if (t.getVersion() == newValue.getVersion()) {
                    newValue.incrementVersion();
                    return newValue;
                } else {
                    throw new MyException();
                }
            }
        });
    }


    /**
     * Delete item from map by id.
     *
     * @param id int.
     */
    public void delete(int id) {
        map.remove(id);
    }

}
