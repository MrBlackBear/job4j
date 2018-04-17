package ru.job4j.tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Anatolii Shalobasov
 * @version $Id$
 * @since 0.1
 */
public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
    /**
     * Root of tree
     */
    Nod<E> root;

    /**
     * Check empty or not tree
     *
     * @return empty tree or not
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert element in tree
     *
     * @param value value
     */
    public void insert(E value) {
        if (isEmpty())
            root = new Nod(value);
        else
            insert(root, value);
    }

    /**
     * Insert element
     *
     * @param node  node
     * @param value value
     */
    private void insert(Nod node, E value) {
        if (value.compareTo((E) node.value) <= 0) {
            if (node.left == null) {
                node.left = new Nod(value);
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Nod(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    /**
     * Iterator
     *
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public Stack<Nod<E>> stack = new Stack<>();
            public Nod<E> current = root;

            @Override
            public boolean hasNext() {
                return current != null || !stack.isEmpty();
            }

            @Override
            public E next() {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                Nod<E> rst = stack.pop();
                current = rst.right;
                return rst.value;
            }
        };
    }
}
