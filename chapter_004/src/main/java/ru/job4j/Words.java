package ru.job4j;

import java.util.HashMap;
import java.util.Map;

public class Words {
    public boolean isAnnagram(String first, String second) {
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        HashMap<Character, Integer> hm1 = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            hm1.putIfAbsent(firstArray[i], 1);
            hm1.computeIfPresent(firstArray[i], (key, value) -> value++);
        }
        for (int i = 0; i < firstArray.length; i++) {
            hm1.computeIfPresent(secondArray[i], (key, value) -> value--);
            if (hm1.containsKey(secondArray[i])) {
                if (hm1.get(secondArray[i]) == 1) {
                    hm1.remove(secondArray[i]);
                }
            }
        }
        return hm1.isEmpty();
    }

    public static void main(String[] args) {
        Words w = new Words();
        System.out.println(w.isAnnagram("top", "ort"));
        System.out.println(w.isAnnagram("top", "opt"));
        System.out.println(w.isAnnagram("topo", "opto"));
        System.out.println(w.isAnnagram("topou", "ophto"));
    }
}
