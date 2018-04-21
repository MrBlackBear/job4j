package ru.job4j.set;

public class SimpleHashSet<E> {
    /**
     * Store
     */
    private Object[] array;
    /**
     * Size of store
     */
    private int size;
    /**
     * Real count of elements in store
     */
    private int numberOfElements = 0;

    /**
     * Constructor
     *
     * @param size size
     */
    public SimpleHashSet(int size) {
        array = new Object[size];
        this.size = size;
    }

    /**
     * Hash function
     */
    private int hashFunc(E e) {
        return Math.abs(e.hashCode()) % array.length;
    }

    /**
     * Add element
     *
     * @param e element
     * @return true if can add element
     */
    boolean add(E e) {
        if (numberOfElements == size) {
            Object[] oldArray = array;
            size *= 2;
            array = new Object[size];
            for (Object el : oldArray) {
                if (el != null) {
                    int index = hashFunc((E) el);
                    array[index] = el;
                }
            }
        }
        boolean result = false;
        int index = hashFunc(e);
        if (array[index] == null) {
            result = true;
            array[index] = e;
            numberOfElements++;
        }
        return result;
    }

    /**
     * Check contain store element or not
     *
     * @param e element
     * @return true if store have element
     */
    boolean contains(E e) {
        int index = hashFunc(e);
        boolean result = true;
        if (array[index] == null) {
            result = false;
        }
        return result;
    }

    /**
     * Remove element from store
     *
     * @param e element
     * @return true if can remove element
     */
    boolean remove(E e) {
        int index = hashFunc(e);
        boolean result = true;
        if (array[index] == null) {
            result = false;
        }
        array[index] = null;
        return result;
    }

    /**
     * Size
     *
     * @return real number of elements
     */
    public int size() {
        return numberOfElements;
    }
}
