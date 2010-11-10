/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function.Integration;

import Mathematics.*;
import Mathematics.Convergence.*;
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
 * jUnit-test of the class Mathematics.Function.Integration.CompositeRealReal.
 * @author Rune Dahl Iversen
 */
public class CompositeRealRealTest {
    private Criterion<Double> _criterion6;
    private Criterion<Double> _criterion8;
    
    private Interval<Double> _unitInterval;

    private CompositeRealReal _lefthand;
    private CompositeRealReal _midpoint;
    private CompositeRealReal _righthand;
    private CompositeRealReal _trapezoid;
    private CompositeRealReal _tunable;

    private Function<Double, Double> _functionPoly;
    private Function<Double, Double> _sine;

    public CompositeRealRealTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        double[] coefficients = new double[] { -1.0, 2.0, 0.5 };
        this._functionPoly = new PolynomialReal(coefficients);
        this._sine = new SineReal(1.0, Math.PI, 0.0);

        this._unitInterval = new IntervalReal(0.0, Interval.EndType.Includes, 1.0, Interval.EndType.Includes);

        this._criterion6 = new EqualsLastValue<Double>(new DoubleAbsolute(Math.pow(10.0, -6.0)), 2);
        this._criterion8 = new EqualsLastValue<Double>(new DoubleAbsolute(Math.pow(10.0, -8.0)), 2);

        this._lefthand = new CompositeRealReal(15, 1, 2,
                new LefthandEvaluatorRealReal(), this._unitInterval, this._criterion8);
        this._midpoint = new CompositeRealReal(25, 1, 2,
                new MidPointEvaluatorRealReal(), this._unitInterval, this._criterion6);
        this._righthand = new CompositeRealReal(15, 1, 2,
                new RighthandEvaluatorRealReal(), this._unitInterval, this._criterion6);
        this._trapezoid = new CompositeRealReal(20, 1, 2,
                new TrapezoidEvaluatorRealReal(), this._unitInterval, this._criterion8);
        this._tunable = new CompositeRealReal(20, 1, 2,
                new TunableEvaluatorRealReal(1.0, 0.5), this._unitInterval, this._criterion8);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCriterion method, of class Composite.
     */
    @Test
    public void testGetCriterion() {
        System.out.println("getCriterion");
        CompositeRealReal instance = this._tunable;
        Criterion result = instance.getCriterion();
        assertTrue("Wrong class of criterion.", result instanceof EqualsLastValue);
        EqualsLastValue<Double> elv = (EqualsLastValue<Double>)result;
        assertEquals("Wrong number of required equalities.", 2, elv.getNumberOfEqualities());
        assertTrue("Wrong class of equality in criterion.", elv.getEquals() instanceof DoubleAbsolute);
        DoubleAbsolute da = (DoubleAbsolute)elv.getEquals();
        assertEquals("Wrong precision in equality.", Math.pow(-10.0, -8.0), da.getPrecision(), 0.0);
    }

    /**
     * Test of setCriterion method, of class Composite.
     */
    @Test
    public void testSetCriterion() {
        System.out.println("setCriterion");
        Criterion<Double> criterion = this._criterion6;
        CompositeRealReal instance = this._tunable;
        instance.setCriterion(criterion);

        Criterion result = instance.getCriterion();
        assertTrue("Wrong class of criterion.", result instanceof EqualsLastValue);
        EqualsLastValue<Double> elv = (EqualsLastValue<Double>)result;
        assertEquals("Wrong number of required equalities.", 2, elv.getNumberOfEqualities());
        assertTrue("Wrong class of equality in criterion.", elv.getEquals() instanceof DoubleAbsolute);
        DoubleAbsolute da = (DoubleAbsolute)elv.getEquals();
        assertEquals("Wrong precision in equality.", Math.pow(-10.0, -6.0), da.getPrecision(), 0.0);
    }

    /**
     * Test of setCriterion method, of class Composite, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetCriterionNull() {
        System.out.println("setCriterion to null");
        Criterion<Double> criterion = null;
        CompositeRealReal instance = this._tunable;
        instance.setCriterion(criterion);
        fail("No exception thrown.");
    }

    /**
     * Test of getEvaluator method, of class Composite.
     */
    @Test
    public void testGetEvaluator() {
        System.out.println("getEvaluator");
        CompositeRealReal instance = this._tunable;
        Evaluator result = instance.getEvaluator();
        assertTrue("Wrong class of evaluator.", result instanceof TunableEvaluatorRealReal);
        TunableEvaluatorRealReal terr = (TunableEvaluatorRealReal)result;
        assertEquals("Wrong gain from tunable evaluator.", 1.0, terr.getGain(), 0.0);
        assertEquals("Wrong phase from tunable evaluator.", 0.5, terr.getPhase(), 0.0);
    }

