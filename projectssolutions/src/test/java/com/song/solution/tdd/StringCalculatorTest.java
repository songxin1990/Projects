package com.song.solution.tdd;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 001844 on 2018/1/5.
 */
public class StringCalculatorTest {

    @Test(expected = RuntimeException.class)
    public final void whereMoreThan2NumbersAreUsedThenExceptionIsThrown(){
        StringCalculator.add("1,2,3");
    }
    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown(){
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown(){
        StringCalculator.add("1,X");
    }
    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals(3+6+15, StringCalculator.add("//;\n3;6;15"));
    }
}
