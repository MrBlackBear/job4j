package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * RoleStoreTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RoleStoreTest {
    /**
     * Store which we test
     */
    private RoleStore roleStore;

    /**
     * Initialize store before we start to use it
     */
    @Before
    public void setUp() {
        roleStore = new RoleStore(10);
        roleStore.add(new Role("11"));
        roleStore.add(new Role("22"));
        roleStore.add(new Role("33"));
        roleStore.add(new Role("44"));
        roleStore.add(new Role("55"));
    }

    /**
     * Test add
     */
    @Test
    public void add() {
        roleStore.add(new Role("66"));
        Role expected = new Role("66");
        assertTrue(expected.getId().equals(roleStore.findById("66").getId()));
    }

    /**
     * Test replace
     */
    @Test
    public void replace() {
        Role replace = new Role("155");
        roleStore.replace("44", replace);
        assertTrue(replace.getId().equals(roleStore.findById("155").getId()));
    }

    /**
     * Test delete
     */
    @Test
    public void delete() {
        roleStore.delete("44");
        Role expected = null;
        Role result = roleStore.findById("44");
        assertThat(expected, is(result));
    }

    /**
     * Test findById
     */
    @Test
    public void findById() {
        Role expected = new Role("44");
        assertTrue(expected.getId().equals(roleStore.findById("44").getId()));
    }
}
