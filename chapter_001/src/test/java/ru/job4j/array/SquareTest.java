package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * SquareTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {
    Square square = new Square();
    /**
     * Test calculate.
     */
    @Test
    public void whenBoundIsZeroThenEmptyArray() {
        int[] result = square.calculate(0);
        Assert.assertArrayEquals(result, new int[0]);
    }

    /**
     * Test calculate.
     */
    @Test
    public void whenBoundIsFiveThenNeedArray() {
        int[] result = square.calculate(5);
        Assert.assertArrayEquals(result, new int[]{1, 4, 9, 16, 25});
    }
}
