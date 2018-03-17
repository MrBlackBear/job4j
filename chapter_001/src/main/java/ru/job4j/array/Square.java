package ru.job4j.array;

/**
 * Square.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * Method calculate.
     *
     * @param bound number to which we need to push in array square of numbers.
     * @return array square of numbers.
     */
    public int[] calculate(int bound) {
        if (bound == 0) {
            return new int[0];
        }
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}
