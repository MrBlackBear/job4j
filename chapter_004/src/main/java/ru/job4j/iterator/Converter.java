package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Converter
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Converter {
    /**
     * Convert list of iterators in one iterator
     *
     * @param it list of iterators
     * @return one iterator
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            Iterator<Integer> current = it.next();

            /**
             * Return have iterator elements or no
             * @return if list of iterators is not empty check have iterator elements ot no
             */
            @Override
            public boolean hasNext() {
                while (!current.hasNext() && it.hasNext()) {
                    current = it.next();
                }

                return  current.hasNext();
            }

            ;

            /**
             * If iterator have element return element or throw exception
             * @throws NoSuchElementException if iterator have no more elements
             * @return next element in iterator
             */
            @Override
            public Integer next() {
                if (!current.hasNext() && it.hasNext()) {
                   current = it.next();
                }
                return current.next();
            }
        };
    }
}
