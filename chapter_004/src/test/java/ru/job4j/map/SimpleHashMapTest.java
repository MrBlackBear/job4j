package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * SimpleHashMapTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleHashMapTest {
    /**
     * Store
     */
    SimpleHashMap<Integer, String> shm;

    /**
     * Set up before tests
     */
    @Before
    public void setUp() {
        shm = new SimpleHashMap<>(10);
        shm.insert(1, "1");
        shm.insert(2, "2");
        shm.insert(3, "3");
        shm.insert(4, "4");
    }

    /**
     * Insert
     */
    @Test
    public void insert() {
        assertThat(shm.size(), is(4));
        shm.insert(5, "5");
        assertThat(shm.size(), is(5));
    }

    /**
     * Get
     */
    @Test
    public void get() {
        String result = shm.get(2);
        String expected = "2";
        assertThat(result, is(expected));
    }

    /**
     * Delete
     */
    @Test
    public void delete() {
        shm.delete(2);
        String result = shm.get(2);
        assertThat(result == null, is(true));
    }

    /**
     * Iterator
     */
    @Test
    public void iterator() {
        Iterator<Integer> it = shm.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }
}
