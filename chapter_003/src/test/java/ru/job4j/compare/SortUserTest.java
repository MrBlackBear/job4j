package ru.job4j.compare;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SortUserTest {
    @Test
    public void whenCompareThenReturnSortedResult() {
        SortUser sortUser = new SortUser();
        ArrayList<User> users = new ArrayList<>();
        User first = new User("ivan", 25);
        User second = new User("ivan44", 44);
        User third = new User("ivan12", 12);
        User fourth = new User("ivan3", 3);
        users.add(first);
        users.add(second);
        users.add(third);
        users.add(fourth);
        Set<User> result = sortUser.sort(users);
        TreeSet<User> expected = new TreeSet<>();
        expected.add(fourth);
        expected.add(third);
        expected.add(first);
        expected.add(second);
        assertTrue(result.equals(expected));
    }

    @Test
    public void sortNameLength() {
        SortUser sortUser = new SortUser();
        ArrayList<User> users = new ArrayList<>();
        User first = new User("ivan", 25);
        User second = new User("ivan44", 44);
        User third = new User("ivan12", 12);
        User fourth = new User("ivan3", 3);
        users.add(first);
        users.add(second);
        users.add(third);
        users.add(fourth);
        ArrayList<User> result = (ArrayList<User>) sortUser.sortNameLength(users);
        ArrayList<User> expected = new ArrayList<>();
        expected.add(second);
        expected.add(third);
        expected.add(fourth);
        expected.add(first);
        assertEquals(result, expected);
    }


    @Test
    public void sortByAllFields() {
        SortUser sortUser = new SortUser();
        ArrayList<User> users = new ArrayList<>();
        User first = new User("nick", 25);
        User second = new User("nick", 44);
        User third = new User("paulo", 12);
        User fourth = new User("paulo", 3);
        users.add(first);
        users.add(second);
        users.add(third);
        users.add(fourth);
        ArrayList<User> result = (ArrayList<User>) sortUser.sortByAllFields(users);
        ArrayList<User> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(fourth);
        expected.add(third);
        assertEquals(result, expected);
    }
}
