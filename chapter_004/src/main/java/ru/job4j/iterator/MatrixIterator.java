package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] doubleArray;
    private int indexCols = 0;
    private int indexRows = 0;

    public MatrixIterator(int[][] doubleArray) {
        this.doubleArray = doubleArray;
    }

    @Override
    public boolean hasNext() {
        boolean indicator = true;
        if (doubleArray[indexCols].length == indexRows && (indexCols + 1) == doubleArray.length) {
            indicator = false;
        }
        return indicator ? doubleArray[indexCols].length > 0 : indicator;
    }

    @Override
    public Integer next() {
        if (doubleArray.length == indexCols) {
            throw new NoSuchElementException("No elements");
        }
        if (doubleArray[indexCols].length == indexRows) {
            indexCols++;
            indexRows = 0;
        }
        return doubleArray[indexCols][indexRows++];
    }
}
