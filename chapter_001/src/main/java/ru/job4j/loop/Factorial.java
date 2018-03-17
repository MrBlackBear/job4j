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
     * @param n number from what we want factorial.
     * @return factorial of this number
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
