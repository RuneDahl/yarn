/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Product;

import Mathematics.Function.Operator;
import Mathematics.Matrix.*;
import Mathematics.Matrix.Command.SwitchRows;
import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Matrix.Product.KroneckerReal.
 * @author Rune Dahl Iversen
 */
public class KroneckerRealTest {
    private KroneckerReal _instance;

    public KroneckerRealTest() { // Instance
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Matrix.Product.KroneckerReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Instance
    }

    @Before
    public void setUp() {
        this._instance = new KroneckerReal();
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of value method, of class OrdinaryReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Operator<Matrix<Double>, Matrix<Double>, Matrix<Double>> instance = this._instance;

        Matrix<Double> firstInput = MatrixReal.Identity(0, 3);
        Matrix<Double> secondInput = MatrixReal.Identity(0, 3);
        Matrix<Double> expResult = MatrixReal.Identity(0, 9);
        Matrix<Double> result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " * " + secondInput.toString(), expResult, result);

        firstInput = MatrixReal.Identity(0, 3);
        secondInput = secondInput.addColumn(new VectorReal(3, 4.5));
        expResult = expResult.join(new MatrixReal(9, 3, 0.0));
        for (int i = 0; i < 3; i++) {
            expResult.setValue(i, 9 + i, 4.5);
            expResult.setValue(3 + i, 9 + i, 4.5);
            expResult.setValue(6 + i, 9 + i, 4.5);
        }
        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " * " + secondInput.toString(), expResult, result);

        firstInput = firstInput.addRow(new VectorReal(3, -2.0));
        secondInput = secondInput.addColumn(new VectorReal(3, 0.5));
        MatrixReal t = MatrixReal.Zero(0, 9, 0, 3);
        for (int i = 0; i < 3; i++) {
            t.setValue(i, i, 0.5);
            t.setValue(3 + i, i, 0.5);
            t.setValue(6 + i, i, 0.5);
        }
        expResult = expResult.join(t);

        expResult = expResult.addRow(new VectorReal(new double[]{-2.0, -2.0, -2.0, -0.0, -0.0, -0.0, -0.0, -0.0, -0.0, -9.0, -9.0, -9.0, -1.0, -1.0, -1.0}));
        for (int row = expResult.getLastRow(); 3 < row; row--)
            expResult = new Mathematics.Matrix.Command.SwitchRows<Double>(row, row-1).applyTo(expResult);
        expResult = expResult.addRow(new VectorReal(new double[]{-0.0, -0.0, -0.0, -2.0, -2.0, -2.0, -0.0, -0.0, -0.0, -9.0, -9.0, -9.0, -1.0, -1.0, -1.0}));
        for (int row = expResult.getLastRow(); 7 < row; row--)
            expResult = new Mathematics.Matrix.Command.SwitchRows<Double>(row, row-1).applyTo(expResult);
        expResult = expResult.addRow(new VectorReal(new double[]{-0.0, -0.0, -0.0, -0.0, -0.0, -0.0, -2.0, -2.0, -2.0, -9.0, -9.0, -9.0, -1.0, -1.0, -1.0}));


        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " * " + secondInput.toString(), expResult, result);

        secondInput = secondInput.removeColumn(0);
        secondInput = secondInput.removeColumn(0);
        secondInput = secondInput.removeColumn(0);
        expResult = expResult.removeColumn(0);
        expResult = expResult.removeColumn(0);
        expResult = expResult.removeColumn(0);
        expResult = expResult.removeColumn(0);
        expResult = expResult.removeColumn(0);
        expResult = expResult.removeColumn(0);
        expResult = expResult.removeColumn(0);
        expResult = expResult.removeColumn(0);
        expResult = expResult.removeColumn(0);
        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " * " + secondInput.toString(), expResult, result);
    }

    /**
     * Test of value method, of class OrdinaryReal,
     * for the first value as null.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_FirstNull() {
        System.out.println("value(null, m)");
        Matrix<Double> firstInput = null;
        Matrix<Double> secondInput = MatrixReal.Identity(0, 3);
        KroneckerReal instance = this._instance;
        instance.value(firstInput, secondInput);
    }

    /**
     * Test of value method, of class OrdinaryReal,
     * for the second value as null.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_SecondNull() {
        System.out.println("value(m, null)");
        Matrix<Double> firstInput = MatrixReal.Identity(0, 3);
        Matrix<Double> secondInput = null;
        KroneckerReal instance = this._instance;
        instance.value(firstInput, secondInput);
    }
 }