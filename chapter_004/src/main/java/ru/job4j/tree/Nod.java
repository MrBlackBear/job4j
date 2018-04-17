package ru.job4j.tree;

/**
 * @author Anatolii Shalobasov
 * @version $Id$
 * @since 0.1
 */
public class Nod<E extends Comparable<E>> {
    /**
     * Value of node
     */
    E value;
    /**
     * Left node
     */
    Nod<E> left;
    /**
     * Right node
     */
    Nod<E> right;

    /**
     * Constructor
     *
     * @param value value
     */
    Nod(E value) {
        this.value = value;
        right = null;
        left = null;
    }
}
