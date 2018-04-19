package ru.job4j.map;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * SimpleHashMap
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleHashMap<K, V> implements Iterable<K> {
    /**
     * Store
     */
    private Entry<K, V>[] store;
    /**
     * Size of store
     */
    private int size;
    /**
     * Real count of elements in store
     */
    private int realCountOfElements;

    /**
     * Constructor
     *
     * @param size size
     */
    public SimpleHashMap(int size) {
        this.size = size;
        store = new Entry[size];
    }

    /**
     * Grow if capacity more than 0,75 grow has map size twice
     */
    private void grow() {
        float capacity = realCountOfElements / size;
        if (capacity >= 0.75F) {
            size *= 2;
            Entry<K, V>[] oldStore = store;
            store = new Entry[size];
            for (Entry<K, V> entry : oldStore) {
                if (entry != null) {
                    store[hashFunc(entry.getKey())] = entry;
                }
            }
        }
    }

    /**
     * Insert element
     *
     * @param key   key
     * @param value value
     * @return true if can add element
     */
    public boolean insert(K key, V value) {
        grow();
        boolean result = false;
        int index = hashFunc(key);
        if (store[index] == null) {
            Entry<K, V> newEntry = new Entry<>(key, value);
            store[index] = newEntry;
            realCountOfElements++;
            result = true;
        }
        return result;
    }

    /**
     * Get value from element by key
     *
     * @param key key
     * @return value
     */
    public V get(K key) {
        int index = hashFunc(key);
        V result = null;
        if (store[index] != null) {
            result = store[index].value;
        }
        return result;
    }

    /**
     * Delete element from store
     *
     * @param key key
     * @return true if can delete
     */
    public boolean delete(K key) {
        int index = hashFunc(key);
        boolean result = false;
        if (store[index] != null) {
            store[index] = null;
            result = true;
        }
        return result;
    }

    /**
     * Size
     *
     * @return size
     */
    public int size() {
        return realCountOfElements;
    }

    /**
     * Hash function
     *
     * @param key key
     * @return index in store
     */
    private int hashFunc(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    /**
     * Iterator
     *
     * @return iterator
     */
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int index = 0;
            int count = 0;

            @Override
            public boolean hasNext() {
                return index != realCountOfElements;
            }

            @Override
            public K next() {
                K result = null;
                for (int i = count; i < size; i++) {
                    if (store[i] != null) {
                        count = i + 1;
                        result = store[i].getKey();
                        index++;
                        break;
                    }
                }
                return result;
            }
        };
    }

    /**
     * Private sub class to store pair key value
     *
     * @param <K> key
     * @param <V> value
     */
    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
