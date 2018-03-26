package ru.job4j.bank;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class BankTest {
    @Test
    public void addUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "123456"));
        TreeMap<User, ArrayList<Account>> treemap = bank.getTreemap();
        User key = null;
        Set set = treemap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            key = (User) mentry.getKey();
        }
        assertTrue(key.getName().equals("Ivan"));
    }

    @Test
    public void deleteUser() {
        Bank bank = new Bank();
        User us2 = new User("Petr", "55555");
        User us1 = new User("Ivan", "123456");
        bank.addUser(us1);
        bank.addUser(us2);
        bank.deleteUser(us2);
        TreeMap<User, ArrayList<Account>> treemap = bank.getTreemap();
        User key = null;
        Set set = treemap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            key = (User) mentry.getKey();
        }
        assertTrue(key.getName().equals("Ivan"));
    }

    @Test
    public void addAccountToUser() {
        Bank bank = new Bank();
        User us = new User("Petr", "55555");
        bank.addUser(us);
        bank.addAccountToUser(us, new Account(5555, "456"));
        TreeMap<User, ArrayList<Account>> treemap = bank.getTreemap();
        ArrayList<Account> value = null;
        Set set = treemap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            value = (ArrayList<Account>) mentry.getValue();
        }
        assertTrue(value.get(0).getRequisites().equals("456"));
    }

    @Test
    public void deleteAccountFromUser() {
        Bank bank = new Bank();
        User us = new User("Petr", "55555");
        bank.addUser(us);
        bank.addAccountToUser(us, new Account(5555, "456"));
        Account account = new Account(5555, "4567");
        bank.addAccountToUser(us, account);
        bank.deleteAccountFromUser(us, account);
        TreeMap<User, ArrayList<Account>> treemap = bank.getTreemap();
        ArrayList<Account> value = null;
        Set set = treemap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            value = (ArrayList<Account>) mentry.getValue();
        }
        assertTrue(value.get(0).getRequisites().equals("456"));
    }

    @Test
    public void getUserAccounts() {
        Bank bank = new Bank();
        User us = new User("Petr", "55555");
        bank.addUser(us);
        bank.addAccountToUser(us, new Account(5555, "456"));
        Account account = new Account(5555, "4567");
        bank.addAccountToUser(us, account);
        ArrayList<Account> value = (ArrayList<Account>) bank.getUserAccounts("55555");
        assertTrue(value.get(0).getRequisites().equals("456"));
    }

    @Test
    public void transfer() {
        Bank bank = new Bank();
        User us = new User("Petr", "55555");
        bank.addUser(us);
        bank.addAccountToUser(us, new Account(55555, "456"));
        Account account = new Account(5555, "4567");
        bank.addAccountToUser(us, account);
        assertTrue(bank.transfer("55555", "456", "55555", "4567", 100));
    }
}
