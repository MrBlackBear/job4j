package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>();
        bst.insert(44);
        bst.insert(11);
        bst.insert(56);
        bst.insert(9);
        bst.insert(12);
    }

    /**
     * Insert
     */
    @Test
    public void insert() {
        boolean result = bst.isEmpty();
        assertThat(result, is(false));
    }

    /**
     * Iterator
     */
    @Test
    public void iterator() {
        Iterator<Integer> it = bst.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(12));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(44));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(56));
        assertThat(it.hasNext(), is(false));
    }
}
