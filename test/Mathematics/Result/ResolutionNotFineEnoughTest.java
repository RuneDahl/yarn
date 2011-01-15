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
 * jUnit test of the class Mathematics.Result.ResolutionNotFineEnough<T>.
 * @author Rune Dahl Iversen
 */
public class ResolutionNotFineEnoughTest {
    private ResolutionNotFineEnough<Double, Double> _double;
    private Function<Double, Double> _function;
    private IntervalReal _interval;
    private double _goalValue;

    public ResolutionNotFineEnoughTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Result.ResolutionNotFineEnough");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        double[] coefficients = new double[]{ -1.0 , 2.0 , 0.5 };
        this._function = new PolynomialReal(coefficients);
        this._interval = new IntervalReal(3.0, Interval.EndType.Includes, 3.2, Interval.EndType.Includes);
        this._goalValue = 4.5;
        this._double = new ResolutionNotFineEnough<Double, Double>(this._function, this._interval,  this._goalValue);
    }

    @After
    public void tearDown() {
        this._double = null;
    }

    /**
     * Test of the constructor of class ResolutionNotFineEnough.
     */
    @Test
    public void testResolutionNotFineEnough() {
        System.out.println("Constructor of ResolutionNotFineEnough.");
        assertNotNull(this._double);
    }

    /**
     * Test of the constructor of class ResolutionNotFineEnough,
     * for a function null value.
     */
    @Test (expected=NullPointerException.class)
    public void testResolutionNotFineEnough_FunctionNull() {
        System.out.println("new ResolutionNotFineEnough(null, i, gv)");
        ResolutionNotFineEnough<Double, Double> result =
                new ResolutionNotFineEnough<Double, Double>(
                null, this._interval, this._goalValue);
    }

    /**
     * Test of the constructor of class ResolutionNotFineEnough,
     * for an interval null value.
     */
    @Test (expected=NullPointerException.class)
    public void testResolutionNotFineEnough_IntervalNull() {
        System.out.println("new ResolutionNotFineEnough(f, null, gv)");
        ResolutionNotFineEnough<Double, Double> result =
                new ResolutionNotFineEnough<Double, Double>(
                this._function, null, this._goalValue);
    }

    /**
     * Test of the constructor of class ResolutionNotFineEnough,
     * for an interval null value.
     */
    @Test (expected=NullPointerException.class)
    public void testResolutionNotFineEnough_GoalValueNull() {
        System.out.println("new ResolutionNotFineEnough(f, i, null)");
        ResolutionNotFineEnough<Double, Double> result =
                new ResolutionNotFineEnough<Double, Double>(
                this._function, this._interval, null);
    }

    /**
     * Test of getFunction method, of class ResolutionNotFineEnough.
     */
    @Test
    public void testGetFunction() {
        System.out.println("getFunction");
        double[] coefficients = new double[]{ -1.0 , 2.0 , 0.5 };
        Function<Double, Double> expected = new PolynomialReal(coefficients);
        Function result = this._double.getFunction();
        assertEquals(expected, result);
    }

    /**
     * Test of getGoalValue method, of class ResolutionNotFineEnough.
     */
    @Test
    public void testGetGoalValue() {
        System.out.println("getGoalValue");
        double expected = 4.5;
        double result = this._double.getGoalValue();
        assertEquals(expected, result, 0.0);
    }

    /**
     * Test of getInterval method, of class ResolutionNotFineEnough.
     */
    @Test
    public void testGetInterval() {
        System.out.println("getInterval");
        IntervalReal expected = new IntervalReal(3.0, Interval.EndType.Includes, 3.2, Interval.EndType.Includes);
        Interval result = this._double.getInterval();
        assertEquals(expected, result);
    }
}