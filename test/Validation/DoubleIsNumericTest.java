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
 * Test of the DoubleIsNumeric class.
 * @author Rune Dahl Iversen
 */
public class DoubleIsNumericTest {
    private ValidatorTest<Double> _tester;
    private DoubleIsNumeric _instance;
    private Double[] _values;

    public DoubleIsNumericTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.DoubleIsNumeric");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new ValidatorTest<Double>();
        this._instance = new DoubleIsNumeric();
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
        this._instance = null;
        this._values = null;
    }

    /**
     * Test of message method, of class DoubleIsNumeric.
     */
    @Test
    public void testMessage() {
        System.out.println("Testing DoubleIsNumeric.message(...).");
        this._tester.testMessage(this._instance, this._values[0],
                Double.toString(this._values[0]), "");
        this._tester.testMessage(this._instance, this._values[1],
                Double.toString(this._values[1]), "");
        this._tester.testMessage(this._instance, this._values[2],
                Double.toString(this._values[2]), "");
        this._tester.testMessage(this._instance, this._values[3],
                Double.toString(this._values[3]), "");
        this._tester.testMessage(this._instance, this._values[4],
                Double.toString(this._values[4]), "");
        this._tester.testMessage(this._instance, this._values[5],
                Double.toString(this._values[5]),
                "NaN is not a number (Double.NaN).");
        this._tester.testMessage(this._instance, this._values[6],
                "null", "null is not a number (Double.NaN).");
    }

    /**
     * Test of isValid method, of class DoubleIsNumeric.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        this._tester.testIsValid(this._instance, this._values[0], true);
        this._tester.testIsValid(this._instance, this._values[1], true);
        this._tester.testIsValid(this._instance, this._values[2], true);
        this._tester.testIsValid(this._instance, this._values[3], true);
        this._tester.testIsValid(this._instance, this._values[4], true);
        this._tester.testIsValid(this._instance, this._values[5], false);
        this._tester.testIsValid(this._instance, this._values[6], false);
    }
}