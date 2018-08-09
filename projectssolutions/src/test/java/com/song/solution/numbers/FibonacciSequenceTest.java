package com.song.solution.numbers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 001844 on 2018/1/3.
 */

public class FibonacciSequenceTest {

    @Test
    public void test() {
        int len = -10;
        List<Long> list = FibonacciSequence.gen(len);
        Assert.assertTrue(list.isEmpty());
        len = 0;
        list = FibonacciSequence.gen(len);
        Assert.assertTrue(list.isEmpty());
        len = 5;
        list = FibonacciSequence.gen(len);

        Assert.assertTrue(list.size() == 5);
        Assert.assertTrue(list.equals(Arrays.asList(0L, 1L, 1L, 2L, 3L)));
    }
}
