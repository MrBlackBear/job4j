package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/**
 * PointTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    /**
     * Test distanceTo when two point with coordinates x = 0, y = 0.
     */
    @Test
    public void twoPointsZeroZero() {
        Point ourPoint = new Point(0, 0);
        double result = ourPoint.distanceTo(new Point(0, 0));
        assertThat(result, closeTo(0, 0.1));
    }

    /**
     * Test distanceTo.
     */
    @Test
    public void firstPointZeroThreeSecondPointThreeFive() {
        Point ourPoint = new Point(0, 3);
        double result = ourPoint.distanceTo(new Point(3, 5));
        assertThat(result, closeTo(3.6, 0.1));
    }
}
