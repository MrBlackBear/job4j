package ru.job4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * SortDepartments
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortDepartments {
    /**
     * All departments
     */
    String[] departmentArray;

    /**
     * Constructor
     *
     * @param departmentArray departmentArray
     */
    public SortDepartments(String[] departmentArray) {
        this.departmentArray = allDepartments(departmentArray);
    }

    /**
     * Return all departments with disappeared departments
     *
     * @param dep departments
     * @return all department
     */
    private String[] allDepartments(String[] dep) {
        String[] store = new String[100];
        String[] array = dep;
        String[] result;
        String res = "";
        int count = 0;
        int indexStore = 0;
        for (String str : array) {
            if (str.length() > 1) {
                String[] word = str.split("[\\\\s\\\\-\\\\.\\\\'\\\\?\\\\,\\\\_\\\\@]+");
                for (int i = 0; i < word.length - 1; ++i) {
                    res = "";
                    count = 0;
                    for (int j = 0; j <= i; j++) {
                        if (j > 0) {
                            res += "\\";
                        }
                        res += word[j];
                    }
                    for (String s : array) {
                        if (s.equals(res)) {
                            count++;
                        }
                    }
                    for (String s : store) {
                        if (s != null && s.equals(res)) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        store[indexStore++] = res;
                    }
                }
            }
        }
        for (String st : array) {
            store[indexStore++] = st;
        }
        result = new String[indexStore];
        System.arraycopy(store, 0, result, 0, indexStore);
        return result;
    }

    /**
     * Order departments by asc
     *
     * @return ordered departments by asc
     */
    public String[] orderByAsc() {
        String[] arr = this.departmentArray;
        Collections.sort(Arrays.asList(arr));
        return arr;
    }

    /**
     * Order departments by desc
     *
     * @return ordered departments
     */
    public String[] orderByDesc() {
        String[] arr = this.departmentArray;
        Collections.sort(Arrays.asList(arr), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] firstStr = o1.split("[\\\\s\\\\-\\\\.\\\\'\\\\?\\\\,\\\\_\\\\@]+");
                String[] secondStr = o2.split("[\\\\s\\\\-\\\\.\\\\'\\\\?\\\\,\\\\_\\\\@]+");
                int length = firstStr.length > secondStr.length ? secondStr.length : firstStr.length;
                int result = 0;
                for (int i = 0; i < length; i++) {
                    if (firstStr[i].compareTo(secondStr[i]) != 0) {
                        result = firstStr[i].compareTo(secondStr[i]) > 0 ? -1 : 1;
                        break;
                    } else {
                        if (firstStr.length == length && secondStr.length == length) {
                            result = o1.compareTo(o2) > 0 ? -1 : 1;
                            break;
                        }
                        if (firstStr.length == length) {
                            result = -1;
                            break;
                        }
                        if (secondStr.length == length) {
                            result = 1;
                            break;
                        }
                    }
                }
                return result;
            }
        });
        return arr;
    }
}
