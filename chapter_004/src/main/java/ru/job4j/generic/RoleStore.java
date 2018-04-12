package ru.job4j.generic;

/**
 * RoleStore
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RoleStore extends AbstractStore<Role> implements Store<Role> {
    /**
     * Constructor
     *
     * @param size of store
     */
    public RoleStore(int size) {
        super(size);
    }
}
