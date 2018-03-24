package ru.job4j.search;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    @Test
    public void whenConvertListThenReturnList() {
        ConvertList list = new ConvertList();
        int[][] doubleArray = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> persons = list.toList(doubleArray);
        assertThat(persons.size(), is(6));
    }

    @Test
    public void whenConvertListToArrayThenReturnArray() {
        ConvertList list = new ConvertList();
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        int[][] expected = {{1, 2, 3}, {4, 5, 0}};
        int[][] result = list.toArray(arrayList, 3);
        Assert.assertArrayEquals(result, expected);
    }
}
