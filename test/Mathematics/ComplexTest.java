/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics;

import Mathematics.Equality.*;
import Mathematics.Norm.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test of Mathematics.Complex.
 * @author Rune Dahl Iversen
 */
public class ComplexTest {
    private Complex _inf;
    private Complex _nan;
    private Complex _origin;
    private Complex _realUnit;
    private Complex _complexUnit;
    private Complex _onePointOne;
    private Complex _polar;

    private Complex[] _array;

    private Equals<Complex> _numericalComparer;

    public ComplexTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Complex");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._inf = Complex.Infinity;
        this._nan = Complex.NaN;
        this._origin = Complex.Origin;
        this._realUnit = Complex.Cartesian(1.0, 0.0);
        this._complexUnit = Complex.Cartesian(0.0, 1.0);
        this._onePointOne = Complex.Cartesian(1.0, 1.0);

        this._polar = Complex.Polar(5.0, -0.9272952180016121);

        Complex[] array = { this._inf, this._nan, this._origin, this._realUnit,
                            this._complexUnit, this._onePointOne, this._polar};
        this._array = array;

        Norm<Complex> norm = new ComplexPower(2.0);

        this._numericalComparer = new NormRelative<Complex>(Math.pow(10.0, -9.0), norm);
    }

    @After
    public void tearDown() {
        this._inf = null;
        this._nan = null;
        this._origin = null;
        this._realUnit = null;
        this._complexUnit = null;
        this._onePointOne = null;
        this._polar = null;
        this._array = null;
        this._numericalComparer = null;
    }

    /**
     * Test of getArgument method, of class Complex.
     */
    @Test
    public void testGetArgument() {
        System.out.println("getArgument");
        assertEquals(Double.NaN, this._inf.getArgument(), 0.0);
        assertEquals(Double.NaN, this._nan.getArgument(), 0.0);
        assertEquals(Double.NaN, this._origin.getArgument(), 0.0);
        assertEquals(0.0, this._realUnit.getArgument(), 0.0);
        assertEquals(Math.PI / 2.0, this._complexUnit.getArgument(), 0.0);
        assertEquals(Math.PI / 4.0, this._onePointOne.getArgument(), 0.0);
        assertEquals(-0.9272952180016121, this._polar.getArgument(), 0.0);
    }

    /**
     * Test of getArgument method, of class Complex.
     */
    @Test
    public void testGetArgument_int() {
        System.out.println("getArgument(int)");
        assertEquals(Double.NaN, this._inf.getArgument(2), 0.0);
        assertEquals(Double.NaN, this._nan.getArgument(2), 0.0);
        assertEquals(Double.NaN, this._origin.getArgument(2), 0.0);
        assertEquals(4.0 * Math.PI, this._realUnit.getArgument(2), 0.0);
        assertEquals(4.0 * Math.PI + Math.PI / 2.0, this._complexUnit.getArgument(2), 0.0);
        assertEquals(4.0 * Math.PI + Math.PI / 4.0, this._onePointOne.getArgument(2), 0.0);
        assertEquals(4.0 * Math.PI + -0.9272952180016121, this._polar.getArgument(2), 0.0);
    }

    /**
     * Test of getImaginary method, of class Complex.
     */
    @Test
    public void testGetImaginary() {
        System.out.println("getImaginary");
        assertEquals(Double.POSITIVE_INFINITY, this._inf.getImaginary(), 0.0);
        assertEquals(Double.NaN, this._nan.getImaginary(), 0.0);
        assertEquals(0.0, this._origin.getImaginary(), 0.0);
        assertEquals(0.0, this._realUnit.getImaginary(), 0.0);
        assertEquals(1.0, this._complexUnit.getImaginary(), 0.0);
        assertEquals(1.0, this._onePointOne.getImaginary(), 0.0);
        assertEquals(-4.0, this._polar.getImaginary(), 0.0000000001);
    }

    /**
     * Test of getModulus method, of class Complex.
     */
    @Test
    public void testGetModulus() {
        System.out.println("getModulus");
        assertEquals(Double.POSITIVE_INFINITY, this._inf.getModulus(), 0.0);
        assertEquals(Double.NaN, this._nan.getModulus(), 0.0);
        assertEquals(0.0, this._origin.getModulus(), 0.0);
        assertEquals(1.0, this._realUnit.getModulus(), 0.0);
        assertEquals(1.0, this._complexUnit.getModulus(), 0.0);
        assertEquals(Math.sqrt(2.0), this._onePointOne.getModulus(), 0.0);
        assertEquals(5.0, this._polar.getModulus(), 0.0);
    }

    /**
     * Test of getReal method, of class Complex.
     */
    @Test
    public void testGetReal() {
        System.out.println("getReal");
        assertEquals(Double.POSITIVE_INFINITY, this._inf.getReal(), 0.0);
        assertEquals(Double.NaN, this._nan.getReal(), 0.0);
        assertEquals(0.0, this._origin.getReal(), 0.0);
        assertEquals(1.0, this._realUnit.getReal(), 0.0);
        assertEquals(0.0, this._complexUnit.getReal(), 0.0);
        assertEquals(1.0, this._onePointOne.getReal(), 0.0);
        assertEquals(3.0, this._polar.getReal(), 0.0000000001);
    }

    /**
     * Test of setArgument method, of class Complex.
     */
    @Test
    public void testSetArgument() {
        System.out.println("setArgument");
        assertEquals(Double.NaN, this._inf.getArgument(), 0.0);
        assertEquals(Double.NaN, this._nan.getArgument(), 0.0);
        assertEquals(Double.NaN, this._origin.getArgument(), 0.0);
        assertEquals(0.0, this._realUnit.getArgument(), 0.0);
        assertEquals(Math.PI / 2.0, this._complexUnit.getArgument(), 0.0);
        assertEquals(Math.PI / 4.0, this._onePointOne.getArgument(), 0.0);
        assertEquals(-0.9272952180016121, this._polar.getArgument(), 0.0000000001);

        this._inf = this._inf.setArgument(2.0);
        this._nan = this._nan.setArgument(2.0);
        this._origin = this._origin.setArgument(2.0);
        this._realUnit = this._realUnit.setArgument(2.0);
        this._complexUnit = this._complexUnit.setArgument(2.0);
        this._onePointOne = this._onePointOne.setArgument(2.0);
        this._polar = this._polar.setArgument(2.0);

        assertEquals(Double.NaN, this._inf.getArgument(), 0.0);
        assertEquals(Double.NaN, this._nan.getArgument(), 0.0);
        assertEquals(Double.NaN, this._origin.getArgument(), 0.0);
        assertEquals(2.0, this._realUnit.getArgument(), 0.0);
        assertEquals(2.0, this._complexUnit.getArgument(), 0.0);
        assertEquals(2.0, this._onePointOne.getArgument(), 0.0);
        assertEquals(2.0, this._polar.getArgument(), 0.0000000001);
    }

    /**
     * Test of setImaginary method, of class Complex.
     */
    @Test
    public void testSetImaginary() {
        System.out.println("setImaginary");
        assertEquals(Double.POSITIVE_INFINITY, this._inf.getImaginary(), 0.0);
        assertEquals(Double.NaN, this._nan.getImaginary(), 0.0);
        assertEquals(0.0, this._origin.getImaginary(), 0.0);
        assertEquals(0.0, this._realUnit.getImaginary(), 0.0);
        assertEquals(1.0, this._complexUnit.getImaginary(), 0.0);
        assertEquals(1.0, this._onePointOne.getImaginary(), 0.0);
        assertEquals(-4.0, this._polar.getImaginary(), 0.0000000001);

        this._inf = this._inf.setImaginary(2.0);
        this._nan = this._nan.setImaginary(2.0);
        this._origin = this._origin.setImaginary(2.0);
        this._realUnit = this._realUnit.setImaginary(2.0);
        this._complexUnit = this._complexUnit.setImaginary(2.0);
        this._onePointOne = this._onePointOne.setImaginary(2.0);
        this._polar = this._polar.setImaginary(2.0);

        assertEquals(Double.POSITIVE_INFINITY, this._inf.getImaginary(), 0.0);
        assertEquals(Double.NaN, this._nan.getImaginary(), 0.0);
        assertEquals(2.0, this._origin.getImaginary(), 0.0);
        assertEquals(2.0, this._realUnit.getImaginary(), 0.0);
        assertEquals(2.0, this._complexUnit.getImaginary(), 0.0);
        assertEquals(2.0, this._onePointOne.getImaginary(), 0.0);
        assertEquals(2.0, this._polar.getImaginary(), 0.0);
    }

    /**
     * Test of setModulus method, of class Complex.
     */
    @Test
    public void testSetModulus() {
        System.out.println("setModulus");
        assertEquals(Double.POSITIVE_INFINITY, this._inf.getModulus(), 0.0);
        assertEquals(Double.NaN, this._nan.getModulus(), 0.0);
        assertEquals(0.0, this._origin.getModulus(), 0.0);
        assertEquals(1.0, this._realUnit.getModulus(), 0.0);
        assertEquals(1.0, this._complexUnit.getModulus(), 0.0);
        assertEquals(Math.sqrt(2.0), this._onePointOne.getModulus(), 0.0);
        assertEquals(5.0, this._polar.getModulus(), 0.0);

        this._inf = this._inf.setModulus(2.0);
        this._nan = this._nan.setModulus(2.0);
        this._origin = this._origin.setModulus(2.0);
        this._realUnit = this._realUnit.setModulus(2.0);
        this._complexUnit = this._complexUnit.setModulus(2.0);
        this._onePointOne = this._onePointOne.setModulus(2.0);
        this._polar = this._polar.setModulus(2.0);

        assertEquals(Double.NaN, this._inf.getModulus(), 0.0);
        assertEquals(Double.NaN, this._nan.getModulus(), 0.0);
        assertEquals(Double.NaN, this._origin.getModulus(), 0.0);
        assertEquals(2.0, this._realUnit.getModulus(), 0.0);
        assertEquals(2.0, this._complexUnit.getModulus(), 0.0);
        assertEquals(2.0, this._onePointOne.getModulus(), 0.0);
        assertEquals(2.0, this._polar.getModulus(), 0.0);
    }

    /**
     * Test of setReal method, of class Complex.
     */
    @Test
    public void testSetReal() {
        System.out.println("setReal");
        assertEquals(Double.POSITIVE_INFINITY, this._inf.getReal(), 0.0);
        assertEquals(Double.NaN, this._nan.getReal(), 0.0);
        assertEquals(0.0, this._origin.getReal(), 0.0);
        assertEquals(1.0, this._realUnit.getReal(), 0.0);
        assertEquals(0.0, this._complexUnit.getReal(), 0.0);
        assertEquals(1.0, this._onePointOne.getReal(), 0.0);
        assertEquals(3.0, this._polar.getReal(), 0.0000000001);

        this._inf = this._inf.setReal(2.0);
        this._nan = this._nan.setReal(2.0);
        this._origin = this._origin.setReal(2.0);
        this._realUnit = this._realUnit.setReal(2.0);
        this._complexUnit = this._complexUnit.setReal(2.0);
        this._onePointOne = this._onePointOne.setReal(2.0);
        this._polar = this._polar.setReal(2.0);

        assertEquals(Double.POSITIVE_INFINITY, this._inf.getReal(), 0.0);
        assertEquals(Double.NaN, this._nan.getReal(), 0.0);
        assertEquals(2.0, this._origin.getReal(), 0.0);
        assertEquals(2.0, this._realUnit.getReal(), 0.0);
        assertEquals(2.0, this._complexUnit.getReal(), 0.0);
        assertEquals(2.0, this._onePointOne.getReal(), 0.0);
        assertEquals(2.0, this._polar.getReal(), 0.0);
    }

    /**
     * Test of conjugate method, of class Complex.
     */
    @Test
    public void testConjugate() {
        System.out.println("Conjugate");

        assertEquals(Complex.Infinity, this._inf.conjugate());
        assertEquals(Complex.NaN, this._nan.conjugate());
        assertEquals(Complex.Origin, this._origin.conjugate());
        assertEquals(Complex.Cartesian(1.0, 0.0), this._realUnit.conjugate());
        assertEquals(Complex.Cartesian(0.0, -1.0), this._complexUnit.conjugate());
        assertEquals(Complex.Cartesian(1.0, -1.0), this._onePointOne.conjugate());
        assertTrue("Failed test of Conjugate for " + this._polar.toString(),
                this._numericalComparer.value(Complex.Cartesian(3.0, 4.0), this._polar.conjugate()));
    }

    /**
     * Test of divide method, of class Complex.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");

        for (int i = 0; i < this._array.length; i++) {
            if (Complex.isNaN(this._array[i]) ||
                    Complex.isInfinite(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._inf.toString(),
                        Complex.NaN, this._inf.divide(this._array[i]));
            else
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._inf.toString(),
                        Complex.Infinity, this._inf.divide(this._array[i]));

            assertEquals("Test divide by " + this._array[i].toString() +
                    " failed for " + this._nan.toString(),
                    Complex.NaN, this._nan.divide(this._array[i]));

            if (Complex.isNaN(this._array[i]) ||
                    Complex.isOrigin(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._origin.toString(),
                        Complex.NaN, this._origin.divide(this._array[i]));
            else
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._origin.toString(),
                        Complex.Origin, this._origin.divide(this._array[i]));

            if (Complex.isNaN(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._realUnit.toString(),
                        Complex.NaN, this._realUnit.divide(this._array[i]));
            else if (Complex.isInfinite(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._realUnit.toString(),
                        Complex.Origin, this._realUnit.divide(this._array[i]));
            else if (Complex.isOrigin(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._realUnit.toString(),
                        Complex.Infinity, this._realUnit.divide(this._array[i]));
            else
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._realUnit.toString(),
                        this._array[i].inverse(), this._realUnit.divide(this._array[i]));

            if (Complex.isNaN(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._complexUnit.toString(),
                        Complex.NaN, this._complexUnit.divide(this._array[i]));
            else if (Complex.isInfinite(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._complexUnit.toString(),
                        Complex.Origin, this._complexUnit.divide(this._array[i]));
            else if (Complex.isOrigin(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._complexUnit.toString(),
                        Complex.Infinity, this._complexUnit.divide(this._array[i]));
            else {
                if (i == 3) {
                    assertEquals("Test divide by " + this._array[i].toString() +
                            " failed for " + this._complexUnit.toString(),
                            Complex.Cartesian(0.0, 1.0), this._complexUnit.divide(this._array[i]));
                } else if (i == 4) {
                    assertTrue("Test divide by " + this._array[i].toString() +
                            " failed for " + this._complexUnit.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(1.0, 0.0), this._complexUnit.divide(this._array[i])));
                } else if (i == 5) {
                    assertTrue("Test divide by " + this._array[i].toString() +
                            " failed for " + this._complexUnit.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(0.5, 0.5), this._complexUnit.divide(this._array[i])));
                } else if (i == 6) {
                    assertTrue("Test divide by " + this._array[i].toString() +
                            " failed for " + this._complexUnit.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(-4.0 / 25.0, 3.0 / 25.0), this._complexUnit.divide(this._array[i])));
                }
            }

            if (Complex.isNaN(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._onePointOne.toString(),
                        Complex.NaN, this._onePointOne.divide(this._array[i]));
            else if (Complex.isInfinite(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._onePointOne.toString(),
                        Complex.Origin, this._onePointOne.divide(this._array[i]));
            else if (Complex.isOrigin(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._onePointOne.toString(),
                        Complex.Infinity, this._onePointOne.divide(this._array[i]));
            else {
                if (i == 3) {
                    assertEquals("Test divide by " + this._array[i].toString() +
                            " failed for " + this._onePointOne.toString(),
                            Complex.Cartesian(1.0, 1.0), this._onePointOne.divide(this._array[i]));
                } else if (i == 4) {
                    assertTrue("Test divide by " + this._array[i].toString() +
                            " failed for " + this._onePointOne.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(1.0, -1.0), this._onePointOne.divide(this._array[i])));
                } else if (i == 5) {
                    assertTrue("Test divide by " + this._array[i].toString() +
                            " failed for " + this._onePointOne.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(1.0, 0.0), this._onePointOne.divide(this._array[i])));
                } else if (i == 6) {
                    assertTrue("Test divide by " + this._array[i].toString() +
                            " failed for " + this._onePointOne.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(-1.0 / 25.0, 7.0 / 25.0), this._onePointOne.divide(this._array[i])));
                }
            }

            if (Complex.isNaN(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._polar.toString(),
                        Complex.NaN, this._polar.divide(this._array[i]));
            else if (Complex.isInfinite(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._polar.toString(),
                        Complex.Origin, this._polar.divide(this._array[i]));
            else if (Complex.isOrigin(this._array[i]))
                assertEquals("Test divide by " + this._array[i].toString() +
                        " failed for " + this._polar.toString(),
                        Complex.Infinity, this._polar.divide(this._array[i]));
            else {
                if (i == 3) {
                    assertEquals("Test divide by " + this._array[i].toString() +
                            " failed for " + this._polar.toString(),
                            Complex.Polar(5.0, -0.9272952180016121),
                            this._polar.divide(this._array[i]));
                } else if (i == 4) {
                    assertTrue("Test divide by " + this._array[i].toString() +
                            " failed for " + this._polar.toString(),
                            this._numericalComparer.value(
                           Complex.Polar(5.0, -0.9272952180016121 - Math.PI/2.0),
                           this._polar.divide(this._array[i])));
                } else if (i == 5) {
                    assertTrue("Test divide by " + this._array[i].toString() +
                            " failed for " + this._polar.toString(),
                            this._numericalComparer.value(
                            Complex.Polar(5.0 / Math.sqrt(2.0), -0.9272952180016121 - Math.PI/4.0),
                            this._polar.divide(this._array[i])));
                } else if (i == 6) {
                    assertTrue("Test divide by " + this._array[i].toString() +
                            " failed for " + this._polar.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(1.0, 0.0), this._polar.divide(this._array[i])));
                }
            }
        }
    }

    /**
     * Test of divide method, of class Complex, with the value Complex.Origin.
     */
    @Test
    public void testDivideByOrigin() {
        System.out.println("divide(Complex.Origin)");

        assertEquals("Test divide by Complex.Origin failed for " + this._inf.toString(),
                Complex.Infinity, this._inf.divide(Complex.Origin));
        assertEquals("Test divide by Complex.Origin failed for " + this._nan.toString(),
                Complex.NaN, this._nan.divide(Complex.Origin));
        assertEquals("Test divide by Complex.Origin failed for " + this._origin.toString(),
                Complex.NaN, this._origin.divide(Complex.Origin));
        assertEquals("Test divide by Complex.Origin failed for " + this._realUnit.toString(),
                Complex.Infinity, this._realUnit.divide(Complex.Origin));
        assertEquals("Test divide by Complex.Origin failed for " + this._complexUnit.toString(),
                Complex.Infinity, this._complexUnit.divide(Complex.Origin));
        assertEquals("Test divide by Complex.Origin failed for " + this._onePointOne.toString(),
                Complex.Infinity, this._onePointOne.divide(Complex.Origin));
        assertEquals("Test divide by Complex.Origin failed for " + this._polar.toString(),
                Complex.Infinity, this._polar.divide(Complex.Origin));
    }

    /**
     * Test of divide method, of class Complex, with null input.
     */
    @Test (expected=NullPointerException.class)
    public void testDivideNullException() {
        System.out.println("divide(null)");
        this._origin.divide(null);
    }

    /**
     * Test of equals method, of class Complex.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Complex nullValue = null;
        for (int i = 0; i < this._array.length; i++)
        {
            for (int j = 0; j < this._array.length; j++)
                assertEquals("Failed comparison of Complex values " +
                        this._array[i].toString() + " to " + this._array[j].toString(),
                        i == j, this._array[i].equals(this._array[j]));
            assertEquals("Failed comparison of Complex value " +
                    this._array[i].toString() + " to null.",
                    false, this._array[i].equals(nullValue));
        }

        assertTrue("Complex.NaN equals itself.",
                Complex.NaN.equals(Complex.NaN));
        assertTrue("Complex.Infinity equals itself.",
                Complex.Infinity.equals(Complex.Infinity));
    }

    /**
     * Test of hashCode method, of class Complex.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");

        for (int i = 0; i < this._array.length; i++)
            for (int j = 0; j < this._array.length; j++)
                assertEquals("Failed test of hashCode for Complex values " +
                        this._array[i].toString() + this._array[j].toString(),
                        i == j,
                        this._array[i].hashCode() == this._array[j].hashCode());

        Complex value = this._inf;
        assertEquals("Wrong hashCode from Complex: " + value.toString(),
                Complex.RealNumber(Double.POSITIVE_INFINITY).hashCode(),
                value.hashCode());
        
        value = this._nan;
        assertEquals("Wrong hashCode from Complex: " + value.toString(),
                Complex.RealNumber(Double.NaN).hashCode(), value.hashCode());

        value = this._origin;
        assertEquals("Wrong hashCode from Complex: " + value.toString(),
                Complex.RealNumber(0.0).hashCode(), value.hashCode());

        value = this._realUnit;
        assertEquals("Wrong hashCode from Complex: " + value.toString(),
                Complex.Cartesian(1.0, 0.0).hashCode(), value.hashCode());

        value = this._complexUnit;
        assertEquals("Wrong hashCode from Complex: " + value.toString(),
                Complex.Cartesian(0.0, 1.0).hashCode(), value.hashCode());

        value = this._onePointOne;
        assertEquals("Wrong hashCode from Complex: " + value.toString(),
                Complex.Cartesian(1.0, 1.0).hashCode(), value.hashCode());
    }

    /**
     * Test of inverse method, of class Complex.
     */
    @Test
    public void testInverse() {
        System.out.println("inverse");
        this._inf = this._inf.inverse();
        this._nan = this._nan.inverse();
        this._origin = this._origin.inverse();
        this._realUnit = this._realUnit.inverse();
        this._complexUnit = this._complexUnit.inverse();
        this._onePointOne = this._onePointOne.inverse();
        this._polar = this._polar.inverse();

        assertEquals(Complex.Origin, this._inf);
        assertEquals(Complex.NaN, this._nan);
        assertEquals(Complex.Infinity, this._origin);
        assertEquals(Complex.Cartesian(1.0, 0.0), this._realUnit);

        assertEquals(0.0, this._complexUnit.getReal(), 0.0000000001);
        assertEquals(-1.0, this._complexUnit.getImaginary(), 0.0);
        assertEquals(0.5, this._onePointOne.getReal(), 0.000000001);
        assertEquals(-0.5, this._onePointOne.getImaginary(), 0.000000001);
        assertEquals(0.12, this._polar.getReal(), 0.0000000001);
        assertEquals(0.16, this._polar.getImaginary(), 0.0000000001);
    }

    /**
     * Test of product method, of class Complex.
     */
    @Test
    public void testProduct() {
        System.out.println("product");

        for (int i = 0; i < this._array.length; i++)
            for (int j = 0; j < this._array.length; j++)
            {
                assertEquals("Failed symmetry test for Complex.product " +
                        this._array[j].toString() + " * " + this._array[i].toString(),
                        this._array[i].product(this._array[j]),
                        this._array[j].product(this._array[i]));
            }

        for (int i = 0; i < this._array.length; i++)
            for (int j = 0; j <= i; j++)
            {
                if (Complex.isNaN(this._array[i]) || Complex.isNaN(this._array[j]))
                    assertEquals("Failed test for Complex.product " +
                        this._array[i].toString() + " * " + this._array[j].toString(),
                        Complex.NaN, this._array[i].product(this._array[j]));
                else if (Complex.isInfinite(this._array[i]) || Complex.isInfinite(this._array[j]))
                {
                    if (Complex.isOrigin(this._array[i]) || Complex.isOrigin(this._array[j]))
                        assertEquals("Failed test for Complex.product " +
                            this._array[i].toString() + " * " + this._array[j].toString(),
                            Complex.NaN, this._array[i].product(this._array[j]));
                    else
                        assertEquals("Failed test for Complex.product " +
                            this._array[i].toString() + " * " + this._array[j].toString(),
                            Complex.Infinity, this._array[i].product(this._array[j]));
                }
                else if (Complex.isOrigin(this._array[i]) || Complex.isOrigin(this._array[j]))
                {
                    assertEquals("Failed test for Complex.product " +
                        this._array[i].toString() + " * " + this._array[j].toString(),
                        Complex.Origin, this._array[i].product(this._array[j]));
                }
                else
                {
                    switch (i) {
                        case 3:
                            assertEquals("Failed test for Complex.product " +
                                this._array[i].toString() + " * " + this._array[j].toString(),
                                Complex.Cartesian(1.0, 0.0), this._array[i].product(this._array[j]));
                            break;
                        case 4:
                            if (j == 3)
                                assertEquals("Failed test for Complex.product " +
                                    this._array[i].toString() + " * " + this._array[j].toString(),
                                    Complex.Cartesian(0.0, 1.0), this._array[i].product(this._array[j]));
                            else
                                assertEquals("Failed test for Complex.product " +
                                    this._array[i].toString() + " * " + this._array[j].toString(),
                                    Complex.Cartesian(-1.0, 0.0), this._array[i].product(this._array[j]));
                            break;
                        case 5:
                            if (j == 3)
                                assertEquals("Failed test for Complex.product " +
                                    this._array[i].toString() + " * " + this._array[j].toString(),
                                    Complex.Cartesian(1.0, 1.0), this._array[i].product(this._array[j]));
                            else if (j == 4)
                                assertEquals("Failed test for Complex.product " +
                                    this._array[i].toString() + " * " + this._array[j].toString(),
                                    Complex.Cartesian(-1.0, 1.0), this._array[i].product(this._array[j]));
                            else
                                assertEquals("Failed test for Complex.product " +
                                    this._array[i].toString() + " * " + this._array[j].toString(),
                                    Complex.Cartesian(0.0, 2.0), this._array[i].product(this._array[j]));
                            break;
                        case 6:
                            if (j == 3)
                                assertTrue("Failed test for Complex.product " +
                                    this._array[i].toString() + " * " + this._array[j].toString(),
                                    this._numericalComparer.value(
                                    Complex.Cartesian(3.0, -4.0), this._array[i].product(this._array[j])));
                            else if (j == 4)
                                assertTrue("Failed test for Complex.product " +
                                    this._array[i].toString() + " * " + this._array[j].toString(),
                                    this._numericalComparer.value(
                                    Complex.Cartesian(4.0, 3.0), this._array[i].product(this._array[j])));
                            else if (j == 5)
                                assertTrue("Failed test for Complex.product " +
                                    this._array[i].toString() + " * " + this._array[j].toString(),
                                    this._numericalComparer.value(
                                    Complex.Cartesian(7.0, -1.0), this._array[i].product(this._array[j])));
                            else
                                assertTrue("Failed test for Complex.product " +
                                    this._array[i].toString() + " * " + this._array[j].toString(),
                                    this._numericalComparer.value(
                                    Complex.Cartesian(-7.0, -24.0), this._array[i].product(this._array[j])));
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
    }

    /**
     * Test of product method, of class Complex, with null input.
     */
    @Test (expected=NullPointerException.class)
    public void testProduct_Null() {
        System.out.println("product(null)");
        this._origin.product(null);
    }

    /**
     * Test of reverse method, of class Complex.
     */
    @Test
    public void testReverse() {
        System.out.println("reverse");

        assertEquals("Failed reversal of " + this._inf.toString(),
                Complex.Infinity, this._inf.reverse());
        assertEquals("Failed reversal of " + this._nan.toString(),
                Complex.NaN, this._nan.reverse());
        assertEquals("Failed reversal of " + this._origin.toString(),
                Complex.Origin, this._origin.reverse());

        assertEquals("Failed reversal of " + this._realUnit.toString(),
                Complex.Cartesian(-1.0, 0.0), this._realUnit.reverse());
        assertEquals("Failed reversal of " + this._complexUnit.toString(),
                Complex.Cartesian(0.0, -1.0), this._complexUnit.reverse());
        assertEquals("Failed reversal of " + this._onePointOne.toString(),
                Complex.Cartesian(-1.0, -1.0), this._onePointOne.reverse());
        assertEquals("Failed reversal of " + this._polar.toString(),
                Complex.Polar(5.0, -0.9272952180016121 - Math.PI), this._polar.reverse());
    }

    /**
     * Test of subtract method, of class Complex.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");

        for (int i = 0; i < this._array.length; i++) {
            if (Complex.isNaN(this._array[i]) ||
                    Complex.isInfinite(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._inf.toString(),
                        Complex.NaN, this._inf.subtract(this._array[i]));
            else
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._inf.toString(),
                        Complex.Infinity, this._inf.subtract(this._array[i]));

            assertEquals("Test subtract by " + this._array[i].toString() +
                    " failed for " + this._nan.toString(),
                    Complex.NaN, this._nan.subtract(this._array[i]));

            if (Complex.isNaN(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._origin.toString(),
                        Complex.NaN, this._origin.subtract(this._array[i]));
            else if (Complex.isInfinite(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._origin.toString(),
                        Complex.Infinity, this._origin.subtract(this._array[i]));
            else
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._origin.toString(),
                        this._array[i].reverse(), this._origin.subtract(this._array[i]));

            if (Complex.isNaN(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._realUnit.toString(),
                        Complex.NaN, this._realUnit.subtract(this._array[i]));
            else if (Complex.isInfinite(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._realUnit.toString(),
                        Complex.Infinity, this._realUnit.subtract(this._array[i]));
            else if (Complex.isOrigin(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._realUnit.toString(),
                        Complex.Cartesian(1.0, 0.0), this._realUnit.subtract(this._array[i]));
            else
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._realUnit.toString(),
                        Complex.Cartesian(1.0, 0.0).sum(this._array[i].reverse()),
                        this._realUnit.subtract(this._array[i]));

            if (!Complex.isInfinite(this._array[i]) &&
                    !Complex.isNaN(this._array[i]) &&
                    !Complex.isOrigin(this._array[i]))
                if (i == 3) {
                    assertEquals("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._complexUnit.toString(),
                            Complex.Cartesian(-1.0, 1.0), this._complexUnit.subtract(this._array[i]));
                } else if (i == 4) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._complexUnit.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(0.0, 0.0), this._complexUnit.subtract(this._array[i])));
                } else if (i == 5) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._complexUnit.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(-1.0, 0.0), this._complexUnit.subtract(this._array[i])));
                } else if (i == 6) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._complexUnit.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(-3.0, 5.0), this._complexUnit.subtract(this._array[i])));
                }
            else if (Complex.isNaN(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._complexUnit.toString(),
                        Complex.NaN, this._complexUnit.subtract(this._array[i]));
            else if (Complex.isInfinite(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._complexUnit.toString(),
                        Complex.Infinity, this._complexUnit.subtract(this._array[i]));
            else if (Complex.isOrigin(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._complexUnit.toString(),
                        Complex.Cartesian(0.0, 1.0), this._complexUnit.subtract(this._array[i]));

            if (!Complex.isInfinite(this._array[i]) &&
                    !Complex.isNaN(this._array[i]) &&
                    !Complex.isOrigin(this._array[i]))
                if (i == 3) {
                    assertEquals("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._onePointOne.toString(),
                            Complex.Cartesian(0.0, 1.0), this._onePointOne.subtract(this._array[i]));
                } else if (i == 4) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._onePointOne.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(1.0, 0.0), this._onePointOne.subtract(this._array[i])));
                } else if (i == 5) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._onePointOne.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(0.0, 0.0), this._onePointOne.subtract(this._array[i])));
                } else if (i == 6) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._onePointOne.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(-2.0, 5.0),
                            this._onePointOne.subtract(this._array[i])));
                }
            else if (Complex.isNaN(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._onePointOne.toString(),
                        Complex.NaN, this._onePointOne.subtract(this._array[i]));
            else if (Complex.isInfinite(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._onePointOne.toString(),
                        Complex.Infinity, this._onePointOne.subtract(this._array[i]));
            else if (Complex.isOrigin(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._onePointOne.toString(),
                        Complex.Cartesian(1.0, 1.0), this._onePointOne.subtract(this._array[i]));

            if (!Complex.isInfinite(this._array[i]) &&
                    !Complex.isNaN(this._array[i]) &&
                    !Complex.isOrigin(this._array[i]))
                if (i == 3) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._polar.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(2.0, -4.0),
                            this._polar.subtract(this._array[i])));
                } else if (i == 4) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._polar.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(3.0, -5.0),
                            this._polar.subtract(this._array[i])));
                } else if (i == 5) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._polar.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(2.0, -5.0),
                            this._polar.subtract(this._array[i])));
                } else if (i == 6) {
                    assertTrue("Test subtract by " + this._array[i].toString() +
                            " failed for " + this._polar.toString(),
                            this._numericalComparer.value(
                            Complex.Cartesian(0.0, 0.0), this._polar.subtract(this._array[i])));
                }
            else if (Complex.isNaN(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._polar.toString(),
                        Complex.NaN, this._polar.subtract(this._array[i]));
            else if (Complex.isInfinite(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._polar.toString(),
                        Complex.Infinity, this._polar.subtract(this._array[i]));
            else if (Complex.isOrigin(this._array[i]))
                assertEquals("Test subtract by " + this._array[i].toString() +
                        " failed for " + this._polar.toString(),
                        Complex.Polar(5.0, -0.9272952180016121),
                        this._polar.subtract(this._array[i]));
        }
    }

    /**
     * Test of subtract method, of class Complex, with null input.
     */
    @Test (expected=NullPointerException.class)
    public void testSubtract_Null() {
        System.out.println("subtract(null)");
        this._origin.subtract(null);
    }

    /**
     * Test of sum method, of class Complex.
     */
    @Test
    public void testSum() {
        System.out.println("sum");

        for (int i = 0; i < this._array.length; i++)
            for (int j = 0; j < this._array.length; j++)
            {
                assertEquals("Failed symmetry test for Complex.add " +
                        this._array[i].toString() + " + " + this._array[j].toString(),
                        this._array[i].sum(this._array[j]),
                        this._array[j].sum(this._array[i]));

            }

        for (int i = 0; i < this._array.length; i++)
            for (int j = 0; j <= i; j++)
            {
                if (Complex.isNaN(this._array[i]) || Complex.isNaN(this._array[j]))
                    assertEquals("Failed test for Complex.add " +
                        this._array[i].toString() + " + " + this._array[j].toString(),
                        Complex.NaN, this._array[i].sum(this._array[j]));
                else if (Complex.isInfinite(this._array[i]) || Complex.isInfinite(this._array[j]))
                    assertEquals("Failed test for Complex.add " +
                        this._array[i].toString() + " + " + this._array[j].toString(),
                        Complex.Infinity, this._array[i].sum(this._array[j]));
                else
                {
                    switch (i) {
                        case 2:
                            assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Origin, this._array[i].sum(this._array[j]));
                            break;
                        case 3:
                            if (j == 2)
                                assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Cartesian(1.0, 0.0), this._array[i].sum(this._array[j]));
                            else
                                assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Cartesian(2.0, 0.0), this._array[i].sum(this._array[j]));
                            break;
                        case 4:
                            if (j == 2)
                                assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Cartesian(0.0, 1.0), this._array[i].sum(this._array[j]));
                            else if (j == 3)
                                assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Cartesian(1.0, 1.0), this._array[i].sum(this._array[j]));
                            else
                                assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Cartesian(0.0, 2.0), this._array[i].sum(this._array[j]));
                            break;
                        case 5:
                            if (j == 2)
                                assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Cartesian(1.0, 1.0), this._array[i].sum(this._array[j]));
                            else if (j == 3)
                                assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Cartesian(2.0, 1.0), this._array[i].sum(this._array[j]));
                            else if (j == 4)
                                assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Cartesian(1.0, 2.0), this._array[i].sum(this._array[j]));
                            else
                                assertEquals("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    Complex.Cartesian(2.0, 2.0), this._array[i].sum(this._array[j]));
                            break;
                        case 6:
                            if (j == 2)
                                assertTrue("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    this._numericalComparer.value(
                                    Complex.Cartesian(3.0, -4.0), this._array[i].sum(this._array[j])));
                            else if (j == 3)
                                assertTrue("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    this._numericalComparer.value(
                                    Complex.Cartesian(4.0, -4.0), this._array[i].sum(this._array[j])));
                            else if (j == 4)
                                assertTrue("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    this._numericalComparer.value(
                                    Complex.Cartesian(3.0, -3.0), this._array[i].sum(this._array[j])));
                            else if (j == 5)
                                assertTrue("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    this._numericalComparer.value(
                                    Complex.Cartesian(4.0, -3.0), this._array[i].sum(this._array[j])));
                            else
                                assertTrue("Failed test for Complex.add " +
                                    this._array[i].toString() + " + " + this._array[j].toString(),
                                    this._numericalComparer.value(
                                    Complex.Cartesian(6.0, -8.0), this._array[i].sum(this._array[j])));
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
    }

    /**
     * Test of sum method, of class Complex, with null input.
     */
    @Test (expected=NullPointerException.class)
    public void testSumNullException() {
        System.out.println("sum(null)");
        this._origin.sum(null);
    }

    /**
     * Test of static Cartesian method, of class Complex.
     */
    @Test
    public void testCartesian() {
        System.out.println("Cartesian");

        Complex value = this._inf;
        assertEquals("Failed test of real value from Complex.Cartesian: " + value.toString(),
                value.getReal(), Double.POSITIVE_INFINITY, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " + value.toString(),
                value.getImaginary(), Double.POSITIVE_INFINITY, 0.0);
        assertEquals("Failed test of modulus value from Complex.Cartesian: " + value.toString(),
                value.getModulus(), Double.POSITIVE_INFINITY, 0.0);
        assertEquals("Failed test of argument value from Complex.Cartesian: " + value.toString(),
                value.getArgument(), Double.NaN, 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " + value.toString(),
                Complex.isNaN(value));
        assertTrue("Failed test of Complex.isInifite from Complex.Cartesian: " + value.toString(),
                Complex.isInfinite(value));

        value = this._nan;
        assertEquals("Failed test of real value from Complex.Cartesian: " + value.toString(),
                value.getReal(), Double.NaN, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " + value.toString(),
                value.getImaginary(), Double.NaN, 0.0);
        assertEquals("Failed test of modulus value from Complex.Cartesian: " + value.toString(),
                value.getModulus(), Double.NaN, 0.0);
        assertEquals("Failed test of argument value from Complex.Cartesian: " + value.toString(),
                value.getArgument(), Double.NaN, 0.0);
        assertTrue("Failed test of Complex.isNaN from Complex.Cartesian: " + value.toString(),
                Complex.isNaN(value));
        assertFalse("Failed test of Complex.isInifite from Complex.Cartesian: " + value.toString(),
                Complex.isInfinite(value));

        value = this._origin;
        assertEquals("Failed test of real value from Complex.Cartesian: " + value.toString(),
                value.getReal(), 0.0, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " + value.toString(),
                value.getImaginary(), 0.0, 0.0);
        assertEquals("Failed test of modulus value from Complex.Cartesian: " + value.toString(),
                value.getModulus(), 0.0, 0.0);
        assertEquals("Failed test of argument value from Complex.Cartesian: " + value.toString(),
                value.getArgument(), Double.NaN, 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " + value.toString(),
                Complex.isNaN(value));
        assertFalse("Failed test of Complex.isInifite from Complex.Cartesian: " + value.toString(),
                Complex.isInfinite(value));

        value = this._realUnit;
        assertEquals("Failed test of real value from Complex.Cartesian: " + value.toString(),
                value.getReal(), 1.0, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " + value.toString(),
                value.getImaginary(), 0.0, 0.0);
        assertEquals("Failed test of modulus value from Complex.Cartesian: " + value.toString(),
                value.getModulus(), 1.0, 0.0);
        assertEquals("Failed test of argument value from Complex.Cartesian: " + value.toString(),
                value.getArgument(), 0.0, 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " + value.toString(),
                Complex.isNaN(value));
        assertFalse("Failed test of Complex.isInifite from Complex.Cartesian: " + value.toString(),
                Complex.isInfinite(value));

        value = this._complexUnit;
        assertEquals("Failed test of real value from Complex.Cartesian: " + value.toString(),
                value.getReal(), 0.0, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " + value.toString(),
                value.getImaginary(), 1.0, 0.0);
        assertEquals("Failed test of modulus value from Complex.Cartesian: " + value.toString(),
                value.getModulus(), 1.0, 0.0);
        assertEquals("Failed test of argument value from Complex.Cartesian: " + value.toString(),
                value.getArgument(), Math.PI / 2.0, 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " + value.toString(),
                Complex.isNaN(value));
        assertFalse("Failed test of Complex.isInifite from Complex.Cartesian: " + value.toString(),
                Complex.isInfinite(value));

        value = this._onePointOne;
        assertEquals("Failed test of real value from Complex.Cartesian: " + value.toString(),
                value.getReal(), 1.0, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " + value.toString(),
                value.getImaginary(), 1.0, 0.0);
        assertEquals("Failed test of modulus value from Complex.Cartesian: " + value.toString(),
                value.getModulus(), Math.sqrt(2.0), 0.0);
        assertEquals("Failed test of argument value from Complex.Cartesian: " + value.toString(),
                value.getArgument(), Math.PI / 4.0, 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " + value.toString(),
                Complex.isNaN(value));
        assertFalse("Failed test of Complex.isInifite from Complex.Cartesian: " + value.toString(),
                Complex.isInfinite(value));

        value = Complex.Cartesian(Double.POSITIVE_INFINITY, 0.0);
        assertEquals("Failed test of real value from Complex.Cartesian: " +
                value.toString() + "from real = Double.POSITIVE_INFINITY.",
                value.getReal(), Double.POSITIVE_INFINITY, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " +
                value.toString() + "from real = Double.POSITIVE_INFINITY.",
                value.getImaginary(), Double.POSITIVE_INFINITY, 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " +
                value.toString() + "from real = Double.POSITIVE_INFINITY.",
                Complex.isNaN(value));
        assertTrue("Failed test of Complex.isInifite from Complex.Cartesian: " +
                value.toString() + "from real = Double.POSITIVE_INFINITY.",
                Complex.isInfinite(value));

        value = Complex.Cartesian(Double.NEGATIVE_INFINITY, 0.0);
        assertEquals("Failed test of real value from Complex.Cartesian: " +
                value.toString() + "from real = Double.NEGATIVE_INFINITY.",
                value.getReal(), Double.POSITIVE_INFINITY, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " +
                value.toString() + "from real = Double.NEGATIVE_INFINITY.",
                value.getImaginary(), Double.POSITIVE_INFINITY, 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " +
                value.toString() + "from real = Double.NEGATIVE_INFINITY.",
                Complex.isNaN(value));
        assertTrue("Failed test of Complex.isInifite from Complex.Cartesian: " +
                value.toString() + "from real = Double.NEGATIVE_INFINITY.",
                Complex.isInfinite(value));

        value = Complex.Cartesian(0.0, Double.POSITIVE_INFINITY);
        assertEquals("Failed test of real value from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.POSITIVE_INFINITY.",
                value.getReal(), Double.POSITIVE_INFINITY, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.POSITIVE_INFINITY.",
                value.getImaginary(), Double.POSITIVE_INFINITY, 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.POSITIVE_INFINITY.",
                Complex.isNaN(value));
        assertTrue("Failed test of Complex.isInifite from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.POSITIVE_INFINITY.",
                Complex.isInfinite(value));

        value = Complex.Cartesian(0.0, Double.NEGATIVE_INFINITY);
        assertEquals("Failed test of real value from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.NEGATIVE_INFINITY.",
                value.getReal(), Double.POSITIVE_INFINITY, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.NEGATIVE_INFINITY.",
                value.getImaginary(), Double.POSITIVE_INFINITY, 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.NEGATIVE_INFINITY.",
                Complex.isNaN(value));
        assertTrue("Failed test of Complex.isInifite from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.NEGATIVE_INFINITY.",
                Complex.isInfinite(value));

        value = Complex.Cartesian(Double.NaN, 0.0);
        assertEquals("Failed test of real value from Complex.Cartesian: " +
                value.toString() + "from real = Double.NaN.",
                value.getReal(), Double.NaN, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " +
                value.toString() + "from real = Double.NaN.",
                value.getImaginary(), Double.NaN, 0.0);
        assertTrue("Failed test of Complex.isNaN from Complex.Cartesian: " +
                value.toString() + "from real = Double.NaN.",
                Complex.isNaN(value));
        assertFalse("Failed test of Complex.isInfinite from Complex.Cartesian: " +
                value.toString() + "from real = Double.NaN.",
                Complex.isInfinite(value));

        value = Complex.Cartesian(0.0, Double.NaN);
        assertEquals("Failed test of real value from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.NaN.",
                value.getReal(), Double.NaN, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.NaN.",
                value.getImaginary(), Double.NaN, 0.0);
        assertTrue("Failed test of Complex.isNaN from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.NaN.",
                Complex.isNaN(value));
        assertFalse("Failed test of Complex.isInfinite from Complex.Cartesian: " +
                value.toString() + "from imaginary = Double.NaN.",
                Complex.isInfinite(value));

        value = Complex.Cartesian(-7.0, -8.5);
        assertEquals("Failed test of real value from Complex.Cartesian: " + value.toString(),
                value.getReal(), -7.0, 0.0);
        assertEquals("Failed test of imaginary value from Complex.Cartesian: " + value.toString(),
                value.getImaginary(), -8.5, 0.0);
        assertEquals("Failed test of modulus value from Complex.Cartesian: " + value.toString(),
                value.getModulus(), Math.sqrt(49.0 + 72.25), 0.000000000001);
        assertEquals("Failed test of argument value from Complex.Cartesian: " + value.toString(),
                value.getArgument(), Math.atan2(-8.5, -7.0), 0.0);
        assertFalse("Failed test of Complex.isNaN from Complex.Cartesian: " + value.toString(),
                Complex.isNaN(value));
        assertFalse("Failed test of Complex.isInfinite from Complex.Cartesian: " + value.toString(),
                Complex.isInfinite(value));
    }

    /**
     * Test of static Polar method, of class Complex.
     */
    @Test
    public void testPolar() {
        System.out.println("Polar");

        assertEquals(Complex.NaN, Complex.Polar(Double.NaN, Double.NaN));
        assertEquals(Complex.NaN, Complex.Polar(Double.NaN, 1.0));
        assertEquals(Complex.NaN, Complex.Polar(1.0, Double.NaN));

        assertEquals(Complex.Infinity, Complex.Polar(Double.POSITIVE_INFINITY, Double.NaN));
        assertEquals(Complex.Infinity, Complex.Polar(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
        assertEquals(Complex.Infinity, Complex.Polar(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
        assertEquals(Complex.Infinity, Complex.Polar(Double.POSITIVE_INFINITY, 1.0));
        assertEquals(Complex.NaN, Complex.Polar(1.0, Double.POSITIVE_INFINITY));

        for (int i = -5; i < 6; i++)
            assertTrue("Failed creating of Complex real unit for rotations: " +
                    Integer.toString(i),
                    this._numericalComparer.value(
                    Complex.Cartesian(1.0, 0.0), Complex.Polar(1.0, 2.0*Math.PI*i)));

         for (int i = -5; i < 6; i++)
            assertTrue("Failed creating of Complex negative real unit for rotations: " +
                    Integer.toString(i),
                    this._numericalComparer.value(
                    Complex.Cartesian(-1.0, 0.0), Complex.Polar(1.0, 2.0*Math.PI*i + Math.PI)));

        for (int i = -5; i < 6; i++)
            assertTrue("Failed creating of Complex imaginary unit for rotations: " +
                    Integer.toString(i),
                    this._numericalComparer.value(
                    Complex.Cartesian(0.0, 1.0), Complex.Polar(1.0, 2.0*Math.PI*i + Math.PI/2.0)));

        for (int i = -5; i < 6; i++)
            assertTrue("Failed creating of Complex negative imaginary unit for rotations: " +
                    Integer.toString(i),
                    this._numericalComparer.value(
                    Complex.Cartesian(0.0, -1.0), Complex.Polar(1.0, 2.0*Math.PI*i - Math.PI/2.0)));

        Complex tri = Complex.Cartesian(3.0, -4.0);

        for (int i = -5; i < 6; i++)
            assertTrue("Failed creating of Compex value " + tri.toString() +
                    " for rotations: " + Integer.toString(i),
                    this._numericalComparer.value(
                    tri, Complex.Polar(5.0, -0.9272952180016121 + 2.0*Math.PI*i)));
    }

    /**
     * Test of static Polar method, of class Complex with negative value for modulus.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testPolar_NegativeModulus() {
        System.out.println("Polar(negative, argument)");
        Complex.Polar(-1.0, 0.0);
    }

    /**
     * Test of static RealNumber method, of class Complex.
     */
    @Test
    public void testRealNumber() {
        System.out.println("RealNumber");

        Complex value = Complex.RealNumber(Double.POSITIVE_INFINITY);
        assertEquals(Complex.Infinity, value);

        value = Complex.RealNumber(Double.NEGATIVE_INFINITY);
        assertEquals(Complex.Infinity, value);
        
        value = Complex.RealNumber(Double.NaN);
        assertEquals(Complex.NaN, value);

        value = Complex.RealNumber(17.0);
        assertEquals(Complex.Cartesian(17.0, 0.0), value);

        value = Complex.RealNumber(-7.0);
        assertEquals(Complex.Cartesian(-7.0, 0.0), value);
    }

    /**
     * Test of static isInfinite method, of class Complex.
     */
    @Test
    public void testIsInfinite() {
        System.out.println("isInfinite");
        for (int i = 0; i < this._array.length; i++)
            assertEquals("Failed test of isInfinite for index " + Integer.toString(i),
                    i == 0, Complex.isInfinite(this._array[i]));
        assertFalse("Failed test of isInfinite for null value.",
                Complex.isInfinite(null));
    }

    /**
     * Test of static isOrigin method, of class Complex.
     */
    @Test
    public void testIsOrigin() {
        System.out.println("isOrigin");
        for (int i = 0; i < this._array.length; i++)
            assertEquals("Failed test of isOrigin for index " + Integer.toString(i),
                    i == 2, Complex.isOrigin(this._array[i]));
        assertFalse("Failed test of isOrigin for null value.",
                Complex.isOrigin(null));
    }

    /**
     * Test of static isNaN method, of class Complex.
     */
    @Test
    public void testIsNaN() {
        System.out.println("isNaN");
        for (int i = 0; i < this._array.length; i++)
            assertEquals("Failed test of isNaN for index " + Integer.toString(i),
                    i == 1, Complex.isNaN(this._array[i]));
        assertFalse("Failed test of isNaN for null value.",
                Complex.isNaN(null));
    }

    /**
     * Test of static exp method, of class Complex.
     */
    @Test
    public void testExp() {
        System.out.println("exp");

        Complex[] expected = { Complex.NaN, Complex.NaN,
            Complex.RealNumber(1.0), Complex.RealNumber(Math.E),
            Complex.Polar(1.0, 1.0), Complex.Polar(Math.E, 1.0),
            Complex.Polar(Math.exp(3.0), -4.0)};
        for (int i = 0; i < 2; i++)
            assertEquals(expected[i], Complex.exp(this._array[i]));
        for (int i = 2; i < this._array.length; i++)
            assertTrue("Failed test of Complex.exp" + this._array[i].toString() + ".",
                    this._numericalComparer.value(expected[i], Complex.exp(this._array[i])));
    }

    /**
     * Test of static exp method, of class Complex, of a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testExp_Null() {
        System.out.println("exp(null)");
        Complex.exp(null);
    }

    /**
     * Test of static log method, of class Complex.
     */
    @Test
    public void testLog() {
        System.out.println("log");
        Complex[] expected = { Complex.NaN, Complex.NaN, Complex.Infinity,
            Complex.Origin, Complex.Cartesian(0.0, Math.PI / 2.0),
            Complex.Cartesian(Math.log(Math.sqrt(2.0)), Math.PI / 4.0),
            Complex.Cartesian(Math.log(5.0), -0.9272952180016121)};
        for (int i = 0; i < 4; i++)
            assertEquals(expected[i], Complex.log(this._array[i]));
        for (int i = 4; i < this._array.length; i++)
            assertTrue("Failed test of Complex.log" + this._array[i].toString() + ".",
                    this._numericalComparer.value(expected[i], Complex.log(this._array[i])));
    }

    /**
     * Test of static log method, of class Complex, of a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testLog_Null() {
        System.out.println("log(null)");
        Complex.log(null);
    }
}