package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * SimpleStackTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleStackTest {
    /**
     * Stack
     */
    SimpleStack<Integer> stack;

    /**
     * Initialize before test methods
     */
    @Before
    public void setUp() {
        stack = new SimpleStack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
    }

    /**
     * Poll
     */
    @Test
    public void poll() {
        assertThat(stack.poll(), is(33));
        assertThat(stack.poll(), is(22));
        assertThat(stack.poll(), is(11));
    }

    /**
     * Push
     */
    @Test
    public void push() {
        stack.push(44);
        stack.push(55);
        stack.push(66);
        assertThat(stack.poll(), is(66));
    }
}
