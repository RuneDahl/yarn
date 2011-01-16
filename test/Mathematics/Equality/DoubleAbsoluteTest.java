/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of the class Mathematics.Equality.DoubleAbsolute.
 * @author Rune Dahl Iversen
 */
public class DoubleAbsoluteTest {
    private final EqualsTest<Double> _equals;
    private final PrecisionBasedTest<Double> _precisionBased;
    private double[] _values;
    private double[] _precisions;
    private DoubleAbsolute _instance;
    private final double _defaultPrecision = Math.pow(10.0, -10.0);

    public DoubleAbsoluteTest() {
        this._equals = new EqualsTest();
        this._precisionBased = new PrecisionBasedTest();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Equality.DoubleAbsolute");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new DoubleAbsolute(this._defaultPrecision);

        this._values = new double[23];
        this._values[0] = Double.NaN;
        this._values[1] = Double.POSITIVE_INFINITY;
        this._values[2] = Double.NEGATIVE_INFINITY;

        this._values[3] = 0.0;
        this._values[4] = Math.pow(10.0, -10.0);
        this._values[5] = -Math.pow(10.0, -10.0);
        this._values[6] = Math.pow(10.0, -9.0);
        this._values[7] = -Math.pow(10.0, -9.0);

        this._values[8] = 1.0;
        this._values[9] = 1.0 + 0.9 * Math.pow(10.0, -10.0);
        this._values[10] = 1.0 - 0.9 * Math.pow(10.0, -10.0);
        this._values[11] = 1.0 + Math.pow(10.0, -9.0);
        this._values[12] = 1.0 - Math.pow(10.0, -9.0);

        this._values[13] = 100.0;
        this._values[14] = 100.0 + 0.9 * Math.pow(10.0, -10.0);
        this._values[15] = 100.0 - 0.9 * Math.pow(10.0, -10.0);
        this._values[16] = 100.0 + Math.pow(10.0, -9.0);
        this._values[17] = 100.0 - Math.pow(10.0, -9.0);

        this._values[18] = Math.pow(10.0, 10.0);
        this._values[19] = Math.pow(10.0, 10.0) + Math.pow(10.0, -10.0);
        this._values[20] = Math.pow(10.0, 10.0) - Math.pow(10.0, -10.0);
        this._values[21] = Math.pow(10.0, 10.0) + Math.pow(10.0, -9.0);
        this._values[22] = Math.pow(10.0, 10.0) - Math.pow(10.0, -9.0);

        this._precisions = new double[5];

        this._precisions[0] = 0.0;
        this._precisions[1] = Math.pow(10.0, -10.0);
        this._precisions[2] = 1.0;
        this._precisions[3] = 100.0;
        this._precisions[4] = Math.pow(10.0, 10.0);
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._values = null;
        this._precisions = null;
    }

    /**
     * Test of the empty contructor, of class DoubleAbsolute.
     */
    @Test
    public void testCtor_Empty() {
        System.out.println("DoubleAbsolute()");
        DoubleAbsolute instance = new DoubleAbsolute();
        assertNotNull(instance);
        assertEquals(0.0, instance.getPrecision(), 0.0);
    }

    /**
     * Test of value method, of class DoubleAbsolute.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        for (int i = 0; i < this._values.length; i++)
        {
            _equals.testValue(_instance, _values[0], _values[i], false);
            _equals.testValue(_instance, _values[1], _values[i], false);
            _equals.testValue(_instance, _values[2], _values[i], false);

            _equals.testValue(_instance, _values[i], _values[0], false);
            _equals.testValue(_instance, _values[i], _values[1], false);
            _equals.testValue(_instance, _values[i], _values[2], false);
        }

        boolean expecteds[] = new boolean[5];
        expecteds[0] = true;
        expecteds[1] = true;
        expecteds[2] = true;
        expecteds[3] = false;
        expecteds[4] = false;

        for (int j = 3; j < 14; j += 5)
        {
            for (int i = 0; i < 5; i++)
            {
                assertEquals("j = " + Integer.toString(j) +
                        " i = " + Integer.toString(i),
                        expecteds[i],
                        _instance.value(_values[j], _values[j + i]));
            }
        }

        // Due to numerical representation causing a lack of difference in values.
        expecteds[3] = true;
        expecteds[4] = true;

        for (int j = 18; j < 19; j += 5)
        {
            for (int i = 0; i < 5; i++)
            {
                assertEquals("j = " + Integer.toString(j) +
                        " i = " + Integer.toString(i),
                        expecteds[i],
                        _instance.value(_values[j], _values[j + i]));
            }
        }

        for (int j = 3; j < 19; j += 5)
        {
            for (int i = 3 - j; i + j < 16; i += 5)
            {
                assertEquals("j = " + Integer.toString(j) +
                        " i = " + Integer.toString(i),
                        i == 0,
                        _instance.value(_values[j], _values[j + i]));
            }
        }
    }

    @Test
    public void testGetPrecision() {
        System.out.println("getPrecision");
        this._precisionBased.testGetPrecision(_instance, Math.pow(10.0, -10.0));
    }

    @Test
    public void testSetPrecision() {
        System.out.println("setPrecision");
        for (int i = 0; i < this._precisions.length; i++)
            this._precisionBased.testSetPrecision(_instance, this._precisions[i]);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetPrecision_NaN() {
        System.out.println("setPrecision(Double.NaN)");
        this._precisionBased.testSetPrecision(_instance, Double.NaN);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetPrecision_NegativeInfinity() {
        System.out.println("setPrecision(Double.NEGATIVE_INFINITY)");
        this._precisionBased.testSetPrecision(_instance, Double.NEGATIVE_INFINITY);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetPrecision_NegativeValue() {
        System.out.println("setPrecision(negative value)");
        this._precisionBased.testSetPrecision(_instance, -_defaultPrecision);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetPrecision_PositiveInfinity() {
        System.out.println("setPrecision(Double.POSITIVE_INFINITY)");
        this._precisionBased.testSetPrecision(_instance, Double.POSITIVE_INFINITY);
    }
}