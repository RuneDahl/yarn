/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Mathematics.Vector.Vector;
import Mathematics.Vector.VectorReal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Function.Rosenbrock.
 * @author Rune Dahl Iversen
 */
public class RosenbrockTest {
    private Rosenbrock _instance;

    public RosenbrockTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.Rosenbrock");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new Rosenbrock();
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of value method, of class Rosenbrock.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Vector<Double> input = new VectorReal(2);
        input = input.setValue(0, 2.4);
        input = input.setValue(1, -1.4);
        Rosenbrock instance = this._instance;
        Double expResult = 5128.51999999999995;
        Double result = instance.value(input);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of value method, of class Rosenbrock.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_WrongDimensions() {
        System.out.println("value");
        Vector<Double> input = new VectorReal(3);
        Rosenbrock instance = this._instance;
        instance.value(input);
    }

    /**
     * Test of value method, of class Rosenbrock, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Vector<Double> input = null;
        Rosenbrock instance = this._instance;
        instance.value(input);
    }
}