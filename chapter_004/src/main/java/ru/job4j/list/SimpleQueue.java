package ru.job4j.list;

/**
 * SimpleQueue
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueue<T> {
    /**
     * Store
     */
    private SimpleListForQueue<T> queue = new SimpleListForQueue<>();

    /**
     * Delete first element in queue and return data
     *
     * @param <T> generic type
     * @return last element in stack
     */
    public <T> T poll() {
        return (T) queue.deleteFirst();
    }

    /**
     * Add element to queue
     *
     * @param value element to add
     */
    public void push(T value) {
        queue.insertLast(value);
    }
}

/**
 * SimpleListForQueue
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
class SimpleListForQueue<T> {
    /**
     * First element list
     */
    private Node<T> first;
    /**
     * Last element in list
     */
    private Node<T> last;

    /**
     * Add in the end
     *
     * @param element element to add
     */
    public void insertLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    /**
     * Delete first element
     *
     * @return deleted element
     */
    public T deleteFirst() {
        T element = first.element;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return element;
    }

    /**
     * Class which id node for list
     *
     * @param <T>
     */
    private class Node<T> {
        /**
         * Link to next element in list
         */
        Node<T> next;
        /**
         * Data of node
         */
        T element;

        /**
         * Constructor
         *
         * @param element which is in node
         */
        public Node(T element) {
            this.element = element;
        }
    }
}
