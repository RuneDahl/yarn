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
        Interval<Double> initialValue = new IntervalReal(
                0.0, Interval.EndType.Includes,
                4.0, Interval.EndType.Includes);
        Equals<Double> criterion = new DoubleAbsolute(Math.pow(10.0, -6.0));
        this._instance = new Bisection(Math.sqrt(2.0), initialValue, criterion, 40);
    }

    @After
    public void tearDown() {
        this._instance = null;
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
        Bisection instance = this._instance;
        Double expResult = Math.sqrt(2.0);
        Double result = instance.getGoalValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitialValue method, of class Bisection.
     */
    @Test
    public void testGetInitialValue() {
        System.out.println("getInitialValue");
        Bisection instance = this._instance;
        Interval expResult = new IntervalReal(
                0.0, Interval.EndType.Includes,
                4.0, Interval.EndType.Includes);
        Interval result = instance.getInitialValue();
        assertEquals(expResult, result);
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
        Bisection instance = this._instance;
        Equals<Double> criterion = null;
        instance.setCriterion(criterion);
    }

    /**
     * Test of setGoalValue method, of class Bisection.
     */
    @Test
    public void testSetGoalValue() {
        System.out.println("setGoalValue");
        Double value = 7.45;
        Bisection instance = this._instance;
        instance.setGoalValue(value);

        Double result = instance.getGoalValue();
        assertEquals(7.45, result, 0.0);
    }

    /**
     * Test of setGoalValue method, of class Bisection, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetGoalValue_Null() {
        System.out.println("setGoalValue(null)");
        Double value = null;
        Bisection instance = this._instance;
        instance.setGoalValue(value);
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
        Bisection instance = this._instance;
        instance.setInitialValue(initialValue);

        Interval result = instance.getInitialValue();
        Interval<Double> expResult = new IntervalReal(
                -1.0, Interval.EndType.Includes,
                1.0, Interval.EndType.Includes);
        assertEquals(expResult, result);
    }

    /**
     * Test of setInitialValue method, of class Bisection, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetInitialValue_Null() {
        System.out.println("setInitialValue(null)");
        Interval<Double> initialValue = null;
        Bisection instance = this._instance;
        instance.setInitialValue(initialValue);
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
        double[] values = new double[3];
        values[0] = -1.0;
        values[2] = 1.0;
        Function<Double, Double> value = new PolynomialReal(values);
        Algorithm<Function<Double, Double>> instance = this._instance;
        Result result = instance.run(value);
        assertTrue("Wrong type of result.", result instanceof IterativeSuccess);
        IterativeSuccess<Double> is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations from result.", 21, is.getIterations());
        assertEquals("Wrong value from result.", 1.553773974403, is.getResult(), Math.pow(-10.0, -6.0));

        this._instance.setMaximumIterations(20);
        result = instance.run(value);
        assertTrue("Maximum Iterations hit: Wrong type of result.", result instanceof MaximumIterationsFailure);
        MaximumIterationsFailure mif = (MaximumIterationsFailure)result;

        this._instance.setMaximumIterations(40);
        this._instance.setGoalValue(-1.0);

        result = instance.run(value);
        assertTrue("Initial hit: Lower Bound - Wrong type of result.", result instanceof SuccessWithValue);
        SuccessWithValue<Double> swv = (SuccessWithValue<Double>)result;
        assertEquals("Initial hit: Lower Bound - Wrong value from result.", 0.0, swv.getResult(), Math.pow(-10.0, -6.0));

        this._instance.setGoalValue(15.0);
        result = instance.run(value);
        assertTrue("Initial hit: Upper Bound - Wrong type of result.", result instanceof SuccessWithValue);
        swv = (SuccessWithValue<Double>)result;
        assertEquals("Initial hit: Upper Bound - Wrong value from result.", 4.0, swv.getResult(), Math.pow(-10.0, -6.0));

        this._instance.setInitialValue(
                new IntervalReal(0.0, Interval.EndType.Includes,
                2.0, Interval.EndType.Includes));
        result = instance.run(value);
        assertTrue("Solution not enclosed - Wrong type of result.", result instanceof SolutionNotEnclosedFailure);
        SolutionNotEnclosedFailure<Double, Double> snef = (SolutionNotEnclosedFailure<Double, Double>)result;
        assertEquals("Solution not enclosed - Wrong goal value from result.", 15.0, snef.getGoalValue(), Math.pow(-10.0, -6.0));
        Polynomial<Double, Double, Double> f = new PolynomialReal(2);
        f = f.setCoefficient(0, -1.0);
        f = f.setCoefficient(2, 1.0);
        assertEquals("Solution not enclosed - Wrong function from result.", f, snef.getFunction());
    }

    /**
     * Test of run method, of class Bisection, for a null value.
     */
    @Test
    public void testRun_Null() {
        System.out.println("run(null)");
        Function<Double, Double> value = null;
        Algorithm<Function<Double, Double>> instance = this._instance;
        Result result = instance.run(value);
        assertTrue("Wrong type of result.", result instanceof UnhandledExceptionThrown);
        UnhandledExceptionThrown uht = (UnhandledExceptionThrown)result;
        assertTrue("Class of exception from result.", uht.getException() instanceof NullPointerException);
    }
}