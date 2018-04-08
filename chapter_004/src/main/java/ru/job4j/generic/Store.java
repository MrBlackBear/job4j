package ru.job4j.generic;

/**
 * Store
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Store<T extends Base> {
    /**
     * Add element
     *
     * @param model element which need to add
     */
    void add(T model);

    /**
     * Replace id with id which we know on model
     *
     * @param id    id item which we find
     * @param model on which element need to change old element
     * @return true if we have such element
     */
    boolean replace(String id, T model);

    /**
     * Delete element
     *
     * @param id by this id we need to find element which need to delete
     * @return return true if we can delete element
     */
    boolean delete(String id);

    /**
     * Find element by id
     *
     * @param id id element which we need to find
     * @return return element
     */
    T findById(String id);
}
