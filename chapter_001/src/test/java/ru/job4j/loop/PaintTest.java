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
    Paint paint = new Paint();
    /**
     * Test paint.
     */
    @Test
    public void whenPyramidHeightTwo() {
        String rst = paint.pyramid(2, (row, column) -> row >= 1 - column && row + 1 >= column);
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
        String rst = paint.pyramid(3, (row, column) -> row >= 2 - column && row + 2 >= column);
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
