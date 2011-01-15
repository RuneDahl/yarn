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
 * jUnit-test for the class Mathematics.Convergence.RichardsonExtrapolationReal.
 * @author Rune Dahl Iversen
 */
public class RichardsonExtrapolationRealTest {
    private RichardsonExtrapolationReal _richardson;
    private Double[] _series;

    public RichardsonExtrapolationRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Convergence.RichardsonExtrapolationReal.");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._richardson = new RichardsonExtrapolationReal(2.0);
        this._series = new Double[5];
        this._series[0] = 0.25;
        this._series[1] = 0.125;
        this._series[2] = 0.0625;
        this._series[3] = 0.03125;
        this._series[4] = 0.015625;
    }

    @After
    public void tearDown() {
        this._richardson = null;
        this._series = null;
    }

    /**
     * Test of getFactor method, of class RichardsonExtrapolationReal.
     */
    @Test
    public void testGetFactor() {
        System.out.println("getFactor");
        RichardsonExtrapolationReal instance = this._richardson;
        double expResult = 2.0;
        double result = instance.getFactor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFactor method, of class RichardsonExtrapolationReal.
     */
    @Test
    public void testSetFactor() {
        System.out.println("setFactor");
        double factor = 8.0;
        RichardsonExtrapolationReal instance = this._richardson;
        instance.setFactor(factor);
        double expResult = 8.0;
        double result = instance.getFactor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFactor method, of class RichardsonExtrapolationReal,
     * for the value 1.0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFactor_One() {
        System.out.println("setFactor(1.0)");
        double factor = 1.0;
        RichardsonExtrapolationReal instance = this._richardson;
        instance.setFactor(factor);
    }

    /**
     * Test of setFactor method, of class RichardsonExtrapolationReal,
     * for the value 0.0.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFactor_Zero() {
        System.out.println("setFactor(0.0)");
        double factor = 0.0;
        RichardsonExtrapolationReal instance = this._richardson;
        instance.setFactor(factor);
    }

    /**
     * Test of setFactor method, of class RichardsonExtrapolationReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFactor_PositiveInfinity() {
        System.out.println("setFactor(Double.POSITIVE_INFINITY)");
        double factor = Double.POSITIVE_INFINITY;
        RichardsonExtrapolationReal instance = this._richardson;
        instance.setFactor(factor);
    }

    /**
     * Test of setFactor method, of class RichardsonExtrapolationReal,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFactor_NaN() {
        System.out.println("setFactor(Double.NaN)");
        double factor = Double.NaN;
        RichardsonExtrapolationReal instance = this._richardson;
        instance.setFactor(factor);
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal.
     */
    @Test
    public void testValue_Integer_DoubleArr() {
        System.out.println("value(Integer, Double[])");
        Double[] sequence = this._series;
        RichardsonExtrapolationReal instance = this._richardson;
        for (Integer iteration = 0; iteration < 5; iteration++) {
            Double expResult = (iteration == 0 ? 0.25 : 0.0);
            Double result = instance.value(iteration, sequence);
            assertEquals("Wrong accelerated value for iteration " +
                    Integer.toString(iteration), expResult, result);
        }
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal,
     * for the wrong integer value.
     */
    @Test (expected=IllegalStateException.class)
    public void testValue_Integer_DoubleArr_WrongIteration() {
        System.out.println("value(Integer (wrong value), Double[])");
        Double[] sequence = this._series;
        RichardsonExtrapolationReal instance = this._richardson;
        for (Integer iteration = 0; iteration < 5; iteration++) {
            instance.value(iteration, sequence);
        }
        instance.value(3, sequence);
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal,
     * for a null array value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Integer_Null() {
        System.out.println("value(Integer, null)");
        Double[] sequence = null;
        RichardsonExtrapolationReal instance = this._richardson;
        Integer iteration = 2;
        instance.value(iteration, sequence);
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal,
     * for an array value with a null value in it.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Integer_DoubleArrWithNullValue() throws Exception {
        Integer iteration = 0;
        try {
            System.out.println("value(Integer, Double[])");
            Double[] sequence = this._series;
            sequence[2] = null;
            RichardsonExtrapolationReal instance = this._richardson;
            for (; iteration < 5; iteration++) {
                Double expResult = (iteration == 0 ? 0.25 : 0.0);
                Double result = instance.value(iteration, sequence);
                assertEquals("Wrong accelerated value for iteration " +
                        Integer.toString(iteration), expResult, result);
            }
        }
        catch (NullPointerException npe) {
            if (iteration == 2)
                throw npe;
            else
                fail("Wrong iteration value: " + Integer.toString(iteration));
        }
        catch (Exception e) {
            fail("Wrong exception thrown: " + e.getClass().getName());
        }
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal,
     * for an array value of length zero.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testValue_Integer_DoubleArrLengthZero() {
        System.out.println("value(Integer, 0-array)");
        Double[] sequence = new Double[0];
        RichardsonExtrapolationReal instance = this._richardson;
        Integer iteration = 2;
        instance.value(iteration, sequence);
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal,
     * for a null Integer value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null_DoubleArr() {
        System.out.println("value(null, Double[])");
        Double[] sequence = this._series;
        RichardsonExtrapolationReal instance = this._richardson;
        Integer iteration = null;
        instance.value(iteration, sequence);
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal.
     */
    @Test
    public void testValue_DoubleArr() {
        System.out.println("value(Double[])");
        Double[] sequence = this._series;
        RichardsonExtrapolationReal instance = this._richardson;
        Double[] expResult = new Double[] { 0.25, 0.0, 0.0, 0.0, 0.0};
        Double[] result = instance.value(sequence);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal,
     * for the value null.
     */
    @Test
    public void testValue_Null() {
        System.out.println("value(null)");
        Double[] sequence = null;
        RichardsonExtrapolationReal instance = this._richardson;
        Double[] result = instance.value(sequence);
        assertNull(result);
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal,
     * for an array with null values.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_ArrayWithNullValues() {
        System.out.println("value(Double[] containing at least one null value)");
        Double[] sequence = this._series;
        sequence[3] = null;
        RichardsonExtrapolationReal instance = this._richardson;
        Double[] result = instance.value(sequence);
        assertNull(result);
    }

    /**
     * Test of value method, of class RichardsonExtrapolationReal,
     * for an array value of length zero.
     */
    @Test
    public void testValue_DoubleArrLengthZero() {
        System.out.println("value(0-array)");
        Double[] sequence = new Double[0];
        RichardsonExtrapolationReal instance = this._richardson;
        Double[] result = instance.value(sequence);
        Double[] expResult = new Double[0];
        assertArrayEquals(expResult, result);
    }
}