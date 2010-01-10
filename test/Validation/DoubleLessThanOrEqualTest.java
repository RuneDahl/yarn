/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test of the DoubleLessThanOrEqual class.
 * @author Rune Dahl Iversen
 */
public class DoubleLessThanOrEqualTest {
    private ValidatorTest<Double> _tester;
    private LimitBasedTest<Double> _limit;
    private DoubleLessThanOrEqual _instance;
    private Double[] _values;

    public DoubleLessThanOrEqualTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this._tester = new ValidatorTest<Double>();
        this._limit = new LimitBasedTest<Double>();
        this._instance = new DoubleLessThanOrEqual();
        this._values = new Double[7];
        this._values[0] = Double.NEGATIVE_INFINITY;
        this._values[1] = -1.0;
        this._values[2] = 0.0;
        this._values[3] = 1.0;
        this._values[4] = Double.POSITIVE_INFINITY;
        this._values[5] = Double.NaN;
        this._values[6] = null;
    }

    @After
    public void tearDown() {
        this._tester = null;
        this._limit = null;
        this._instance = null;
        this._values = null;
    }

    /**
     * Test of the specified constructor, of class DoubleLessThanOrEqual.
     */
    @Test
    public void testSpecifiedCtor() {
        System.out.println("Testing specified ctor of DoubleLessThanOrEqual.");
        DoubleLessThanOrEqual instance = new DoubleLessThanOrEqual(9.0);
        this._limit.testGetLimit(instance, 9.0);
    }

    /**
     * Test of getLimit method, of class DoubleLessThanOrEqual.
     */
    @Test
    public void testGetLimit() {
        System.out.println("Testing DoubleLessThanOrEqual.getLimit().");
        this._limit.testGetLimit(this._instance, 0.0);
    }

    /**
     * Test of setLimit method, of class DoubleLessThanOrEqual.
     */
    @Test
    public void testSetLimit() {
        System.out.println("Testing DoubleLessThanOrEqual.setLimit(...).");
        this._limit.testSetLimit(this._instance, 1.0);
    }

    /**
     * Test of setLimit method, of class DoubleLessThanOrEqual.
     * Setting the limit to Double.NaN.
     */
    @Test
    public void testSetLimitToNaN() {
        System.out.println("Testing DoubleLessThanOrEqual.setLimit(...) " +
                "with Double.NaN as input.");
        this._limit.testSetLimit(this._instance, Double.NaN);
    }

    /**
     * Test of setLimit method, of class DoubleLessThanOrEqual.
     * Setting the limit to null.
     * This is expected to cause a NullPointerException.
     */
    @Test(expected=NullPointerException.class)
    public void testSetLimitToNull() {
        System.out.println("Testing DoubleLessThanOrEqual.setLimit(...) " +
                "with null input.");
        this._limit.testSetLimit(this._instance, null);
    }

    /**
     * Test of Message method, of class DoubleLessThanOrEqual.
     */
    @Test
    public void testMessage() {
        System.out.println("Testing DoubleLessThanOrEqual.Message(...).");
        this._tester.testMessage(this._instance, this._values[0],
                Double.toString(this._values[0]), "");
        this._tester.testMessage(this._instance, this._values[1],
                Double.toString(this._values[1]), "");
        this._tester.testMessage(this._instance, this._values[2],
                Double.toString(this._values[2]), "");
        this._tester.testMessage(this._instance, this._values[3],
                Double.toString(this._values[3]),
                "1.0 must be less than or equal to 0.0.");
        this._tester.testMessage(this._instance, this._values[4],
                Double.toString(this._values[4]),
                "Infinity must be less than or equal to 0.0.");
        this._tester.testMessage(this._instance, this._values[5],
                Double.toString(this._values[5]),
                "NaN must be less than or equal to 0.0.");
        this._tester.testMessage(this._instance, this._values[6],
                "null", "null must be less than or equal to 0.0.");
    }

    /**
     * Test of Validate method, of class DoubleLessThanOrEqual.
     */
    @Test
    public void testValidate() {
        System.out.println("Testing DoubleLessThanOrEqual.Validate(...)");
        this._tester.testValidate(this._instance, this._values[0], true);
        this._tester.testValidate(this._instance, this._values[1], true);
        this._tester.testValidate(this._instance, this._values[2], true);
        this._tester.testValidate(this._instance, this._values[3], false);
        this._tester.testValidate(this._instance, this._values[4], false);
        this._tester.testValidate(this._instance, this._values[5], false);
        this._tester.testValidate(this._instance, this._values[6], false);
    }
}