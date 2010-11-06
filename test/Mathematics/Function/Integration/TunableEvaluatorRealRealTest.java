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
 *
 * @author Rune Dahl Iversen
 */
public class TunableEvaluatorRealRealTest {
    TunableEvaluatorRealReal _evaluator;
    private Interval<Double> _interval;
    private Function<Double, Double> _poly;
    private Function<Double, Double> _sine;

    public TunableEvaluatorRealRealTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this._evaluator = new TunableEvaluatorRealReal(2.0, 0.35);
        this._interval = new DoubleInterval(
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
     * Test of getGain method, of class TunableEvaluatorRealReal.
     */
    @Test
    public void testGetGain() {
        System.out.println("getGain");
        assertEquals(2.0, this._evaluator.getGain(), 0.0);
    }

    /**
     * Test of getPhase method, of class TunableEvaluatorRealReal.
     */
    @Test
    public void testGetPhase() {
        System.out.println("getPhase");
        assertEquals(0.35, this._evaluator.getPhase(), 0.0);
    }

    /**
     * Test of setGain method, of class TunableEvaluatorRealReal.
     */
    @Test
    public void testSetGain() {
        System.out.println("setGain");
        this._evaluator.setGain(0.0);
        assertEquals(0.0, this._evaluator.getGain(), 0.0);
    }

    /**
     * Test of setGain method, of class TunableEvaluatorRealReal
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetGainNaN() {
        System.out.println("setGain to Double.NaN");
        this._evaluator.setGain(Double.NaN);
        fail("Expected exception not thrown.");
    }

    /**
     * Test of setGain method, of class TunableEvaluatorRealReal
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetGainPositiveInfinity() {
        System.out.println("setGain to Double.POSITIVE_INFINITY");
        this._evaluator.setGain(Double.POSITIVE_INFINITY);
        fail("Expected exception not thrown.");
    }

    /**
     * Test of setGain method, of class TunableEvaluatorRealReal
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetGainNegativeInfinity() {
        System.out.println("setGain to Double.NEGATIVE_INFINITY");
        this._evaluator.setGain(Double.NEGATIVE_INFINITY);
        fail("Expected exception not thrown.");
    }

    /**
     * Test of setPhase method, of class TunableEvaluatorRealReal.
     */
    @Test
    public void testSetPhase() {
        System.out.println("setPhase");
        this._evaluator.setPhase(0.0);
        assertEquals(0.0, this._evaluator.getPhase(), 0.0);
    }

    /**
     * Test of setPhase method, of class TunableEvaluatorRealReal
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPhaseNaN() {
        System.out.println("setPhase to Double.NaN");
        this._evaluator.setPhase(Double.NaN);
        fail("Expected exception not thrown.");
    }

    /**
     * Test of setPhase method, of class TunableEvaluatorRealReal
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPhasePositiveInfinity() {
        System.out.println("setPhase to Double.POSITIVE_INFINITY");
        this._evaluator.setPhase(Double.POSITIVE_INFINITY);
        fail("Expected exception not thrown.");
    }

    /**
     * Test of setPhase method, of class TunableEvaluatorRealReal
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPhaseNegativeInfinity() {
        System.out.println("setPhase to Double.NEGATIVE_INFINITY");
        this._evaluator.setPhase(Double.NEGATIVE_INFINITY);
        fail("Expected exception not thrown.");
    }

    /**
     * Test of value method, of class TunableEvaluatorRealReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        double expResult = 1.25;
        double precision = Math.pow(10.0, -8);
        assertEquals(
                expResult,
                this._evaluator.value(this._poly, this._interval),
                precision);

        expResult = 1.3 * Math.sin(1.0);
        assertEquals(
                expResult,
                this._evaluator.value(this._sine, this._interval),
                precision);
    }
}