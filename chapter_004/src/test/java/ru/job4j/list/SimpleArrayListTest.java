package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * SimpleArrayListTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayListTest {
    /**
     * Store
     */
    SimpleArrayList<Integer> simpleArrayList;

    /**
     * Before all our methods
     */
    @Before
    public void setUp() {
        simpleArrayList = new SimpleArrayList<>(5);
        simpleArrayList.add(11);
        simpleArrayList.add(22);
        simpleArrayList.add(33);
        simpleArrayList.add(44);
        simpleArrayList.add(55);
    }

    /**
     * Method add
     */
    @Test
    public void add() {
        simpleArrayList.add(66);
        simpleArrayList.add(77);
        simpleArrayList.add(88);
        simpleArrayList.add(99);
        simpleArrayList.add(100);
        simpleArrayList.add(200);
        simpleArrayList.add(300);
        simpleArrayList.add(400);
        assertThat(simpleArrayList.get(10), is(200));
    }

    /**
     * Method get
     */
    @Test
    public void get() {
        assertThat(simpleArrayList.get(2), is(33));
    }

    /**
     * Method iterator
     */
    @Test
    public void iterator() {
        Iterator<Integer> it = simpleArrayList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(22));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(33));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(44));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(55));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Check iterator exception
     */
    @Test(expected = ConcurrentModificationException.class)
    public void ifChangeStoreAndUseIteratorThrowConcurrentModificationException() {
        Iterator<Integer> it = simpleArrayList.iterator();
        assertThat(it.next(), is(11));
        assertThat(it.next(), is(22));
        assertThat(it.next(), is(33));
        simpleArrayList.add(22);
        it.next();
    }
}