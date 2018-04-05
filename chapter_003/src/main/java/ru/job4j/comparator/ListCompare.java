package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lessLength = left.length() < right.length() ? left.length() : right.length();
        int detector = -1;
        for (int i = 0; i < lessLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                detector = i;
                break;
            }
        }
        return detector == -1 ? Integer.compare(left.length(), right.length()) : Character.compare(left.charAt(detector), right.charAt(detector));
    }
}
