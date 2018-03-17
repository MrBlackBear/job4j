package ru.job4j.array;

/**
 * Matrix.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    /**
     * Method multiple.
     *
     * @param size size of matrix.
     * @return matrix from size which user put
     */
    int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                result[i-1][j-1] = i*j;
            }

        }
        return result;
    }
}
