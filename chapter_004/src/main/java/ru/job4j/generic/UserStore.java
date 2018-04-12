package ru.job4j.generic;

/**
 * UserStore
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserStore extends AbstractStore<User> implements Store<User> {
    /**
     * Constructor
     *
     * @param size of store
     */
    public UserStore(int size) {
        super(size);
    }
}
