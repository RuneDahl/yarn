/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Matrix.Matrix;
import Mathematics.Matrix.MatrixReal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Norm.MatrixRealPower.
 * @author Rune Dahl Iversen
 */
public class MatrixRealPowerTest {
    private MatrixRealPower _instance;

    public MatrixRealPowerTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Norm.MatrixRealPower");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new MatrixRealPower(2.0);
    }

    @After
    public void tearDown() {
        this._instance =  null;
    }

    /**
     * Test of getPower method, of class MatrixRealPower.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        Power<Matrix<Double>> instance = this._instance;

        double expResult = 2.0;
        double result = instance.getPower();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPower method, of class MatrixRealPower.
     */
    @Test
    public void testSetPower() {
        System.out.println("setPower");
        Power<Matrix<Double>> instance = this._instance;

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
     * Test of setPower method, of class MatrixRealPower, for the value 0.5.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_OneHalf() {
        System.out.println("setPower(0.5)");
        MatrixRealPower instance = this._instance;

        instance.setPower(0.5);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class MatrixRealPower, for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_NaN() {
        System.out.println("setPower(Double.NaN)");
        MatrixRealPower instance = this._instance;

        instance.setPower(Double.NaN);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class MatrixRealPower, for the value
     * Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_PositiveInfinity() {
        System.out.println("setPower(Double.POSITIVE_INFINITY)");
        MatrixRealPower instance = this._instance;

        instance.setPower(Double.POSITIVE_INFINITY);
        fail("No exception thrown.");
    }

    /**
     * Test of setPower method, of class MatrixRealPower, for the value
     * Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPower_NegativeInfinity() {
        System.out.println("setPower(Double.NEGATIVE_INFINITY)");
        MatrixRealPower instance = this._instance;

        instance.setPower(Double.NEGATIVE_INFINITY);
        fail("No exception thrown.");
    }

    /**
     * Test of value method, of class MatrixRealPower.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Matrix<Double> input = MatrixReal.Identity(1, 3);
        input.setValue(2, 2, -7.0);
        Norm<Matrix<Double>> instance = this._instance;
        double expResult = Math.sqrt(1.0 + 49.0 + 1.0);
        double result = instance.value(input);
        assertEquals(expResult, result, Math.pow(10.0, -15.0));
    }

    /**
     * Test of value method, of class MatrixRealPower.
     */
    @Test
    public void testValue_Zero() {
        System.out.println("value(resulting in 0)");
        Matrix<Double> input = MatrixReal.Zero(1, 3, 1, 4);
        Norm<Matrix<Double>> instance = this._instance;
        double expResult = 0.0;
        double result = instance.value(input);
        assertEquals(expResult, result, Math.pow(10.0, -15.0));
    }

    /**
     * Test of value method, of class MatrixRealPower.
     */
    @Test
    public void testValue_Infinite() {
        System.out.println("value(resulting in an infinite value)");
        Matrix<Double> input = MatrixReal.Zero(1, 3, 1, 4);
        input.setValue(1, 2, Double.MAX_VALUE);
        input.setValue(3, 4, -Double.MAX_VALUE);
        Norm<Matrix<Double>> instance = this._instance;
        double expResult = Double.POSITIVE_INFINITY;
        double result = instance.value(input);
        assertEquals(expResult, result, Math.pow(10.0, -15.0));
    }

    /**
     * Test of value method, of class MatrixRealPower, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Matrix<Double> input = null;
        Norm<Matrix<Double>> instance = this._instance;
        instance.value(input);
    }

    /**
     * Test of equals method, of class MatrixRealPower.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new MatrixRealPower(2.0);
        MatrixRealPower instance = this._instance;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class MatrixRealPower.
     */
    @Test
    public void testEquals_Self() {
        System.out.println("equals(same instance)");
        Object obj = this._instance;
        MatrixRealPower instance = this._instance;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class MatrixRealMaximum,
     * for an instance of a different class.
     */
    @Test
    public void testEquals_DifferentClass() {
        System.out.println("equals(different class)");
        Object obj = MatrixReal.Identity(1, 3);
        MatrixRealPower instance = this._instance;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class MatrixRealMaximum,
     * for an instance with a different power.
     */
    @Test
    public void testEquals_DifferentPower() {
        System.out.println("equals(different power)");
        Object obj = new MatrixRealPower(2.5);
        MatrixRealPower instance = this._instance;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class MatrixRealPower.
     */
    @Test
    public void testEquals_Null() {
        System.out.println("equals(null)");
        Object obj = null;
        MatrixRealPower instance = this._instance;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class MatrixRealPower.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        MatrixRealPower instance = this._instance;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class MatrixRealPower.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MatrixRealPower instance = this._instance;
        String expResult = "{Mathematics.Norm.MatrixRealPower(2.0)}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
