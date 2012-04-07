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
 * Unit test of Finance.Yield.ContinuousTime.
 * @author Rune Dahl Iversen
 */
public class ContinuousTimeTest {
    private ContinuousTime _instance;
    private double _delta;
    
    public ContinuousTimeTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Finance.Yield.ContinuousTime");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }
    
    @Before
    public void setUp() {
        this._instance = new ContinuousTime();
        this._delta = Math.pow(10.0, -12.0);
    }
    
    @After
    public void tearDown() {
        this._instance = null;
    }
    
    /**
     * Test of discountFactor method, of class ContinuousTime.
     */
    @Test
    public void testDiscountFactor_1() {
        System.out.println("discountFactor(1 year)");
        Double start = -1.0;
        Double end = 0.0;
        double yield = 0.04;
        Convention<Double, Double> instance = this._instance;
        double expResult = Math.exp(-0.04);
        double result = instance.discountFactor(start, end, yield);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of discountFactor method, of class ContinuousTime.
     */
    @Test
    public void testDiscountFactor_3() {
        System.out.println("discountFactor(3%)");
        Double start = 0.0;
        Double end = 10.0;
        double yield = 0.03;
        Convention<Double, Double> instance = this._instance;
        double expResult = Math.exp(-0.3);
        double result = instance.discountFactor(start, end, yield);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of discountFactor method, of class ContinuousTime.
     */
    @Test
    public void testDiscountFactor_10() {
        System.out.println("discountFactor(10 years)");
        Double start = 0.0;
        Double end = 10.0;
        double yield = 0.01;
        Convention<Double, Double> instance = this._instance;
        double expResult = Math.exp(-0.1);
        double result = instance.discountFactor(start, end, yield);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getName method, of class ContinuousTime.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Convention<Double, Double> instance = this._instance;
        String expResult = "Continuous";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of time method, of class ContinuousTime.
     */
    @Test
    public void testTime_1() {
        System.out.println("time(1 year)");
        double discountFactor = Math.exp(-0.01);
        double yield = 0.01;
        Convention<Double, Double> instance = this._instance;
        Double expResult = 1.0;
        Double result = instance.time(discountFactor, yield);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of time method, of class ContinuousTime.
     */
    @Test
    public void testTime_3() {
        System.out.println("time(3%)");
        double discountFactor = Math.exp(-0.3);
        double yield = 0.03;
        Convention<Double, Double> instance = this._instance;
        Double expResult = 10.0;
        Double result = instance.time(discountFactor, yield);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of time method, of class ContinuousTime.
     */
    @Test
    public void testTime_10() {
        System.out.println("time(10 years)");
        double discountFactor = Math.exp(-0.1);
        double yield = 0.01;
        Convention<Double, Double> instance = this._instance;
        Double expResult = 10.0;
        Double result = instance.time(discountFactor, yield);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of yield method, of class ContinuousTime.
     */
    @Test
    public void testYield_1() {
        System.out.println("yield(1 year)");
        double discountFactor = Math.exp(-0.01);
        Double start = -1.0;
        Double end = 0.0;
        Convention<Double, Double> instance = this._instance;
        double expResult = 0.01;
        double result = instance.yield(discountFactor, start, end);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of yield method, of class ContinuousTime.
     */
    @Test
    public void testYield_3() {
        System.out.println("yield(3%)");
        double discountFactor = Math.exp(-0.3);
        Double start = 0.0;
        Double end = 10.0;
        Convention<Double, Double> instance = this._instance;
        double expResult = 0.03;
        double result = instance.yield(discountFactor, start, end);
        assertEquals(expResult, result, this._delta);
    }

    /**
     * Test of yield method, of class ContinuousTime.
     */
    @Test
    public void testYield_10() {
        System.out.println("yield(10 years)");
        double discountFactor = Math.exp(-0.1);
        Double start = 0.0;
        Double end = 10.0;
        Convention<Double, Double> instance = this._instance;
        double expResult = 0.01;
        double result = instance.yield(discountFactor, start, end);
        assertEquals(expResult, result, this._delta);
    }
}
