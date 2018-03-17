package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * WordTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class WordTest {
    /**
     * Test contains.
     */
    @Test
    public void whenWordIsPrefixThreeTrue() {
        Word word = new Word();
        boolean result = word.contains("lo", "lo");
        assertThat(result, is(true));
    }

    /**
     * Test contains.
     */
    @Test
    public void whenHasPrefixinTheMiddleThenTrue() {
        Word word = new Word();
        boolean result = word.contains("asasasloasasas", "lo");
        assertThat(result, is(true));
    }

    /**
     * Test contains.
     */
    @Test
    public void whenNoPrefixinTheWordThenFalse() {
        Word word = new Word();
        boolean result = word.contains("asasaslasasas", "lo");
        assertThat(result, is(false));
    }

    /**
     * Test contains.
     */
    @Test
    public void whenWordSmallerThanPrfixThenFalse() {
        Word word = new Word();
        boolean result = word.contains("a", "lo");
        assertThat(result, is(false));
    }
}
