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
 * Test of the DoubleIsNotNull class.
 * @author Rune Dahl Iversen
 */
public class DoubleIsNotNullTest {
    private ValidatorTest<Double> _tester;
    private DoubleIsNotNull _instance;
    private Double[] _values;

    public DoubleIsNotNullTest() {
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
        this._instance = new DoubleIsNotNull();
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
     * Test of Message method, of class DoubleIsNotNull.
     */
    @Test
    public void testMessage() {
        System.out.println("Testing DoubleIsNotNull.Message(...).");
        this._tester.testMessage(this._instance, this._values[0], "0", "");
        this._tester.testMessage(this._instance, this._values[1], "1", "");
        this._tester.testMessage(this._instance, this._values[2], "2", "");
        this._tester.testMessage(this._instance, this._values[3], "3", "");
        this._tester.testMessage(this._instance, this._values[4], "4", "");
        this._tester.testMessage(this._instance, this._values[5], "5", "");
        this._tester.testMessage(this._instance, this._values[6], "6",
                "6 is null.");
    }

    /**
     * Test of Validate method, of class DoubleIsNotNull.
     */
    @Test
    public void testValidate() {
        System.out.println("Testing DoubleIsNotNull.Validate(...)");
        this._tester.testValidate(this._instance, this._values[0], true);
        this._tester.testValidate(this._instance, this._values[1], true);
        this._tester.testValidate(this._instance, this._values[2], true);
        this._tester.testValidate(this._instance, this._values[3], true);
        this._tester.testValidate(this._instance, this._values[4], true);
        this._tester.testValidate(this._instance, this._values[5], true);
        this._tester.testValidate(this._instance, this._values[6], false);
    }
}