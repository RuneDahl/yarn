/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Function;

import Mathematics.Command;
import Mathematics.Equality.NormAbsolute;
import Mathematics.Matrix.Command.*;
import Mathematics.Matrix.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Matrix.Function.InverseGaussJordanReal.
 * @author Rune Dahl Iversen
 */
public class InverseGaussJordanRealTest {
    private NormAbsolute<Matrix<Double>> _comparer;

    public InverseGaussJordanRealTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        double precision = Math.pow(10.0, -10.0);
        this._comparer = new NormAbsolute<Matrix<Double>>(precision, new Mathematics.Norm.MatrixRealMaximum());
    }

    @After
    public void tearDown() {
        this._comparer = null;
    }

    /**
     * Test of value method, of class InverseGaussJordanReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Matrix<Double> input = MatrixReal.Identity(1, 2);
        Command<Matrix<Double>> sc = new SwitchColumns<Double>(1,2);
        sc.applyTo(input);
        Matrix<Double> expResult = (Matrix<Double>) input.clone();
        sc = new ScaleColumnReal(2, 2.0);
        sc.applyTo(input);
        InverseGaussJordanReal instance = new InverseGaussJordanReal();
        sc = new ScaleColumnReal(2, 0.5);
        sc.applyTo(expResult);
        Matrix<Double> result = instance.value(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class InverseGaussJordanReal.
     */
    @Test
    public void testValue2() {
        System.out.println("value");
        Matrix<Double> input = MatrixReal.Identity(1, 3);
        input.setValue(1, 2, 2.0);
        input.setValue(1, 3, 3.0);
        input.setValue(2, 1, 4.0);
        input.setValue(2, 2, 5.0);
        input.setValue(2, 3, 6.0);
        input.setValue(3, 1, 7.0);
        input.setValue(3, 2, 8.0);
        input.setValue(3, 3, 10.0);
        InverseGaussJordanReal instance = new InverseGaussJordanReal();
        Matrix<Double> expResult = MatrixReal.Value(1, 3, 1, 3, 1.0);
        expResult.setValue(1, 1, -2.0/3.0);
        expResult.setValue(1, 2, -2.0/3.0);
        expResult.setValue(2, 1, -4.0/3.0);
        expResult.setValue(2, 2, 11.0/3.0);
        expResult.setValue(2, 3, -2.0);
        expResult.setValue(3, 2, -2.0);

        Matrix<Double> result = instance.value(input);
        String message = "Result: " + result.toString() +
                " against Expected: " + expResult.toString();
        assertTrue(message, this._comparer.value(expResult, result));
    }

    /**
     * Test of value method, of class InverseGaussJordanReal.
     */
    @Test
    public void testValue3() {
        System.out.println("value");
        Matrix<Double> input = MatrixReal.Identity(1, 3);
        input = input.scale(2.0);
        input.setValue(1, 2, -1.0);
        input.setValue(2, 1, -1.0);
        input.setValue(3, 2, -1.0);
        input.setValue(2, 3, -1.0);
        InverseGaussJordanReal instance = new InverseGaussJordanReal();
        Matrix<Double> expResult = MatrixReal.Value(1, 3, 1, 3, 0.5);
        expResult.setValue(1, 1, 0.75);
        expResult.setValue(1, 3, 0.25);
        expResult.setValue(2, 2, 1.0);
        expResult.setValue(3, 1, 0.25);
        expResult.setValue(3, 3, 0.75);
        Matrix<Double> result = instance.value(input);
        String message = "Result: " + result.toString() +
                " against Expected: " + expResult.toString();
        assertTrue(message, this._comparer.value(expResult, result));
    }

    /**
     * Test of value method, of class InverseGaussJordanReal.
     */
    @Test
    public void testValue4() {
        System.out.println("value");
        Matrix<Double> input = MatrixReal.Identity(1, 2);
        input.setValue(1, 1, 0.001);
        input.setValue(1, 2, 1.0);
        input.setValue(2, 1, 1.0);
        input.setValue(2, 2, -999.0);
        InverseGaussJordanReal instance = new InverseGaussJordanReal();
        Matrix<Double> expResult = MatrixReal.Value(1, 2, 1, 2, 0.5);
        expResult.setValue(1, 1, 999000.0/1999);
        expResult.setValue(1, 2, 1000.0/1999.0);
        expResult.setValue(2, 1, 1000.0/1999.0);
        expResult.setValue(2, 2, -1.0/1999.0);
        Matrix<Double> result = instance.value(input);
        String message = "Result: " + result.toString() +
                " against Expected: " + expResult.toString();
        assertTrue(message, this._comparer.value(expResult, result));
    }

    /**
     * Test of value method, of class InverseGaussJordanReal,
     * for a non-square matrix.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_NonSquareMatrix() {
        System.out.println("value(non-square matrix)");
        Matrix<Double> input = MatrixReal.Identity(1, 4);
        input = input.removeColumn(2);
        InverseGaussJordanReal instance = new InverseGaussJordanReal();
        input = instance.value(input);
    }

    /**
     * Test of value method, of class InverseGaussJordanReal,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Matrix<Double> input = null;
        InverseGaussJordanReal instance = new InverseGaussJordanReal();
        input = instance.value(input);
    }
}
