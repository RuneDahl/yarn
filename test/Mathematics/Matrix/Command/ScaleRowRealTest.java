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
 * jUnit test for the class Mathematics.Matrix.Command.ScaleRowReal.
 * @author Rune Dahl Iversen
 */
public class ScaleRowRealTest {
    private RowTest<Double> _rowTest;
    private ScaleRowReal _instance;
    private Matrix<Double> _matrix;

    public ScaleRowRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._rowTest = new RowTest<Double>();
        this._instance = new ScaleRowReal(2, -2.0);
        this._matrix = MatrixReal.Value(1, 3, 1, 3, 2.0);
    }

    @After
    public void tearDown() {
        this._rowTest = null;
        this._instance = null;
        this._matrix = null;
    }

    /**
     * Test of getRow method, of class AddScaledRowReal.
     */
    @Test
    public void testGetFirstRow() {
        System.out.println("getRow");
        this._rowTest.testGetRow(this._instance, 2);
    }

    /**
     * Test of setRow method, of class AddScaledRowReal.
     */
    @Test
    public void testSetFirstRow() {
        System.out.println("setRow");
        this._rowTest.testSetRow(this._instance, 14);
    }

    /**
     * Test of getScalar method, of class ScaleRowReal.
     */
    @Test
    public void testGetScalar() {
        System.out.println("getScalar");
        ScaleRowReal instance = this._instance;
        double expResult = -2.0;
        double result = instance.getScalar();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setScalar method, of class ScaleRowReal.
     */
    @Test
    public void testSetScalar() {
        System.out.println("setScalar");
        double scalar = 2.0;
        ScaleRowReal instance = this._instance;
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
        ScaleRowReal instance = this._instance;
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
        ScaleRowReal instance = this._instance;
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
        ScaleRowReal instance = this._instance;
        instance.setScalar(scalar);
    }

    /**
     * Test of applyTo method, of class ScaleRowReal.
     */
    @Test
    public void testApplyTo() {
        System.out.println("applyTo");
        Matrix<Double> matrix = this._matrix;
        ScaleRowReal instance = this._instance;
        Matrix<Double> expResult = MatrixReal.Value(1, 3, 1, 3, 2.0);
        expResult.setValue(2, 1, -4.0);
        expResult.setValue(2, 2, -4.0);
        expResult.setValue(2, 3, -4.0);
        Matrix result = instance.applyTo(matrix);
        assertEquals(expResult, result);
    }
}
