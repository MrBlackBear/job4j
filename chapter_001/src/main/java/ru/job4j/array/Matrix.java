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
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                result[row - 1][col - 1] = row * col;
            }

        }
        return result;
    }
}
