package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * UserStoreTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserStoreTest {
    /**
     * Store which we test
     */
    private UserStore userStore;

    /**
     * Initialize store before we start to use it
     */
    @Before
    public void setUp() {
        userStore = new UserStore(10);
        userStore.add(new User("11"));
        userStore.add(new User("22"));
        userStore.add(new User("33"));
        userStore.add(new User("44"));
        userStore.add(new User("55"));
    }

    /**
     * Test add
     */
    @Test
    public void add() {
        userStore.add(new User("66"));
        User expected = new User("66");
        assertTrue(expected.getId().equals(userStore.findById("66").getId()));
    }

    /**
     * Test replace
     */
    @Test
    public void replace() {
        User replace = new User("155");
        userStore.replace("44", replace);
        assertTrue(replace.getId().equals(userStore.findById("155").getId()));
    }

    /**
     * Test delete
     */
    @Test
    public void delete() {
        userStore.delete("44");
        User expected = new User("");
        assertTrue(expected.getId().equals(userStore.findById("44").getId()));
    }

    /**
     * Test findById
     */
    @Test
    public void findById() {
        User expected = new User("44");
        assertTrue(expected.getId().equals(userStore.findById("44").getId()));
    }
}
