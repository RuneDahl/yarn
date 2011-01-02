/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Convergence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Convergence.NumberOfValues<T>.
 * @author Rune Dahl Iversen
 */
public class NumberOfValuesTest {
    Double[] _converged;
    Double[] _notConverged;
    Double[] _null;
    NumberOfValues<Double> _criterion;

    public NumberOfValuesTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Convergence.NumberOfValues<T>.");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._null = null;
        this._converged = new Double[10];
        this._notConverged = new Double[3];
        this._criterion = new NumberOfValues<Double>(5);
    }

    @After
    public void tearDown() {
        this._converged = null;
        this._notConverged = null;
        this._criterion = null;
    }

    /**
     * Test of converges method, of class NumberOfValues.
     */
    @Test
    public void testConverges() {
        System.out.println("converges");
        Double[] series = this._converged;
        NumberOfValues<Double> instance = this._criterion;
        boolean expResult = true;
        boolean result = instance.converges(series);
        assertEquals("Wrong result from converges for a series of 10 values.",
                expResult, result);

        series = this._notConverged;
        expResult = false;
        result = instance.converges(series);
        assertEquals("Wrong result from converges for a series of 3 values.",
                expResult, result);
    }

    /**
     * Test of converges method, of class NumberOfValues, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testConverges_Null() {
        System.out.println("converges(null)");
        Double[] series = this._null;
        NumberOfValues<Double> instance = this._criterion;
        instance.converges(series);
    }

    /**
     * Test of getCount method, of class NumberOfValues.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        NumberOfValues<Double> instance = this._criterion;
        int expResult = 5;
        int result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCount method, of class NumberOfValues.
     */
    @Test
    public void testSetCount() {
        System.out.println("setCount");
        int count = 100;
        NumberOfValues<Double> instance = this._criterion;
        instance.setCount(count);

        int expResult = 100;
        int result = instance.getCount();
        assertEquals("Wrong result from getCount after setCount.",
                expResult, result);
}

    /**
     * Test of setCount method, of class NumberOfValues, for the value 0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCount_Zero() {
        System.out.println("setCount(0)");
        int count = 0;
        NumberOfValues<Double> instance = this._criterion;
        instance.setCount(count);
    }

    /**
     * Test of setCount method, of class NumberOfValues, for a negative value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCount_Negative() {
        System.out.println("setCount(negative)");
        int count = -5;
        NumberOfValues<Double> instance = this._criterion;
        instance.setCount(count);
    }
}