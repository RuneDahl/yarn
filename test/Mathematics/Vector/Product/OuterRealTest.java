/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector.Product;

import Mathematics.Matrix.*;
import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Vector.Product.OuterReal.
 * @author Rune Dahl Iversen
 */
public class OuterRealTest {
    private OuterReal _instance;

    public OuterRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Vector.Product.OuterReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new OuterReal();
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of value method, of class OuterReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        OuterReal instance = this._instance;

        Vector<Double> firstInput = new VectorReal(3);

        Vector<Double> secondInput = new VectorReal(3);
        Matrix<Double> expResult = new MatrixReal(3, 3);
        Matrix<Double> result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " .*. " + secondInput.toString(), expResult, result);

        firstInput = new VectorReal(3, 1.0);
        expResult = new MatrixReal(3, 3);
        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " .*. " + secondInput.toString(), expResult, result);

        secondInput = new VectorReal(3, 1.0);
        expResult = new MatrixReal(3, 3, 1.0);
        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " .*. " + secondInput.toString(), expResult, result);

        firstInput = firstInput.scale(7.45);
        secondInput = VectorReal.Unit(3, 0);
        expResult = new MatrixReal(3, 3);
        expResult.setValue(0, 0, 7.45);
        expResult.setValue(1, 0, 7.45);
        expResult.setValue(2, 0, 7.45);
        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " .*. " + secondInput.toString(), expResult, result);

        secondInput = VectorReal.Unit(3, 1);
        expResult = new MatrixReal(3, 3);
        expResult.setValue(0, 1, 7.45);
        expResult.setValue(1, 1, 7.45);
        expResult.setValue(2, 1, 7.45);
        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " .*. " + secondInput.toString(), expResult, result);

        secondInput = VectorReal.Unit(3, 2);
        expResult = new MatrixReal(3, 3);
        expResult.setValue(0, 2, 7.45);
        expResult.setValue(1, 2, 7.45);
        expResult.setValue(2, 2, 7.45);
        result = instance.value(firstInput, secondInput);
        assertEquals(firstInput.toString() + " .*. " + secondInput.toString(), expResult, result);
    }

    /**
     * Test of value method, of class OuterReal,
     * for null as the first value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_FirstNull() {
        System.out.println("value(null, v)");
        OuterReal instance = this._instance;

        Vector<Double> firstInput = null;
        Vector<Double> secondInput = new VectorReal(3);
        instance.value(firstInput, secondInput);
    }

    /**
     * Test of value method, of class OuterReal,
     * for null as the second value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_SecondNull() {
        System.out.println("value(v, null)");
        OuterReal instance = this._instance;

        Vector<Double> firstInput = new VectorReal(3);
        Vector<Double> secondInput = null;
        instance.value(firstInput, secondInput);
    }
}