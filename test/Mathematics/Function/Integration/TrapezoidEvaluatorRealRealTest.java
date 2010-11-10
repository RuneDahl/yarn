/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.*;
import Mathematics.Function.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for TrapezoidEvaluatorRealReal.
 * @author Rune Dahl Iversen
 */
public class TrapezoidEvaluatorRealRealTest {
    private Evaluator<Function<Double,Double>, Interval<Double>, Double> _evaluator;
    private Interval<Double> _interval;
    private Function<Double, Double> _poly;
    private Function<Double, Double> _sine;

    public TrapezoidEvaluatorRealRealTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this._evaluator = new TrapezoidEvaluatorRealReal();
        this._interval = new IntervalReal(
                0.0, Interval.EndType.Includes,
                1.0, Interval.EndType.Includes);
        double[] coefficients = new double[] { -1.0, 2.0, 0.5 };
        this._poly = new PolynomialReal(coefficients);
        this._sine = new SineReal();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of value method, of class LefthandEvaluatorRealReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Function<Double, Double> function = this._poly;
        Interval<Double> interval = this._interval;

        Double result = this._evaluator.value(function, interval);
        assertEquals(0.25, result, 0.0); // (Poly(0) = -1 + Poly(1) = 1.5)/2.

        function = this._sine;

        result = this._evaluator.value(function, interval);
        assertEquals(Math.sin(1.0)/2.0, result, 0.0); // Sine(1)/2.
    }

    /**
     * Test of value method, of class LefthandEvaluatorRealReal
     * for a function that is null.
     */
    @Test (expected=NullPointerException.class)
    public void testValueFunctionNull() {
        System.out.println("value of function that is null");
        Double result = this._evaluator.value(null, this._interval);
        fail("Expected exception not thrown.");
    }
    /**
     * Test of value method, of class LefthandEvaluatorRealReal
     * for an interval that is null.
     */
    @Test (expected=NullPointerException.class)
    public void testValueIntervalNull() {
        System.out.println("value of interval that is null");
        Double result = this._evaluator.value(this._poly, null);
        fail("Expected exception not thrown.");
    }
}