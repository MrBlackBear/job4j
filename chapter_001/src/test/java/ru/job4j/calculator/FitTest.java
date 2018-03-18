package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FitTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FitTest {
    Fit fit = new Fit();
    /**
     * Test manWeight.
     */
    @Test
    public void manWeight() {
        double weight = fit.manWeight(180);
        assertThat(weight, is(92.0));
    }

    /**
     * Test womanWeight.
     */
    @Test
    public void womanWeight() {
        double weight = fit.womanWeight(170);
        assertThat(weight, is(69.0));
    }
}
