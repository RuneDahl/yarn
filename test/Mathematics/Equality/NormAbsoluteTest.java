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
    private NormBasedTest _normBased;
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
        this._normBased = new NormBasedTest();
        this._norm = new ComplexPower(2.0);
        this._precision = Math.pow(10.0, -5.0);
        this._equality = new Mathematics.Equality.NormAbsolute<Complex>(
                this._precision, this._norm);
        this._a = Complex.Cartesian(1.0, 0.0);
        this._b = Complex.Cartesian(0.0, 1.0);
    }

    @After
    public void tearDown() {
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
     * Test of value method, of class NormAbsolute.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Complex a = this._a;
        Complex b = this._b;
        NormAbsolute<Complex> instance = this._equality;
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