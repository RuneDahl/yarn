/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.*;
import Mathematics.Equality.DoubleAbsolute;
import Mathematics.Function.*;
import Mathematics.Result.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test of the class Mathematics.Function.Integration.AdaptiveRealReal.
 * @author Rune Dahl Iversen
 */
public class AdaptiveRealRealTest {
    private DoubleAbsolute _criterion6;
    private DoubleAbsolute _criterion8;

    private Interval<Double> _unitInterval;

    private AdaptiveRealReal _lefthand;
    private AdaptiveRealReal _midpoint;
    private AdaptiveRealReal _righthand;
    private AdaptiveRealReal _trapezoid;
    private AdaptiveRealReal _tunable;

    private Function<Double, Double> _functionPoly;
    private Function<Double, Double> _sine;

    public AdaptiveRealRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.Integration.AdaptiveRealReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        double[] coefficients = new double[] { -1.0, 2.0, 0.5 };
        this._functionPoly = new PolynomialReal(coefficients);
        this._sine = new SineReal(1.0, Math.PI, 0.0);

        this._unitInterval = new IntervalReal(0.0, Interval.EndType.Includes, 1.0, Interval.EndType.Includes);

        this._criterion6 = new DoubleAbsolute(Math.pow(10.0, -6.0));
        this._criterion8 = new DoubleAbsolute(Math.pow(10.0, -8.0));

