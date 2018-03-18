package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    Max maxim = new Max();
    /**
     * Test max.
     */
    @Test
    public void whenFirstLessSecond() {
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Test max.
     */
    @Test
    public void whenFirstMoreThanSecond() {
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }

    /**
     * Test max.
     */
    @Test
    public void whenFirstMoreThanOther() {
        int result = maxim.max(3, 2, 1);
        assertThat(result, is(3));
    }

    /**
     * Test max.
     */
    @Test
    public void whenSecondMoreThanOther() {
        int result = maxim.max(2, 3, 1);
        assertThat(result, is(3));
    }

    /**
     * Test max.
     */
    @Test
    public void whenThirdMoreThanOther() {
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }
}
