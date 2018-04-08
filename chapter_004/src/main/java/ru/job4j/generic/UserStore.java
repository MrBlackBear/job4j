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

    /**
     * Method find element
     *
     * @param id id element which we need to find
     * @return if have no need element in store return element with empty id else return need element
     */
    @Override
    public User findById(String id) {
        User result = super.findById(id);
        if (result == null) {
            result = new User("");
        }
        return result;
    }
}
