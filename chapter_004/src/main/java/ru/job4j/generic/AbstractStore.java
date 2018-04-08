package ru.job4j.generic;

/**
 * AbstractStore
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public abstract class AbstractStore<T extends Base> {
    /**
     * Store of elements
     */
    private SimpleArray<T> simpleArray;
    /**
     * Size of store
     */
    private int elements;

    /**
     * Constructor
     *
     * @param size of store
     */
    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    /**
     * Add element
     *
     * @param model element which need to add
     */
    public void add(T model) {
        elements++;
        simpleArray.add(model);
    }

    /**
     * Replace elements
     *
     * @param id    id item which we find
     * @param model on which element need to change old element
     * @return true if we can do this and false in other case
     */
    public boolean replace(String id, T model) {
        for (int i = 0; i < elements; i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                simpleArray.set(i, model);
                return true;
            }
        }
        return false;
    }

    /**
     * Delete element from store
     *
     * @param id by this id we need to find element which need to delete
     * @return true if method can to do this and false in other case
     */
    public boolean delete(String id) {
        for (int i = 0; i < elements; i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                elements--;
                simpleArray.delete(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Find element by id
     *
     * @param id id element which we need to find
     * @return element null if we have no element or element with need id
     */
    public T findById(String id) {
        T result = null;
        for (int i = 0; i < elements; i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                result = simpleArray.get(i);
            }
        }
        return result;
    }
}
