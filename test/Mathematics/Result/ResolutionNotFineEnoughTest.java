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

    public ResolutionNotFineEnoughTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        double[] coefficients = new double[]{ -1.0 , 2.0 , 0.5 };
        Function<Double, Double> function = new PolynomialReal(coefficients);
        IntervalReal interval = new IntervalReal(3.0, Interval.EndType.Includes, 3.2, Interval.EndType.Includes);
        this._double = new ResolutionNotFineEnough<Double, Double>(function, interval, 4.5);
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