/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Determinant;

import Mathematics.Function.Function;
import Mathematics.Matrix.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Matrix.Determinant.MatrixRealThreeDimensionsOrLess.
 * @author Rune Dahl Iversen
 */
public class MatrixRealThreeDimensionsOrLessTest {
    private DimensionLimitsTest _limits;
    private MatrixRealThreeDimensionsOrLess _instance;
    private Matrix<Double> _zeroOneDim;
    private Matrix<Double> _zeroTwoDim;
    private Matrix<Double> _zeroThreeDim;
    private Matrix<Double> _unitOneDim;
    private Matrix<Double> _unitTwoDim;
    private Matrix<Double> _unitThreeDim;
    private Matrix<Double> _matrix;

    public MatrixRealThreeDimensionsOrLessTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.print("Mathematics.Matrix.Determinant.MatrixRealThreeDimensionsOrLess");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._limits = new DimensionLimitsTest();
        this._instance = new MatrixRealThreeDimensionsOrLess();

        this._unitOneDim = MatrixReal.Identity(0, 1);
        this._unitTwoDim = MatrixReal.Identity(2, 2);
        this._unitThreeDim = MatrixReal.Identity(0, 3);

        this._zeroOneDim = MatrixReal.Zero(0, 1, 1 ,1);
        this._zeroTwoDim = MatrixReal.Zero(2, 2, 0, 2);
        this._zeroThreeDim = MatrixReal.Zero(0, 3, 0, 3);

        double i = 1;
        double[][] values = new double[3][3];
        for (int c = 0; c < 3; c++)
            for (int r = 0; r < 3; r++) {
                values[r][c] = i;
                i++;
            }
        values[2][2] = 10.0;
        this._matrix = new MatrixReal(values);
    }

    @After
    public void tearDown() {
        this._limits = null;
        this._instance = null;
    }

    /**
     * Test of getColumnLimit method, of class MatrixRealThreeDimensionsOrLess.
     */
    @Test
    public void testGetColumnLimit() {
        System.out.println("getColumnLimit");
        this._limits.testGetColumnLimit(this._instance, 3);
    }

    /**
     * Test of getRowLimit method, of class MatrixRealThreeDimensionsOrLess.
     */
    @Test
    public void testGetRowLimit() {
        System.out.println("getRowLimit");
        this._limits.testGetRowLimit(this._instance, 3);
    }

    /**
     * Test of value method, of class MatrixRealThreeDimensionsOrLess.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Function<Matrix<Double>, Double> instance = this._instance;

        Double expResult = 1.0;

        Matrix<Double> input = this._unitOneDim;
        Double result = instance.value(input);
        assertEquals(input.toString(), expResult, result, 0.0);

        input = this._unitTwoDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result, 0.0);

        input = this._unitThreeDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result, 0.0);

        expResult = 0.0;

        input = this._zeroOneDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result, 0.0);

        input = this._zeroTwoDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result, 0.0);

        input = this._zeroThreeDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result, 0.0);

        expResult = -3.0;

        input = this._matrix;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result, 0.0);

        input = input.transpose();
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result, 0.0);
    }

    /**
     * Test of value method, of class MatrixRealThreeDimensionsOrLess,
     * for a not square matrix.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_NotSquare() {
        System.out.println("value(too high dimension)");
        Matrix<Double> input = MatrixReal.Zero(0, 2, 0, 3);
        MatrixRealThreeDimensionsOrLess instance = this._instance;
        instance.value(input);
    }

    /**
     * Test of value method, of class MatrixRealThreeDimensionsOrLess,
     * for a square matrix of too high dimension.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_TooHighDimension() {
        System.out.println("value(too high dimension)");
        Matrix<Double> input = MatrixReal.Identity(0, 4);
        MatrixRealThreeDimensionsOrLess instance = this._instance;
        instance.value(input);
    }

    /**
     * Test of value method, of class MatrixRealThreeDimensionsOrLess,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Matrix<Double> input = null;
        MatrixRealThreeDimensionsOrLess instance = this._instance;
        instance.value(input);
    }
}