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
 * jUnit for the class Mathematics.Matrix.Command.SwitchRows.
 * @author Rune Dahl Iversen
 */
public class SwitchRowsTest {
    private RowsTest<Double> _rowsTest;
    private SwitchRows<Double> _instance;
    private Matrix<Double> _matrix;

    public SwitchRowsTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.print("Mathematics.Matrix.Command.SwitchRows<T>");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._rowsTest = new RowsTest<Double>();
        this._instance = new SwitchRows<Double>(1, 2);
        this._matrix = MatrixReal.Identity(1, 3);
    }

    @After
    public void tearDown() {
        this._rowsTest = null;
        this._instance = null;
        this._matrix = null;
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
     * Test of applyTo method, of class SwitchRows.
     */
    @Test
    public void testApplyTo() {
        System.out.println("applyTo");
        Matrix<Double> matrix = this._matrix;
        Mathematics.Command<Matrix<Double>> instance = this._instance;
        Matrix expResult = MatrixReal.Zero(1, 3, 1, 3);
        expResult.setValue(1, 2, 1.0);
        expResult.setValue(2, 1, 1.0);
        expResult.setValue(3, 3, 1.0);
        Matrix result = instance.applyTo(matrix);
        assertEquals(expResult, result);
    }

    /**
     * Test of applyTo method, of class SwitchRows.
     */
    @Test
    public void testApplyTo_HavingSameRows() {
        System.out.println("applyTo(having same rows)");
        Matrix<Double> matrix = this._matrix;
        SwitchRows<Double> instance = this._instance;
        instance.setFirstRow(instance.getSecondRow());
        Matrix expResult = MatrixReal.Identity(1, 3);
        Matrix result = instance.applyTo(matrix);
        assertEquals(expResult, result);
    }
}
