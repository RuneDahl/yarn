/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance.Yield;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test of Finance.Yield.CompoundTime.
 * @author Rune Dahl Iversen
 */
public class CompoundTimeTest {
    private CompoundTime _instance;
    private double _delta;
    
    public CompoundTimeTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Finance.Yield.CompoundTime");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._instance = new CompoundTime(4.0);
        this._delta = Math.pow(10.0, -12.0);
    }
    
    @After
    public void tearDown() {
        this._instance = null;
    }
    
    /**
     * Test of getFrequency method, of class CompoundTime.
     */
    @Test
    public void testGetFrequency() {
        System.out.println("getFrequency");
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        double expResult = 4.0;
        double result = instance.getFrequency();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFrequency method, of class CompoundTime.
     */
    @Test
    public void testSetFrequency() {
        System.out.println("setFrequency");
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        assertFalse("Failed initial condition for testing setFrequency.",
                2.0 == instance.getFrequency());
        double expResult = 2.0;
        instance.setFrequency(expResult);
        double result = instance.getFrequency();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFrequency method, of class CompoundTime,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFrequency_NaN() {
        System.out.println("setFrequency(Double.NaN)");
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        instance.setFrequency(Double.NaN);
    }

    /**
     * Test of setFrequency method, of class CompoundTime,
     * for a negative number.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFrequency_Negative() {
        System.out.println("setFrequency(Negative)");
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        instance.setFrequency(-4.0);
    }

    /**
     * Test of setFrequency method, of class CompoundTime,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFrequency_PositiveInfinity() {
        System.out.println("setFrequency(Double.POSITIVE_INFINITY)");
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        instance.setFrequency(Double.POSITIVE_INFINITY);
    }

    /**
     * Test of setFrequency method, of class CompoundTime,
     * for the value 0.0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFrequency_Zero() {
        System.out.println("setFrequency(0.0)");
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        instance.setFrequency(0.0);
    }

    /**
     * Test of discountFactor method, of class CompoundTime.
     */
    @Test
    public void testDiscountFactor_1() {
        System.out.println("discountFactor(1 year)");
        Double start = -1.0;
        Double end = 0.0;
        double yield = 0.04;
        Convention<Double, Double> instance = this._instance;
        double expResult = Math.pow(1.01, -4.0);
        double result = instance.discountFactor(start, end, yield);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of discountFactor method, of class CompoundTime.
     */
    @Test
    public void testDiscountFactor_2() {
        System.out.println("discountFactor(semiannnual)");
        Double start = 0.0;
        Double end = 10.0;
        double yield = 0.01;
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        instance.setFrequency(2.0);
        double expResult = Math.pow(1.005, -20.0);
        double result = instance.discountFactor(start, end, yield);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of discountFactor method, of class CompoundTime.
     */
    @Test
    public void testDiscountFactor_3() {
        System.out.println("discountFactor(3%)");
        Double start = 0.0;
        Double end = 10.0;
        double yield = 0.03;
        Convention<Double, Double> instance = this._instance;
        double expResult = Math.pow(1.0075, -40.0);
        double result = instance.discountFactor(start, end, yield);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of discountFactor method, of class CompoundTime.
     */
    @Test
    public void testDiscountFactor_10() {
        System.out.println("discountFactor(10 years)");
        Double start = 0.0;
        Double end = 10.0;
        double yield = 0.01;
        Convention<Double, Double> instance = this._instance;
        double expResult = Math.pow(1.0025, -40.0);
        double result = instance.discountFactor(start, end, yield);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getName method, of class CompoundTime.
     */
    @Test
    public void testGetName_2() {
        System.out.println("getName");
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        instance.setFrequency(2.0);
        String expResult = "Compound(2.0)";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class CompoundTime.
     */
    @Test
    public void testGetName_4() {
        System.out.println("getName");
        Convention<Double, Double> instance = this._instance;
        String expResult = "Compound(4.0)";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of time method, of class CompoundTime.
     */
    @Test
    public void testTime_1() {
        System.out.println("time(1 year)");
        double discountFactor = Math.pow(1.0025, -4.0);
        double yield = 0.01;
        Convention<Double, Double> instance = this._instance;
        Double expResult = 1.0;
        Double result = instance.time(discountFactor, yield);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of time method, of class CompoundTime.
     */
    @Test
    public void testTime_2() {
        System.out.println("time(semiannual)");
        double discountFactor = Math.pow(1.005, -20.0);
        double yield = 0.01;
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        instance.setFrequency(2.0);
        Double expResult = 10.0;
        Double result = instance.time(discountFactor, yield);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of time method, of class CompoundTime.
     */
    @Test
    public void testTime_3() {
        System.out.println("time(3%)");
        double discountFactor = Math.pow(1.0075, -40.0);
        double yield = 0.03;
        Convention<Double, Double> instance = this._instance;
        Double expResult = 10.0;
        Double result = instance.time(discountFactor, yield);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of time method, of class CompoundTime.
     */
    @Test
    public void testTime_10() {
        System.out.println("time(10 years)");
        double discountFactor = Math.pow(1.0025, -40.0);
        double yield = 0.01;
        Convention<Double, Double> instance = this._instance;
        Double expResult = 10.0;
        Double result = instance.time(discountFactor, yield);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of yield method, of class CompoundTime.
     */
    @Test
    public void testYield_1() {
        System.out.println("yield(1 year)");
        double discountFactor = Math.pow(1.0025, -4.0);
        Double start = -1.0;
        Double end = 0.0;
        Convention<Double, Double> instance = this._instance;
        double expResult = 0.01;
        double result = instance.yield(discountFactor, start, end);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of yield method, of class CompoundTime.
     */
    @Test
    public void testYield_2() {
        System.out.println("yield(semiannual)");
        double discountFactor = Math.pow(1.005, -20.0);
        Double start = 0.0;
        Double end = 10.0;
        HasCompoundingFrequency<Double, Double> instance = this._instance;
        instance.setFrequency(2.0);
        double expResult = 0.01;
        double result = instance.yield(discountFactor, start, end);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of yield method, of class CompoundTime.
     */
    @Test
    public void testYield_3() {
        System.out.println("yield(3%)");
        double discountFactor = Math.pow(1.0075, -40.0);
        Double start = 0.0;
        Double end = 10.0;
        Convention<Double, Double> instance = this._instance;
        double expResult = 0.03;
        double result = instance.yield(discountFactor, start, end);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of yield method, of class CompoundTime.
     */
    @Test
    public void testYield_10() {
        System.out.println("yield(10 years)");
        double discountFactor = Math.pow(1.0025, -40.0);
        Double start = 0.0;
        Double end = 10.0;
        Convention<Double, Double> instance = this._instance;
        double expResult = 0.01;
        double result = instance.yield(discountFactor, start, end);
        assertEquals(expResult, result, this._delta);
    }
}
