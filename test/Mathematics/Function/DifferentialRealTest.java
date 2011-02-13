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
 * jUnit test of the class Mathematics.Function.DifferentialReal.
 * @author Rune Dahl Iversen
 */
public class DifferentialRealTest {
    private DifferentialTest<Double, Double> _dt;
    private DifferentialReal _instance;

    public DifferentialRealTest() { // Intetional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.DifferentialReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intetional
    }

    @Before
    public void setUp() {
        this._dt = new DifferentialTest<Double, Double>();
        this._instance = new DifferentialReal(
                Math.pow(10.0, -8.0), DifferentialDirections.Central);
    }

    @After
    public void tearDown() {
        this._dt = null;
        this._instance = null;
    }

    /**
     * Test of getDirection method, of class DifferentialReal.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        DifferentialReal instance = this._instance;
        DifferentialDirections expResult = DifferentialDirections.Central;
        this._dt.testGetDirection(instance, expResult);
    }

    /**
     * Test of setDirection method, of class DifferentialReal.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        DifferentialReal instance = this._instance;
        DifferentialDirections direction = DifferentialDirections.Positive;
        this._dt.testSetDirection(instance, direction);
    }

    /**
     * Test of setDirection method, of class DifferentialReal,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetDirection_Null() {
        System.out.println("setDirection(null)");
        DifferentialReal instance = this._instance;
        DifferentialDirections direction = null;
        this._dt.testSetDirection(instance, direction);
    }

    /**
     * Test of getStep method, of class DifferentialReal.
     */
    @Test
    public void testGetStep() {
        System.out.println("getDirection");
        DifferentialReal instance = this._instance;
        double expResult = Math.pow(10.0, -8.0);
        this._dt.testGetStep(instance, expResult);
    }

    /**
     * Test of setStep method, of class DifferentialReal.
     */
    @Test
    public void testSetStep() {
        System.out.println("setStep");
        DifferentialReal instance = this._instance;
        double step = Math.pow(10.0, -5.0);
        this._dt.testSetStep(instance, step);
    }

    /**
     * Test of setStep method, of class DifferentialReal,
     * for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetStep_Null() {
        System.out.println("setStep(null)");
        DifferentialReal instance = this._instance;
        Double step = null;
        this._dt.testSetStep(instance, step);
    }

    /**
     * Test of value method, of class DifferentialReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Differential<Double, Double> instance = this._instance;

        Double value = 0.0;
        Function<Double, Double> function = new SineReal();
        Double expResult = 1.0;
        Double result = instance.value(value, function);
        assertEquals(function.toString() + " differential at " + value.toString(),
                expResult, result);

        instance.setDirection(DifferentialDirections.Negative);
        value = 0.0;
        function = new SineReal();
        expResult = 1.0;
        result = instance.value(value, function);
        assertEquals(function.toString() + " differential at " + value.toString(),
                expResult, result);

        instance.setDirection(DifferentialDirections.Positive);
        value = 0.0;
        function = new SineReal();
        expResult = 1.0;
        result = instance.value(value, function);
        assertEquals(function.toString() + " differential at " + value.toString(),
                expResult, result);
    }

    /**
     * Test of value method, of class DifferentialReal.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_ValueNull() {
        System.out.println("value(null, function)");
        Double value = null;
        Function<Double, Double> function = new SineReal();
        DifferentialReal instance = this._instance;
        instance.value(value, function);
    }

    /**
     * Test of value method, of class DifferentialReal.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_FunctionNull() {
        System.out.println("value(value, null)");
        Double value = 2.0;
        Function<Double, Double> function = null;
        DifferentialReal instance = this._instance;
        instance.value(value, function);
    }
}