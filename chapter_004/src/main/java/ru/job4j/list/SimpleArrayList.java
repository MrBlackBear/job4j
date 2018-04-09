package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * SimpleArrayList
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayList<E> implements Iterable<E> {
    /**
     * Array which use to store elements
     */
    private Object[] container;
    /**
     * Size of store
     */
    private int size;
    /**
     * Real number of elements
     */
    private int realNumberOfElements;
    /**
     * Count of operation which was done with store
     */
    private int modCount;

    /**
     * Constructor
     *
     * @param size size of store
     */
    public SimpleArrayList(int size) {
        this.size = size;
        container = new Object[size];
    }

    /**
     * Method which add element, change modCount and if realNumberOfelements more than size
     * grow store in two times
     *
     * @param value add element in store
     */
    void add(E value) {
        if (realNumberOfElements == size) {
            int newSize = size * 2;
            Object[] newContainer = new Object[newSize];
            System.arraycopy(container, 0, newContainer, 0, realNumberOfElements);
            container = newContainer;
            size = newSize;
        }
        modCount++;
        container[realNumberOfElements++] = value;
    }

    /**
     * Return element from store by index
     *
     * @param index index by which return element from store
     * @return element from store by index
     */
    E get(int index) {
        return (E) container[index];
    }

    /**
     * Iterator
     *
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Count of changes in array when iterator was created
             */
            private int expectedModCount = modCount;
            /**
             * Position in iterator
             */
            private int position;

            /**
             * Check modCount which was created when was created iterator with real modCount
             */
            private void checkForComodification() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
            }

            /**
             * If has elements return true
             * @return if has elements return true
             */
            @Override
            public boolean hasNext() {
                checkForComodification();
                return realNumberOfElements > position;
            }

            /**
             * Return next element by iterator
             * @return return next element by iterator
             */
            @Override
            public E next() {
                checkForComodification();
                return (E) container[position++];
            }
        };
    }
}
