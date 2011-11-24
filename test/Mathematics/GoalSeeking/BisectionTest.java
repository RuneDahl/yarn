/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

import Mathematics.*;
import Mathematics.Algorithm.*;
import Mathematics.Equality.*;
import Mathematics.Function.*;
import Mathematics.Result.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.GoalSeeking.Bisection.
 * @author Rune Dahl Iversen
 */
public class BisectionTest {
    private Bisection _instance;
    private Function<Double, Double> _poly;
    private GoalSeekFunctionTest<Interval<Double>, Double, Double> _tester;
    
    public BisectionTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.GoalSeeking.Bisection");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new GoalSeekFunctionTest<Interval<Double>, Double, Double>();
        double[] values = new double[3];
        values[0] = -1.0;
        values[2] = 1.0;
        this._poly = new PolynomialReal(values);
        Interval<Double> initialValue = new IntervalReal(
                0.0, Interval.EndType.Includes,
                4.0, Interval.EndType.Includes);
        Equals<Double> criterion = new DoubleAbsolute(Math.pow(10.0, -6.0));
        this._instance = new Bisection(this._poly,
                Math.sqrt(2.0), initialValue, criterion, 40);
    }

    @After
    public void tearDown() {
        this._tester = null;
        this._instance = null;
        this._poly = null;
    }

    /**
     * Test of getCriterion method, of class Bisection.
     */
    @Test
    public void testGetCriterion() {
        System.out.println("getCriterion");
        Bisection instance = this._instance;
        Equals result = instance.getCriterion();
        assertTrue(result instanceof DoubleAbsolute);
        DoubleAbsolute da = (DoubleAbsolute)result;
        assertEquals(Math.pow(10.0, -6.0), da.getPrecision(), 0.0);
    }

    /**
     * Test of getGoalValue method, of class Bisection.
     */
    @Test
    public void testGetGoalValue() {
        System.out.println("getGoalValue");
        this._tester.testGetGoalValue(this._instance, Math.sqrt(2.0));
    }

    /**
     * Test of getInitialValue method, of class Bisection.
     */
    @Test
    public void testGetInitialValue() {
        System.out.println("getInitialValue");
        Interval expResult = new IntervalReal(
                0.0, Interval.EndType.Includes,
                4.0, Interval.EndType.Includes);
        this._tester.testGetInitialValue(this._instance, expResult);
    }

    /**
     * Test of getMaximumIterations method, of class Bisection.
     */
    @Test
    public void testGetMaximumIterations() {
        System.out.println("getMaximumIterations");
        Bisection instance = this._instance;
        int expResult = 40;
        int result = instance.getMaximumIterations();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCriterion method, of class Bisection.
     */
    @Test
    public void testSetCriterion() {
        System.out.println("setCriterion");
        Bisection instance = this._instance;
        Equals<Double> criterion = new DoubleRelative(Math.pow(10.0, -4.0));
        instance.setCriterion(criterion);
        Equals<Double> result = instance.getCriterion();
        assertTrue(result instanceof DoubleRelative);
        DoubleRelative da = (DoubleRelative)result;
        assertEquals(Math.pow(10.0, -4.0), da.getPrecision(), 0.0);
    }

    /**
     * Test of setCriterion method, of class Bisection, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetCriterion_Null() {
        System.out.println("setCriterion(null)");
        this._tester.testSetCriterion(this._instance, null);
    }

    /**
     * Test of setFunction method, of class Bisection, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetFunction_Null() {
        System.out.println("setFunction(null)");
        this._tester.testSetFunction(this._instance, null);
    }

    /**
     * Test of setGoalValue method, of class Bisection.
     */
    @Test
    public void testSetGoalValue() {
        System.out.println("setGoalValue");
        this._tester.testSetGoalValue(this._instance, 7.45);
    }

    /**
     * Test of setGoalValue method, of class Bisection, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetGoalValue_Null() {
        System.out.println("setGoalValue(null)");
        this._tester.testSetGoalValue(this._instance, null);
    }

    /**
     * Test of setInitialValue method, of class Bisection.
     */
    @Test
    public void testSetInitialValue() {
        System.out.println("setInitialValue");
        Interval<Double> initialValue = new IntervalReal(
                -1.0, Interval.EndType.Includes,
                1.0, Interval.EndType.Includes);
        this._tester.testSetInitialValue(this._instance, initialValue);
    }

    /**
     * Test of setInitialValue method, of class Bisection, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetInitialValue_Null() {
        System.out.println("setInitialValue(null)");
        this._tester.testSetInitialValue(this._instance, null);
    }

    /**
     * Test of setMaximumIterations method, of class Bisection.
     */
    @Test
    public void testSetMaximumIterations() {
        System.out.println("setMaximumIterations");
        int iterations = 10;
        Bisection instance = this._instance;
        instance.setMaximumIterations(iterations);
    }

    /**
     * Test of setMaximumIterations method, of class Bisection,
     * for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetMaximumIterations_Zero() {
        System.out.println("setMaximumIterations(null)");
        int iterations = 0;
        Bisection instance = this._instance;
        instance.setMaximumIterations(iterations);
    }

    /**
     * Test of run method, of class Bisection.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Algorithm<Result> instance = this._instance;
        Result result = instance.run();
        assertTrue("Wrong type of result.", result instanceof IterativeSuccess);
        IterativeSuccess<Double> is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations from result.", 21, is.getIterations());
        assertEquals("Wrong value from result.", 1.553773974403, is.getResult(), Math.pow(-10.0, -6.0));
    }

    /**
     * Test of run method, of class Bisection, resulting in a maximum iterations
     * result.
     */
    @Test
    public void testRun_MaximumIterations() {
        System.out.println("run(maximum iterations)");
        Algorithm<Result> instance = this._instance;
        this._instance.setMaximumIterations(20);
        Result result = instance.run();
        assertTrue("Maximum Iterations hit: Wrong type of result.", result instanceof MaximumIterationsFailure);
        MaximumIterationsFailure mif = (MaximumIterationsFailure)result;
    }
    
    /**
     * Test of run method, of class Bisection, resulting in an initial hit on
     * the lower bound.
     */
    @Test
    public void testRun_InitialHit_LowerBound() {
        System.out.println("run(initial hit - lower bound");
        Algorithm<Result> instance = this._instance;
        this._instance.setGoalValue(-1.0);
        Result result = instance.run();

        assertTrue("Initial hit: Lower Bound - Wrong type of result.", result instanceof SuccessWithValue);
        SuccessWithValue<Double> swv = (SuccessWithValue<Double>)result;
        assertEquals("Initial hit: Lower Bound - Wrong value from result.", 0.0, swv.getResult(), Math.pow(-10.0, -6.0));
    }
    
    /**
     * Test of run method, of class Bisection, resulting in an initial hit on
     * the upper bound.
     */
    @Test
    public void testRun_InitialHit_UpperBound() {
        System.out.println("run(initial hit - upper bound)");
        Algorithm<Result> instance = this._instance;
        this._instance.setGoalValue(15.0);
        Result result = instance.run();
        assertTrue("Initial hit: Upper Bound - Wrong type of result.", result instanceof SuccessWithValue);
        SuccessWithValue<Double>swv = (SuccessWithValue<Double>)result;
        assertEquals("Initial hit: Upper Bound - Wrong value from result.", 4.0, swv.getResult(), Math.pow(-10.0, -6.0));
    }
    
    /**
     * Test of run method, of class Bisection, resulting in a solution not enclosed.
     */
    @Test
    public void testRun_SolutionNotEnclosed() {
        System.out.println("run(solution not enclosed)");
        Algorithm<Result> instance = this._instance;
        this._instance.setInitialValue(
                new IntervalReal(100.0, Interval.EndType.Includes,
                102.0, Interval.EndType.Includes));
        Result result = instance.run();
        assertTrue("Solution not enclosed - Wrong type of result.", result instanceof SolutionNotEnclosedFailure);
        SolutionNotEnclosedFailure<Double, Double> snef = (SolutionNotEnclosedFailure<Double, Double>)result;
        assertEquals("Solution not enclosed - Wrong goal value from result.", Math.sqrt(2.0), snef.getGoalValue(), Math.pow(-10.0, -6.0));
        Polynomial<Double, Double, Double> f = new PolynomialReal(2);
        f = f.setCoefficient(0, -1.0);
        f = f.setCoefficient(2, 1.0);
        assertEquals("Solution not enclosed - Wrong function from result.", f, snef.getFunction());
    }
    
    /**
     * Test of run method, of class Bisection, resulting in a resolution not
     * fine enough.
     */
    @Test
    public void testRun_ResolutionNotFineEnough() {
        System.out.println("run(resolution not fine enough)");
        Algorithm<Result> instance = this._instance;
        this._instance.setInitialValue(
                new IntervalReal(3000.0, Interval.EndType.Includes,
                4000.0, Interval.EndType.Includes));
        this._instance.setMaximumIterations(300);
        this._instance.setGoalValue(15000000.0);
        ((PrecisionBased)this._instance.getCriterion()).setPrecision(Math.pow(10.0, -12.0));
        Result result = instance.run();
        assertTrue("Resolution not fine enough - Wrong type of result.", result instanceof ResolutionNotFineEnough);
        ResolutionNotFineEnough<Double, Double> rnfe = (ResolutionNotFineEnough<Double, Double>)result;
        IntervalReal interval = new IntervalReal(
                3872.9834753068594, Interval.EndType.Includes,
                3872.98347530686, Interval.EndType.Includes);
        assertEquals("Resolution not fine enough - Wrong value from result.", interval, rnfe.getInterval());
    }

    /**
     * Test of run method, of class Bisection, with an exception thrown.
     */
    @Test
    public void testRun_Exception() {
        System.out.println("run throwing Exception");
        this._instance.setFunction(new ExceptionThrower<Double, Double>());
        Algorithm<Result> instance = this._instance;
        Result result = instance.run();
        assertTrue("Wrong type of result.", result instanceof UnhandledExceptionThrown);
        UnhandledExceptionThrown uet = (UnhandledExceptionThrown)result;
        assertTrue("Wrong type of Exception.", uet.getException() instanceof UnsupportedOperationException);
    }
}
