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

    public DoubleIsNumericTest() {
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
     * Test of Message method, of class DoubleIsNumeric.
     */
    @Test
    public void testMessage() {
        System.out.println("Testing DoubleIsNumeric.Message(...).");
        this._tester.testMessage(this._instance, this._values[0], "0", "");
        this._tester.testMessage(this._instance, this._values[1], "1", "");
        this._tester.testMessage(this._instance, this._values[2], "2", "");
        this._tester.testMessage(this._instance, this._values[3], "3", "");
        this._tester.testMessage(this._instance, this._values[4], "4", "");
        this._tester.testMessage(this._instance, this._values[5], "5",
                "5 is not a number (Double.NaN).");
    }

    /**
     * Test of Validate method, of class DoubleIsNumeric.
     */
    @Test
    public void testValidate() {
        System.out.println("Testing DoubleIsNumeric.Validate(...)");
        this._tester.testValidate(this._instance, this._values[0], true);
        this._tester.testValidate(this._instance, this._values[1], true);
        this._tester.testValidate(this._instance, this._values[2], true);
        this._tester.testValidate(this._instance, this._values[3], true);
        this._tester.testValidate(this._instance, this._values[4], true);
        this._tester.testValidate(this._instance, this._values[5], false);
    }

    /**
     * Test of Validate method, of class DoubleIsNumeric for a null value.
     */
    @Test(expected=NullPointerException.class)
    public void testValidateNullValueCausesNullPointerException() {
        this._tester.testValidate(this._instance, this._values[6], false);
    }
}