package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayCharTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayCharTest {
    ArrayChar word = new ArrayChar("Hello");
    /**
     * Test startWith.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    /**
     * Test startWith.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }
}
