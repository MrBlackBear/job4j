package ru.job4j.compare;

import java.util.Comparator;
import java.util.List;

import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort (List<User> users){
        TreeSet<User> result = new TreeSet<>();
        for (User user:users) {
            result.add(user);
        }
        return result;
    }
}
