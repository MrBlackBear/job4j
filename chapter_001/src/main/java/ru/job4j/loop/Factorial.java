package ru.job4j.loop;

/**
 * Factorial.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Method calc.
     *
     * @param number number from what we want factorial.
     * @return factorial of this number
     */
    public int calc(int number) {
        int result = 1;
        for (int count = 1; count <= number; count++) {
            result *= count;
        }
        return result;
    }
}
