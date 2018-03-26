package ru.job4j.bank;

import java.util.*;

public class Bank {
    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public void addUser(User user) {
        this.treemap.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.treemap.remove(user);
    }

    public void addAccountToUser(User user, Account account) {
        this.treemap.get(user).add(account);
    }

    public void deleteAccountFromUser(User user, Account account) {
        this.treemap.get(user).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        Set<User> keys = this.treemap.keySet();
        List<Account> result = null;
        for (User user : keys) {
            if (user.getPassport().equals(passport)) {
                result = this.treemap.get(user);
            }
        }
        return result;
    }

    private Account getActualAccount(String passport, String requisite) {
        ArrayList<Account> list = (ArrayList) this.getUserAccounts(passport);
        Account result = null;
        for (Account account : list) {
            if (account.getRequisites().equals(requisite)) {
                result = account;
            }
        }
        return result;
    }

    public boolean transfer(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        return this.getActualAccount(srcPassport, srcRequisite) != null ? getActualAccount(srcPassport, srcRequisite).transfer(getActualAccount(destPassport, destRequisite), amount) : false;
    }

    public TreeMap<User, ArrayList<Account>> getTreemap() {
        return treemap;
    }
}