package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashSetTest {
    /**
     * Store
     */
    SimpleHashSet<Integer> simpleHashSet;

    /**
     * Before tests
     */
    @Before
    public void setUp() {
        simpleHashSet = new SimpleHashSet<>(10);
        simpleHashSet.add(1);
        simpleHashSet.add(2);
        simpleHashSet.add(3);
        simpleHashSet.add(4);
    }

    /**
     * Add
     */
    @Test
    public void add() {
        assertThat(simpleHashSet.size(), is(4));
        simpleHashSet.add(5);
        assertThat(simpleHashSet.size(), is(5));
    }

    /**
     * Contains
     */
    @Test
    public void contains() {
        boolean result = simpleHashSet.contains(2);
        assertThat(result, is(true));
    }

    /**
     * Remove
     */
    @Test
    public void remove() {
        simpleHashSet.remove(2);
        boolean result = simpleHashSet.contains(2);
        assertThat(result, is(false));
    }
}