package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * SimpleLinkedList
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleLinkedList<E> implements Iterable<E> {
    /**
     * Real number of elements
     */
    private int realNumberOfElements;
    /**
     * Count of operation which was done with store
     */
    private int modCount;
    /**
     * First element in list
     */
    private Node<E> first;
    /**
     * Last element in list
     */
    private Node<E> last;

    /**
     * Add element to linkedList
     *
     * @param value element to add
     */
    void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        realNumberOfElements++;
        modCount++;
    }

    /**
     * Get element by index
     *
     * @param index of element
     * @return element by index
     */
    E get(int index) {
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
    public Iterator<E> iterator() {
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
            private void checkForComodification() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
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

        public Node(E element) {
            this.element = element;
        }
    }
}
