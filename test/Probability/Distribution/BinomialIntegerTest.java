/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Probability.Distribution;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test of the class Probability.Distribution.BinomialInteger.
 * @author Rune Dahl Iversen
 */
public class BinomialIntegerTest {
    private BinomialInteger _instance;

    public BinomialIntegerTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Probability.Distribution.BinomialInteger");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new BinomialInteger(101, 0.5);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of getCentralMoment method, of class BinomialInteger.
     */
    @Test
    public void testGetCentralMoment() {
        System.out.println("getCentralMoment");
        MomentOfAnyOrder<Double, Integer> instance = this._instance;
        int order = 1;
        double precision = Math.pow(10.0, -9.0);
        double expResult = 0.0;
        double result = instance.getCentralMoment(order);
        assertEquals("Central moment of order " + Integer.toString(order),
                expResult, result, precision);

        order = 2;
        expResult = 25.25;
        result = instance.getCentralMoment(order);
        assertEquals("Central moment of order " + Integer.toString(order),
                expResult, result, precision);

        order = 3;
        expResult = 0.0;
        result = instance.getCentralMoment(order);
        assertEquals("Central moment of order " + Integer.toString(order),
                expResult, result, precision);

        order = 4;
        expResult = 1900.0625;
        result = instance.getCentralMoment(order);
        assertEquals("Central moment of order " + Integer.toString(order),
                expResult, result, precision);
    }

