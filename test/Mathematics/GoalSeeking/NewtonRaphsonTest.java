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
        Double initialValue = 4.0;
        Equals<Double> criterion = new DoubleAbsolute(Math.pow(10.0, -6.0));
        Mathematics.Function.Differentiator<Double, Double, Double> derivative =
                new Derivative<Double, Double, Double>();
        this._instance = new NewtonRaphson(Math.sqrt(2.0), initialValue, criterion, derivative, 40);
    }

    @After
    public void tearDown() {
        this._instance = null;
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
     * Test of getGoalValue method, of class NewtonRaphson.
     */
    @Test
    public void testGetGoalValue() {
        System.out.println("getGoalValue");
        NewtonRaphson instance = this._instance;
        Double expResult = Math.sqrt(2.0);
        Double result = instance.getGoalValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitialValue method, of class NewtonRaphson.
     */
    @Test
    public void testGetInitialValue() {
        System.out.println("getInitialValue");
        NewtonRaphson instance = this._instance;
        Double expResult = 4.0;
        Double result = instance.getInitialValue();
        assertEquals(expResult, result);
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
        NewtonRaphson instance = this._instance;
        Equals<Double> criterion = null;
        instance.setCriterion(criterion);
    }

    /**
     * Test of setGoalValue method, of class NewtonRaphson.
     */
    @Test
    public void testSetGoalValue() {
        System.out.println("setGoalValue");
        Double value = 7.45;
        NewtonRaphson instance = this._instance;
        instance.setGoalValue(value);

        Double result = instance.getGoalValue();
        assertEquals(7.45, result, 0.0);
    }

    /**
     * Test of setGoalValue method, of class NewtonRaphson, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetGoalValue_Null() {
        System.out.println("setGoalValue(null)");
        Double value = null;
        NewtonRaphson instance = this._instance;
        instance.setGoalValue(value);
    }

    /**
     * Test of setInitialValue method, of class NewtonRaphson.
     */
    @Test
    public void testSetInitialValue() {
        System.out.println("setInitialValue");
        Double initialValue = 1.0;
        NewtonRaphson instance = this._instance;
        instance.setInitialValue(initialValue);

        Double result = instance.getInitialValue();
        Double expResult = 1.0;
        assertEquals(expResult, result);
    }

    /**
     * Test of setInitialValue method, of class NewtonRaphson, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetInitialValue_Null() {
        System.out.println("setInitialValue(null)");
        Double initialValue = null;
        NewtonRaphson instance = this._instance;
        instance.setInitialValue(initialValue);
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
     * Test of Run method, of class NewtonRaphson.
     */
    @Test
    public void testRun() {
        System.out.println("Run");
        double[] values = new double[3];
        values[0] = -1.0;
        values[2] = 1.0;
        Function<Double, Double> value = new PolynomialReal(values);
        Algorithm<Function<Double, Double>> instance = this._instance;
        Result result = instance.run(value);
        assertTrue("Wrong type of result.", result instanceof IterativeSuccess);
        IterativeSuccess<Double> is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations from result.", 6, is.getIterations());
        assertEquals("Wrong value from result.", 1.553773974403, is.getResult(), Math.pow(-10.0, -6.0));
    }
}