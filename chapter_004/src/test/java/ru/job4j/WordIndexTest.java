package ru.job4j;

import org.apache.commons.collections4.Trie;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class WordIndexTest {
    private static final String TEST_STRING = "! fd [addfgd] s-b,   fdgfd. \n  zzzD ojgdfgsd. fd";
    Trie<String, Set<Integer>> trie;

    @Before
    public void setup() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(TEST_STRING));
        WordIndex wordIndex = new WordIndex(TEST_STRING, "fd");
        wordIndex.loadFileStringTest(TEST_STRING);
        trie = wordIndex.getTrie();
    }

    @Test
    public void testCreate() {
        assertNotNull(trie);
    }

    @Test
    public void testGetIndexForWord() {
        assertEquals(new HashSet<>(asList(2, 44)), trie.get("fd"));
    }

}