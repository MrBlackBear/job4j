package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ConverterTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConverterTest {
    /**
     * Test rubleToDollar.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    /**
     * Test rubleToDollar.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(70);
        assertThat(result, is(1));
    }

    /**
     * Test dollarToRuble.
     */
    @Test
    public void when6DollarToRubleThen360() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(6);
        assertThat(result, is(360));
    }

    /**
     * Test euroToRuble.
     */
    @Test
    public void when7EuroToRubleThen490() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(7);
        assertThat(result, is(490));
    }
}
