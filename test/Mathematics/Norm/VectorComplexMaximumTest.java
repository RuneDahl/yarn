/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Complex;
import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Norm.VectorComplexMaximum.
 * @author Rune Dahl Iversen
 */
public class VectorComplexMaximumTest {
    private VectorComplexMaximum _norm;
    private Vector<Complex> _vector;

    public VectorComplexMaximumTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Norm.VectorComplexMaximum");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._norm = new VectorComplexMaximum(new ComplexPower(2.0));
        this._vector = new VectorComplex(7, Complex.RealNumber(1.0));
    }

    @After
    public void tearDown() {
        this._norm = null;
        this._vector = null;
    }

    /**
     * Test of getNorm method, of class VectorComplexMaximum.
     */
    @Test
    public void testGetNorm() {
        System.out.println("getNorm");
        VectorComplexMaximum instance = this._norm;

        Norm<Complex> expResult = new ComplexPower(2.0);
        Norm<Complex> result = instance.getNorm();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNorm method, of class VectorComplexMaximum.
     */
    @Test
    public void testSetNorm() {
        System.out.println("setNorm");
        VectorComplexMaximum instance = this._norm;

        Norm<Complex> norm = new ComplexMaximum();
        instance.setNorm(norm);
        Norm<Complex> result = instance.getNorm();
        assertEquals(norm, result);
    }

    /**
     * Test of setNorm method, of class VectorComplexMaximum,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetNorm_Null() {
        System.out.println("setNorm(null)");
        VectorComplexMaximum instance = this._norm;

        Norm<Complex> norm = null;
        instance.setNorm(norm);
    }

    /**
     * Test of value method, of class VectorComplexMaximum.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        VectorComplexMaximum instance = this._norm;

        double expResult = 1.0;
        Vector<Complex> input = this._vector;
        double result = instance.value(input);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of value method, of class VectorComplexMaximum, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Norm<Vector<Complex>> instance = this._norm;

        Vector<Complex> input = null;
        instance.value(input);
    }

    /**
     * Test of equals method, of class VectorComplexMaximum.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        VectorComplexMaximum instance = new VectorComplexMaximum(new ComplexPower(2.0));

        boolean expResult = true;
        Object obj = new VectorComplexMaximum(new ComplexPower(2.0));
        boolean result = instance.equals(obj);
        assertEquals("Does not equal another VectorComplexMaximum", expResult, result);

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
     * Test of hashCode method, of class VectorComplexMaximum.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        VectorComplexMaximum instance = new VectorComplexMaximum(new ComplexPower(2.0));
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class VectorComplexMaximum.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VectorComplexMaximum instance = new VectorComplexMaximum(new ComplexPower(2.0));
        String expResult = "{Mathematics.Norm.VectorComplexMaximum({Mathematics.Norm.ComplexPower(2.0)})}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}