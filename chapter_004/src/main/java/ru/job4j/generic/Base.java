package ru.job4j.generic;

/**
 * Base
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public abstract class Base {
    /**
     * Identifier
     */
    private final String id;

    /**
     * Condtructor
     *
     * @param id identifier
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Method which return identifier
     *
     * @return return identifier
     */
    public String getId() {
        return id;
    }
}
