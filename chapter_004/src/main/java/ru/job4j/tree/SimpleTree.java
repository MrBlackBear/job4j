package ru.job4j.tree;

import java.util.Optional;

/**
 * @author Anatolii Shalobasov
 * @version $Id$
 * @since 0.1
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return true if we can add element
     */
    boolean add(E parent, E child);

    /**
     * Найти лист по значению
     *
     * @param value value
     * @return лист
     */
    Optional<Node<E>> findBy(E value);
}
