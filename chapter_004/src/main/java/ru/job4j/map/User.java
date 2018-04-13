package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * User
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     * Name
     */
    private String name;
    /**
     * Number of children
     */
    private int children;
    /**
     * Date of birth
     */
    private Calendar birth;

    /**
     * Constructor
     *
     * @param name     name
     * @param children number of children
     * @param birth    date of birth
     */
    public User(String name, int children, Calendar birth) {
        this.name = name;
        this.children = children;
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birth, user.birth);
    }
}
