package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : array) {
            for (int item : arr) {
                result.add(item);
            }
        }
        return result;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        Integer[] convertedArrayFromList = new Integer[list.size()];
        convertedArrayFromList = list.toArray(convertedArrayFromList);
        int rest = convertedArrayFromList.length % rows;
        int newLength = convertedArrayFromList.length;
        if (rest != 0) {
            newLength = convertedArrayFromList.length + rows - rest;
        }
        Integer[] newLengthArray = new Integer[newLength];
        System.arraycopy(convertedArrayFromList, 0, newLengthArray, 0, list.size());
        int needSize = 0;
        if (rest != 0) {
            needSize = list.size() / rows + 1;
        } else {
            needSize = list.size() / rows;
        }
        int[][] result = new int[needSize][rows];
        int[] ar;
        int position = 0;
        for (int i = 0; i < newLength; ) {
            ar = new int[rows];
            for (int j = 0; j < rows; j++) {
                if (newLengthArray[i] == null) {
                    ar[j] = 0;
                    i++;
                } else {
                    ar[j] = newLengthArray[i++];
                }
            }
            result[position++] = ar;
        }
        return result;
    }
}
