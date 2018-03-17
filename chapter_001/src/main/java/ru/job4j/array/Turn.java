package ru.job4j.array;

/**
 * Turn.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Method back.
     *
     * @param array array which we need to reverse.
     * @return reverse array.
     */
    public int[] back(int[] array) {
        int result;
        for (int i = array.length - 1, j = 0; j < array.length / 2; i--, j++) {
            result = array[j];
            array[j] = array[i];
            array[i] = result;
        }
        return array;
    }
}
