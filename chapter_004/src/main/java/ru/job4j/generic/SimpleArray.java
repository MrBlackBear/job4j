package ru.job4j.generic;

import java.util.Iterator;

/**
 * SimpleArray<T>
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Real array in class
     */
    private T[] simpleArray;
    /**
     * Count real numbers in array
     */
    private int countRealELements = 0;

    /**
     * Constructor
     *
     * @param size size of array
     */
    public SimpleArray(int size) {
        this.simpleArray = (T[]) new Object[size];
    }

    /**
     * Method add which add element in array
     *
     * @param model number which we add to array
     * @return true if array is not full
     */
    public boolean add(T model) {
        if (countRealELements == simpleArray.length) {
            return false;
        }
        simpleArray[countRealELements++] = model;
        return true;
    }

    /**
     * Method which add in that index new item
     *
     * @param index index in which we add element
     * @param model element which we set in that index
     * @return old element which we change
     */
    public T set(int index, T model) {
        T old = simpleArray[index];
        simpleArray[index] = model;
        return old;
    }

    /**
     * Method in which we delete elements
     *
     * @param index delete element in this index
     * @return delete element
     */
    public T delete(int index) {
        T item;
        if (index == simpleArray.length - 1) {
            item = simpleArray[index];
            simpleArray[index] = null;
            return item;
        }
        item = simpleArray[index];
        System.arraycopy(simpleArray, index + 1, simpleArray, index, simpleArray.length - index - 1);
        return item;
    }

    /**
     * Method return element by index
     *
     * @param index by which we get element
     * @return element in array by index
     */
    public T get(int index) {
        return simpleArray[index];
    }

    /**
     * Method iterator with methods hasNext and next
     *
     * @return new iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * Position in iterator
             */
            int position = 0;

            /**
             * If real counts of elements more than position return true
             * @return true if we have real numbers in element
             */
            @Override
            public boolean hasNext() {
                return countRealELements > position;
            }

            /**
             * Method next
             * @return return next element in array
             */
            @Override
            public T next() {
                return simpleArray[position++];
            }
        };
    }
}
