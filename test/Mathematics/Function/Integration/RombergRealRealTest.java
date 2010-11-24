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
 * jUnit-test of the class Mathematics.Function.Integration.RombergRealReal.
 * @author Rune Dahl Iversen
 */
public class RombergRealRealTest {
    private Criterion<Double> _criterion6;
    private Criterion<Double> _criterion8;

    private Interval<Double> _unitInterval;

    private RombergRealReal _romberg;

    private Function<Double, Double> _functionPoly;
    private Function<Double, Double> _sine;

    public RombergRealRealTest() {
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

        this._romberg = new RombergRealReal(20, _unitInterval, _criterion8);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCriterion method, of class RombergRealReal.
     */
    @Test
    public void testGetCriterion() {
        System.out.println("getCriterion");
        RombergRealReal instance = this._romberg;
        Criterion result = instance.getCriterion();
        assertTrue("Wrong class of criterion.", result instanceof EqualsLastValue);
        EqualsLastValue<Double> elv = (EqualsLastValue<Double>)result;
        assertEquals("Wrong number of required equalities.", 2, elv.getNumberOfEqualities());
        assertTrue("Wrong class of equality in criterion.", elv.getEquals() instanceof DoubleAbsolute);
        DoubleAbsolute da = (DoubleAbsolute)elv.getEquals();
        assertEquals("Wrong precision in equality.", Math.pow(-10.0, -8.0), da.getPrecision(), 0.0);
    }

    /**
     * Test of setCriterion method, of class RombergRealReal.
     */
    @Test
    public void testSetCriterion() {
        System.out.println("setCriterion");
        Criterion<Double> criterion = this._criterion6;
        RombergRealReal instance = this._romberg;
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
     * Test of setCriterion method, of class RombergRealReal, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetCriterionNull() {
        System.out.println("setCriterion to null");
        Criterion<Double> criterion = null;
        RombergRealReal instance = this._romberg;
        instance.setCriterion(criterion);
        fail("No exception thrown.");
    }

    /**
     * Test of getMaximumIterations method, of class RombergRealReal.
     */
    @Test
    public void testGetMaximumIterations() {
        System.out.println("getMaximumIterations");
        RombergRealReal instance = this._romberg;
        assertEquals("Wrong number of maximum iterations", 20, instance.getMaximumIterations());
    }

    /**
     * Test of setMaximumIterations method, of class RombergRealReal.
     */
    @Test
    public void testSetMaximumIterations() {
        System.out.println("setMaximumIterations");
        RombergRealReal instance = this._romberg;
        instance.setMaximumIterations(6);
        assertEquals("Wrong number of maximum iterations", 6, instance.getMaximumIterations());
    }

    /**
     * Test of getRegion method, of class RombergRealReal.
     */
    @Test
    public void testGetRegion() {
        System.out.println("getRegion");
        RombergRealReal instance = this._romberg;
        Interval expResult = new IntervalReal(
                0.0, Interval.EndType.Includes,
                1.0, Interval.EndType.Includes);
        Interval result = instance.getRegion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegion method, of class RombergRealReal.
     */
    @Test
    public void testSetRegion() {
        System.out.println("setRegion");
        Interval<Double> interval = new IntervalReal(
                -7.4, Interval.EndType.Excludes,
                Math.PI, Interval.EndType.Excludes);
        RombergRealReal instance = this._romberg;
        instance.setRegion(interval);
        Interval<Double> expected = new IntervalReal(
                -7.4, Interval.EndType.Excludes,
                Math.PI, Interval.EndType.Excludes);
        assertEquals(expected, interval);
    }

    /**
     * Test of setRegion method, of class RombergRealReal, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetRegionNull() {
        System.out.println("setRegion to null");
        Interval<Double> interval = null;
        RombergRealReal instance = this._romberg;
        instance.setRegion(interval);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class RombergRealReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");

        final DoubleAbsolute precision = new DoubleAbsolute(Math.pow(10.0, -8.0));

        final double poly = 1.0/6.0;
        final double sine = 2.0/Math.PI;

        RombergRealReal instance = this._romberg;
        Result result = instance.value(this._functionPoly);

        assertTrue("Wrong class of result poly+Romberg.", result instanceof IterativeSuccess);
        IterativeSuccess<Double> is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result poly+Romberg.", 4, is.getIterations());
        assertTrue("Wrong value of result poly+Romberg.", precision.value(poly, is.getResult()));

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+Romberg.", result instanceof IterativeSuccess);
        is = (IterativeSuccess<Double>)result;
        assertEquals("Wrong number of iterations of result sine+Romberg.", 7, is.getIterations());
        assertTrue("Wrong value of result sine+Romberg.", precision.value(sine, is.getResult()));

        instance.setMaximumIterations(6);

        result = instance.value(this._sine);

        assertTrue("Wrong class of result sine+Romberg.", result instanceof MaximumIterationsFailure);
        MaximumIterationsFailure mif = (MaximumIterationsFailure)result;
        assertEquals("Wrong number of iterations of result sine+Romberg.", 6, mif.getIterations());
    }

    /**
     * Test of value method, of class RombergRealReal, for the value null.
     */
    @Test
    public void testValueNull() {
        System.out.println("value(null)");
        Result result = this._romberg.value(null);
        assertTrue("Wrong class of result.", result instanceof UnhandledExceptionThrown);
        UnhandledExceptionThrown uet = (UnhandledExceptionThrown)result;
        assertTrue("Wrong class of exception in result.", uet.getException() instanceof NullPointerException);
    }
}