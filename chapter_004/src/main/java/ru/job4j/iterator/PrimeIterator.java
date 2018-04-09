package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * PrimeIterator
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PrimeIterator implements Iterator<Integer> {
    /**
     * Our array
     */
    private int[] array;
    /**
     * Count of prime elements
     */
    int countPrime;
    /**
     * Index in array for which we iterate
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
    public PrimeIterator(int[] array) {
        this.array = array;
        this.countPrime = countOfPrimeElements(array);
    }

    /**
     * Method hasNext
     *
     * @return true if we have any prime elements in array
     */
    @Override
    public boolean hasNext() {
        return countPrime > countOfNeedElements;
    }

    /**
     * Method next which throw exception if we have no more prime elements or return prime element from array
     *
     * @return next prime element in array
     * @throws NoSuchElementException if we have no more prime elements
     */
    @Override
    public Integer next() {
        if (countPrime == countOfNeedElements) {
            throw new NoSuchElementException("No elements");
        }
        int element = 0;
        for (int i = indexArray; i < array.length; i++) {
            if (isPrime(array[i])) {
                countOfNeedElements++;
                element = array[i];
                indexArray = i + 1;
                break;
            }
        }
        return element;
    }

    /**
     * Method which return count of prime elements
     *
     * @param array in which we search prime elements
     * @return counts of prime elements
     */
    private int countOfPrimeElements(int[] array) {
        int count = 0;
        for (int i : array) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method which return primenumber or no
     *
     * @param num number which we check
     * @return prime number or no
     */
    private boolean isPrime(int num) {
        boolean result = true;
        if (num < 2) {
            result = false;
        }
        for (int i = 2; i * i <= num; i += 2) {
            if (num % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
