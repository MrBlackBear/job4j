package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {
    MergeSort mergeSort = new MergeSort();

    /**
     * Test mergeSort.
     */
    @Test
    public void whenTwoArraysThenReturnSortTherdArray() {
        int[] first = {1, 2, 3, 4};
        int[] second = {4, 5, 5, 6};
        int[] result = mergeSort.mergeSort(first, second);
        Assert.assertArrayEquals(result, new int[]{1, 2, 3, 4, 4, 5, 5, 6});
    }

    /**
     * Test mergeSort.
     */
    @Test
    public void whenFirstArrayNoThenSecondArray() {
        int[] second = {4, 5, 5, 6};
        int[] result = mergeSort.mergeSort(new int[0], second);
        Assert.assertArrayEquals(result, new int[]{4, 5, 5, 6});
    }

    /**
     * Test mergeSort.
     */
    @Test
    public void whenSecondArrayNoThenFirstArray() {
        int[] first = {1, 2, 3, 4};
        int[] result = mergeSort.mergeSort(first, new int[0]);
        Assert.assertArrayEquals(result, new int[]{1, 2, 3, 4});
    }
}
