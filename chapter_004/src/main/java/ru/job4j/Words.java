package ru.job4j;

import java.util.HashMap;

public class Words {
    public boolean isAnnagram(String first, String second) {
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        boolean result = true;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            if (hm1.containsKey(firstArray[i])) {
                Character key = firstArray[i];
                Integer value = hm1.get(key);
                hm1.put(key, value += 1);
            } else {
                hm1.put(firstArray[i], 1);
            }
        }
        for (int i = 0; i < firstArray.length; i++) {
            if (hm1.containsKey(secondArray[i])) {
                if (hm1.get(secondArray[i]) > 1) {
                    Character key = secondArray[i];
                    Integer value = hm1.get(key);
                    hm1.put(key, value -= 1);
                } else {
                    hm1.remove(secondArray[i]);
                }
            } else {
                result = false;
                break;
            }
        }
        return result && hm1.isEmpty();
    }

    public static void main(String[] args) {
        Words w = new Words();
        System.out.println(w.isAnnagram("top", "ort"));
    }
}
