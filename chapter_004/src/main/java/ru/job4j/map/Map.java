package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Map
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Map {
    public static void main(String[] args) {
        HashMap<User, Object> map = new HashMap<>();
        User first = new User("Petr", 22, new GregorianCalendar(1992, 1, 30));
        User second = new User("Petr", 22, new GregorianCalendar(1992, 1, 30));
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
    }
}
