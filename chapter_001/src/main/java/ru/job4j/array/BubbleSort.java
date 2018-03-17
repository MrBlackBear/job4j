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
        int number;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    number = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = number;
                }
            }
        }
        return array;
    }
}
