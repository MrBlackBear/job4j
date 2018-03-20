package ru.job4j.figure;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TriangleTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    /**
     * Test draw.
     */
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(" +++ ")
                                .append("+++++")
                                .toString()
                )
        );
    }
}
