/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import Mathematics.*;
import Mathematics.Norm.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Equality.NormAbsolute.
 * @author Rune Dahl Iversen
 */
public class NormAbsoluteTest {
    private PrecisionBasedTest<Complex> _precisionBased;
    private NormBasedTest<Complex> _normBased;
    private Norm<Complex> _norm;
    private NormAbsolute<Complex> _equality;
    private double _precision;
    private Complex _a;
    private Complex _b;

    public NormAbsoluteTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Equality.NormAbsolute");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._precisionBased = new PrecisionBasedTest<Complex>();
        this._normBased = new NormBasedTest<Complex>();
        this._norm = new ComplexPower(2.0);
        this._precision = Math.pow(10.0, -5.0);
        this._equality = new Mathematics.Equality.NormAbsolute<Complex>(
                this._precision, this._norm);
        this._a = Complex.Cartesian(1.0, 0.0);
        this._b = Complex.Cartesian(0.0, 1.0);
    }

    @After
    public void tearDown() {
        this._precisionBased = null;
        this._normBased = null;
        this._norm = null;
        this._precision = Double.NaN;
        this._equality = null;
        this._a = null;
        this._b = null;
    }

    /**
     * Test of the protected getMetric method, of class NormAbsolute.
     */
    @Test
    public void testGetMetric() {
        System.out.println("getMetric");
        this._normBased.testGetMetric(this._equality,
                new Mathematics.Metric.NormBased<Complex>(new ComplexPower(2.0)));
    }

    /**
     * Test of the getNorm method, of class NormAbsolute.
     */
    @Test
    public void testGetNorm() {
        System.out.println("getNorm");
        this._normBased.testGetNorm(this._equality, new ComplexPower(2.0));
    }

    /**
     * Test of the SetNorm method, of class NormAbsolute.
     */
    @Test
    public void testSetNorm() {
        System.out.println("setNorm");
        this._normBased.testSetNorm(this._equality, new ComplexPower(3.0));
    }

    /**
     * Test of the SetNorm method, of class NormAbsolute, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testSetNorm_Null() {
        System.out.println("setNorm(null)");
        this._normBased.testSetNorm(this._equality, null);
    }

    /**
     * Test of the getPrecision method, of class NormAbsolute.
     */
    @Test
    public void testGetPrecision() {
        System.out.println("getPrecision");
        this._precisionBased.testGetPrecision(this._equality, Math.pow(10.0, -5.0));
    }

    /**
     * Test of the setPrecision method, of class NormAbsolute.
     */
    @Test
    public void testsetPrecision() {
        System.out.println("setPrecision");
        this._precisionBased.testSetPrecision(this._equality, Math.pow(10.0, -6.0));
    }

    /**
     * Test of the method getPrecision, of class NormAbsolute,
     * for the value Double.NaN.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetPrecision_NaN() {
        System.out.println("setPrecision(Double.NaN)");
        this._precisionBased.testSetPrecision(this._equality, Double.NaN);
    }

    /**
     * Test of the method getPrecision, of class NormAbsolute,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetPrecision_NegativeInfinity() {
        System.out.println("setPrecision(Double.NEGATIVE_INFINITY)");
        this._precisionBased.testSetPrecision(this._equality, Double.NEGATIVE_INFINITY);
    }

    /**
     * Test of the method getPrecision, of class NormAbsolute,
     * for a negative value.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetPrecision_NegativeValue() {
        System.out.println("setPrecision(negative value)");
        this._precisionBased.testSetPrecision(this._equality, -this._precision);
    }

    /**
     * Test of the method getPrecision, of class NormAbsolute,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSetPrecision_PositiveInfinity() {
        System.out.println("setPrecision(Double.POSITIVE_INFINITY)");
        this._precisionBased.testSetPrecision(this._equality, Double.POSITIVE_INFINITY);
    }

    /**
     * Test of value method, of class NormAbsolute.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Complex a = this._a;
        Complex b = this._b;
        Equals<Complex> instance = this._equality;
        Boolean expResult = false;
        Boolean result = instance.value(a, b);
        assertEquals(a.toString() + " compared to " + b.toString() + " using " + instance.toString(), expResult, result);

        double delta = Math.pow(10.0, -4.0);

        b = a.sum(Complex.Cartesian(0.0, delta));
        result = instance.value(a, b);
        assertEquals(a.toString() + " compared to " + b.toString() + " using " + instance.toString(), expResult, result);

        b = a.sum(Complex.Cartesian(delta, 0.0));
        result = instance.value(a, b);
        assertEquals(a.toString() + " compared to " + b.toString() + " using " + instance.toString(), expResult, result);

        b = a.sum(Complex.Cartesian(0.0, -delta));
        result = instance.value(a, b);
        assertEquals(a.toString() + " compared to " + b.toString() + " using " + instance.toString(), expResult, result);

        b = a.sum(Complex.Cartesian(-delta, 0.0));
        result = instance.value(a, b);
        assertEquals(a.toString() + " compared to " + b.toString() + " using " + instance.toString(), expResult, result);

        delta = Math.pow(10.0, -6.0);
        expResult = true;

        b = a.sum(Complex.Cartesian(0.0, delta));
        result = instance.value(a, b);
        assertEquals(a.toString() + " compared to " + b.toString() + " using " + instance.toString(), expResult, result);

        b = a.sum(Complex.Cartesian(delta, 0.0));
        result = instance.value(a, b);
        assertEquals(a.toString() + " compared to " + b.toString() + " using " + instance.toString(), expResult, result);

        b = a.sum(Complex.Cartesian(0.0, -delta));
        result = instance.value(a, b);
        assertEquals(a.toString() + " compared to " + b.toString() + " using " + instance.toString(), expResult, result);

        b = a.sum(Complex.Cartesian(-delta, 0.0));
        result = instance.value(a, b);
        assertEquals(a.toString() + " compared to " + b.toString() + " using " + instance.toString(), expResult, result);
    }

    /**
     * Test of value method, of class NormAbsolute, for a null value as the first input.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_FirstNull() {
        System.out.println("value(null, x)");
        Complex a = null;
        Complex b = this._b;
        NormAbsolute<Complex> instance = this._equality;
        instance.value(a, b);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class NormAbsolute, for a null value as the second input.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_SecondNull() {
        System.out.println("value(x, null)");
        Complex a = this._a;
        Complex b = null;
        NormAbsolute<Complex> instance = this._equality;
        instance.value(a, b);
        fail("No exception thrown.");
    }
}