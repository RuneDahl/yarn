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
 * jUnit test for the class Validation.IntegerGreaterThanOrEqual.
 * @author Rune Dahl Iversen
 */
public class IntegerGreaterThanOrEqualTest {
    private ValidatorTest<Integer> _tester;
    private LimitBasedTest<Integer> _limit;
    private IntegerGreaterThanOrEqual _instance;
    private Integer[] _values;

    public IntegerGreaterThanOrEqualTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.IntegerGreaterThanOrEqual");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new ValidatorTest<Integer>();
        this._limit = new LimitBasedTest<Integer>();
        this._instance = new IntegerGreaterThanOrEqual(0);
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
     * Test of constructor, of class IntegerGreaterThanOrEqual, without input.
     */
    @Test
    public void testCtor() {
        System.out.println("IntegerGreaterThanOrEqual()");
        IntegerGreaterThanOrEqual instance = new IntegerGreaterThanOrEqual();

        assertNotNull("Null value result from ctor().", instance);
        this._limit.testGetLimit(instance, 0);
    }

    /**
     * Test of constructor, of class IntegerGreaterThanOrEqual, with an int value.
     */
    @Test
    public void testCtor_int() {
        System.out.println("IntegerGreaterThanOrEqual(int)");
        IntegerGreaterThanOrEqual instance = new IntegerGreaterThanOrEqual(7);

        assertNotNull("Null value result from ctor(int).", instance);
        this._limit.testGetLimit(instance, 7);
    }

    /**
     * Test of getLimit method, of class IntegerGreaterThanOrEqual.
     */
    @Test
    public void testGetLimit() {
        System.out.println("getLimit");
        this._limit.testGetLimit(this._instance, 0);
    }

    /**
     * Test of setLimit method, of class IntegerGreaterThanOrEqual.
     */
    @Test
    public void testSetLimit() {
        System.out.println("setLimit");
        this._limit.testSetLimit(this._instance, 7);
    }

    /**
     * Test of setLimit method, of class IntegerGreaterThanOrEqual.
     */
    @Test (expected=NullPointerException.class)
    public void testSetLimit_Null() {
        System.out.println("setLimit(null)");
        this._limit.testSetLimitToNull(this._instance);
    }

    /**
     * Test of message method, of class IntegerGreaterThanOrEqual.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        IntegerGreaterThanOrEqual instance = this._instance;

        this._tester.testMessage(instance, this._values[0], Integer.toString(this._values[0]), "-2147483648 must be greater than or equal to 0.");
        this._tester.testMessage(instance, this._values[1], Integer.toString(this._values[1]), "-1 must be greater than or equal to 0.");
        this._tester.testMessage(instance, this._values[2], Integer.toString(this._values[2]), "");
        this._tester.testMessage(instance, this._values[3], Integer.toString(this._values[3]), "");
        this._tester.testMessage(instance, this._values[4], Integer.toString(this._values[4]), "");
        this._tester.testMessage(instance, this._values[5], "null", "null must be greater than or equal to 0.");
    }

    /**
     * Test of isValid method, of class IntegerGreaterThanOrEqual.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        IntegerGreaterThanOrEqual instance = this._instance;

        this._tester.testIsValid(instance, this._values[0], false);
        this._tester.testIsValid(instance, this._values[1], false);
        this._tester.testIsValid(instance, this._values[2], true);
        this._tester.testIsValid(instance, this._values[3], true);
        this._tester.testIsValid(instance, this._values[4], true);
        this._tester.testIsValid(instance, this._values[5], false);
    }
}
