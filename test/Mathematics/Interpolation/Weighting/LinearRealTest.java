/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation.Weighting;

import Mathematics.*;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * jUnit test of the class Mathematics.Interpolation.Weighting.LinearReal.
 * @author Rune Dahl Iversen
 */
public class LinearRealTest {
    private LinearReal _instance;
    private RealIntervalWeightsTest _tester;

    public LinearRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Interpolation.Weighting.LinearReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new LinearReal();
        this._tester = new RealIntervalWeightsTest();
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._tester = null;
    }

    /**
     * Test of getWeights method, of class LinearReal.
     */
    @Test
    public void testGetWeights() {
        System.out.println("getWeights");
        Interval<Double> interval = new IntervalReal(
                0.0, Interval.EndType.Includes, 1.0, Interval.EndType.Includes);
        Map<Double, Double> expResult = new HashMap<Double, Double>();

        expResult.put(0.0, 1.5);
        expResult.put(1.0, -0.5);
        this._tester.testGetWeights(this._instance, -0.5, interval, expResult);

        expResult.put(0.0, 1.25);
        expResult.put(1.0, -0.25);
        this._tester.testGetWeights(this._instance, -0.25, interval, expResult);

        expResult.put(0.0, 1.0);
        expResult.put(1.0, 0.0);
        this._tester.testGetWeights(this._instance, 0.0, interval, expResult);

        expResult.put(0.0, 0.75);
        expResult.put(1.0, 0.25);
        this._tester.testGetWeights(this._instance, 0.25, interval, expResult);

        expResult.put(0.0, 0.5);
        expResult.put(1.0, 0.5);
        this._tester.testGetWeights(this._instance, 0.5, interval, expResult);

        expResult.put(0.0, 0.25);
        expResult.put(1.0, 0.75);
        this._tester.testGetWeights(this._instance, 0.75, interval, expResult);

        expResult.put(0.0, 0.0);
        expResult.put(1.0, 1.0);
        this._tester.testGetWeights(this._instance, 1.0, interval, expResult);

        expResult.put(0.0, -0.25);
        expResult.put(1.0, 1.25);
        this._tester.testGetWeights(this._instance, 1.25, interval, expResult);

        expResult.put(0.0, -0.5);
        expResult.put(1.0, 1.5);
        this._tester.testGetWeights(this._instance, 1.5, interval, expResult);

        interval.setUpperBound(0.0);
        expResult.clear();
        expResult.put(0.0, 1.0);
        this._tester.testGetWeights(this._instance, -0.5, interval, expResult);
        this._tester.testGetWeights(this._instance, 0.0, interval, expResult);
        this._tester.testGetWeights(this._instance, 0.5, interval, expResult);
        this._tester.testGetWeights(this._instance, 1.0, interval, expResult);
        this._tester.testGetWeights(this._instance, 1.5, interval, expResult);
    }

    /**
     * Test of getWeights method, of class LinearReal for a null valued interval.
     */
    @Test (expected=NullPointerException.class)
    public void testGetWeights_IntervalNull() {
        System.out.println("getWeights(t, null)");
        this._tester.testGetWeights(this._instance, 0.0, null, null);
    }

    /**
     * Test of getWeights method, of class LinearReal, for a misspecified interval.
     */
    @Test (expected=ArithmeticException.class)
    public void testGetWeights_IntervalWronglyBounded() {
        System.out.println("getWeights(t, misspecified interval)");
        Interval<Double> interval = new IntervalReal(
                1.0, Interval.EndType.Includes, 0.0, Interval.EndType.Includes);
        this._tester.testGetWeights(this._instance, 0.0, interval, null);
    }

    /**
     * Test of getWeights method, of class LinearReal for an invalid target value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testGetWeights_TargetNaN() {
        System.out.println("getWeights(Double.NaN, i)");
        Interval<Double> interval = new IntervalReal(
                0.0, Interval.EndType.Includes, 1.0, Interval.EndType.Includes);
        this._tester.testGetWeights(this._instance, Double.NaN, interval, null);
    }
}
