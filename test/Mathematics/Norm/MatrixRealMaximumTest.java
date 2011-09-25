/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Norm;

import Mathematics.Matrix.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Norm.MatrixRealMaximum.
 * @author Rune Dahl Iversen
 */
public class MatrixRealMaximumTest {

    public MatrixRealMaximumTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of value method, of class MatrixRealMaximum.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Matrix<Double> input = MatrixReal.Identity(1, 3);
        input.setValue(2, 2, -7.0);
        MatrixRealMaximum instance = new MatrixRealMaximum();
        double expResult = 7.0;
        double result = instance.value(input);
        assertEquals(expResult, result, Math.pow(10.0, -8.0));
    }

    /**
     * Test of value method, of class MatrixRealMaximum.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Matrix<Double> input = null;
        MatrixRealMaximum instance = new MatrixRealMaximum();
        Double result = instance.value(input);
    }

    /**
     * Test of equals method, of class MatrixRealMaximum.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new MatrixRealMaximum();
        MatrixRealMaximum instance = new MatrixRealMaximum();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class MatrixRealMaximum.
     */
    @Test
    public void testEquals_DifferentClass() {
        System.out.println("equals");
        Object obj = MatrixReal.Identity(1, 3);
        MatrixRealMaximum instance = new MatrixRealMaximum();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class MatrixRealMaximum.
     */
    @Test
    public void testEquals_Null() {
        System.out.println("equals(null)");
        Object obj = null;
        MatrixRealMaximum instance = new MatrixRealMaximum();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class MatrixRealMaximum.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        MatrixRealMaximum instance = new MatrixRealMaximum();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class MatrixRealMaximum.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MatrixRealMaximum instance = new MatrixRealMaximum();
        String expResult = "{Mathematics.Norm.MatrixRealMaximum}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}