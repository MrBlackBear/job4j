package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * PaintTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    /**
     * Test paint.
     */
    @Test
    public void whenPyramidHeightTwo() {
        Paint paint = new Paint();
        String rst = paint.pyramid(2);
        System.out.println(rst);
        assertThat(rst,
                is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add(" ^ ")
                        .add("^^^")
                        .toString())
        );
    }

    /**
     * Test paint.
     */
    @Test
    public void whenPyramidHeightThree() {
        Paint paint = new Paint();
        String rst = paint.pyramid(3);
        System.out.println(rst);
        assertThat(rst,
                is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("  ^  ")
                        .add(" ^^^ ")
                        .add("^^^^^")
                        .toString())
        );
    }
}
