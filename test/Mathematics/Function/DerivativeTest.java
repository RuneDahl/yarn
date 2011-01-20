/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Function.Derivative.
 * @author Rune Dahl Iversen
 */
public class DerivativeTest {
    private Derivative<Double, Double, Double> _instance;

    public DerivativeTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.Derivative");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new Derivative<Double, Double, Double>();
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of value method, of class Derivative.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Double value = 7.5;
        double[] values = new double[3];
        values[0] = -1.0;
        values[1] = 0.45;
        values[2] = 0.01;
        Function<Double, Double> function = new PolynomialReal(values);
        Derivative<Double, Double, Double> instance = new Derivative();
        Double expResult = 0.6;
        Double result = instance.value(value, function);
        assertEquals(function.toString() + " derived at " + value.toString(),
                expResult, result);
    }

    /**
     * Test of value method, of class Derivative,
     * for a function that is not differentiable.
     */
    @Test (expected=ArithmeticException.class)
    public void testValue_NotDifferentiableFunction() {
        System.out.println("value(v, not diff'able)");
        Double value = 7.5;
        Function<Double, Double> function = new GaussianReal(0.0, 1.0, 1.0);
        Differentiator<Double, Double, Double> instance = new Derivative();
        Double expResult = 0.6;
        Double result = instance.value(value, function);
        assertEquals(function.toString() + " derived at " + value.toString(),
                expResult, result);
    }

    /**
     * Test of value method, of class Derivative, for a null function.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_FunctionNull() {
        System.out.println("value(v, null)");
        Double value = 7.5;
        Function<Double, Double> function = null;
        Derivative<Double, Double, Double> instance = this._instance;
        instance.value(value, function);
    }

    /**
     * Test of value method, of class Derivative, for a null value.
     * This test depends on how the function  handles a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_ValueNull() {
        System.out.println("value(null, f)");
        Double value = null;
        double[] values = new double[3];
        values[0] = -1.0;
        values[1] = 0.45;
        values[2] = 0.01;
        Function<Double, Double> function = new PolynomialReal(values);
        Derivative<Double, Double, Double> instance = this._instance;
        instance.value(value, function);
    }
}