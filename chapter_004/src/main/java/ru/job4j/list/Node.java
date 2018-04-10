package ru.job4j.list;

/**
 * Node
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
class Node<T> {
    /**
     * Value
     */
    T value;
    /**
     * Link of next element
     */
    Node<T> next;

    /**
     * Constructor
     *
     * @param value element value
     */
    public Node(T value) {
        this.value = value;
    }

}