/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import Mathematics.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Validation.Factory.
 * @author Rune Dahl Iversen
 */
public class FactoryTest {

    public FactoryTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.Factory");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() { // Intentional
    }

    @After
    public void tearDown() { // Intentional
    }

    /**
     * Test of FiniteComplex method, of class Factory.
     */
    @Test
    public void testFiniteComplex() {
        System.out.println("FiniteComplex");
        Validator<Complex> result = Factory.FiniteComplex();
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Complex> and = (And)result;
        assertEquals("Wrong size of result.", 3, and.size());
    }

    /**
     * Test of BoundedReal method, of class Factory.
     */
    @Test
    public void testBoundedReal() {
        System.out.println("BoundedReal");
        Validator<Double> result = Factory.BoundedReal(0.0, 2.0);
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> and = (And)result;
        assertEquals("Wrong size of result.", 5, and.size());
    }

    /**
     * Test of FiniteReal method, of class Factory.
     */
    @Test
    public void testFiniteReal() {
        System.out.println("FiniteReal");
        Validator<Double> result = Factory.FiniteReal();
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> and = (And)result;
        assertEquals("Wrong size of result.", 3, and.size());
    }

    /**
     * Test of FiniteRealGreaterThan method, of class Factory.
     */
    @Test
    public void testFiniteRealGreaterThan() {
        System.out.println("FiniteRealGreaterThan");
        double limit = 0.0;
        Validator<Double> result = Factory.FiniteRealGreaterThan(limit);
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> and = (And)result;
        assertEquals("Wrong size of result.", 4, and.size());
    }

    /**
     * Test of FiniteRealGreaterThanOrEqual method, of class Factory.
     */
    @Test
    public void testFiniteRealGreaterThanOrEqual() {
        System.out.println("FiniteRealGreaterThanOrEqual");
        double limit = 0.0;
        Validator<Double> result = Factory.FiniteRealGreaterThanOrEqual(limit);
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> and = (And)result;
        assertEquals("Wrong size of result.", 4, and.size());
    }

    /**
     * Test of FiniteRealLessThan method, of class Factory.
     */
    @Test
    public void testFiniteRealLessThan() {
        System.out.println("FiniteRealLessThan");
        double limit = 0.0;
        Validator<Double> result = Factory.FiniteRealLessThan(limit);
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> and = (And)result;
        assertEquals("Wrong size of result.", 4, and.size());
    }

    /**
     * Test of FiniteRealLessThanOrEqual method, of class Factory.
     */
    @Test
    public void testFiniteRealLessThanOrEqual() {
        System.out.println("FiniteRealLessThanOrEqual");
        double limit = 0.0;
        Validator<Double> result = Factory.FiniteRealLessThanOrEqual(limit);
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> and = (And)result;
        assertEquals("Wrong size of result.", 4, and.size());
    }

    /**
     * Test of LimitedReal method, of class Factory.
     */
    @Test
    public void testLimitedReal() {
        System.out.println("LimitedReal");
        Validator<Double> result = Factory.LimitedReal(0.0, 2.0);
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> and = (And)result;
        assertEquals("Wrong size of result.", 5, and.size());
    }

    /**
     * Test of Complex method, of class Factory.
     */
    @Test
    public void testComplex() {
        System.out.println("Complex");
        Validator<Complex> result = Factory.Complex();
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Complex> and = (And)result;
        assertEquals("Wrong size of result.", 2, and.size());
    }

    /**
     * Test of PositiveInteger method, of class Factory.
     */
    @Test
    public void testPositiveInteger() {
        System.out.println("PositiveInteger");
        Validator<Integer> result = Factory.PositiveInteger();
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Complex> and = (And)result;
        assertEquals("Wrong size of result.", 2, and.size());
    }

    /**
     * Test of BoundedLong method, of class Factory.
     */
    @Test
    public void testBoundedLong() {
        System.out.println("BoundedLong");
        Validator<Long> result = Factory.BoundedLong(4, 9);
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Long> and = (And)result;
        assertEquals("Wrong size of result.", 3, and.size());
    }

    /**
     * Test of NonNegativeLong method, of class Factory.
     */
    @Test
    public void testNonNegativeLong() {
        System.out.println("NonNegativeLong");
        Validator<Long> result = Factory.NonNegativeLong();
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Long> and = (And)result;
        assertEquals("Wrong size of result.", 2, and.size());
    }

    /**
     * Test of PositiveLong method, of class Factory.
     */
    @Test
    public void testPositiveLong() {
        System.out.println("PositiveLong");
        Validator<Long> result = Factory.PositiveLong();
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Long> and = (And)result;
        assertEquals("Wrong size of result.", 2, and.size());
    }

    /**
     * Test of PrimeLong method, of class Factory.
     */
    @Test
    public void testPrimeLong() {
        System.out.println("PrimeLong");
        Validator<Long> result = Factory.PrimeLong();
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Long> and = (And)result;
        assertEquals("Wrong size of result.", 3, and.size());
    }

    /**
     * Test of Real method, of class Factory.
     */
    @Test
    public void testReal() {
        System.out.println("Real");
        Validator<Double> result = Factory.Real();
        assertNotNull("Result is null.", result);
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> and = (And)result;
        assertEquals("Wrong size of result.", 2, and.size());
    }

}