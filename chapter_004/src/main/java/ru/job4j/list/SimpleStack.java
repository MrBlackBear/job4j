package ru.job4j.list;

/**
 * SimpleStack
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleStack<T> {
    /**
     * Store
     */
    private SimpleLinkedListForStack<T> stack = new SimpleLinkedListForStack<>();

    /**
     * Delete last element in stack and return it
     *
     * @param <T> generic type
     * @return last element in stack
     */
    public <T> T poll() {
        return (T) stack.deleteFirst();
    }

    /**
     * Add element to stack
     *
     * @param value ekement to add
     */
    public void push(T value) {
        stack.insertFirst(value);
    }
}

/**
 * Class were add to first and delete from first
 *
 * @param <T> generic type
 */
class SimpleLinkedListForStack<T> {
    /**
     * First element list
     */
    private Node<T> first;

    /**
     * Add to start
     *
     * @param element element to add
     */
    public void insertFirst(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = first;
        first = newNode;
    }

    /**
     * Delete first element
     *
     * @return deleted element
     */
    public T deleteFirst() {
        Node<T> temp = first;
        first = first.next;
        return temp.element;
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
