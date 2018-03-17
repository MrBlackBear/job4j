package ru.job4j.loop;

/**
 * Counter.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Method add.
     *
     * @param start  number from what counting begins.
     * @param finish number from what counting ends.
     * @return sum of odd number from start to finish
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
