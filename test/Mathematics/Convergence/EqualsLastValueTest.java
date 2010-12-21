/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

import Mathematics.Equality.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit-test for the class Mathematics.Converges.EqualsLastValue.
 * @author Rune Dahl Iversen
 */
public class EqualsLastValueTest {
    EqualsLastValue<Double> _double;
    Double[] _converges;
    Double[] _diverges;
    Double[] _importantNull;
    Double[] _same;
    Double[] _unimportantNull;

    public EqualsLastValueTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Convergence.EqualsLastValue");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        double precision = Math.pow(10.0, -10.0);
        Equals<Double> equality = new DoubleAbsolute(precision);
        this._double = new EqualsLastValue<Double>(equality, 1);

        this._converges = new Double[] {4.0, 3.0, 2.0, 1.0 + Math.pow(10.0, -11.0), 1.0};
        this._diverges = new Double[this._converges.length];
        this._importantNull = new Double[this._converges.length];
        this._same = new Double[this._converges.length];
        this._unimportantNull = new Double[this._converges.length];
        for (int i = 0; i < this._diverges.length; i++) {
            this._diverges[i] = this._converges[this._converges.length - 1 - i];
            this._same[i] = Math.PI;
            if (1 < i)
                this._unimportantNull[i] = 0.0;
            else
                this._unimportantNull[i] = null;
            if (3 == i)
                this._importantNull[i] = null;
            else
                this._importantNull[i] = 2.0;
        }
    }

    @After
    public void tearDown() {
        this._double = null;
        this._converges = null;
        this._diverges = null;
        this._importantNull = null;
        this._same = null;
        this._unimportantNull = null;
    }

    /**
     * Test of getEquals method, of class EqualsLastValue.
     */
    @Test
    public void testGetEquals() {
        System.out.println("getEquals");
        EqualsLastValue instance = this._double;
        double precision = Math.pow(10.0, -10.0);
        Equals<Double> result = instance.getEquals();
        if (result instanceof DoubleAbsolute) {
            DoubleAbsolute da = (DoubleAbsolute)result;
            double resultPrecision = da.getPrecision();
            assertEquals("Wrong value of precision from equality.",
            precision, resultPrecision, 0.0);
        }
        else
            fail("Wrong kind of equality returned.");
    }

    /**
     * Test of setEquals method, of class EqualsLastValue.
     */
    @Test
    public void testSetEquals() {
        System.out.println("setEquals");
        double precision = Math.pow(10.0, -8.0);
        Equals<Double> equality = new DoubleRelative(precision);
        EqualsLastValue instance = this._double;
        instance.setEquals(equality);
        Equals<Double> result = instance.getEquals();
        if (result instanceof DoubleRelative) {
            DoubleRelative dr = (DoubleRelative)result;
            double resultPrecision = dr.getPrecision();
            assertEquals("Wrong value of precision from equality.",
            precision, resultPrecision, 0.0);
        }
        else
            fail("Wrong kind of equality returned.");
    }

    /**
     * Test of setEquals method, of class EqualsLastValue, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetEquals_Null() {
        System.out.println("setEquals(null)");
        Equals<Double> equality = null;
        EqualsLastValue instance = this._double;
        instance.setEquals(equality);
        fail("No exception thrown.");
    }

    /**
     * Test of getNumberOfEqualities method, of class EqualsLastValue.
     */
    @Test
    public void testGetNumberOfEqualities() {
        System.out.println("getNumberOfEqualities");
        EqualsLastValue instance = this._double;
        int expResult = 1;
        int result = instance.getNumberOfEqualities();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberOfEqualities method, of class EqualsLastValue.
     */
    @Test
    public void testSetNumberOfEqualities() {
        System.out.println("setNumberOfEqualities");
        int numberOfEqualities = 17;
        EqualsLastValue instance = this._double;
        instance.setNumberOfEqualities(numberOfEqualities);
        int expResult = 17;
        int result = instance.getNumberOfEqualities();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberOfEqualities method, of class EqualsLastValue, for the value 0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetNumberOfEqualities_Zero() {
        System.out.println("setNumberOfEqualities(0)");
        int numberOfEqualities = 0;
        EqualsLastValue instance = this._double;
        instance.setNumberOfEqualities(numberOfEqualities);
        fail("No exception thrown.");
    }

    /**
     * Test of converges method, of class EqualsLastValue.
     */
    @Test
    public void testConverges() {
        System.out.println("converges");
        Double[] series = this._converges;
        EqualsLastValue<Double> instance = this._double;
        boolean expResult = true;
        boolean result = instance.converges(series);
        assertEquals("Convergent series does not converge.", expResult, result);

        series = this._same;
        result = instance.converges(series);
        assertEquals("Series of same values does not converge.", expResult, result);

        series = this._unimportantNull;
        result = instance.converges(series);
        assertEquals("Series of with unimportant null values does not converge.",
                expResult, result);

        series = this._diverges;
        expResult = false;
        result = instance.converges(series);
        assertEquals("Divergent series converges.", expResult, result);

        series = this._importantNull;
        result = instance.converges(series);
        assertEquals("Series of with important null value converges.",
                expResult, result);
    }

    /**
     * Test of converges method, of class EqualsLastValue, for an empty array.
     * Length is 0 (zero).
     */
    @Test
    public void testConverges_ArrayOfLengthZero() {
        System.out.println("converges(array[0])");
        Double[] series = new Double[0];
        EqualsLastValue<Double> instance = this._double;
        boolean expResult = false;
        boolean result = instance.converges(series);
        assertEquals(expResult, result);
    }

    /**
     * Test of converges method, of class EqualsLastValue, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testConverges_Null() {
        System.out.println("converges(null)");
        Double[] series = null;
        EqualsLastValue<Double> instance = this._double;
        instance.converges(series);
        fail("No exception thrown.");
    }
}