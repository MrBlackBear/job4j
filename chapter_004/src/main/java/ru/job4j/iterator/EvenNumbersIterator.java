package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenNumbersIterator
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    /**
     * Our array
     */
    private int[] array;
    /**
     * Count of even elements
     */
    int countEven;
    /**
     * INdex in array for which we iterate
     */
    int indexArray = 0;
    /**
     * Counts of elements which we found by method next in array
     */
    int countOfNeedElements = 0;

    /**
     * Constructor of class
     *
     * @param array our array
     */
    public EvenNumbersIterator(int[] array) {
        this.array = array;
        this.countEven = countOfEvenElements(array);
    }

    /**
     * Method hasNext
     *
     * @return true if we have any even elements in array
     */
    @Override
    public boolean hasNext() {
        return countEven > countOfNeedElements;
    }

    /**
     * Method next which throw exception if we have no more even elements or return even element from array
     *
     * @return next even element in array
     * @throws NoSuchElementException if we have no more even elements
     */
    @Override
    public Integer next() {
        if (countEven == countOfNeedElements) {
            throw new NoSuchElementException("No elements");
        }
        int element = 0;
        for (int i = indexArray; i < array.length; i++) {
            if (isEven(array[i])) {
                countOfNeedElements++;
                element = array[i];
                indexArray = i + 1;
                break;
            }
        }
        return element;
    }

    /**
     * Method which retorn count of even elements
     *
     * @param array in which we search even elements
     * @return counts of even elements
     */
    private int countOfEvenElements(int[] array) {
        int count = 0;
        for (int i : array) {
            if (isEven(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method which return even number or no
     *
     * @param number number which we check
     * @return even number or no
     */
    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
