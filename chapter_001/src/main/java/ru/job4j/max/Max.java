package ru.job4j.max;

/**
 * Max.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Method max.
     *
     * @param first  first number.
     * @param second second number
     * @return the largest number
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Method max.
     *
     * @param first  first number.
     * @param second second number
     * @param third  third number
     * @return the largest number
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
