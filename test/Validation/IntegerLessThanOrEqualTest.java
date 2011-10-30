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
 * jUnit test for the class Validation.IntegerLessThanOrEqual.
 * @author Rune Dahl Iversen
 */
public class IntegerLessThanOrEqualTest {
    private ValidatorTest<Integer> _tester;
    private LimitBasedTest<Integer> _limit;
    private IntegerLessThanOrEqual _instance;
    private Integer[] _values;

    public IntegerLessThanOrEqualTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.IntegerLessThanOrEqual");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new ValidatorTest<Integer>();
        this._limit = new LimitBasedTest<Integer>();
        this._instance = new IntegerLessThanOrEqual(0);
        this._values = new Integer[6];
        this._values[0] = Integer.MIN_VALUE;
        this._values[1] = -1;
        this._values[2] = 0;
        this._values[3] = 1;
        this._values[4] = Integer.MAX_VALUE;
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
     * Test of constructor, of class IntegerLessThanOrEqual, without input.
     */
    @Test
    public void testCtor() {
        System.out.println("IntegerLessThanOrEqual()");
        IntegerLessThanOrEqual instance = new IntegerLessThanOrEqual();

        assertNotNull("Null value result from ctor().", instance);
        this._limit.testGetLimit(instance, 0);
    }

    /**
     * Test of constructor, of class IntegerLessThanOrEqual, with an int value.
     */
    @Test
    public void testCtor_int() {
        System.out.println("IntegerLessThanOrEqual(int)");
        IntegerLessThanOrEqual instance = new IntegerLessThanOrEqual(7);

        assertNotNull("Null value result from ctor(int).", instance);
        this._limit.testGetLimit(instance, 7);
    }

    /**
     * Test of getLimit method, of class IntegerLessThanOrEqual.
     */
    @Test
    public void testGetLimit() {
        System.out.println("getLimit");
        this._limit.testGetLimit(this._instance, 0);
    }

    /**
     * Test of setLimit method, of class IntegerLessThanOrEqual.
     */
    @Test
    public void testSetLimit() {
        System.out.println("setLimit");
        this._limit.testSetLimit(this._instance, 7);
    }

    /**
     * Test of setLimit method, of class IntegerLessThanOrEqual.
     */
    @Test (expected=NullPointerException.class)
    public void testSetLimit_Null() {
        System.out.println("setLimit(null)");
        this._limit.testSetLimitToNull(this._instance);
    }

    /**
     * Test of message method, of class IntegerLessThanOrEqual.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        IntegerLessThanOrEqual instance = this._instance;

        this._tester.testMessage(instance, this._values[0], Integer.toString(this._values[0]), "");
        this._tester.testMessage(instance, this._values[1], Integer.toString(this._values[1]), "");
        this._tester.testMessage(instance, this._values[2], Integer.toString(this._values[2]), "");
        this._tester.testMessage(instance, this._values[3], Integer.toString(this._values[3]), "1 must be less than or equal to 0.");
        this._tester.testMessage(instance, this._values[4], Integer.toString(this._values[4]), "2147483647 must be less than or equal to 0.");
        this._tester.testMessage(instance, this._values[5], "null", "null must be less than or equal to 0.");
    }

    /**
     * Test of isValid method, of class IntegerLessThanOrEqual.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        IntegerLessThanOrEqual instance = this._instance;

        this._tester.testIsValid(instance, this._values[0], true);
        this._tester.testIsValid(instance, this._values[1], true);
        this._tester.testIsValid(instance, this._values[2], true);
        this._tester.testIsValid(instance, this._values[3], false);
        this._tester.testIsValid(instance, this._values[4], false);
        this._tester.testIsValid(instance, this._values[5], false);
    }
}
