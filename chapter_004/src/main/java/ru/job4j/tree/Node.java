package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatolii Shalobasov
 * @version $Id$
 * @since 0.1
 */
public class Node<E extends Comparable<E>> {
    /**
     * Children
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Value of node
     */
    private final E value;

    /**
     * Constructor
     *
     * @param value value
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Add child to Node
     *
     * @param child child
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Return children
     *
     * @return children
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Compare elements
     *
     * @param that that element
     * @return true if lements equal
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    /**
     * Return value of Node
     *
     * @return value
     */
    public E getValue() {
        return value;
    }
}
