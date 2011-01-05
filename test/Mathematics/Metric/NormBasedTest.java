/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Metric;

import Mathematics.Complex;
import Mathematics.Norm.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Metric.NormBased.
 * @author Rune Dahl Iversen
 */
public class NormBasedTest {
    private NormBased<Complex> _metric;
    private NormBased<Double> _illegalState;
    private Norm<Complex> _max;
    private Norm<Complex> _euclidian;

    public NormBasedTest() { // Intentional;
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Metric.NormBased");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._max = new ComplexMaximum();
        this._euclidian = new ComplexPower(2.0);

        this._metric = new NormBased<Complex>(this._euclidian);
        this._illegalState = new NormBased<Double>(new RealAbsolute());
    }

    @After
    public void tearDown() {
        this._metric = null;
        this._illegalState = null;

        this._max = null;
        this._euclidian = null;
    }

    /**
     * Test of getNorm method, of class NormBased.
     */
    @Test
    public void testGetNorm() {
        System.out.println("getNorm");
        NormBased instance = this._metric;
        Norm expResult = new ComplexPower(2.0);
        Norm result = instance.getNorm();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNorm method, of class NormBased.
     */
    @Test
    public void testSetNorm() {
        System.out.println("setNorm");
        NormBased instance = this._metric;

        Norm expResult = this._euclidian;
        Norm result = instance.getNorm();
        assertEquals("Failed precondition for test of method setNorm(...)",
                expResult, result);

        Norm<Complex> norm = this._max;
        instance.setNorm(norm);

        expResult = new ComplexMaximum();
        result = instance.getNorm();
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class NormBased.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        NormBased<Complex> instance = this._metric;

        Complex firstInput = Complex.Cartesian(10.0, -3.4);
        Complex secondInput = Complex.Cartesian(1.0, 0.0);
        double expResult = Math.sqrt(81.0 + 3.4*3.4);

        double result = instance.value(firstInput, secondInput);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of value method, of class NormBased, for the null value as first input.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_FirstNull() {
        System.out.println("value(null, y)");
        NormBased<Complex> instance = this._metric;

        Complex firstInput = null;
        Complex secondInput = Complex.Cartesian(1.0, 0.0);

        instance.value(firstInput, secondInput);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class NormBased, for the null value as second input.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_SecondNull() {
        System.out.println("value(x, null)");
        NormBased<Complex> instance = this._metric;

        Complex firstInput = Complex.Cartesian(10.0, -3.4);
        Complex secondInput = null;

        instance.value(firstInput, secondInput);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class NormBased, for an illegal state/type.
     */
    @Test (expected=IllegalStateException.class)
    public void testValue_IllegalState() {
        System.out.println("value(x, null)");
        NormBased<Double> instance = this._illegalState;

        Double firstInput = 5.0;
        Double secondInput = 2.4;

        instance.value(firstInput, secondInput);
        fail("No exception thrown.");
    }

    /**
     * Dummy class to allow testing of the IllegalStateException
     * thrown in Double value(...).
     */
    private class RealAbsolute implements Norm<Double> {

        @Override
        public Double value(Double value) {
            return Math.abs(value);
        }
    }
}