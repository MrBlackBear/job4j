package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordsTest {

    @Test
    public void isAnnagram() {
        Words w = new Words();
        assertFalse(w.isAnnagram("top", "ort"));
        assertTrue(w.isAnnagram("top", "opt"));
        assertTrue(w.isAnnagram("topo", "opto"));
        assertFalse(w.isAnnagram("topou", "ophto"));
    }
}