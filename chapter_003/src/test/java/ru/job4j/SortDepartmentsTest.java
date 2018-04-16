package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SortDepartmentsTest
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortDepartmentsTest {
    /**
     * Departments to test
     */
    SortDepartments sortDepartments;

    /**
     * SetUp before tests
     */
    @Before
    public void setUp() {
        String[] arr = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        sortDepartments = new SortDepartments(arr);
    }

    /**
     * Order by asc
     */
    @Test
    public void orderByAsc() {
        String[] result = sortDepartments.orderByAsc();
        String[] expected = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        assertArrayEquals(result, expected);
    }

    /**
     * Order by desc
     */
    @Test
    public void orderByDesc() {
        String[] result = sortDepartments.orderByDesc();
        String[] expected = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        assertArrayEquals(result, expected);
    }
}