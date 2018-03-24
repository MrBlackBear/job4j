package ru.job4j.compare;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.testng.Assert.assertTrue;

public class SortUserTest {
    @Test
    public void whenCompareThenReturnSortedResult() {
        SortUser sortUser = new SortUser();
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("ivan", 25));
        users.add(new User("ivan44", 44));
        users.add(new User("ivan12", 12));
        users.add(new User("ivan3", 3));
        Set<User> result = sortUser.sort(users);
        TreeSet<User> expected = new TreeSet<>();
        expected.add(new User("ivan3", 3));
        expected.add(new User("ivan12", 12));
        expected.add(new User("ivan", 25));
        expected.add(new User("ivan44", 44));
        assertTrue(result.equals(expected));
    }
}
