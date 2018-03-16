package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    /**
     * Contains the result of actions with two numbers
     */
    private double result;

    /**
     * Method add.
     * Update field result with sum of first and second number
     *
     * @param first  first number
     * @param second second number
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method substract.
     * Update field result with subtraction first number from second
     *
     * @param first  first number
     * @param second second number
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div.
     * Update field result with first number divided by second number
     *
     * @param first  first number
     * @param second second number
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiply.
     * Update field result with multiply first number on second number
     *
     * @param first  first number
     * @param second second number
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult
     *
     * @return value of field result
     */
    public double getResult() {
        return this.result;
    }
}
