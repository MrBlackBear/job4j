package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;

import java.util.Iterator;

/**
 * SimpleSetList
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleSetList<E> implements Iterable<E> {
    /**
     * Store
     */
    private SimpleLinkedList<E> list = new SimpleLinkedList<>();

    /**
     * Size of store
     */
    int size = 0;

    /**
     * Add element to store
     *
     * @param e add if is not in store
     */
    public void add(E e) {
        if (!this.contains(e)) {
            list.add(e);
            size++;
        }
    }

    /**
     * Size of store
     *
     * @return size of store
     */
    public int size() {
        return this.size;
    }

    public boolean contains(E e) {
        boolean result = false;
        for (E el : list) {
            if (el.equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Iterator method
     *
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
