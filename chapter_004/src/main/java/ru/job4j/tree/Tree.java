package ru.job4j.tree;

import java.util.*;

/**
 * @author Anatolii Shalobasov
 * @version $Id$
 * @since 0.1
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Root
     */
    Node<E> root;

    /**
     * Constructor
     *
     * @param value value of root
     */
    public Tree(E value) {
        this.root = new Node(value);
    }

    /**
     * Add child to element only if it has no this child before
     *
     * @param parent parent.
     * @param child  child.
     * @return true if has no this child before and in tree has this parent
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> par = findBy(parent);
        if (par != null) {
            rsl = true;
            par.get().add(new Node<>(child));
        }
        return rsl;
    }

    /**
     * Find Node in tree
     *
     * @param value value
     * @return Node
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Check binary tree or not
     *
     * @return true if tree is binary
     */
    public boolean isBinary() {
        boolean rsl = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                rsl = false;
                break;
            }
            for (Node<E> ch : el.leaves()) {
                data.offer(ch);
            }
        }
        return rsl;
    }

    /**
     * Iterator where we can go by all elements in tree
     *
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> it = new LinkedList<>();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        it.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            for (Node<E> child : el.leaves()) {
                it.offer(child);
                data.offer(child);
            }
        }
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !it.isEmpty();
            }

            @Override
            public E next() {
                return it.poll().getValue();
            }
        };
    }
}
