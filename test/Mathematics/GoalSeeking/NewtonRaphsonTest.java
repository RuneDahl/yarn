/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.GoalSeeking;

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
 * jUnit test for the class Mathematics.GoalSeeking.NewtonRaphson.
 * @author Rune Dahl Iversen
 */
public class NewtonRaphsonTest {
    private NewtonRaphson _instance;
    private Function<Double, Double> _poly;
    private GoalSeekFunctionTest<Double, Double, Double> _tester;

    public NewtonRaphsonTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.GoalSeeking.NewtonRaphson");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new GoalSeekFunctionTest<Double, Double, Double>();
        double[] values = new double[3];
        values[0] = -1.0;
        values[2] = 1.0;
        this._poly = new PolynomialReal(values);
        Double initialValue = 4.0;
        Equals<Double> criterion = new DoubleAbsolute(Math.pow(10.0, -6.0));
        Mathematics.Function.Differentiator<Double, Double, Double> derivative =
                new Derivative<Double, Double, Double>();
        this._instance = new NewtonRaphson(this._poly,
                Math.sqrt(2.0), initialValue, criterion, derivative, 40);
    }

    @After
    public void tearDown() {
        this._tester = null;
        this._instance = null;
        this._poly = null;
    }

    /**
     * Test of getCriterion method, of class NewtonRaphson.
     */
    @Test
    public void testGetCriterion() {
        System.out.println("getCriterion");
        NewtonRaphson instance = this._instance;
        Equals result = instance.getCriterion();
        assertTrue(result instanceof DoubleAbsolute);
        DoubleAbsolute da = (DoubleAbsolute)result;
        assertEquals(Math.pow(10.0, -6.0), da.getPrecision(), 0.0);
    }

    /**
     * Test of getDifferentiator method, of class NewtonRaphson.
     */
    @Test
    public void testGetDifferentiator() {
        System.out.println("getDifferentiator");
        NewtonRaphson instance = this._instance;
        Object result = instance.getDifferentiator();
        assertTrue(result instanceof Derivative);
        Derivative<Double, Double, Double> d =
                (Derivative<Double, Double, Double>)result;
    }

    /**
     * Test of getGoalValue method, of class NewtonRaphson.
     */
    @Test
    public void testGetGoalValue() {
        System.out.println("getGoalValue");
        this._tester.testGetGoalValue(this._instance, Math.sqrt(2.0));
    }

    /**
     * Test of getInitialValue method, of class NewtonRaphson.
     */
    @Test
    public void testGetInitialValue() {
        System.out.println("getInitialValue");
        this._tester.testGetInitialValue(this._instance, 4.0);
    }

    /**
     * Test of getMaximumIterations method, of class NewtonRaphson.
     */
    @Test
    public void testGetMaximumIterations() {
        System.out.println("getMaximumIterations");
        NewtonRaphson instance = this._instance;
        int expResult = 40;
        int result = instance.getMaximumIterations();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCriterion method, of class NewtonRaphson.
     */
    @Test
    public void testSetCriterion() {
        System.out.println("setCriterion");
        NewtonRaphson instance = this._instance;
        Equals<Double> criterion = new DoubleRelative(Math.pow(10.0, -4.0));
        instance.setCriterion(criterion);
        Equals<Double> result = instance.getCriterion();
        assertTrue(result instanceof DoubleRelative);
        DoubleRelative da = (DoubleRelative)result;
        assertEquals(Math.pow(10.0, -4.0), da.getPrecision(), 0.0);
    }

    /**
     * Test of setCriterion method, of class NewtonRaphson, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetCriterion_Null() {
        System.out.println("setCriterion(null)");
        this._tester.testSetCriterion(this._instance, null);
    }

    /**
     * Test of setDifferentiator method, of class NewtonRaphson.
     */
    @Test
    public void testSetDifferentiator() {
        System.out.println("setDifferentiator");
        NewtonRaphson instance = this._instance;
        Derivative<Double, Double, Double> derivative =
                new Derivative<Double, Double, Double>();
        instance.setDifferentiator(derivative);
        Object result = instance.getDifferentiator();
        assertTrue(result instanceof Derivative);
        Derivative<Double, Double, Double> d =
                (Derivative<Double, Double, Double>)result;
    }

    /**
     * Test of setDifferentiator method, of class NewtonRaphson,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetDifferentiator_Null() {
        System.out.println("setDifferentiator(null)");
        NewtonRaphson instance = this._instance;
        Derivative<Double, Double, Double> derivative = null;
        instance.setDifferentiator(derivative);
    }

    /**
     * Test of setFunction method, of class NewtonRaphson, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetFunction_Null() {
        System.out.println("setFunction(null)");
        this._tester.testSetFunction(this._instance, null);
    }

    /**
     * Test of setGoalValue method, of class NewtonRaphson.
     */
    @Test
    public void testSetGoalValue() {
        System.out.println("setGoalValue");
        this._tester.testSetGoalValue(this._instance, 7.45);
    }

    /**
     * Test of setGoalValue method, of class NewtonRaphson, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetGoalValue_Null() {
        System.out.println("setGoalValue(null)");
        this._tester.testSetGoalValue(this._instance, null);
    }

    /**
     * Test of setInitialValue method, of class NewtonRaphson.
     */
    @Test
    public void testSetInitialValue() {
        System.out.println("setInitialValue");
        this._tester.testSetInitialValue(this._instance, 1.0);
    }

    /**
     * Test of setInitialValue method, of class NewtonRaphson, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetInitialValue_Null() {
        System.out.println("setInitialValue(null)");
        this._tester.testSetInitialValue(this._instance, null);
    }

    /**
     * Test of setMaximumIterations method, of class NewtonRaphson.
     */
    @Test
    public void testSetMaximumIterations() {
        System.out.println("setMaximumIterations");
        int iterations = 10;
        NewtonRaphson instance = this._instance;
        instance.setMaximumIterations(iterations);
    }

    /**
     * Test of setMaximumIterations method, of class NewtonRaphson,
     * for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetMaximumIterations_Zero() {
        System.out.println("setMaximumIterations(null)");
        int iterations = 0;
        NewtonRaphson instance = this._instance;
        instance.setMaximumIterations(iterations);
    }

    /**
     * Test of run method, of class NewtonRaphson.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Algorithm<Result> instance = this._instance;
        Result result = instance.run();
        assertTrue("Wrong type of result.", result instanceof IterativeSuccess);
        IterativeSuccess<Double> is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations from result.", 6, is.getIterations());
        assertEquals("Wrong value from result.", 1.553773974403, is.getResult(), Math.pow(-10.0, -6.0));

        this._instance.setMaximumIterations(5);
        result = instance.run();
        assertTrue("Maximum iterations hit - Wrong type of result.", result instanceof MaximumIterationsFailure);
        MaximumIterationsFailure mif = (MaximumIterationsFailure)result;
        assertEquals("Maximum iterations hit - Wrong number of iterations from result.", 5, mif.getIterations());

        this._instance.setInitialValue(0.0);
        result = instance.run();
        assertTrue("Slope equals 0 (zero) - Wrong type of result.", result instanceof SlopeEqualsZeroFailure);
        SlopeEqualsZeroFailure<Double> sez = (SlopeEqualsZeroFailure<Double>)result;
        assertEquals("Slope equals 0 (zero) - Wrong number of iterations from result.", 0.0, sez.getValue(), 0.0);
    }

    /**
     * Test of run method, of class NewtonRaphson, with an exception thrown.
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
