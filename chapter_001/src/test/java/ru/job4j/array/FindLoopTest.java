package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FindLoopTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoopTest {
    FindLoop findLoop = new FindLoop();
    /**
     * Test indexOf.
     */
    @Test
    public void whenElementFourThenIndexThree() {
        int result = findLoop.indexOf(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 4);
        assertThat(result, is(3));
    }

    /**
     * Test indexOf.
     */
    @Test
    public void whenNoNumberThenMinusOne() {
        int result = findLoop.indexOf(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 114);
        assertThat(result, is(-1));
    }
}
