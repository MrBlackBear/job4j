package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {
    Factorial fact = new Factorial();
    /**
     * Test calc.
     */
    @Test
    public void whenIsZeroThenFactorialOne() {
        int result = fact.calc(0);
        assertThat(result, is(1));
    }

    /**
     * Test calc.
     */
    @Test
    public void whenIsFiveThenFactorialOfFiveIs120() {
        int result = fact.calc(5);
        assertThat(result, is(120));
    }
}
