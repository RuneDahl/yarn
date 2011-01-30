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
     * Test of getPower method, of class VectorRealPower.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        VectorRealPower instance = this._norm;

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
        VectorRealPower instance = this._norm;

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
     * Test of setPower method, of class VectorRealPower, for the value 0.5.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_OneHalf() {
        System.out.println("setPower(0.5)");
        VectorRealPower instance = this._norm;

        instance.setPower(0.5);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class VectorRealPower, for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_NaN() {
        System.out.println("setPower(Double.NaN)");
        VectorRealPower instance = this._norm;

        instance.setPower(Double.NaN);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class VectorRealPower, for the value
     * Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_PositiveInfinity() {
        System.out.println("setPower(Double.POSITIVE_INFINITY)");
        VectorRealPower instance = this._norm;

        instance.setPower(Double.POSITIVE_INFINITY);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class VectorRealPower, for the value
     * Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_NegativeInfinity() {
        System.out.println("setPower(Double.NEGATIVE_INFINITY)");
        VectorRealPower instance = this._norm;

        instance.setPower(Double.NEGATIVE_INFINITY);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class VectorRealPower.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Norm<Vector<Double>> instance = this._norm;

        Vector<Double> vector = this._vector;
        Double expResult = Math.sqrt(7.0);
        Double result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = vector.scale(40.0);
        expResult = Math.sqrt(7.0) * 40.0;
        result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = VectorReal.Unit(50, 3); // Unit-vector.
        expResult = 1.0;
        result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = vector.scale(40.0);
        expResult = 40.0;
        result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = vector.scale(0.0);
        expResult = 0.0;
        result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = new InfiniteVector();
        expResult = Double.POSITIVE_INFINITY;
        result = instance.value(vector);
        assertEquals("Vector with infinite value.", expResult, result, 0.0);

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
        assertEquals("Equals a VectorRealPower(1.0)", expResult, result);

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
        String expResult = "{Mathematics.Norm.VectorRealPower(2.0)}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    private class InfiniteVector implements Vector<Double> {

        @Override
        public int getDimensions() {
            return 1;
        }

        @Override
        public int getFirstDimension() {
            return 0;
        }

        @Override
        public int getLastDimension() {
            return 0;
        }

        @Override
        public Double getValue(int dimension) {
            return Double.POSITIVE_INFINITY;
        }

        @Override
        public boolean hasSameDimensions(Vector<Double> vector) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Double> setValue(int dimension, Double value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Double[] toArray() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Double> sum(Vector<Double> value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Double> scale(Double scalar) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Double> subtract(Vector<Double> value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
}