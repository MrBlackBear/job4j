package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * SimpleQueueTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueueTest {
    /**
     * Queue
     */
    SimpleQueue<Integer> queue;

    /**
     * Initialize before test methods
     */
    @Before
    public void setUp() {
        queue = new SimpleQueue<>();
        queue.push(11);
        queue.push(22);
        queue.push(33);
    }

    /**
     * Poll
     */
    @Test
    public void poll() {
        assertThat(queue.poll(), is(11));
        assertThat(queue.poll(), is(22));
        assertThat(queue.poll(), is(33));
    }

    /**
     * Push
     */
    @Test
    public void push() {
        queue.push(44);
        queue.push(55);
        queue.push(66);
        assertThat(queue.poll(), is(11));
    }
}
