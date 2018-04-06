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
            /**
             * First iterator in lists of iterators
             */
            Iterator<Integer> iterator = check(it);

            /**
             * Return have iterator elements or no
             * @return if list of iterators is not empty check have iterator elements ot no
             */
            @Override
            public boolean hasNext() {
                if (iterator == null) {
                    return false;
                }
                return iterator.hasNext() ? iterator.hasNext() : it.hasNext();
            }

            /**
             * If iterator have element return element or throw exception
             * @throws NoSuchElementException if iterator have no more elements
             * @return next element in iterator
             */
            @Override
            public Integer next() {
                if (!iterator.hasNext() && it.hasNext()) {
                    iterator = it.next();
                }
                if (iterator.hasNext()) {
                    return iterator.next();
                } else {
                    throw new NoSuchElementException(" No element");
                }
            }

            /**
             * Check iterator and put first not null iterator
             * @param iteratorList list of iterators
             * @return first not null iterator
             */
            private Iterator<Integer> check(Iterator<Iterator<Integer>> iteratorList) {
                Iterator<Integer> iterator = iteratorList.hasNext() ? iteratorList.next() : null;
                while (iterator != null) {
                    if (iterator.hasNext()) {
                        return iterator;
                    } else {
                        iterator = iteratorList.hasNext() ? iteratorList.next() : null;
                    }
                }
                return iterator;
            }
        };
    }
}
