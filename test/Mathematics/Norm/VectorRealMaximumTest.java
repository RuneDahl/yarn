/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Norm.VectorRealMaximum.
 * @author Rune Dahl Iversen
 */
public class VectorRealMaximumTest {
    private VectorRealMaximum _norm;
    private Vector<Double> _vector;

    public VectorRealMaximumTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Norm.VectorRealMaximum");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._norm = new VectorRealMaximum();
        this._vector = new VectorReal(7, 1.0);
    }

    @After
    public void tearDown() {
        this._norm = null;
        this._vector = null;
    }

    /**
     * Test of value method, of class VectorRealMaximum.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        VectorRealMaximum instance = this._norm;

        Double expResult = 1.0;
        Vector<Double> input = this._vector;
        Double result = instance.value(input);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of value method, of class VectorRealMaximum, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Norm<Vector<Double>> instance = this._norm;

        Double expResult = 1.0;
        Vector<Double> input = null;
        instance.value(input);
        fail("No exception thrown.");
    }

    /**
     * Test of equals method, of class VectorRealMaximum.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        VectorRealMaximum instance = new VectorRealMaximum();

        boolean expResult = true;
        Object obj = new VectorRealMaximum();
        boolean result = instance.equals(obj);
        assertEquals("Does not equal another VectorRealMaximum", expResult, result);

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
     * Test of hashCode method, of class VectorRealMaximum.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        VectorRealMaximum instance = new VectorRealMaximum();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class VectorRealMaximum.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VectorRealMaximum instance = new VectorRealMaximum();
        String expResult = "{VectorRealMaximum}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}