package ru.job4j.monitor;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SynchronizedSimpleArrayList<E> implements Iterable<E> {
    /**
     * Array which use to store elements
     */
    @GuardedBy("this")
    private Object[] container;
    /**
     * Size of store
     */
    @GuardedBy("this")
    private int size;
    /**
     * Real number of elements
     */
    @GuardedBy("this")
    private int realNumberOfElements;
    /**
     * Count of operation which was done with store
     */
    @GuardedBy("this")
    private volatile int modCount;

    /**
     * Constructor
     *
     * @param size size of store
     */
    public SynchronizedSimpleArrayList(int size) {
        this.size = size;
        container = new Object[size];
    }

    /**
     * Method which add element, change modCount and if realNumberOfelements more than size
     * grow store in two times
     *
     * @param value add element in store
     */
    public synchronized void add(E value) {
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
    @SuppressWarnings("unchecked")
    public synchronized E get(int index) {
        return (E) container[index];
    }

    /**
     * Iterator
     *
     * @return iterator
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {
            int realNum = realNumberOfElements;
            Object[] clone = container.clone();
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
                    if (modCount != expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
            }

            /**
             * If has elements return true
             * @return if has elements return true
             */
            @Override
            public synchronized boolean hasNext() {
                checkForComodification();
                return realNum > position;
            }

            /**
             * Return next element by iterator
             * @return return next element by iterator
             */
            @SuppressWarnings("unchecked")
            @Override
            public synchronized E next() {
                checkForComodification();
                return (E) clone[position++];
            }
        };
    }
}
