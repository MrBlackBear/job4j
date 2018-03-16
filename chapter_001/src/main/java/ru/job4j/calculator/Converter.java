package ru.job4j.calculator;

/**
 * Конвертор валюты
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Converter {
    /**
     * Цена 1 евро в рублях
     */
    final private int COSTEURO = 70;
    /**
     * Цена одного доллара в рублях
     */
    final private int COSTDOLLAR = 60;

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / COSTEURO;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / COSTDOLLAR;
    }

    /**
     * Конвертируем евро в рубли.
     *
     * @param value евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return value * COSTEURO;
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value доллары.
     * @return рубли.
     */
    public int dollarToRuble(int value) {
        return value * COSTDOLLAR;
    }
}
