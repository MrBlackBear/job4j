package ru.job4j;

public class Check {
    int[] changes(int value, int price) {
        int[] result = new int[100];
        int index = 0;
        int ost = value - price;
        while (ost != 0) {
            if (ost >= 10) {
                result[index++] = 10;
                ost -= 10;
                continue;
            } else if (ost >= 5) {
                result[index++] = 5;
                ost -= 5;
                continue;
            } else if (ost >= 2) {
                result[index++] = 2;
                ost -= 2;
                continue;
            } else {
                result[index++] = 1;
                ost -= 1;
                continue;
            }
        }
        int[] newResult = new int[index];
        System.arraycopy(result, 0, newResult, 0, index);
        return newResult;
    }
}
