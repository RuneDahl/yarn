/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Vector.Vector;
import Mathematics.Vector.VectorReal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Norm.VectorRealPower.
 * @author Rune Dahl Iversen
 */
public class VectorRealPowerTest {
    private VectorRealPower _norm;
    private Vector<Double> _vector;

    public VectorRealPowerTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Norm.VectorRealPower");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._norm = new VectorRealPower(2.0);
        this._vector = new VectorReal(7, 1.0);
    }

    @After
    public void tearDown() {
        this._norm = null;
        this._vector = null;
    }

    /**
     * Test of value method, of class VectorRealPower.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        VectorRealPower instance = this._norm;

        Vector<Double> vector = this._vector;
        Double expResult = Math.sqrt(7.0);
        Double result = instance.value(vector);
        assertEquals(expResult, result, 0.0);

        vector = vector.scale(40.0);
        expResult = Math.sqrt(7.0) * 40.0;
        result = instance.value(vector);
        assertEquals(expResult, result, 0.0);

        vector = VectorReal.Unit(50, 3); // Unit-vector.
        expResult = 1.0;
        result = instance.value(vector);
        assertEquals(expResult, result, 0.0);

        vector = vector.scale(40.0);
        expResult = 40.0;
        result = instance.value(vector);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of value method, of class VectorRealPower, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        VectorRealPower instance = this._norm;

        Vector<Double> input = null;
        instance.value(input);
        fail("No exception thrown.");
    }

    /**
     * Test of equals method, of class VectorRealPower.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        VectorRealPower instance = this._norm;

        boolean expResult = true;
        Object obj = new VectorRealPower(2.0);
        boolean result = instance.equals(obj);
        assertEquals("Does not equal another VectorRealPower(2.0)", expResult, result);

        obj = instance;
        result = instance.equals(obj);
        assertEquals("Does not equal itself", expResult, result);

        expResult = false;

        obj = new VectorRealPower(1.0);
        result = instance.equals(obj);
        assertEquals("Equal a VectorRealPower(1.0)", expResult, result);

        obj = 7.0;
        result = instance.equals(obj);
        assertEquals("Equals the value 7.0", expResult, result);

        obj = null;
        result = instance.equals(obj);
        assertEquals("Equals a null value", expResult, result);
    }

    /**
     * Test of hashCode method, of class VectorRealPower.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        VectorRealPower instance = this._norm;
        int expResult = ((Double)2.0).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class VectorRealPower.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VectorRealPower instance = this._norm;
        String expResult = "{VectorRealPower(2.0)}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}