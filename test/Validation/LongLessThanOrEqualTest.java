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
import static org.junit.Assert.*;

/**
 * jUnit test for the class Validation.LongLessThanOrEqual.
 * @author Rune Dahl Iversen
 */
public class LongLessThanOrEqualTest {
    private ValidatorTest<Long> _tester;
    private LimitBasedTest<Long> _limit;
    private LongLessThanOrEqual _instance;
    private Long[] _values;

    public LongLessThanOrEqualTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.LongLessThanOrEqual");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new ValidatorTest<Long>();
        this._limit = new LimitBasedTest<Long>();
        this._instance = new LongLessThanOrEqual(0);
        this._values = new Long[6];
        this._values[0] = Long.MIN_VALUE;
        this._values[1] = -1L;
        this._values[2] = 0L;
        this._values[3] = 1L;
        this._values[4] = Long.MAX_VALUE;
        this._values[5] = null;
    }

    @After
    public void tearDown() {
        this._tester = null;
        this._limit = null;
        this._instance = null;
        this._values = null;
    }

    /**
     * Test of constructor, of class LongLessThanOrEqual, without input.
     */
    @Test
    public void testCtor() {
        System.out.println("LongLessThanOrEqual()");
        LongLessThanOrEqual instance = new LongLessThanOrEqual();

        assertNotNull("Null value result from ctor().", instance);
        this._limit.testGetLimit(instance, 0L);
    }

    /**
     * Test of constructor, of class LongLessThanOrEqual, with an int value.
     */
    @Test
    public void testCtor_int() {
        System.out.println("LongLessThanOrEqual(int)");
        LongLessThanOrEqual instance = new LongLessThanOrEqual(7);

        assertNotNull("Null value result from ctor(int).", instance);
        this._limit.testGetLimit(instance, 7L);
    }

    /**
     * Test of getLimit method, of class LongLessThanOrEqual.
     */
    @Test
    public void testGetLimit() {
        System.out.println("getLimit");
        this._limit.testGetLimit(this._instance, 0L);
    }

    /**
     * Test of setLimit method, of class LongLessThanOrEqual.
     */
    @Test
    public void testSetLimit() {
        System.out.println("setLimit");
        this._limit.testSetLimit(this._instance, 7L);
    }

    /**
     * Test of setLimit method, of class LongLessThanOrEqual.
     */
    @Test (expected=NullPointerException.class)
    public void testSetLimit_Null() {
        System.out.println("setLimit(null)");
        this._limit.testSetLimitToNull(this._instance);
    }

    /**
     * Test of message method, of class LongLessThanOrEqual.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        LongLessThanOrEqual instance = this._instance;

        this._tester.testMessage(instance, this._values[0], Long.toString(this._values[0]), "");
        this._tester.testMessage(instance, this._values[1], Long.toString(this._values[1]), "");
        this._tester.testMessage(instance, this._values[2], Long.toString(this._values[2]), "");
        this._tester.testMessage(instance, this._values[3], Long.toString(this._values[3]), "1 must be less than or equal to 0.0.");
        this._tester.testMessage(instance, this._values[4], Long.toString(this._values[4]), "9223372036854775807 must be less than or equal to 0.0.");
        this._tester.testMessage(instance, this._values[5], "null", "null must be less than or equal to 0.0.");
    }

    /**
     * Test of isValid method, of class LongLessThanOrEqual.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        LongLessThanOrEqual instance = this._instance;

        this._tester.testIsValid(instance, this._values[0], true);
        this._tester.testIsValid(instance, this._values[1], true);
        this._tester.testIsValid(instance, this._values[2], true);
        this._tester.testIsValid(instance, this._values[3], false);
        this._tester.testIsValid(instance, this._values[4], false);
        this._tester.testIsValid(instance, this._values[5], false);
    }
}