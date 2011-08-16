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
 * jUnit for the class Mathematics.Matrix.Command.AddScaledRowReal.
 * @author Rune Dahl Iversen
 */
public class AddScaledRowRealTest {
    private RowsTest<Double> _rowsTest;
    private AddScaledRowReal _instance;
    private Matrix<Double> _matrix;

    public AddScaledRowRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.print("Mathematics.Matrix.Command.AddScaledRowReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._rowsTest = new RowsTest<Double>();
        this._instance = new AddScaledRowReal(1, 2, 2.0);
        this._matrix = MatrixReal.Identity(1, 2);
    }

    @After
    public void tearDown() {
        this._rowsTest = null;
        this._instance = null;
        this._matrix = null;
    }

    /**
     * Test of getRowToAddTo method, of class AddScaledRowReal.
     */
    @Test
    public void testGetRowToAddTo() {
        System.out.println("getRowToAddTo");
        AddScaledRowReal instance = this._instance;
        int expResult = 1;
        int result = instance.getRowToAddTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRowToAddTo method, of class AddScaledRowReal.
     */
    @Test
    public void testSetRowToAddTo() {
        System.out.println("setRowToAddTo");
        int RowToAddTo = 3;
        AddScaledRowReal instance = this._instance;
        instance.setRowToAddTo(RowToAddTo);
        int expResult = 3;
        int result = instance.getRowToAddTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRowToScaleAndAdd method, of class AddScaledRowReal.
     */
    @Test
    public void testGetRowToScaleAndAdd() {
        System.out.println("getRowToScaleAndAdd");
        AddScaledRowReal instance = this._instance;
        int expResult = 2;
        int result = instance.getRowToScaleAndAdd();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRowToScaleAndAdd method, of class AddScaledRowReal.
     */
    @Test
    public void testSetRowToScaleAndAdd() {
        System.out.println("setRowToScaleAndAdd");
        int RowToScaleAndAdd = 3;
        AddScaledRowReal instance = this._instance;
        instance.setRowToScaleAndAdd(RowToScaleAndAdd);
        int expResult = 3;
        int result = instance.getRowToScaleAndAdd();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstRow method, of class AddScaledRowReal.
     */
    @Test
    public void testGetFirstRow() {
        System.out.println("getFirstRow");
        this._rowsTest.testGetFirstRow(this._instance, 1);
    }

    /**
     * Test of setFirstRow method, of class AddScaledRowReal.
     */
    @Test
    public void testSetFirstRow() {
        System.out.println("setFirstRow");
        this._rowsTest.testSetFirstRow(this._instance, 14);
    }

    /**
     * Test of getSecondRow method, of class AddScaledRowReal.
     */
    @Test
    public void testGetSecondRow() {
        System.out.println("getSecondRow");
        this._rowsTest.testGetSecondRow(this._instance, 2);
    }

    /**
     * Test of setSecondRow method, of class AddScaledRowReal.
     */
    @Test
    public void testSetSecondRow() {
        System.out.println("setSecondRow");
        this._rowsTest.testSetSecondRow(this._instance, 14);
    }

    /**
     * Test of getScalar method, of class AddScaledRowReal.
     */
    @Test
    public void testGetScalar() {
        System.out.println("getScalar");
        AddScaledRowReal instance = this._instance;
        double expResult = 2.0;
        double result = instance.getScalar();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setScalar method, of class AddScaledRowReal.
     */
    @Test
    public void testSetScalar() {
        System.out.println("setScalar");
        double scalar = -2.0;
        AddScaledRowReal instance = this._instance;
        instance.setScalar(scalar);
        double expResult = -2.0;
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
        AddScaledRowReal instance = this._instance;
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
        AddScaledRowReal instance = this._instance;
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
        AddScaledRowReal instance = this._instance;
        instance.setScalar(scalar);
    }

    /**
     * Test of applyTo method, of class AddScaledRowReal.
     */
    @Test
    public void testApplyTo() {
        System.out.println("applyTo");
        Matrix<Double> matrix = this._matrix;
        AddScaledRowReal instance = this._instance;
        Matrix<Double> expResult = MatrixReal.Identity(1, 2);
        expResult.setValue(1, 2, 2.0);
        Matrix result = instance.applyTo(matrix);
        assertEquals(expResult, result);
    }
}
