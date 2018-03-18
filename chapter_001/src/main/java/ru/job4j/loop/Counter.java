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
        for (int currentNumber = start; currentNumber <= finish; currentNumber++) {
            if (currentNumber % 2 == 0) {
                result += currentNumber;
            }
        }
        return result;
    }
}
