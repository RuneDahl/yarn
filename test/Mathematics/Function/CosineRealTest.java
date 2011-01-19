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
 * jUnit test for the class Mathematics.Function.CosineReal.
 * @author Rune Dahl Iversen
 */
public class CosineRealTest {
    private TrigonometricTest<Double> _trig;
    private CosineReal _instance;

    public CosineRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.CosineReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._trig = new TrigonometricTest<Double>();
        this._instance = new CosineReal(2.0, 0.4, 0.2);
    }

    @After
    public void tearDown() {
        this._trig = null;
        this._instance = null;
    }

    /**
     * Test of getAmplitude method, of class CosineReal.
     */
    @Test
    public void testGetAmplitude() {
        System.out.println("getAmplitude");
        CosineReal instance = this._instance;
        this._trig.testGetAmplitude(instance, 2.0);
    }

    /**
     * Test of getFrequency method, of class CosineReal.
     */
    @Test
    public void testGetFrequency() {
        System.out.println("getFrequency");
        CosineReal instance = this._instance;
        this._trig.testGetFrequency(instance, 0.4);
    }

    /**
     * Test of getPhase method, of class CosineReal.
     */
    @Test
    public void testGetPhase() {
        System.out.println("getPhase");
        CosineReal instance = this._instance;
        this._trig.testGetPhase(instance, 0.2);
    }

    /**
     * Test of setAmplitude method, of class CosineReal.
     */
    @Test
    public void testSetAmplitude() {
        System.out.println("setAmplitude");
        CosineReal instance = this._instance;
        this._trig.testSetAmplitude(instance, 17.5);
    }

    /**
     * Test of setAmplitude method, of class CosineReal,
     * for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetAmplitude_Null() {
        System.out.println("setAmplitude(null)");
        CosineReal instance = this._instance;
        this._trig.testSetAmplitude(instance, null);
    }

    /**
     * Test of setAmplitude method, of class CosineReal,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetAmplitude_NaN() {
        System.out.println("setAmplitude(Double.NaN)");
        CosineReal instance = this._instance;
        this._trig.testSetAmplitude(instance, Double.NaN);
    }

    /**
     * Test of setAmplitude method, of class CosineReal,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetAmplitude_NegativeInfinity() {
        System.out.println("setAmplitude(Double.NEGATIVE_INFINITY)");
        CosineReal instance = this._instance;
        this._trig.testSetAmplitude(instance, Double.NEGATIVE_INFINITY);
    }

    /**
     * Test of setAmplitude method, of class CosineReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetAmplitude_PositiveInfinity() {
        System.out.println("setAmplitude(Double.POSITIVE_INFINITY)");
        CosineReal instance = this._instance;
        this._trig.testSetAmplitude(instance, Double.POSITIVE_INFINITY);
    }

    /**
     * Test of setFrequency method, of class CosineReal.
     */
    @Test
    public void testSetFrequency() {
        System.out.println("setFrequency");
        CosineReal instance = this._instance;
        this._trig.testSetFrequency(instance, 17.5);
    }

    /**
     * Test of setFrequency method, of class CosineReal,
     * for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFrequency_Null() {
        System.out.println("setFrequency(null)");
        CosineReal instance = this._instance;
        this._trig.testSetFrequency(instance, null);
    }

    /**
     * Test of setFrequency method, of class CosineReal,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFrequency_NaN() {
        System.out.println("setFrequency(Double.NaN)");
        CosineReal instance = this._instance;
        this._trig.testSetFrequency(instance, Double.NaN);
    }

    /**
     * Test of setFrequency method, of class CosineReal,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFrequency_NegativeInfinity() {
        System.out.println("setFrequency(Double.NEGATIVE_INFINITY)");
        CosineReal instance = this._instance;
        this._trig.testSetFrequency(instance, Double.NEGATIVE_INFINITY);
    }

    /**
     * Test of setFrequency method, of class CosineReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFrequency_PositiveInfinity() {
        System.out.println("setFrequency(Double.POSITIVE_INFINITY)");
        CosineReal instance = this._instance;
        this._trig.testSetFrequency(instance, Double.POSITIVE_INFINITY);
    }

    /**
     * Test of setPhase method, of class CosineReal.
     */
    @Test
    public void testSetPhase() {
        System.out.println("setPhase");
        CosineReal instance = this._instance;
        this._trig.testSetPhase(instance, 17.5);
    }

    /**
     * Test of setPhase method, of class CosineReal,
     * for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPhase_Null() {
        System.out.println("setPhase(null)");
        CosineReal instance = this._instance;
        this._trig.testSetPhase(instance, null);
    }

    /**
     * Test of setPhase method, of class CosineReal,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPhase_NaN() {
        System.out.println("setPhase(Double.NaN)");
        CosineReal instance = this._instance;
        this._trig.testSetPhase(instance, Double.NaN);
    }

    /**
     * Test of setPhase method, of class CosineReal,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPhase_NegativeInfinity() {
        System.out.println("setPhase(Double.NEGATIVE_INFINITY)");
        CosineReal instance = this._instance;
        this._trig.testSetPhase(instance, Double.NEGATIVE_INFINITY);
    }

    /**
     * Test of setPhase method, of class CosineReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetPhase_PositiveInfinity() {
        System.out.println("setPhase(Double.POSITIVE_INFINITY)");
        CosineReal instance = this._instance;
        this._trig.testSetPhase(instance, Double.POSITIVE_INFINITY);
    }

    /**
     * Test of value method, of class CosineReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        CosineReal instance = this._instance;
        Double input = 0.625;
        Double expResult = instance.getAmplitude() * Math.cos(instance.getFrequency()*input + instance.getPhase());
        Double result = instance.value(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class CosineReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value");
        Double input = null;
        Function<Double, Double> instance = this._instance;
        instance.value(input);
    }

    /**
     * Test of equals method, of class CosineReal.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        CosineReal instance = this._instance;

        Object obj = 7.5;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(instance.toString() + " equals " + obj.toString(),
                expResult, result);

        obj = null;
        expResult = false;
        result = instance.equals(obj);
        assertEquals(instance.toString() + " equals null",
                expResult, result);

        CosineReal s = new CosineReal();
        obj = s;
        expResult = false;
        result = instance.equals(obj);
        assertEquals(instance.toString() + " equals " + obj.toString(),
                expResult, result);

        s.setAmplitude(2.0);
        result = instance.equals(obj);
        assertEquals(instance.toString() + " equals " + obj.toString(),
                expResult, result);

        s.setFrequency(0.4);
        result = instance.equals(obj);
        assertEquals(instance.toString() + " equals " + obj.toString(),
                expResult, result);

        expResult = true;
        s.setPhase(0.2);
        result = instance.equals(obj);
        assertEquals(instance.toString() + " equals " + obj.toString(),
                expResult, result);

        obj = this._instance;
        expResult = true;
        result = instance.equals(obj);
        assertEquals(instance.toString() + " equals " + obj.toString(),
                expResult, result);

        obj = new CosineReal(2.0, 0.4, 0.2);
        expResult = true;
        result = instance.equals(obj);
        assertEquals(instance.toString() + " equals " + obj.toString(),
                expResult, result);
    }

    /**
     * Test of hashCode method, of class CosineReal.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        CosineReal instance = this._instance;
        instance.hashCode();
    }
}