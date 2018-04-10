package ru.job4j.list;

/**
 * Cycle
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Cycle {
    /**
     * Check have list cycle or not
     *
     * @param first first elementin list
     * @return true if list has cycle
     */
    boolean hasCycle(Node first) {
        Node turtle = first;
        Node hare = first;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }
}
