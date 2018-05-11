package ru.job4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

public class WordIndex {
    private String fileName;
    private String word;
    private Trie<String, Set<Integer>> trie = new PatriciaTrie<>();

    public WordIndex(String fileName, String word) {
        this.fileName = fileName;
        this.word = word;
    }

    public void loadFileStringTest(String stringName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new StringReader(fileName))) {
            String currentLine;
            Integer pos = 0;
            String[] words;
            while ((currentLine = reader.readLine()) != null) {
                words = currentLine.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (i == words.length - 1) {
                        if (words[i].equals(word)) {
                            putWordToTrie(word, pos);
                        }
                        pos += words[i].length();
                    } else {
                        if (words[i].equals(word)) {
                            putWordToTrie(word, pos);
                        }
                        pos += words[i].length() + 1;
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public void loadFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            Integer pos = 0;
            String[] words;
            while ((currentLine = reader.readLine()) != null) {
                words = currentLine.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (i == words.length - 1) {
                        if (words[i].equals(word)) {
                            putWordToTrie(word, pos);
                        }
                        pos += words[i].length();
                    } else {
                        if (words[i].equals(word)) {
                            putWordToTrie(word, pos);
                        }
                        pos += words[i].length() + 1;
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public Set<Integer> getIndexes4Word(String searchWord) {
        return trie.get(searchWord);
    }

    private void putWordToTrie(String key, Integer pos) {
        Set<Integer> index = trie.get(key);
        if (index == null) {
            index = new HashSet<>();
            index.add(pos);
            trie.put(key, index);
        } else {
            index.add(pos);
            trie.put(key, index);
        }
    }

    public Trie<String, Set<Integer>> getTrie() {
        return trie;
    }
}
