package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.assertThrows;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testCalculateFactorialForZero() {
        long result = App.calculateFactorial(0);
        assertEquals(1, result);
    }

    public void testCalculateFactorialForOne() {
        long result = App.calculateFactorial(1);
        assertEquals(1, result);
    }

    public void testCalculateFactorialForPositiveNumber() {
        long result = App.calculateFactorial(5);
        assertEquals(120, result);
    }

    public void testCalculateFactorialForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> App.calculateFactorial(-5));
    }
}
