package ru.job4j.monitor;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SynchronizedSimpleLinkedList<E> implements Iterable<E> {
    /**
     * Count of operation which was done with store
     */
    @GuardedBy("this")
    private volatile int modCount;
    /**
     * First element in list
     */
    @GuardedBy("this")
    private Node<E> first;
    /**
     * Last element in list
     */
    @GuardedBy("this")
    private Node<E> last;

    /**
     * Add element to linkedList
     *
     * @param value element to add
     */
    public synchronized void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        modCount++;
    }

    /**
     * Get element by index
     *
     * @param index of element
     * @return element by index
     */
    synchronized E get(int index) {
        int position = 0;
        Node<E> result = first;
        while (position != index) {
            result = result.next;
            position++;
        }
        return result.element;
    }

    /**
     * Iterator
     *
     * @return iterator of linkedList
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Count of changes in array when iterator was created
             */
            private int expectedModCount = modCount;
            /**
             * Linked list
             */
            Node<E> it = first;

            /**
             * Check modCount which was created when was created iterator with real modCount
             */
            private synchronized void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }

            /**
             * HasNext
             * @return if it is not null
             */
            @Override
            public boolean hasNext() {
                checkForComodification();
                return it != null;
            }

            /**
             * Next
             * @return next element in iterator
             */
            @Override
            public E next() {
                checkForComodification();
                E link = it.element;
                it = it.next;
                return link;
            }
        };
    }

    /**
     * Class Node
     *
     * @param <E> generic
     */
    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }
}