        this._lefthand = new AdaptiveRealReal(15, 1, 2,
                new LefthandEvaluatorRealReal(), this._unitInterval, this._criterion8);
        this._midpoint = new AdaptiveRealReal(25, 1, 2,
                new MidPointEvaluatorRealReal(), this._unitInterval, this._criterion6);
        this._righthand = new AdaptiveRealReal(15, 1, 2,
                new RighthandEvaluatorRealReal(), this._unitInterval, this._criterion6);
        this._trapezoid = new AdaptiveRealReal(20, 1, 2,
                new TrapezoidEvaluatorRealReal(), this._unitInterval, this._criterion8);
        this._tunable = new AdaptiveRealReal(20, 1, 2,
                new TunableEvaluatorRealReal(1.0, 0.5), this._unitInterval, this._criterion8);
    }

    @After
    public void tearDown() {
        this._functionPoly = null;
        this._sine = null;
        this._unitInterval = null;
        this._criterion6 = null;
        this._criterion8 = null;
        this._lefthand = null;
        this._midpoint = null;
        this._righthand = null;
        this._trapezoid = null;
        this._tunable = null;
    }

    /**
     * Test of getCriterion method, of class AdaptiveRealReal.
     */
    @Test
    public void testGetCriterion() {
        System.out.println("getCriterion");
        AdaptiveRealReal instance = this._tunable;
        DoubleAbsolute result = instance.getCriterion();
        assertEquals("Wrong precision in equality.", Math.pow(-10.0, -8.0), result.getPrecision(), 0.0);
    }

    /**
     * Test of setCriterion method, of class AdaptiveRealReal.
     */
    @Test
    public void testSetCriterion() {
        System.out.println("setCriterion");
        DoubleAbsolute criterion = this._criterion6;
        AdaptiveRealReal instance = this._tunable;
        instance.setCriterion(criterion);

        DoubleAbsolute result = instance.getCriterion();
        assertEquals("Wrong precision in equality.", Math.pow(-10.0, -6.0), result.getPrecision(), 0.0);
    }

    /**
     * Test of setCriterion method, of class AdaptiveRealReal, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetCriterion_Null() {
        System.out.println("setCriterion(null)");
        DoubleAbsolute criterion = null;
        AdaptiveRealReal instance = this._tunable;
        instance.setCriterion(criterion);
    }

    /**
     * Test of getEvaluator method, of class AdaptiveRealReal.
     */
    @Test
    public void testGetEvaluator() {
        System.out.println("getEvaluator");
        AdaptiveRealReal instance = this._tunable;
        Evaluator result = instance.getEvaluator();
        assertTrue("Wrong class of evaluator.", result instanceof TunableEvaluatorRealReal);
        TunableEvaluatorRealReal terr = (TunableEvaluatorRealReal)result;
        assertEquals("Wrong gain from tunable evaluator.", 1.0, terr.getGain(), 0.0);
        assertEquals("Wrong phase from tunable evaluator.", 0.5, terr.getPhase(), 0.0);
    }

    /**
     * Test of setEvaluator method, of class AdaptiveRealReal.
     */
    @Test
    public void testSetEvaluator() {
        System.out.println("setEvaluator");
        Evaluator<Function<Double, Double>, Interval<Double>, Double> evaluator = new MidPointEvaluatorRealReal();
        AdaptiveRealReal instance = this._tunable;
        instance.setEvaluator(evaluator);
        assertTrue("Wrong class of evaluator.", instance.getEvaluator() instanceof MidPointEvaluatorRealReal);
    }

    /**
     * Test of setEvaluator method, of class AdaptiveRealReal, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetEvaluator_Null() {
        System.out.println("setEvaluator(null)");
        Evaluator<Function<Double, Double>, Interval<Double>, Double> evaluator = null;
        AdaptiveRealReal instance = this._tunable;
        instance.setEvaluator(evaluator);
    }

    /**
     * Test of getMaximumIterations method, of class AdaptiveRealReal.
     */
    @Test
    public void testGetMaximumIterations() {
        System.out.println("getMaximumIterations");
        AdaptiveRealReal instance = this._tunable;
        assertEquals("Wrong number of maximum iterations", 20, instance.getMaximumIterations());
    }

    /**
     * Test of setMaximumIterations method, of class AdaptiveRealReal.
     */
    @Test
    public void testSetMaximumIterations() {
        System.out.println("setMaximumIterations");
        AdaptiveRealReal instance = this._tunable;
        instance.setMaximumIterations(6);
        assertEquals("Wrong number of maximum iterations", 6, instance.getMaximumIterations());
    }

    /**
     * Test of getInitialSplits method, of class AdaptiveRealReal.
     */
    @Test
    public void testGetInitialSplits() {
        System.out.println("getInitialSplits");
        AdaptiveRealReal instance = this._tunable;
        assertEquals("Wrong number of initial splits", 1, instance.getInitialSplits());
    }

    /**
     * Test of setInitialSplits method, of class AdaptiveRealReal.
     */
    @Test
    public void testSetInitialSplits() {
        System.out.println("setInitialSplits");
        AdaptiveRealReal instance = this._tunable;
        instance.setInitialSplits(2);
        assertEquals("Wrong number of initial splits", 2, instance.getInitialSplits());
    }

    /**
     * Test of setInitialSplits method, of class AdaptiveRealReal, to 0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetInitialSplits_Negative() {
        System.out.println("setInitialSplits(-2)");
        AdaptiveRealReal instance = this._tunable;
        instance.setInitialSplits(-2);
        fail("No exception thrown.");
    }

    /**
     * Test of setInitialSplits method, of class AdaptiveRealReal, to 0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetInitialSplits_Zero() {
        System.out.println("setInitialSplits(0)");
        AdaptiveRealReal instance = this._tunable;
        instance.setInitialSplits(0);
        fail("No exception thrown.");
    }

    /**
     * Test of getIterativeSplits method, of class AdaptiveRealReal.
     */
    @Test
    public void testGetIterativeSplits() {
        System.out.println("getIterativeSplits");
        AdaptiveRealReal instance = this._tunable;
        assertEquals("Wrong number of iterative splits", 2, instance.getIterativeSplits());
    }

    /**
     * Test of setIterativeSplits method, of class AdaptiveRealReal.
     */
    @Test
    public void testSetIterativeSplits() {
        System.out.println("setIterativeSplits");
        AdaptiveRealReal instance = this._tunable;
        instance.setIterativeSplits(4);
        assertEquals("Wrong number of iterative splits", 4, instance.getIterativeSplits());
    }

    /**
     * Test of setInitialSplits method, of class AdaptiveRealReal, to a negative value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetIterativeSplits_Negative() {
        System.out.println("setIterativeSplits(-2)");
        AdaptiveRealReal instance = this._tunable;
        instance.setIterativeSplits(-2);
        fail("No exception thrown.");
    }

    /**
     * Test of setIterativeSplits method, of class AdaptiveRealReal, to 0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetIterativeSplits_Zero() {
        System.out.println("setIterativeSplits(0)");
        AdaptiveRealReal instance = this._tunable;
        instance.setIterativeSplits(0);
        fail("No exception thrown.");
    }

    /**
     * Test of setIterativeSplits method, of class AdaptiveRealReal, to 1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetIterativeSplits_One() {
        System.out.println("setIterativeSplits(1)");
        AdaptiveRealReal instance = this._tunable;
        instance.setIterativeSplits(1);
        fail("No exception thrown.");
    }

    /**
     * Test of getRegion method, of class AdaptiveRealReal.
     */
    @Test
    public void testGetRegion() {
        System.out.println("getRegion");
        AdaptiveRealReal instance = this._tunable;
        Interval expResult = new IntervalReal(
                0.0, Interval.EndType.Includes,
                1.0, Interval.EndType.Includes);
        Interval result = instance.getRegion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegion method, of class AdaptiveRealReal.
     */
    @Test
    public void testSetRegion() {
        System.out.println("setRegion");
        Interval<Double> interval = new IntervalReal(
                -7.4, Interval.EndType.Excludes,
                Math.PI, Interval.EndType.Excludes);
        AdaptiveRealReal instance = this._tunable;
        instance.setRegion(interval);
        Interval<Double> expected = new IntervalReal(
                -7.4, Interval.EndType.Excludes,
                Math.PI, Interval.EndType.Excludes);
        assertEquals(expected, interval);
    }

    /**
     * Test of setRegion method, of class AdaptiveRealReal, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetRegion_Null() {
        System.out.println("setRegion(null)");
        Interval<Double> interval = null;
        Integrator<Function<Double, Double>, Interval<Double>> instance = this._tunable;
        instance.setRegion(interval);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class AdaptiveRealReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");

        final DoubleAbsolute precision = new DoubleAbsolute(Math.pow(10.0, -6.0));

        final double poly = 1.0/6.0;
        final double sine = 2.0/Math.PI;

        AdaptiveRealReal instance = this._tunable;
        Result result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+Tunable.", result instanceof IterativeSuccess);
        IterativeSuccess<Double> is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result poly+Tunable.", 20, is.getIterations());
        assertTrue("Wrong value of result poly+Tunable.", precision.value(poly, is.getResult()));

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+Tunable.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result sine+Tunable.", 20, is.getIterations());
        assertTrue("Wrong value of result sine+Tunable.", precision.value(sine, is.getResult()));

        instance = this._trapezoid;
        result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+Trapezoid.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result poly+Trapezoid.", 20, is.getIterations());
        assertTrue("Wrong value of result poly+Trapezoid.", precision.value(poly, is.getResult()));

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+Trapezoid.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result sine+Trapezoid.", 20, is.getIterations());
        assertTrue("Wrong value of result sine+Trapezoid.", precision.value(sine, is.getResult()));

        instance = this._righthand;
        result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+RightHand.", result instanceof MaximumIterationsFailure);
        MaximumIterationsFailure mif = (MaximumIterationsFailure)result;
        assertEquals("Wrong number of iterations of result poly+RightHand.", 16, mif.getIterations());

        instance.setMaximumIterations(25);
        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+RightHand.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result sine+RightHand.", 25, is.getIterations());
        assertTrue("Wrong value of result sine+RightHand.", precision.value(sine, is.getResult()));

        instance = this._midpoint;
        result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+MidPoint.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result poly+MidPoint.", 25, is.getIterations());
        assertTrue("Wrong value of result poly+MidPoint.", precision.value(poly, is.getResult()));

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+MidPoint.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result sine+MidPoint.", 25, is.getIterations());
        assertTrue("Wrong value of result sine+MidPoint.", precision.value(sine, is.getResult()));

        instance = this._lefthand;
        result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+LeftHand.", result instanceof MaximumIterationsFailure);
        mif = (MaximumIterationsFailure)result;
        assertEquals("Wrong number of iterations of result poly+LeftHand.", 16, mif.getIterations());

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+LeftHand.", result instanceof MaximumIterationsFailure);
        mif = (MaximumIterationsFailure)result;
        assertEquals("Wrong number of iterations of result sine+LeftHand.", 16, mif.getIterations());
    }

    /**
     * Test of value method, of class AdaptiveRealReal, for the value null.
     */
    @Test
    public void testValue_Null() {
        System.out.println("value(null)");
        Result result = this._tunable.value(null);
        assertTrue("Wrong class of result.", result instanceof UnhandledExceptionThrown);
        UnhandledExceptionThrown uet = (UnhandledExceptionThrown)result;
        assertTrue("Wrong class of exception in result.", uet.getException() instanceof NullPointerException);
    }
}