    /**
     * Test of getCentralMoment method, of class BinomialInteger, for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testGetCentralMoment_NegativeOne() {
        System.out.println("getCentralMoment(-1)");
        MomentOfAnyOrder<Double, Integer> instance = this._instance;
        int order = -1;
        instance.getCentralMoment(order);
    }

    /**
     * Test of getCentralMoment method, of class BinomialInteger, for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testGetCentralMoment_Zero() {
        System.out.println("getCentralMoment(0)");
        MomentOfAnyOrder<Double, Integer> instance = this._instance;
        int order = 0;
        instance.getCentralMoment(order);
    }

    /**
     * Test of getDeviance method, of class BinomialInteger.
     */
    @Test
    public void testGetDeviance() {
        System.out.println("getDeviance");
        Variance<Double, Integer> instance = this._instance;
        Double expResult = 5.024937810560445;
        Double result = instance.getDeviance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLowerBound method, of class BinomialInteger.
     */
    @Test
    public void testGetLowerBound() {
        System.out.println("getLowerBound");
        LowerBound<Integer> instance = this._instance;
        Integer expResult = 0;
        Integer result = instance.getLowerBound();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMean method, of class BinomialInteger.
     */
    @Test
    public void testGetMean() {
        System.out.println("getMean");
        Mean<Double, Integer> instance = this._instance;
        Double expResult = 50.5;
        Double result = instance.getMean();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoment method, of class BinomialInteger.
     */
    @Test
    public void testGetMoment() {
        System.out.println("getMoment");
        MomentOfAnyOrder<Double, Integer> instance = this._instance;
        int order = 1;
        double precision = Math.pow(10.0, -9.0);
        double expResult = 50.5;
        double result = instance.getMoment(order);
        assertEquals("Central moment of order " + Integer.toString(order),
                expResult, result, precision);

        order = 2;
        expResult = 2575.5;
        result = instance.getMoment(order);
        assertEquals("Central moment of order " + Integer.toString(order),
                expResult, result, precision);

        order = 3;
        expResult = 132613.0;
        result = instance.getMoment(order);
        assertEquals("Central moment of order " + Integer.toString(order),
                expResult, result, precision);

        precision = Math.pow(10.0, -8.0);
        order = 4;
        expResult = 6892038.0;
        result = instance.getMoment(order);
        assertEquals("Central moment of order " + Integer.toString(order),
                expResult, result, precision);
    }

    /**
     * Test of getMoment method, of class BinomialInteger, for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testGetMoment_NegativeOne() {
        System.out.println("getMoment(-1)");
        MomentOfAnyOrder<Double, Integer> instance = this._instance;
        int order = -1;
        instance.getMoment(order);
    }

    /**
     * Test of getMoment method, of class BinomialInteger, for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testGetMoment_Zero() {
        System.out.println("getMoment(0)");
        MomentOfAnyOrder<Double, Integer> instance = this._instance;
        int order = 0;
        instance.getMoment(order);
    }

    /**
     * Test of getP method, of class BinomialInteger.
     */
    @Test
    public void testGetP() {
        System.out.println("getP");
        BinomialInteger instance = this._instance;
        double expResult = 0.5;
        double result = instance.getP();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setP method, of class BinomialInteger.
     */
    @Test
    public void testSetP() {
        System.out.println("setP");
        double p = 0.1;
        BinomialInteger instance = this._instance;
        instance.setP(p);
        double result = instance.getP();
        assertEquals("Wrong value from getP after use of setP(double).",
                p, result, 0.0);
    }

    /**
     * Test of setP method, of class BinomialInteger,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetP_PositiveInfinity() {
        System.out.println("setP(Double.POSITIVE_INFINITY)");
        double p = Double.POSITIVE_INFINITY;
        BinomialInteger instance = this._instance;
        instance.setP(p);
    }

    /**
     * Test of setP method, of class BinomialInteger, for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetP_NaN() {
        System.out.println("setP(Double.NaN)");
        double p = Double.NaN;
        BinomialInteger instance = this._instance;
        instance.setP(p);
    }

    /**
     * Test of setP method, of class BinomialInteger, for a negative value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetP_Negative() {
        System.out.println("setP(-0.5)");
        double p = -0.5;
        BinomialInteger instance = this._instance;
        instance.setP(p);
    }

    /**
     * Test of getVariance method, of class BinomialInteger.
     */
    @Test
    public void testGetVariance() {
        System.out.println("getVariance");
        BinomialInteger instance = this._instance;
        Double expResult = 25.25;
        Double result = instance.getVariance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUpperBound method, of class BinomialInteger.
     */
    @Test
    public void testGetUpperBound() {
        System.out.println("getUpperBound");
        UpperBound<Integer> instance = this._instance;
        Integer expResult = 101;
        Integer result = instance.getUpperBound();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUpperBound method, of class BinomialInteger.
     */
    @Test
    public void testSetUpperBound() {
        System.out.println("setUpperBound");
        int upperBound = 51;
        BinomialInteger instance = this._instance;
        instance.setUpperBound(upperBound);
        int result = instance.getUpperBound();
        assertEquals("Wrong value from getUpperBound() after use of setUpperBound(int).",
                upperBound, result);
    }

    /**
     * Test of setUpperBound method, of class BinomialInteger,
     * for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetUpperBound_NegativeOne() {
        System.out.println("setUpperBound(-1)");
        int upperBound = -1;
        BinomialInteger instance = this._instance;
        instance.setUpperBound(upperBound);
    }

    /**
     * Test of density method, of class BinomialInteger.
     */
    @Test
    public void testDensity() {
        System.out.println("density");
        Integer value = 0;
        Distribution<Integer> instance = this._instance;
        double expResult = Math.pow(0.5, 101.0);
        double result = instance.density(value);
        assertEquals("Wrong value of density(" + value.toString() + ").",
                expResult, result, 0.0);
        for (value = 1; value < 102; value++) {
            expResult *= (102.0 - value) / value;
            result = instance.density(value);
            assertEquals("Wrong value of density(" + value.toString() + ").",
                    expResult, result, 0.0);
        }
        value = -1;
        expResult = 0.0;
        result = instance.density(value);
        assertEquals("Wrong value of density(" + value.toString() + ").",
                expResult, result, 0.0);
        value = 103;
        expResult = 0.0;
        result = instance.density(value);
        assertEquals("Wrong value of density(" + value.toString() + ").",
                expResult, result, 0.0);
    }

    /**
     * Test of density method, of class BinomialInteger, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testDensity_Null() {
        System.out.println("density(null)");
        Integer value = null;
        Distribution<Integer> instance = this._instance;
        instance.density(value);
    }

    /**
     * Test of densityFactor method, of class BinomialInteger.
     */
    @Test
    public void testDensityFactor() {
        System.out.println("densityFactor");
        DiscreteDensityFactor<Integer> instance = this._instance;
        Integer value = 0;
        double expResult = Math.pow(0.5, 101);
        double result = instance.densityFactor(value);
        assertEquals("Wrong value of densityFactor(" + value.toString() + ").",
                expResult, result, 0.0);
        for (value = 1; value < 102; value++) {
            expResult = (102.0 - value) / value;
            result = instance.densityFactor(value);
            assertEquals("Wrong value of densityFactor(" + value.toString() + ").",
                    expResult, result, 0.0);
        }
        value = -1;
        expResult = 0.0;
        result = instance.densityFactor(value);
        assertEquals("Wrong value of densityFactor(" + value.toString() + ").",
                expResult, result, 0.0);
        value = 103;
        expResult = 0.0;
        result = instance.densityFactor(value);
        assertEquals("Wrong value of densityFactor(" + value.toString() + ").",
                expResult, result, 0.0);
    }

    /**
     * Test of densityFactor method, of class BinomialInteger,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testDensityFactor_Null() {
        System.out.println("densityFactor(null)");
        DiscreteDensityFactor<Integer> instance = this._instance;
        Integer value = null;
        instance.densityFactor(value);
    }

    /**
     * Test of distributionFunction method, of class BinomialInteger.
     */
    @Test
    public void testDistributionFunction() {
        System.out.println("distributionFunction");
        DistributionFunction<Integer> instance = this._instance;
        Integer value = 50;
        double expResult = 0.5000000000000001;
        double result = instance.distributionFunction(value);
        assertEquals("Wrong value from distributionFunction(" + value.toString() + ").",
                expResult, result, 0.0);

        value = -1;
        expResult = 0.0;
        result = instance.distributionFunction(value);
        assertEquals("Wrong value from distributionFunction(" + value.toString() + ").",
                expResult, result, 0.0);

        value = 102;
        expResult = 1.0;
        result = instance.distributionFunction(value);
        assertEquals("Wrong value from distributionFunction(" + value.toString() + ").",
                expResult, result, 0.0);
    }

    /**
     * Test of distributionFunction method, of class BinomialInteger,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testDistributionFunction_Null() {
        System.out.println("distributionFunction(null)");
        Integer value = null;
        DistributionFunction<Integer> instance = this._instance;
        instance.distributionFunction(value);
    }

    /**
     * Test of quantileFunction method, of class BinomialInteger.
     */
    @Test
    public void testQuantileFunction() {
        System.out.println("quantileFunction");
        QuantileFunction<Integer> instance = this._instance;
        double value = 0.0;
        Integer expResult = 0;
        Integer result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 0.1;
        expResult = 44;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 0.2;
        expResult = 46;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 0.3;
        expResult = 48;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 0.4;
        expResult = 49;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 0.5;
        expResult = 50;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 0.6;
        expResult = 52;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 0.7;
        expResult = 53;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 0.8;
        expResult = 55;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 0.9;
        expResult = 57;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);

        value = 1.0;
        expResult = 101;
        result = instance.quantileFunction(value);
        assertEquals("Wrong value from quantileFunction(" + Double.toString(value) + ").",
                expResult, result);
    }
}