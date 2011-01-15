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
 * jUnit-test for LefthandEvaluatorRealReal.
 * @author Rune Dahl Iversen
 */
public class LefthandEvaluatorRealRealTest {
    private Evaluator<Function<Double,Double>, Interval<Double>, Double> _evaluator;
    private Interval<Double> _interval;
    private Function<Double, Double> _poly;
    private Function<Double, Double> _sine;

    public LefthandEvaluatorRealRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._evaluator = new LefthandEvaluatorRealReal();
        this._interval = new IntervalReal(
                0.0, Interval.EndType.Includes,
                1.0, Interval.EndType.Includes);
        double[] coefficients = new double[] { -1.0, 2.0, 0.5 };
        this._poly = new PolynomialReal(coefficients);
        this._sine = new SineReal();
    }

    @After
    public void tearDown() {
        this._evaluator = null;
        this._interval = null;
        this._poly = null;
        this._sine = null;
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
        assertEquals(-1.0, result, 0.0); // Poly(0) = -1.

        function = this._sine;

        result = this._evaluator.value(function, interval);
        assertEquals(0.0, result, 0.0); // Sine(0) == 0.
    }

    /**
     * Test of value method, of class LefthandEvaluatorRealReal
     * for a function that is null.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_FunctionNull() {
        System.out.println("value(null, i)");
        this._evaluator.value(null, this._interval);
    }
    /**
     * Test of value method, of class LefthandEvaluatorRealReal
     * for an interval that is null.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_IntervalNull() {
        System.out.println("value(f, null)");
        this._evaluator.value(this._poly, null);
    }

    /**
     * Test of value method, of class LefthandEvaluatorRealReal
     * for two null values.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null_BothValues() {
        System.out.println("value(null, null)");
        this._evaluator.value(null, null);
    }
}