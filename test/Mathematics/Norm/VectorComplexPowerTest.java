/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Complex;
import Mathematics.Vector.Vector;
import Mathematics.Vector.VectorComplex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Norm.VectorComplexPower.
 * @author Rune Dahl Iversen
 */
public class VectorComplexPowerTest {
    private VectorComplexPower _norm;
    private Vector<Complex> _vector;

    public VectorComplexPowerTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Norm.VectorComplexPower");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._norm = new VectorComplexPower(2.0, new ComplexPower(2.0));
        this._vector = new VectorComplex(7, Complex.RealNumber(1.0));
    }

    @After
    public void tearDown() {
        this._norm = null;
        this._vector = null;
    }

    /**
     * Test of getNorm method, of class VectorComplexPower.
     */
    @Test
    public void testGetNorm() {
        System.out.println("getNorm");
        VectorComplexPower instance = this._norm;

        Norm<Complex> expResult = new ComplexPower(2.0);
        Norm<Complex> result = instance.getNorm();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNorm method, of class VectorComplexPower.
     */
    @Test
    public void testSetNorm() {
        System.out.println("setNorm");
        VectorComplexPower instance = this._norm;

        Norm<Complex> norm = new ComplexMaximum();
        instance.setNorm(norm);
        Norm<Complex> result = instance.getNorm();
        assertEquals(norm, result);
    }

    /**
     * Test of setNorm method, of class VectorComplexPower,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetNorm_Null() {
        System.out.println("setNorm(null)");
        VectorComplexPower instance = this._norm;

        Norm<Complex> norm = null;
        instance.setNorm(norm);
    }

    /**
     * Test of getPower method, of class VectorComplexPower.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        VectorComplexPower instance = this._norm;

        double expResult = 2.0;
        double result = instance.getPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPower method, of class VectorComplexPower.
     */
    @Test
    public void testSetPower() {
        System.out.println("setPower");
        VectorComplexPower instance = this._norm;

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
     * Test of setPower method, of class VectorComplexPower, for the value 0.5.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_OneHalf() {
        System.out.println("setPower(0.5)");
        VectorComplexPower instance = this._norm;

        instance.setPower(0.5);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class VectorComplexPower, for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_NaN() {
        System.out.println("setPower(Double.NaN)");
        VectorComplexPower instance = this._norm;

        instance.setPower(Double.NaN);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class VectorComplexPower, for the value
     * Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_PositiveInfinity() {
        System.out.println("setPower(Double.POSITIVE_INFINITY)");
        VectorComplexPower instance = this._norm;

        instance.setPower(Double.POSITIVE_INFINITY);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class VectorComplexPower, for the value
     * Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_NegativeInfinity() {
        System.out.println("setPower(Double.NEGATIVE_INFINITY)");
        VectorComplexPower instance = this._norm;

        instance.setPower(Double.NEGATIVE_INFINITY);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class VectorComplexPower.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Norm<Vector<Complex>> instance = this._norm;

        Vector<Complex> vector = this._vector;
        Double expResult = Math.sqrt(7.0);
        Double result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = vector.scale(Complex.RealNumber(40.0));
        expResult = Math.sqrt(7.0) * 40.0;
        result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = VectorComplex.Unit(50, 3); // Unit-vector.
        expResult = 1.0;
        result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = vector.scale(Complex.RealNumber(40.0));
        expResult = 40.0;
        result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = vector.scale(Complex.RealNumber(0.0));
        expResult = 0.0;
        result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);

        vector = new InfiniteVector();
        expResult = Double.POSITIVE_INFINITY;
        result = instance.value(vector);
        assertEquals(vector.toString(), expResult, result, 0.0);
    }

    /**
     * Test of value method, of class VectorComplexPower, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        VectorComplexPower instance = this._norm;

        Vector<Complex> input = null;
        instance.value(input);
        fail("No exception thrown.");
    }

    /**
     * Test of equals method, of class VectorComplexPower.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        VectorComplexPower instance = this._norm;

        boolean expResult = true;
        Object obj = new VectorComplexPower(2.0, new ComplexPower(2.0));
        boolean result = instance.equals(obj);
        assertEquals("Does not equal another VectorComplexPower(2.0)", expResult, result);

        obj = instance;
        result = instance.equals(obj);
        assertEquals("Does not equal itself", expResult, result);

        expResult = false;

        obj = new VectorComplexPower(1.0, new ComplexPower(1.0));
        result = instance.equals(obj);
        assertEquals("Equals a VectorComplexPower(1.0)", expResult, result);

        obj = 7.0;
        result = instance.equals(obj);
        assertEquals("Equals the value 7.0", expResult, result);

        obj = null;
        result = instance.equals(obj);
        assertEquals("Equals a null value", expResult, result);
    }

    /**
     * Test of hashCode method, of class VectorComplexPower.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        VectorComplexPower instance = this._norm;
        int expResult = ((Double)2.0).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class VectorComplexPower.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VectorComplexPower instance = this._norm;
        String expResult = "{Mathematics.Norm.VectorComplexPower(2.0)}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    private class InfiniteVector implements Vector<Complex> {

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
        public Complex getValue(int dimension) {
            return Complex.Infinity;
        }

        @Override
        public boolean hasSameDimensions(Vector<Complex> vector) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Complex> setValue(int dimension, Complex value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Complex[] toArray() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Complex> sum(Vector<Complex> value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Complex> scale(Complex scalar) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Complex> subtract(Vector<Complex> value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}