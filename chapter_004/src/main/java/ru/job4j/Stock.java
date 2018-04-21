package ru.job4j;

import java.util.Random;

public class Stock implements Comparable<Stock> {
    /**
     * Unique key of application
     */
    String id;

    @Override
    public String toString() {
        return "Stock{" + "price=" + price + '}';
    }

    /**
     * Identifier of application
     */
    String book;
    /**
     * If type true - than add
     * If type false - than delete
     */
    boolean type;
    /**
     * If type true - bid , ask to buy some stock
     * if type false - ask, ask to sale some stock
     */
    boolean action;
    /**
     * Price
     */
    int price;
    /**
     * Volume
     */
    int volume;

    /**
     * Random generated number
     */
    private static final Random RN = new Random();

    /**
     * Generate id
     *
     * @return id
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Constructor
     *
     * @param book   name of company
     * @param type   add or delete
     * @param action buy or sale
     * @param price  price
     * @param volume volume
     */
    public Stock(String book, boolean type, boolean action, int price, int volume) {
        id = generateId();
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public int compareTo(Stock o) {
        return o.price - this.price;
    }
}
