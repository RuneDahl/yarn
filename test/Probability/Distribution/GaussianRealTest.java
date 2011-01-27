/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

import Mathematics.Interval.EndType;
import Mathematics.Result.IterativeSuccess;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Probability.Random.GaussianReal.
 * @author Rune Dahl Iversen
 */
public class GaussianRealTest {
    private GaussianReal _instance;

    public GaussianRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Probability.Random.GaussianReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new GaussianReal(-1.2, 3.4);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of getDeviance method, of class GaussianReal.
     */
    @Test
    public void testGetDeviance() {
        System.out.println("getDeviance");
        GaussianReal instance = this._instance;
        Double expResult = 3.4;
        Double result = instance.getDeviance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocation method, of class GaussianReal.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        GaussianReal instance = this._instance;
        Double expResult = -1.2;
        Double result = instance.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMean method, of class GaussianReal.
     */
    @Test
    public void testGetMean() {
        System.out.println("getMean");
        GaussianReal instance = this._instance;
        Double expResult = -1.2;
        Double result = instance.getMean();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScale method, of class GaussianReal.
     */
    @Test
    public void testGetScale() {
        System.out.println("getScale");
        GaussianReal instance = this._instance;
        Double expResult = 3.4;
        Double result = instance.getScale();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVariance method, of class GaussianReal.
     */
    @Test
    public void testGetVariance() {
        System.out.println("getVariance");
        GaussianReal instance = this._instance;
        Double expResult = 3.4 * 3.4;
        Double result = instance.getVariance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocation method, of class GaussianReal.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        Double location = 5.6;
        GaussianReal instance = this._instance;
        instance.setLocation(location);
        Double result = instance.getLocation();
        assertEquals(location, result);
    }

    /**
     * Test of setLocation method, of class GaussianReal, for the value null.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetLocation_Null() {
        System.out.println("setLocation(null)");
        Double location = null;
        GaussianReal instance = this._instance;
        instance.setLocation(location);
    }

    /**
     * Test of setLocation method, of class GaussianReal, for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetLocation_NaN() {
        System.out.println("setLocation(Double.NaN)");
        Double location = Double.NaN;
        GaussianReal instance = this._instance;
        instance.setLocation(location);
    }

    /**
     * Test of setLocation method, of class GaussianReal,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetLocation_NegativeInfinity() {
        System.out.println("setLocation(Double.NEGATIVE_INFINITY)");
        Double location = Double.NEGATIVE_INFINITY;
        GaussianReal instance = this._instance;
        instance.setLocation(location);
    }

    /**
     * Test of setLocation method, of class GaussianReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetLocation_PositiveInfinity() {
        System.out.println("setLocation(Double.POSITIVE_INFINITY)");
        Double location = Double.POSITIVE_INFINITY;
        GaussianReal instance = this._instance;
        instance.setLocation(location);
    }

    /**
     * Test of setScale method, of class GaussianReal, for the value null.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScale_Null() {
        System.out.println("setScale(null)");
        Double scale = null;
        GaussianReal instance = this._instance;
        instance.setScale(scale);
    }

    /**
     * Test of setScale method, of class GaussianReal, for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScale_NaN() {
        System.out.println("setScale(Double.NaN)");
        Double scale = Double.NaN;
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
        Double scale = Double.NEGATIVE_INFINITY;
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
        Double scale = Double.POSITIVE_INFINITY;
        GaussianReal instance = this._instance;
        instance.setScale(scale);
    }

    /**
     * Test of setScale method, of class GaussianReal, for the value 0.0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScale_Zero() {
        System.out.println("setScale(0.0)");
        Double scale = 0.0;
        GaussianReal instance = this._instance;
        instance.setScale(scale);
    }

    /**
     * Test of setScale method, of class GaussianReal, for the value -1.0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetScale_NegativeOne() {
        System.out.println("setScale(-1.0)");
        Double scale = -1.0;
        GaussianReal instance = this._instance;
        instance.setScale(scale);
    }

    /**
     * Test of density method, of class GaussianReal.
     */
    @Test
    public void testDensity() {
        System.out.println("density");
        Distribution<Double> instance = this._instance;
        Double value = 0.0;
        double expResult = 0.11025077867690977;
        double result = instance.density(value);
        assertEquals("Density at " + Double.toString(value), expResult, result, 0.0);

        value = -2.4;
        result = instance.density(value);
        assertEquals("Density at " + Double.toString(value), expResult, result, 0.0);

        value = -1.2;
        expResult = 0.1173359648239508;
        result = instance.density(value);
        assertEquals("Density at " + Double.toString(value), expResult, result, 0.0);

        value = Double.POSITIVE_INFINITY;
        expResult = 0.0;
        result = instance.density(value);
        assertEquals("Density at " + Double.toString(value), expResult, result, 0.0);

        value = Double.NEGATIVE_INFINITY;
        expResult = 0.0;
        result = instance.density(value);
        assertEquals("Density at " + Double.toString(value), expResult, result, 0.0);

        value = Double.NaN;
        expResult = Double.NaN;
        result = instance.density(value);
        assertEquals("Density at " + Double.toString(value), expResult, result, 0.0);
    }

    /**
     * Test of density method, of class GaussianReal, for the value null.
     */
    @Test (expected=NullPointerException.class)
    public void testDensity_Null() {
        System.out.println("density(null)");
        Distribution<Double> instance = this._instance;
        Double value = null;
        instance.density(value);
    }

    @Test
    public void testIntegrationOfDensity() {
        double p = Math.pow(10.0, -8.0);
        Mathematics.Equality.Equals<Double> e = new Mathematics.Equality.DoubleAbsolute(p);
        Mathematics.Convergence.Criterion<Double> c =
                new Mathematics.Convergence.EqualsLastValue<Double>(e, 3);
        double m, d;
        m = 17.0; d = 0.004;
        Mathematics.Function.Function<Double, Double> f = new F(m, d);
        Mathematics.IntervalReal i = new Mathematics.IntervalReal(m - 10.0*d, EndType.Includes, m + 10.0*d, EndType.Includes);
        Mathematics.Function.Integration.RombergRealReal ri = new Mathematics.Function.Integration.RombergRealReal(20, i, c);
        Mathematics.Result.Result r = ri.value(f);
        assertTrue("Wrong type of result.", r instanceof IterativeSuccess);
        IterativeSuccess<Double> its = (IterativeSuccess<Double>)r;
        assertEquals("Wrong result value.", 1.0, its.getResult(), 0.00000001);
    }

    private final class F implements Mathematics.Function.Function<Double, Double> {
        private GaussianReal _g;

        public F(final double m, final double d) {
            this._g = new GaussianReal(m, d);
        }

        @Override
        public Double value(final Double value) {
            return this._g.density(value);
        }
    }
}