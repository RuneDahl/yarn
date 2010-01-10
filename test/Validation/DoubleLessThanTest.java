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
public class DoubleLessThanTest {
    private ValidatorTest<Double> _tester;
    private LimitBasedTest<Double> _limit;
    private DoubleLessThan _instance;
    private Double[] _values;

    public DoubleLessThanTest() {
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
        this._instance = new DoubleLessThan();
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
     * Test of the specified constructor, of class DoubleLessThan.
     */
    @Test
    public void testSpecifiedCtor() {
        System.out.println("Testing specified ctor of DoubleLessThan.");
        DoubleLessThan instance = new DoubleLessThan(9.0);
        this._limit.testGetLimit(instance, 9.0);
    }

    /**
     * Test of getLimit method, of class DoubleLessThan.
     */
    @Test
    public void testGetLimit() {
        System.out.println("Testing DoubleLessThan.getLimit().");
        this._limit.testGetLimit(this._instance, 0.0);
    }

    /**
     * Test of setLimit method, of class DoubleLessThan.
     */
    @Test
    public void testSetLimit() {
        System.out.println("Testing DoubleLessThan.setLimit(...).");
        this._limit.testSetLimit(this._instance, 1.0);
    }

    /**
     * Test of setLimit method, of class DoubleLessThan.
     * Setting the limit to Double.NaN.
     */
    @Test
    public void testSetLimitToNaN() {
        System.out.println("Testing DoubleLessThan.setLimit(...) " +
                "with Double.NaN as input.");
        this._limit.testSetLimit(this._instance, Double.NaN);
    }

    /**
     * Test of setLimit method, of class DoubleLessThan.
     * Setting the limit to null.
     * This is expected to cause a NullPointerException.
     */
    @Test(expected=NullPointerException.class)
    public void testSetLimitToNull() {
        System.out.println("Testing DoubleLessThan.setLimit(...) " +
                "with null input.");
        this._limit.testSetLimit(this._instance, null);
    }

    /**
     * Test of Message method, of class DoubleLessThan.
     */
    @Test
    public void testMessage() {
        System.out.println("Testing DoubleLessThan.Message(...).");
        this._tester.testMessage(this._instance, this._values[0],
                Double.toString(this._values[0]), "");
        this._tester.testMessage(this._instance, this._values[1],
                Double.toString(this._values[1]), "");
        this._tester.testMessage(this._instance, this._values[2],
                Double.toString(this._values[2]),
                "0.0 must be less than 0.0.");
        this._tester.testMessage(this._instance, this._values[3],
                Double.toString(this._values[3]),
                "1.0 must be less than 0.0.");
        this._tester.testMessage(this._instance, this._values[4],
                Double.toString(this._values[4]),
                "Infinity must be less than 0.0.");
        this._tester.testMessage(this._instance, this._values[5],
                Double.toString(this._values[5]),
                "NaN must be less than 0.0.");
        this._tester.testMessage(this._instance, this._values[6],
                "null", "null must be less than 0.0.");
    }

    /**
     * Test of Validate method, of class DoubleLessThan.
     */
    @Test
    public void testValidate() {
        System.out.println("Testing DoubleLessThan.Validate(...)");
        this._tester.testValidate(this._instance, this._values[0], true);
        this._tester.testValidate(this._instance, this._values[1], true);
        this._tester.testValidate(this._instance, this._values[2], false);
        this._tester.testValidate(this._instance, this._values[3], false);
        this._tester.testValidate(this._instance, this._values[4], false);
        this._tester.testValidate(this._instance, this._values[5], false);
        this._tester.testValidate(this._instance, this._values[6], false);
    }
}