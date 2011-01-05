/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Norm.ComplexPower.
 * @author Rune Dahl Iversen
 */
public class ComplexPowerTest {
    private ComplexPower _norm;

    public ComplexPowerTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Norm.ComplexPower");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._norm = new ComplexPower(2.0);
    }

    @After
    public void tearDown() {
        this._norm = null;
    }

    /**
     * Test of getPower method, of class VectorRealPower.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        ComplexPower instance = this._norm;

        double expResult = 2.0;
        double result = instance.getPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPower method, of class VectorRealPower.
     */
    @Test
    public void testSetPower() {
        System.out.println("setPower");
        ComplexPower instance = this._norm;

        double expResult = 2.0;
        double result = instance.getPower();
        assertEquals("Failed pre-condition for testing setPower(double)",
                expResult, result, 0.0);

        instance.setPower(8.0);

        expResult = 8.0;
        result = instance.getPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPower method, of class ComplexPower, for the value 0.5.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_OneHalf() {
        System.out.println("setPower(0.5)");
        ComplexPower instance = this._norm;

        instance.setPower(0.5);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class ComplexPower, for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_NaN() {
        System.out.println("setPower(Double.NaN)");
        ComplexPower instance = this._norm;

        instance.setPower(Double.NaN);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class ComplexPower, for the value
     * Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_PositiveInfinity() {
        System.out.println("setPower(Double.POSITIVE_INFINITY)");
        ComplexPower instance = this._norm;

        instance.setPower(Double.POSITIVE_INFINITY);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class ComplexPower, for the value
     * Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_NegativeInfinity() {
        System.out.println("setPower(Double.NEGATIVE_INFINITY)");
        ComplexPower instance = this._norm;

        instance.setPower(Double.NEGATIVE_INFINITY);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class ComplexPower.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        ComplexPower instance = this._norm;
        double precision = 0.0;

        double expResult = 0.0;
        Complex input = Complex.Origin;
        double result = instance.value(input);
        assertEquals("Norm of origin.", expResult, result, precision);

        expResult = 7.0;
        input = Complex.RealNumber(7.0);
        result = instance.value(input);
        assertEquals("Norm of 7.0", expResult, result, precision);

        expResult = 7.0;
        input = Complex.Cartesian(0.0, 7.0);
        result = instance.value(input);
        assertEquals("Norm of î7.0", expResult, result, precision);

        precision = Math.pow(10.0, -10.0);

        expResult = 5.0 * Math.sqrt(1.36);
        input = Complex.Cartesian(3.0, 5.0);
        result = instance.value(input);
        assertEquals("Norm of 3.0 + î5.0", expResult, result, precision);

        expResult = 5.0 *  Math.sqrt(1.36);
        input = Complex.Cartesian(5.0, -3.0);
        result = instance.value(input);
        assertEquals("Norm of 5.0 - î3.0", expResult, result, precision);

        expResult = 5.0 * Math.sqrt(2.0);
        input = Complex.Cartesian(-5.0, 5.0);
        result = instance.value(input);
        assertEquals("Norm of -5.0 + î5.0", expResult, result, precision);
    }

    /**
     * Test of value method, of class ComplexPower.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        ComplexPower instance = this._norm;
        Complex input = null;
        instance.value(input);
        fail("No exception thrown.");
    }

    /**
     * Test of equals method, of class ComplexPower.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ComplexPower instance = this._norm;
        boolean expResult = true;

        Object obj = instance;
        boolean result = instance.equals(obj);
        assertEquals("Does not equal itself.", expResult, result);

        obj = new ComplexPower(2.0);
        result = instance.equals(obj);
        assertEquals("Does not equal another ComplexPower(2.0).", expResult, result);

        expResult = false;

        obj = new ComplexPower(1.0);
        result = instance.equals(obj);
        assertEquals("Equal a ComplexPower(1.0)", expResult, result);

        obj = 7.0;
        result = instance.equals(obj);
        assertEquals("Equals the value 7.0", expResult, result);

        obj = null;
        result = instance.equals(obj);
        assertEquals("Equals a null value", expResult, result);
    }

    /**
     * Test of hashCode method, of class ComplexPower.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ComplexPower instance = this._norm;
        int expResult = Double.valueOf(2.0).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ComplexPower.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexPower instance = this._norm;
        String expResult = "{ComplexPower(2.0)}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}