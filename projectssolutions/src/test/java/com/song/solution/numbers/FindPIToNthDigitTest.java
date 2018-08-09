package com.song.solution.numbers;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by 001844 on 2018/1/3.
 */
public class FindPIToNthDigitTest {

    @Test
    public void test() throws IOException {
        int decimal = -10;
        String result = FindPIToNthDigit.getDecimalPI(decimal);
        Assert.assertTrue(result == null);

        decimal = 0;
        result = FindPIToNthDigit.getDecimalPI(decimal);
        Assert.assertTrue(result.equalsIgnoreCase("3"));

        decimal = 1;
        result = FindPIToNthDigit.getDecimalPI(decimal);
        Assert.assertTrue(result.equalsIgnoreCase("3.1"));

        decimal = 15;
        String exceptResult = "3.141592653589793";
        result = FindPIToNthDigit.getDecimalPI(decimal);
        Assert.assertTrue(result.equalsIgnoreCase(exceptResult));
    }
}
