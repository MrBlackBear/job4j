package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class UserConvertTest {
    @Test
    public void whenConvertListThenReturnMap() {
        UserConvert userConvert = new UserConvert();
        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(new User(12, "Alex", "Gomel"));
        listOfUsers.add(new User(15, "Alex15", "Gomel15"));
        listOfUsers.add(new User(17, "Alex17", "Gomel17"));
        HashMap<Integer, User> result = userConvert.process(listOfUsers);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(12, new User(12, "Alex", "Gomel"));
        expected.put(15, new User(15, "Alex15", "Gomel15"));
        expected.put(17, new User(17, "Alex17", "Gomel17"));
        assertTrue(result.equals(expected));
    }
}
