package ru.job4j.set;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

/**
 * SimpleSet
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleSet<T> implements Iterable<T> {
    /**
     * Store
     */
    private SimpleArray<T> simpleArray;
    /**
     * Size of store
     */
    private int size = 0;

    /**
     * Constructor
     *
     * @param size size of store
     */
    public SimpleSet(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    /**
     * Add element to store
     *
     * @param e add element
     */
    public void add(T e) {
        boolean flag = this.noDuplicate(e);
        if (flag) {
            simpleArray.add(e);
            size++;
        }
    }

    /**
     * Search duplicates
     *
     * @param e element
     * @return have store this element or not
     */
    private boolean noDuplicate(T e) {
        boolean result = true;
        for (T item : simpleArray) {
            if (item.equals(e)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Size of store
     *
     * @return size of store
     */
    public int size() {
        return this.size;
    }

    /**
     * Iterator method
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }

    /**
     * Size
     *
     * @return size
     */
    public int sizeSet() {
        return size;
    }
}
