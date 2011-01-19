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
 * jUnit test for the class Mathematics.Function.GaussianReal.
 * @author Rune Dahl Iversen
 */
public class GaussianRealTest {
    private double _center, _spread, _scale;
    private GaussianReal _instance;

    public GaussianRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.GaussianReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._center = 1.0;
        this._scale = 0.5;
        this._spread = 4.53;
        this._instance = new GaussianReal(this._center, this._spread, this._scale);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of getCenter method, of class GaussianReal.
     */
    @Test
    public void testGetCenter() {
        System.out.println("getCenter");
        GaussianReal instance = this._instance;
        double expResult = 1.0;
        double result = instance.getCenter();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getScale method, of class GaussianReal.
     */
    @Test
    public void testGetScale() {
        System.out.println("getScale");
        GaussianReal instance = this._instance;
        double expResult = 0.5;
        double result = instance.getScale();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSpread method, of class GaussianReal.
     */
    @Test
    public void testGetSpread() {
        System.out.println("getSpread");
        GaussianReal instance = this._instance;
        double expResult = 4.53;
        double result = instance.getSpread();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCenter method, of class GaussianReal.
     */
    @Test
    public void testSetCenter() {
        System.out.println("setCenter");
        double center = 2.0;
        GaussianReal instance = this._instance;
        instance.setCenter(center);
        assertEquals("Value from getCenter after setCenter.", center, instance.getCenter(), 0.0);
    }

    /**
     * Test of setCenter method, of class GaussianReal,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCenter_NaN() {
        System.out.println("setCenter(Double.NaN)");
        double center = Double.NaN;
        GaussianReal instance = this._instance;
        instance.setCenter(center);
    }

    /**
     * Test of setCenter method, of class GaussianReal,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCenter_NegativeInfinity() {
        System.out.println("setCenter(Double.NEGATIVE_INFINITY)");
        double center = Double.NEGATIVE_INFINITY;
        GaussianReal instance = this._instance;
        instance.setCenter(center);
    }

    /**
     * Test of setCenter method, of class GaussianReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCenter_PositiveInfinity() {
        System.out.println("setCenter(Double.POSITIVE_INFINITY)");
        double center = Double.POSITIVE_INFINITY;
        GaussianReal instance = this._instance;
        instance.setCenter(center);
    }

    /**
     * Test of setScale method, of class GaussianReal.
     */
    @Test
    public void testSetScale() {
        System.out.println("setScale");
        double scale = 456.4560435;
        GaussianReal instance = this._instance;
        instance.setScale(scale);
        assertEquals("Value from getScale after setScale.", scale, instance.getScale(), 0.0);
    }

    /**
     * Test of setScale method, of class GaussianReal,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScale_NaN() {
        System.out.println("setScale(Double.NaN)");
        double scale = Double.NaN;
        GaussianReal instance = this._instance;
        instance.setScale(scale);
    }

    /**
     * Test of setScale method, of class GaussianReal,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScale_NegativeInfinity() {
        System.out.println("setScale(Double.NEGATIVE_INFINITY)");
        double scale = Double.NEGATIVE_INFINITY;
        GaussianReal instance = this._instance;
        instance.setScale(scale);
    }

    /**
     * Test of setScale method, of class GaussianReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScale_PositiveInfinity() {
        System.out.println("setScale(Double.POSITIVE_INFINITY)");
        double scale = Double.POSITIVE_INFINITY;
        GaussianReal instance = this._instance;
        instance.setScale(scale);
    }

    /**
     * Test of setSpread method, of class GaussianReal.
     */
    @Test
    public void testSetSpread() {
        System.out.println("setSpread");
        double spread = 456.4560435;
        GaussianReal instance = this._instance;
        instance.setSpread(spread);
        assertEquals("Value from getSpread after setSpread.", spread, instance.getSpread(), 0.0);
    }

    /**
     * Test of setSpread method, of class GaussianReal,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSpread_NaN() {
        System.out.println("setSpread(Double.NaN)");
        double spread = Double.NaN;
        GaussianReal instance = this._instance;
        instance.setSpread(spread);
    }

    /**
     * Test of setSpread method, of class GaussianReal,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSpread_NegativeInfinity() {
        System.out.println("setSpread(Double.NEGATIVE_INFINITY)");
        double spread = Double.NEGATIVE_INFINITY;
        GaussianReal instance = this._instance;
        instance.setSpread(spread);
    }

    /**
     * Test of setSpread method, of class GaussianReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSpread_PositiveInfinity() {
        System.out.println("setSpread(Double.POSITIVE_INFINITY)");
        double spread = Double.POSITIVE_INFINITY;
        GaussianReal instance = this._instance;
        instance.setSpread(spread);
    }

    /**
     * Test of value method, of class GaussianReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Function<Double, Double> instance = this._instance;
        Double input = 0.0;
        Double expResult = 0.48796451856213685;
        Double result = instance.value(input);
        assertEquals("Value of " + input.toString(), expResult, result);

        input = 2.0;
        result = instance.value(input);
        assertEquals("Value of " + input.toString(), expResult, result);

        input = Double.NaN;
        expResult = Double.NaN;
        result = instance.value(input);
        assertEquals("Value of " + input.toString(), expResult, result);

        input = Double.NEGATIVE_INFINITY;
        expResult = 0.0;
        result = instance.value(input);
        assertEquals("Value of " + input.toString(), expResult, result);

        input = Double.POSITIVE_INFINITY;
        expResult = 0.0;
        result = instance.value(input);
        assertEquals("Value of " + input.toString(), expResult, result);

        input = 1.0;
        expResult = 0.5;
        result = instance.value(input);
        assertEquals("Value of " + input.toString(), expResult, result);
    }

    /**
     * Test of value method, of class GaussianReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        Double input = null;
        GaussianReal instance = this._instance;
        instance.value(input);
    }
}