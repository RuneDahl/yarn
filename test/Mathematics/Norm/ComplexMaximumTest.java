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
 * jUnit-test for the class Mathematics.Norm.ComplexMaximum.
 * @author Rune Dahl Iversen
 */
public class ComplexMaximumTest {
    private ComplexMaximum _norm;

    public ComplexMaximumTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Norm.ComplexMaximum");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._norm = new ComplexMaximum();
    }

    @After
    public void tearDown() {
        this._norm = null;
    }

    /**
     * Test of value method, of class ComplexMaximum.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        ComplexMaximum instance = this._norm;
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

        expResult = 5.0;
        input = Complex.Cartesian(3.0, 5.0);
        result = instance.value(input);
        assertEquals("Norm of 3.0 + î5.0", expResult, result, precision);

        expResult = 5.0;
        input = Complex.Cartesian(5.0, -3.0);
        result = instance.value(input);
        assertEquals("Norm of 5.0 - î3.0", expResult, result, precision);

        expResult = 5.0;
        input = Complex.Cartesian(-5.0, 5.0);
        result = instance.value(input);
        assertEquals("Norm of -5.0 + î5.0", expResult, result, precision);
    }

    /**
     * Test of value method, of class ComplexMaximum, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Complex input = null;
        Norm<Complex> instance = this._norm;
        instance.value(input);
        fail("No exception thrown.");
    }

    /**
     * Test of equals method, of class ComplexMaximum.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ComplexMaximum instance = new ComplexMaximum();

        boolean expResult = true;
        Object obj = new ComplexMaximum();
        boolean result = instance.equals(obj);
        assertEquals("Does not equal another ComplexMaximum", expResult, result);

        obj = instance;
        result = instance.equals(obj);
        assertEquals("Does not equal itself", expResult, result);

        expResult = false;
        obj = 7.0;
        result = instance.equals(obj);
        assertEquals("Equals the value 7.0", expResult, result);

        obj = null;
        result = instance.equals(obj);
        assertEquals("Equals a null value", expResult, result);
    }

    /**
     * Test of hashCode method, of class ComplexMaximum.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ComplexMaximum instance = this._norm;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ComplexMaximum.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexMaximum instance = this._norm;
        String expResult = "{ComplexMaximum}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}