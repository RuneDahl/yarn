/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix.Product;

import Mathematics.Function.Operator;
import Mathematics.Matrix.*;
import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Matrix.Product.OrdinaryReal.
 * @author Rune Dahl Iversen
 */
public class OrdinaryRealTest {
    private OrdinaryReal _instance;

    public OrdinaryRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Matrix.Product.OrdinaryReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new OrdinaryReal();
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
        Matrix<Double> expResult = MatrixReal.Identity(0, 3);
        Matrix<Double> result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " * " + secondInput.toString(), expResult, result);

        firstInput = MatrixReal.Identity(0, 3);
        secondInput = secondInput.addColumn(new VectorReal(3, 4.5));
        expResult = expResult.addColumn(new VectorReal(3, 4.5));
        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " * " + secondInput.toString(), expResult, result);

        firstInput = firstInput.addRow(new VectorReal(3, -2.0));
        secondInput = secondInput.addColumn(new VectorReal(3, 0.5));
        expResult = expResult.addColumn(new VectorReal(new double[]{0.5, 0.5, 0.5}));
        expResult = expResult.addRow(new VectorReal(new double[]{-2.0, -2.0, -2.0, -27.0, -3.0}));
        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " * " + secondInput.toString(), expResult, result);

        secondInput = secondInput.removeColumn(0);
        secondInput = secondInput.removeColumn(0);
        secondInput = secondInput.removeColumn(0);
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
        OrdinaryReal instance = this._instance;
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
        OrdinaryReal instance = this._instance;
        instance.value(firstInput, secondInput);
    }
    
    /**
     * Test of value method, of class OrdinaryReal,
     * for mismatched first dimensions.
     */
    @Test (expected=ArithmeticException.class)
    public void testValue_WrongFirstDimensions() {
        System.out.println("value(wrong first dimensions)");
        Matrix<Double> firstInput = MatrixReal.Identity(1, 3);
        Matrix<Double> secondInput = MatrixReal.Identity(0, 3);
        OrdinaryReal instance = this._instance;
        instance.value(firstInput, secondInput);
    }

    /**
     * Test of value method, of class OrdinaryReal,
     * for mismatched dimensions.
     */
    @Test (expected=ArithmeticException.class)
    public void testValue_WrongDimensions() {
        System.out.println("value(wrong dimensions)");
        Matrix<Double> firstInput = MatrixReal.Identity(0, 4);
        Matrix<Double> secondInput = MatrixReal.Identity(0, 3);
        OrdinaryReal instance = this._instance;
        instance.value(firstInput, secondInput);
    }
}