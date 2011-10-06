/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Command;

import Mathematics.Matrix.Matrix;
import Mathematics.Matrix.MatrixReal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Matrix.Command.ScaleColumnReal.
 * @author Rune Dahl Iversen
 */
public class ScaleColumnRealTest {
    private ColumnTest<Double> _columnTest;
    private ScaleColumnReal _instance;
    private Matrix<Double> _matrix;

    public ScaleColumnRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.print("Mathematics.Matrix.Command.ScaleColumnReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._columnTest = new ColumnTest<Double>();
        this._instance = new ScaleColumnReal(2, -2.0);
        this._matrix = MatrixReal.Value(1, 3, 1, 3, 2.0);
    }

    @After
    public void tearDown() {
        this._columnTest = null;
        this._instance = null;
        this._matrix = null;
    }

    /**
     * Test of getColumn method, of class AddScaledColumnReal.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        this._columnTest.testGetColumn(this._instance, 2);
    }

    /**
     * Test of setColumn method, of class AddScaledColumnReal.
     */
    @Test
    public void testSetColumn() {
        System.out.println("setColumn");
        this._columnTest.testSetColumn(this._instance, 14);
    }

    /**
     * Test of getScalar method, of class ScaleColumnReal.
     */
    @Test
    public void testGetScalar() {
        System.out.println("getScalar");
        ScaleColumnReal instance = this._instance;
        double expResult = -2.0;
        double result = instance.getScalar();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setScalar method, of class ScaleColumnReal.
     */
    @Test
    public void testSetScalar() {
        System.out.println("setScalar");
        double scalar = 2.0;
        ScaleColumnReal instance = this._instance;
        instance.setScalar(scalar);
        double expResult = 2.0;
        double result = instance.getScalar();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setScalar method, of class AddScaledRowReal,
     * to the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScalar_NaN() {
        System.out.println("setScalar(Double.NaN)");
        double scalar = Double.NaN;
        ScaleColumnReal instance = this._instance;
        instance.setScalar(scalar);
    }

    /**
     * Test of setScalar method, of class AddScaledRowReal,
     * to the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScalar_NegativeInfinity() {
        System.out.println("setScalar(Double.NEGATIVE_INFINITY)");
        double scalar = Double.NEGATIVE_INFINITY;
        ScaleColumnReal instance = this._instance;
        instance.setScalar(scalar);
    }

    /**
     * Test of setScalar method, of class AddScaledRowReal,
     * to the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScalar_PositiveInfinity() {
        System.out.println("setScalar(Double.POSITIVE_INFINITY)");
        double scalar = Double.POSITIVE_INFINITY;
        ScaleColumnReal instance = this._instance;
        instance.setScalar(scalar);
    }

    /**
     * Test of applyTo method, of class ScaleColumnReal.
     */
    @Test
    public void testApplyTo() {
        System.out.println("applyTo");
        Matrix<Double> matrix = this._matrix;
        Mathematics.Command<Matrix<Double>> instance = this._instance;
        Matrix<Double> expResult = MatrixReal.Value(1, 3, 1, 3, 2.0);
        expResult.setValue(1, 2, -4.0);
        expResult.setValue(2, 2, -4.0);
        expResult.setValue(3, 2, -4.0);
        Matrix result = instance.applyTo(matrix);
        assertEquals(expResult, result);
    }

    /**
     * Test of applyTo method, of class ScaleColumnReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testApplyTo_Null() {
        System.out.println("applyTo(null)");
        Matrix<Double> matrix = null;
        Mathematics.Command<Matrix<Double>> instance = this._instance;
        instance.applyTo(matrix);
    }
}
