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
 * jUnit test for the class Validation.LongGreaterThan.
 * @author Rune Dahl Iversen
 */
public class LongGreaterThanTest {
    private ValidatorTest<Long> _tester;
    private LimitBasedTest<Long> _limit;
    private LongGreaterThan _instance;
    private Long[] _values;

    public LongGreaterThanTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.LongGreaterThan");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new ValidatorTest<Long>();
        this._limit = new LimitBasedTest<Long>();
        this._instance = new LongGreaterThan(0);
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
     * Test of constructor, of class LongGreaterThan, without input.
     */
    @Test
    public void testCtor() {
        System.out.println("LongGreaterThan()");
        LongGreaterThan instance = new LongGreaterThan();

        assertNotNull("Null value result from ctor().", instance);
        this._limit.testGetLimit(instance, 0L);
    }

    /**
     * Test of constructor, of class LongGreaterThan, with an int value.
     */
    @Test
    public void testCtor_int() {
        System.out.println("LongGreaterThan(int)");
        LongGreaterThan instance = new LongGreaterThan(7);

        assertNotNull("Null value result from ctor(int).", instance);
        this._limit.testGetLimit(instance, 7L);
    }

    /**
     * Test of getLimit method, of class LongGreaterThan.
     */
    @Test
    public void testGetLimit() {
        System.out.println("getLimit");
        this._limit.testGetLimit(this._instance, 0L);
    }

    /**
     * Test of setLimit method, of class LongGreaterThan.
     */
    @Test
    public void testSetLimit() {
        System.out.println("setLimit");
        this._limit.testSetLimit(this._instance, 7L);
    }

    /**
     * Test of setLimit method, of class LongGreaterThan.
     */
    @Test (expected=NullPointerException.class)
    public void testSetLimit_Null() {
        System.out.println("setLimit(null)");
        this._limit.testSetLimitToNull(this._instance);
    }

    /**
     * Test of message method, of class LongGreaterThan.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        LongGreaterThan instance = this._instance;

        this._tester.testMessage(instance, this._values[0], Long.toString(this._values[0]), "-9223372036854775808 must be greater than 0.0.");
        this._tester.testMessage(instance, this._values[1], Long.toString(this._values[1]), "-1 must be greater than 0.0.");
        this._tester.testMessage(instance, this._values[2], Long.toString(this._values[2]), "0 must be greater than 0.0.");
        this._tester.testMessage(instance, this._values[3], Long.toString(this._values[3]), "");
        this._tester.testMessage(instance, this._values[4], Long.toString(this._values[4]), "");
        this._tester.testMessage(instance, this._values[5], "null", "null must be greater than 0.0.");
    }

    /**
     * Test of isValid method, of class LongGreaterThan.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        LongGreaterThan instance = this._instance;

        this._tester.testIsValid(instance, this._values[0], false);
        this._tester.testIsValid(instance, this._values[1], false);
        this._tester.testIsValid(instance, this._values[2], false);
        this._tester.testIsValid(instance, this._values[3], true);
        this._tester.testIsValid(instance, this._values[4], true);
        this._tester.testIsValid(instance, this._values[5], false);
    }
}