    /**
     * Test of setEvaluator method, of class Composite.
     */
    @Test
    public void testSetEvaluator() {
        System.out.println("setEvaluator");
        Evaluator<Function<Double, Double>, Interval<Double>, Double> evaluator = new MidPointEvaluatorRealReal();
        CompositeRealReal instance = this._tunable;
        instance.setEvaluator(evaluator);
        assertTrue("Wrong class of evaluator.", instance.getEvaluator() instanceof MidPointEvaluatorRealReal);
    }

    /**
     * Test of setEvaluator method, of class Composite, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetEvaluatorNull() {
        System.out.println("setEvaluator to null");
        Evaluator<Function<Double, Double>, Interval<Double>, Double> evaluator = null;
        CompositeRealReal instance = this._tunable;
        instance.setEvaluator(evaluator);
        fail("No exception thrown.");
    }

    /**
     * Test of getInterval method, of class Composite.
     */
    @Test
    public void testGetInterval() {
        System.out.println("getInterval");
        CompositeRealReal instance = this._tunable;
        Interval expResult = new IntervalReal(
                0.0, Interval.EndType.Includes,
                1.0, Interval.EndType.Includes);
        Interval result = instance.getRegion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInterval method, of class Composite.
     */
    @Test
    public void testSetInterval() {
        System.out.println("setInterval");
        Interval<Double> interval = new IntervalReal(
                -7.4, Interval.EndType.Excludes,
                Math.PI, Interval.EndType.Excludes);
        CompositeRealReal instance = this._tunable;
        instance.setRegion(interval);
        Interval<Double> expected = new IntervalReal(
                -7.4, Interval.EndType.Excludes,
                Math.PI, Interval.EndType.Excludes);
        assertEquals(expected, interval);
    }

    /**
     * Test of setInterval method, of class Composite, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetIntervalNull() {
        System.out.println("setInterval to null");
        Interval<Double> interval = null;
        CompositeRealReal instance = this._tunable;
        instance.setRegion(interval);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class Composite.
     */
    @Test
    public void testValue() {
        System.out.println("value");

        final DoubleAbsolute precision = new DoubleAbsolute(Math.pow(10.0, -6.0));

        final double poly = 1.0/6.0;
        final double sine = 2.0/Math.PI;

        CompositeRealReal instance = this._tunable;
        Result result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+Tunable.", result instanceof IterativeSuccess);
        IterativeSuccess<Double> is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result poly+Tunable.", 15, is.getIterations());
        assertTrue("Wrong value of result poly+Tunable.", precision.Equal(poly, is.getResult()));

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+Tunable.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result sine+Tunable.", 16, is.getIterations());
        assertTrue("Wrong value of result sine+Tunable.", precision.Equal(sine, is.getResult()));

        instance = this._trapezoid;
        result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+Trapezoid.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result poly+Trapezoid.", 15, is.getIterations());
        assertTrue("Wrong value of result poly+Trapezoid.", precision.Equal(poly, is.getResult()));

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+Trapezoid.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result sine+Trapezoid.", 16, is.getIterations());
        assertTrue("Wrong value of result sine+Trapezoid.", precision.Equal(sine, is.getResult()));

        instance = this._righthand;
        result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+RightHand.", result instanceof MaximumIterationsFailure);
        MaximumIterationsFailure mif = (MaximumIterationsFailure)result;
        assertEquals("Wrong number of iterations of result poly+RightHand.", 15, mif.getIterations());

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+RightHand.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result sine+RightHand.", 13, is.getIterations());
        assertTrue("Wrong value of result sine+RightHand.", precision.Equal(sine, is.getResult()));

        instance = this._midpoint;
        result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+MidPoint.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result poly+MidPoint.", 11, is.getIterations());
        assertTrue("Wrong value of result poly+MidPoint.", precision.Equal(poly, is.getResult()));

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+MidPoint.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result sine+MidPoint.", 12, is.getIterations());
        assertTrue("Wrong value of result sine+MidPoint.", precision.Equal(sine, is.getResult()));

        instance = this._lefthand;
        result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+LeftHand.", result instanceof MaximumIterationsFailure);
        mif = (MaximumIterationsFailure)result;
        assertEquals("Wrong number of iterations of result poly+LeftHand.", 15, mif.getIterations());

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+LeftHand.", result instanceof MaximumIterationsFailure);
        mif = (MaximumIterationsFailure)result;
        assertEquals("Wrong number of iterations of result sine+LeftHand.", 15, mif.getIterations());
    }

    /**
     * Test of value method, of class Composite, for the value null.
     */
    @Test
    public void testValueNull() {
        System.out.println("value(null)");
        Result result = this._tunable.value(null);
        assertTrue("Wrong class of result.", result instanceof UnhandledExceptionThrown);
        UnhandledExceptionThrown uet = (UnhandledExceptionThrown)result;
        assertTrue("Wrong class of exception in result.", uet.getException() instanceof NullPointerException);
    }
}