/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Result;

import Mathematics.*;
import Mathematics.Function.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Result.SolutionNotEnclosedFailure.
 * @author Rune Dahl Iversen
 */
public class SolutionNotEnclosedFailureTest {
    private Function<Double, Double> _function;
    private IntervalReal _interval;
    private Double _goal;
    private SolutionNotEnclosedFailure<Double, Double> _result;

    public SolutionNotEnclosedFailureTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Result.SolutionNotEnclosedFailure");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._function = new SineReal();
        this._goal = -1.0;
        this._interval = new IntervalReal(
                0.0, Interval.EndType.Includes,
                Math.PI, Interval.EndType.Includes);
        this._result = new SolutionNotEnclosedFailure<Double, Double>(
                this._function, this._interval, this._goal);
    }

    @After
    public void tearDown() {
        this._function = null;
        this._goal = null;
        this._interval = null;
        this._result = null;
    }

    /**
     * Test of constructor with a null value for the function.
     */
    @Test (expected=NullPointerException.class)
    public void Ctor_NullFunction() {
        new SolutionNotEnclosedFailure<Double, Double>(
                null, this._interval, this._goal);
    }

    /**
     * Test of constructor with a null value for the interval.
     */
    @Test (expected=NullPointerException.class)
    public void Ctor_NullInterval() {
        new SolutionNotEnclosedFailure<Double, Double>(
                this._function, null, this._goal);
    }

    /**
     * Test of constructor with a null value for the goal value.
     */
    @Test (expected=NullPointerException.class)
    public void Ctor_NullGoalValue() {
        new SolutionNotEnclosedFailure<Double, Double>(
                this._function, this._interval, null);
    }

    /**
     * Test of getFunction method, of class SolutionNotEnclosedFailure.
     */
    @Test
    public void testGetFunction() {
        System.out.println("getFunction");
        SolutionNotEnclosedFailure<Double, Double> instance = this._result;
        Function result = instance.getFunction();
        if (result instanceof SineReal) {
            SineReal s = (SineReal)result;
            assertEquals(new SineReal(), result);
        }
        else {
            fail("Wrong type of function from getFunction.");
        }
    }

    /**
     * Test of getGoalValue method, of class SolutionNotEnclosedFailure.
     */
    @Test
    public void testGetGoalValue() {
        System.out.println("getGoalValue");
        SolutionNotEnclosedFailure<Double, Double> instance = this._result;
        Double expResult = -1.0;
        Double result = instance.getGoalValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getInterval method, of class SolutionNotEnclosedFailure.
     */
    @Test
    public void testGetInterval() {
        System.out.println("getInterval");
        SolutionNotEnclosedFailure<Double, Double> instance = this._result;
        Interval expResult = new IntervalReal(
                0.0, Interval.EndType.Includes,
                Math.PI, Interval.EndType.Includes);
        Interval result = instance.getInterval();
        assertEquals(expResult, result);
    }
}