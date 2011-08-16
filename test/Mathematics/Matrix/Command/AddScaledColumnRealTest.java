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
 * jUnit for the class Mathematics.Matrix.Command.AddScaledColumnReal.
 * @author Rune Dahl Iversen
 */
public class AddScaledColumnRealTest {
    private ColumnsTest<Double> _columnsTest;
    private AddScaledColumnReal _instance;
    private Matrix<Double> _matrix;

    public AddScaledColumnRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.print("Mathematics.Matrix.Command.AddScaledColumnReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._columnsTest = new ColumnsTest<Double>();
        this._instance = new AddScaledColumnReal(1, 2, 2.0);
        this._matrix = MatrixReal.Identity(1, 2);
    }

    @After
    public void tearDown() {
        this._columnsTest = null;
        this._instance = null;
        this._matrix = null;
    }

    /**
     * Test of getColumnToAddTo method, of class AddScaledColumnReal.
     */
    @Test
    public void testGetColumnToAddTo() {
        System.out.println("getColumnToAddTo");
        AddScaledColumnReal instance = this._instance;
        int expResult = 1;
        int result = instance.getColumnToAddTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColumnToAddTo method, of class AddScaledColumnReal.
     */
    @Test
    public void testSetColumnToAddTo() {
        System.out.println("setColumnToAddTo");
        int columnToAddTo = 3;
        AddScaledColumnReal instance = this._instance;
        instance.setColumnToAddTo(columnToAddTo);
        int expResult = 3;
        int result = instance.getColumnToAddTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColumnToScaleAndAdd method, of class AddScaledColumnReal.
     */
    @Test
    public void testGetColumnToScaleAndAdd() {
        System.out.println("getColumnToScaleAndAdd");
        AddScaledColumnReal instance = this._instance;
        int expResult = 2;
        int result = instance.getColumnToScaleAndAdd();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColumnToScaleAndAdd method, of class AddScaledColumnReal.
     */
    @Test
    public void testSetColumnToScaleAndAdd() {
        System.out.println("setColumnToScaleAndAdd");
        int columnToScaleAndAdd = 3;
        AddScaledColumnReal instance = this._instance;
        instance.setColumnToScaleAndAdd(columnToScaleAndAdd);
        int expResult = 3;
        int result = instance.getColumnToScaleAndAdd();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstColumn method, of class AddScaledColumnReal.
     */
    @Test
    public void testGetFirstColumn() {
        System.out.println("getFirstColumn");
        this._columnsTest.testGetFirstColumn(this._instance, 1);
    }

    /**
     * Test of setFirstColumn method, of class AddScaledColumnReal.
     */
    @Test
    public void testSetFirstColumn() {
        System.out.println("setFirstColumn");
        this._columnsTest.testSetFirstColumn(this._instance, 14);
    }

    /**
     * Test of getSecondColumn method, of class AddScaledColumnReal.
     */
    @Test
    public void testGetSecondColumn() {
        System.out.println("getSecondColumn");
        this._columnsTest.testGetSecondColumn(this._instance, 2);
    }

    /**
     * Test of setSecondColumn method, of class AddScaledColumnReal.
     */
    @Test
    public void testSetSecondColumn() {
        System.out.println("setSecondColumn");
        this._columnsTest.testSetSecondColumn(this._instance, 14);
    }

    /**
     * Test of getScalar method, of class AddScaledColumnReal.
     */
    @Test
    public void testGetScalar() {
        System.out.println("getScalar");
        AddScaledColumnReal instance = this._instance;
        double expResult = 2.0;
        double result = instance.getScalar();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setScalar method, of class AddScaledColumnReal.
     */
    @Test
    public void testSetScalar() {
        System.out.println("setScalar");
        double scalar = -2.0;
        AddScaledColumnReal instance = this._instance;
        instance.setScalar(scalar);
        double expResult = -2.0;
        double result = instance.getScalar();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setScalar method, of class AddScaledColumnReal,
     * to the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScalar_NaN() {
        System.out.println("setScalar(Double.NaN)");
        double scalar = Double.NaN;
        AddScaledColumnReal instance = this._instance;
        instance.setScalar(scalar);
    }

    /**
     * Test of setScalar method, of class AddScaledColumnReal,
     * to the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScalar_NegativeInfinity() {
        System.out.println("setScalar(Double.NEGATIVE_INFINITY)");
        double scalar = Double.NEGATIVE_INFINITY;
        AddScaledColumnReal instance = this._instance;
        instance.setScalar(scalar);
    }

    /**
     * Test of setScalar method, of class AddScaledColumnReal,
     * to the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScalar_PositiveInfinity() {
        System.out.println("setScalar(Double.POSITIVE_INFINITY)");
        double scalar = Double.POSITIVE_INFINITY;
        AddScaledColumnReal instance = this._instance;
        instance.setScalar(scalar);
    }

    /**
     * Test of applyTo method, of class AddScaledColumnReal.
     */
    @Test
    public void testApplyTo() {
        System.out.println("applyTo");
        Matrix<Double> matrix = this._matrix;
        AddScaledColumnReal instance = this._instance;
        Matrix<Double> expResult = MatrixReal.Identity(1, 2);
        expResult.setValue(2, 1, 2.0);
        Matrix result = instance.applyTo(matrix);
        assertEquals(expResult, result);
    }
}
