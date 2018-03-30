package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

public class CheckTest {
    @Test
    public void changes() {
        Check check = new Check();
        int[] result = check.changes(50, 35);
        int[] expected = {10, 5};
        Assert.assertArrayEquals( expected, result );
    }
}
