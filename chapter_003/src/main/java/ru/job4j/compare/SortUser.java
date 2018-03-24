package ru.job4j.compare;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> users) {
        TreeSet<User> result = new TreeSet<>();
        for (User user : users) {
            result.add(user);
        }
        return result;
    }

    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            public int compare(User o1, User o2) {
                return o1.getName().length() <= o2.getName().length() ? 1 : -1;
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            public int compare(User o1, User o2) {
                final int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
