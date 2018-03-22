package ru.job4j.array;

/**
 * MergeSort.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MergeSort {
    /**
     * MergeSort.
     *
     * @param first  first sort array
     * @param second second sort array
     * @return return sort first + second array
     */
    public int[] mergeSort(int[] first, int[] second) {
        int lengthAll = first.length + second.length;
        int firstCount = 0;
        int secondCount = 0;
        int[] result = new int[lengthAll];
        while (firstCount + secondCount < lengthAll) {
            if (firstCount >= first.length) {
                result[secondCount + firstCount] = second[secondCount];
                secondCount++;
                continue;
            }
            if (secondCount >= second.length) {
                result[firstCount + secondCount] = first[firstCount];
                firstCount++;
                continue;
            }
            if (first[firstCount] < second[secondCount]) {
                result[firstCount + secondCount] = first[firstCount];
                firstCount++;
            } else {
                result[secondCount + firstCount] = second[secondCount];
                secondCount++;
            }
        }
        return result;
    }
}
