package ru.job4j.array;

/**
 * BubbleSort.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Method sort.
     *
     * @param array array which we need to sort
     * @return sorted array
     */
    public int[] sort(int[] array) {
        int container;
        for (int out = 0; out < array.length - 1; out++) {
            for (int in = 0; in < array.length - 1; in++) {
                if (array[in] > array[in + 1]) {
                    container = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = container;
                }
            }
        }
        return array;
    }
}
