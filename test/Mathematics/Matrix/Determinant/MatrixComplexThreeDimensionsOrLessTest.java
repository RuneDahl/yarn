/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Determinant;

import Mathematics.Complex;
import Mathematics.Function.Function;
import Mathematics.Matrix.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Matrix.Determinant.MatrixComplexThreeDimensionsOrLess.
 * @author Rune Dahl Iversen
 */
public class MatrixComplexThreeDimensionsOrLessTest {
    private DimensionLimitsTest _limits;
    private MatrixComplexThreeDimensionsOrLess _instance;
    private Matrix<Complex> _zeroOneDim;
    private Matrix<Complex> _zeroTwoDim;
    private Matrix<Complex> _zeroThreeDim;
    private Matrix<Complex> _unitOneDim;
    private Matrix<Complex> _unitTwoDim;
    private Matrix<Complex> _unitThreeDim;
    private Matrix<Complex> _matrix;

    public MatrixComplexThreeDimensionsOrLessTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.print("Mathematics.Matrix.Determinant.MatrixComplexThreeDimensionsOrLess");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._limits = new DimensionLimitsTest();
        this._instance = new MatrixComplexThreeDimensionsOrLess();

        this._unitOneDim = MatrixComplex.Identity(0, 1);
        this._unitTwoDim = MatrixComplex.Identity(2, 2);
        this._unitThreeDim = MatrixComplex.Identity(0, 3);

        this._zeroOneDim = MatrixComplex.Zero(0, 1, 1 ,1);
        this._zeroTwoDim = MatrixComplex.Zero(2, 2, 0, 2);
        this._zeroThreeDim = MatrixComplex.Zero(0, 3, 0, 3);

        Complex i = Complex.RealNumber(1.0);
        Complex[][] values = new Complex[3][3];
        for (int c = 0; c < 3; c++)
            for (int r = 0; r < 3; r++) {
                values[r][c] = i;
                i = i.sum(Complex.RealNumber(1.0));
            }
        values[2][2] = Complex.RealNumber(10.0);
        this._matrix = new MatrixComplex(values);
    }

    @After
    public void tearDown() {
        this._limits = null;
        this._instance = null;
    }

    /**
     * Test of getColumnLimit method, of class MatrixComplexThreeDimensionsOrLess.
     */
    @Test
    public void testGetColumnLimit() {
        System.out.println("getColumnLimit");
        this._limits.testGetColumnLimit(this._instance, 3);
    }

    /**
     * Test of getRowLimit method, of class MatrixComplexThreeDimensionsOrLess.
     */
    @Test
    public void testGetRowLimit() {
        System.out.println("getRowLimit");
        this._limits.testGetRowLimit(this._instance, 3);
    }

    /**
     * Test of value method, of class MatrixComplexThreeDimensionsOrLess.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Function<Matrix<Complex>, Complex> instance = this._instance;

        Complex expResult = Complex.RealNumber(1.0);

        Matrix<Complex> input = this._unitOneDim;
        Complex result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        input = this._unitTwoDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        input = this._unitThreeDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        expResult = Complex.Origin;

        input = this._zeroOneDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        input = this._zeroTwoDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        input = this._zeroThreeDim;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        expResult = Complex.RealNumber(-3.0);

        input = this._matrix;
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        input = input.transpose();
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);
    }

    /**
     * Test of value method, of class MatrixComplexThreeDimensionsOrLess,
     * for a not square matrix.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_NotSquare() {
        System.out.println("value(not square)");
        Matrix<Complex> input = MatrixComplex.Zero(0, 2, 0, 3);
        MatrixComplexThreeDimensionsOrLess instance = this._instance;
        instance.value(input);
    }

    /**
     * Test of value method, of class MatrixComplexThreeDimensionsOrLess,
     * for a square matrix of too high dimension.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_TooHighDimension() {
        System.out.println("value(too high dimension)");
        Matrix<Complex> input = MatrixComplex.Identity(0, 4);
        MatrixComplexThreeDimensionsOrLess instance = this._instance;
        instance.value(input);
    }

    /**
     * Test of value method, of class MatrixComplexThreeDimensionsOrLess,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Matrix<Complex> input = null;
        MatrixComplexThreeDimensionsOrLess instance = this._instance;
        instance.value(input);
    }
}