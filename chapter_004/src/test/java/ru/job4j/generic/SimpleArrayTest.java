package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * SimpleArrayTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayTest {
    /**
     * Array which we test
     */
    private SimpleArray<Integer> simpleArray;

    /**
     * Initialize array before we start to use it
     */
    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(10);
        simpleArray.add(11);
        simpleArray.add(22);
        simpleArray.add(33);
        simpleArray.add(44);
        simpleArray.add(55);
    }

    /**
     * Test method add
     */
    @Test
    public void add() {
        assertThat(simpleArray.get(2), is(33));
    }

    /**
     * Test method set
     */
    @Test
    public void set() {
        simpleArray.set(2, 777);
        assertThat(simpleArray.get(2), is(777));
    }

    /**
     * Test method delete
     */
    @Test
    public void delete() {
        simpleArray.delete(2);
        assertThat(simpleArray.get(2), is(44));
    }

    /**
     * Test method get
     */
    @Test
    public void get() {
        assertThat(simpleArray.get(0), is(11));
        assertThat(simpleArray.get(1), is(22));
        assertThat(simpleArray.get(2), is(33));
        assertThat(simpleArray.get(3), is(44));
        assertThat(simpleArray.get(4), is(55));
    }

    /**
     * Test method iterator
     */
    @Test
    public void iterator() {
        Iterator<Integer> it = simpleArray.iterator();
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
}
