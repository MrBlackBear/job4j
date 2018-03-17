package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Paint.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Method pyramid.
     *
     * @param height height of pyramid.
     * @return figure pyramid in pseudo-graphic.
     */
    public String pyramid(int height, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
