package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Fit {
    /**
     * Const need to count ideal weight to man
     */
    private static final double FOR_MAN = 100;
    /**
     * Const need to count ideal weight to woman
     */
    private static final double FOR_WOMAN = 110;
    /**
     * Const need to count ideal weight to woman and men
     */
    private static final double CONSTANT = 1.15;

    /**
     * Идеальный вес для мужщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - FOR_MAN) * CONSTANT;
    }

    /**
     * Идеальный вес для женщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - FOR_WOMAN) * CONSTANT;
    }
}