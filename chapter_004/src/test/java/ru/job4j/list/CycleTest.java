package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * CycleTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CycleTest {
    /**
     * Test hasCycle
     */
    @Test
    public void hasCycle() {
        Cycle cycle = new Cycle();
        Node<Integer> first = new Node(1);
        Node<Integer> two = new Node(2);
        Node<Integer> third = new Node(3);
        Node<Integer> four = new Node(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(cycle.hasCycle(first), is(true));
    }
}
