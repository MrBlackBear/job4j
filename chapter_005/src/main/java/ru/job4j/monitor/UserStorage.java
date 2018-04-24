package ru.job4j.monitor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private List<User> users = new ArrayList<>();

    public synchronized boolean add(User user) {
        users.add(user);
        return true;
    }

    public synchronized boolean update(User user) {
        boolean result = users.contains(user);
        if (result) {
            for (User us : users) {
                if (us.equals(user)) {
                    us.setAmount(user.getAmount());
                    break;
                }
            }
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        boolean result = users.contains(user);
        if (result) {
            users.remove(user);
        }
        return result;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        User from = null;
        User to = null;
        for (User us : users) {
            if (us.getId() == fromId) {
                from = us;
            }
            if (us.getId() == toId) {
                to = us;
            }
        }
        if (from != null && to != null && from.getAmount() >= amount) {
            to.setAmount(to.getAmount() + amount);
            from.setAmount(from.getAmount() - amount);
        }
    }
}
