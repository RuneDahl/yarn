/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Interpolation;

import Mathematics.Function.Function;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Interpolation.LinearRealIntoReal.
 * @author Rune Dahl Iversen
 */
public class LinearRealIntoRealTest {
    private InterpolatorTest<Map<Double, Double>, Double, Double> _tester;
    private LinearRealIntoReal _instance;
    private LinkedHashMap _data;

    public LinearRealIntoRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Interpolation.LinearRealIntoReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new InterpolatorTest<Map<Double, Double>, Double, Double>();
        this._data = new LinkedHashMap();
        this._data.put(0.0, 1.0);
        this._data.put(1.0, 2.0);
        this._data.put(2.0, 1.0);
        this._instance = new LinearRealIntoReal(this._data);
    }

    @After
    public void tearDown() {
        this._tester = null;
        this._instance = null;
        this._data = null;
    }

    /**
     * Test of getData method, of class LinearRealIntoReal.
     */
    @Test
    public void testGetData() {
        System.out.println("getData()");
        LinkedHashMap expResult = new LinkedHashMap();
        expResult.put(0.0, 1.0);
        expResult.put(1.0, 2.0);
        expResult.put(2.0, 1.0);
        this._tester.testGetData(this._instance, expResult);
    }

    /**
     * Test of setData method, of class LinearRealIntoReal.
     */
    @Test
    public void testSetData() {
        System.out.println("setData()");
        LinkedHashMap expResult = new LinkedHashMap();
        expResult.put(0.0, 1.0);
        expResult.put(1.0, 2.0);
        expResult.put(2.0, 1.0);
        expResult.put(3.0, 1.5);
        this._tester.testSetData(this._instance, expResult);
    }


    /**
     * Test of setData method, of class LinearRealIntoReal for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetData_Null() {
        System.out.println("setData(null)");
        this._tester.testSetData(this._instance, null);
    }

    /**
     * Test of value method, of class LinearRealIntoReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        LinearRealIntoReal instance = this._instance;
        double input = -0.6;
        double expResult = 0.4;
        double precision = Math.pow(10.0, -15.0);
        double result = instance.value(input);
        assertEquals("Linear interpolation from input " + Double.toString(input),
                expResult, result, precision);

        input = 0.0;
        expResult = 1.0;
        result = instance.value(input);
        assertEquals("Linear interpolation from input " + Double.toString(input),
                expResult, result, precision);

        input = 0.6;
        expResult = 1.6;
        result = instance.value(input);
        assertEquals("Linear interpolation from input " + Double.toString(input),
                expResult, result, precision);

        input = 1.0;
        expResult = 2.0;
        result = instance.value(input);
        assertEquals("Linear interpolation from input " + Double.toString(input),
                expResult, result, precision);

        input = 1.7;
        expResult = 1.3;
        result = instance.value(input);
        assertEquals("Linear interpolation from input " + Double.toString(input),
                expResult, result, precision);

        input = 2.0;
        expResult = 1.0;
        result = instance.value(input);
        assertEquals("Linear interpolation from input " + Double.toString(input),
                expResult, result, precision);

        input = 2.4;
        expResult = 0.6;
        result = instance.value(input);
        assertEquals("Linear interpolation from input " + Double.toString(input),
                expResult, result, precision);

        instance.getData().clear();
        input = 1.5;
        expResult = Double.NaN;
        result = instance.value(input);
        assertEquals("Linear interpolation from input " + Double.toString(input),
                expResult, result, precision);
    }

    /**
     * Test of value method, of class LinearRealIntoReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Function<Double, Double> instance = this._instance;
        Double input = null;
        instance.value(input);
    }
}
