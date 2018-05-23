package ru.job4j;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    private final String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public BufferedReader loadFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            return reader;
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
