package ru.job4j.list;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * SimpleLinkedListTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleLinkedListTest {
    /**
     * LinkedList
     */
    SimpleLinkedList<Integer> simpleLinkedList;

    /**
     * Set up before start to test methods
     */
    @Before
    public void setUp() {
        simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(11);
        simpleLinkedList.add(22);
        simpleLinkedList.add(33);
    }

    /**
     * Add
     */
    @Test
    public void add() {
        simpleLinkedList.add(44);
        Integer result = simpleLinkedList.get(3);
        assertThat(result, is(44));
    }

    /**
     * Get
     */
    @Test
    public void get() {
        Integer result = simpleLinkedList.get(2);
        assertThat(result, is(33));
    }

    /**
     * Iterator
     */
    @Test
    public void iterator() {
        Iterator<Integer> it = simpleLinkedList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(22));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(33));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Check iterator exception
     */
    @Test(expected = ConcurrentModificationException.class)
    public void ifChangeStoreAndUseIteratorThrowConcurrentModificationException() {
        Iterator<Integer> it = simpleLinkedList.iterator();
        assertThat(it.next(), Matchers.is(11));
        assertThat(it.next(), Matchers.is(22));
        assertThat(it.next(), Matchers.is(33));
        simpleLinkedList.add(22);
        it.next();
    }
}
