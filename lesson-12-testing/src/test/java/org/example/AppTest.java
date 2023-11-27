package org.example;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testCalculateFactorialForZero(){
        long result = App.calculateFactorial(0);
        assertEquals(result, 1);
    }

    @Test
    public void testCalculateFactorialForOne(){
        long result = App.calculateFactorial(1);
        assertEquals(result, 1);
    }

    @Test
    public void testCalculateFactorialForPositiveNumber(){
        long result = App.calculateFactorial(5);
        assertEquals(result, 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialForNegativeNumber(){
        App.calculateFactorial(-5);
    }
}
