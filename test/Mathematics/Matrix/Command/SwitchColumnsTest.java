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
 * jUnit for the class Mathematics.Matrix.Command.SwitchColumns.
 * @author Rune Dahl Iversen
 */
public class SwitchColumnsTest {
    private ColumnsTest<Double> _columnsTest;
    private SwitchColumns<Double> _instance;
    private Matrix<Double> _matrix;

    public SwitchColumnsTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.print("Mathematics.Matrix.Command.SwitchColumns<T>");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._columnsTest = new ColumnsTest<Double>();
        this._instance = new SwitchColumns<Double>(1, 2);
        this._matrix = MatrixReal.Identity(1, 3);
    }

    @After
    public void tearDown() {
        this._columnsTest = null;
        this._instance = null;
        this._matrix = null;
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
     * Test of applyTo method, of class SwitchColumns.
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
     * Test of applyTo method, of class SwitchColumns.
     */
    @Test
    public void testApplyTo_SameColumns() {
        System.out.println("applyTo(having the same columns)");
        Matrix<Double> matrix = this._matrix;
        SwitchColumns<Double> instance = this._instance;
        instance.setFirstColumn(instance.getSecondColumn());
        Matrix expResult = MatrixReal.Identity(1, 3);
        Matrix result = instance.applyTo(matrix);
        assertEquals(expResult, result);
    }
}
