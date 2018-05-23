package ru.job4j;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WordIndexFinder {
    private final String word;
    private final String fileName;
    private FileReader fileReader;
    private Trie<String, Set<Integer>> trie = new PatriciaTrie<>();

    public WordIndexFinder(String word, String fileName) {
        this.word = word;
        this.fileName = fileName;
        fileReader = new FileReader(fileName);
    }

    public void countIndexes(String stringName) {
        try (BufferedReader bf = fileReader.loadFile(fileName)) {
            String currentLine;
            Integer pos = 0;
            String[] words;
            while ((currentLine = bf.readLine()) != null) {
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
            e.printStackTrace();
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
