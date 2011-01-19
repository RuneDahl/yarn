/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import Mathematics.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * jUnit test for the class Validation.ComplexIsNumeric.
 * @author Rune Dahl Iversen
 */
public class ComplexIsNumericTest {
    private ValidatorTest<Complex> _tester;
    private ComplexIsNumeric _instance;
    private Complex[] _values;

    public ComplexIsNumericTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.ComplexIsNumeric");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new ValidatorTest<Complex>();
        this._instance = new ComplexIsNumeric();
        this._values = new Complex[6];
        this._values[0] = Complex.RealNumber(1.0);
        this._values[1] = Complex.Origin;
        this._values[2] = Complex.Cartesian(-1.0, 1.0);
        this._values[3] = Complex.Infinity;
        this._values[4] = Complex.NaN;
        this._values[5] = null;
    }

    @After
    public void tearDown() {
        this._tester = null;
        this._instance = null;
        this._values = null;
    }

    /**
     * Test of message method, of class ComplexIsNumeric.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        ComplexIsNumeric instance = this._instance;

        this._tester.testMessage(instance, this._values[0], this._values[0].toString(), "");
        this._tester.testMessage(instance, this._values[1], this._values[1].toString(), "");
        this._tester.testMessage(instance, this._values[2], this._values[2].toString(), "");
        this._tester.testMessage(instance, this._values[3], this._values[3].toString(), "");
        this._tester.testMessage(instance, this._values[4], this._values[4].toString(), "NaN is not a number (Complex.NaN).");
        this._tester.testMessage(instance, this._values[5], "null", "null is not a number (Complex.NaN).");
    }

    /**
     * Test of isValid method, of class ComplexIsNumeric.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        ComplexIsNumeric instance = this._instance;

        this._tester.testIsValid(instance, this._values[0], true);
        this._tester.testIsValid(instance, this._values[1], true);
        this._tester.testIsValid(instance, this._values[2], true);
        this._tester.testIsValid(instance, this._values[3], true);
        this._tester.testIsValid(instance, this._values[4], false);
        this._tester.testIsValid(instance, this._values[5], false);
    }
}