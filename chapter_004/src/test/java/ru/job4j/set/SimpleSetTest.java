package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * SimpleSetTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleSetTest {
    /**
     * Store
     */
    SimpleSet<Integer> set;

    /**
     * Set initialize before start to test methods
     */
    @Before
    public void setUp() {
        set = new SimpleSet<>(10);
        set.add(11);
        set.add(22);
        set.add(33);
    }

    /**
     * Test add
     */
    @Test
    public void add() {
        assertThat(set.sizeSet(), is(3));
        set.add(44);
        assertThat(set.sizeSet(), is(4));
        set.add(11);
        set.add(11);
        set.add(11);
        set.add(11);
        set.add(11);
        set.add(22);
        set.add(33);
        assertThat(set.sizeSet(), is(4));
    }

    /**
     * Test iterator
     */
    @Test
    public void iterator() {
        Iterator<Integer> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(22));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(33));
        assertThat(it.hasNext(), is(false));
    }
}
