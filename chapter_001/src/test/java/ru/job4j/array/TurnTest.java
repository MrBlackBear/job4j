package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * TurnTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TurnTest {
    Turn turn = new Turn();
    /**
     * Test back.
     */
    @Test
    public void whenEvenElementInArray() {
        int[] result = turn.back(new int[]{1, 2, 3, 4, 5});
        Assert.assertArrayEquals(result, new int[]{5, 4, 3, 2, 1});
    }

    /**
     * Test back.
     */
    @Test
    public void whenOddElementInArray() {
        int[] result = turn.back(new int[]{1, 2, 3, 4, 5, 6});
        Assert.assertArrayEquals(result, new int[]{6, 5, 4, 3, 2, 1});
    }
}
