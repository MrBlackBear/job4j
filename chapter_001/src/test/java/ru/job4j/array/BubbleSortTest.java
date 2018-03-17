package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * BubbleSortTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSortTest {
    /**
     * Test calculate.
     */
    @Test
    public void whenOddArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(new int[]{5,4,3,2,1});
        Assert.assertArrayEquals(result, new int[]{1,2,3,4,5});
    }

    /**
     * Test calculate.
     */
    @Test
    public void whenEvenArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(new int[]{5,4,3,2});
        Assert.assertArrayEquals(result, new int[]{2,3,4,5});
    }
}
