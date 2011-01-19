/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Validation.And.
 * @author Rune Dahl Iversen
 */
public class AndTest {
    private ValidatorTest<Double> _tester;
    private And<Double> _instance;
    private Double[] _values;

    public AndTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.And<T>");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new ValidatorTest<Double>();
        this._instance = new And<Double>();
        this._instance.add(new NotNull<Double>());
        this._instance.add(new DoubleIsNumeric());
        this._instance.add(new DoubleIsFinite());

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
     * Test of constructor method, of class And, without a value.
     */
    @Test
    public void testCtor_Empty() {
        System.out.println("And()");
        And<Double> instance = new And<Double>();

        assertNotNull("Result from collection ctor.", instance);
        assertEquals("Items is result from collection ctor.", 0, instance.size());
    }


    /**
     * Test of constructor method, of class And, for a collection value.
     */
    @Test
    public void testCtor_Collection() {
        System.out.println("And(Collection)");
        Collection<Validator<Double>> c = new LinkedList<Validator<Double>>();
        c.add(new NotNull<Double>());
        c.add(new DoubleIsNumeric());
        c.add(new DoubleIsFinite());
        And<Double> instance = new And<Double>(c);

        assertNotNull("Result from collection ctor.", instance);
        assertEquals("Items is result from collection ctor.", 3, instance.size());
    }

    /**
     * Test of constructor method, of class And, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_Collection_Null() {
        System.out.println("And(null)");

        And<Double> instance = new And<Double>(null);
    }

    /**
     * Test of message method, of class And.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        And<Double> instance = this._instance;

        this._tester.testMessage(instance, this._values[0], Double.toString(this._values[0]), "(-Infinity is not finite)");
        this._tester.testMessage(instance, this._values[1], Double.toString(this._values[1]), "");
        this._tester.testMessage(instance, this._values[2], Double.toString(this._values[2]), "");
        this._tester.testMessage(instance, this._values[3], Double.toString(this._values[3]), "");
        this._tester.testMessage(instance, this._values[4], Double.toString(this._values[4]), "(Infinity is not finite)");
        this._tester.testMessage(instance, this._values[5], Double.toString(this._values[5]), "(NaN is not a number (Double.NaN))");
        this._tester.testMessage(instance, this._values[6], "null", "(null is null. && null is not a number (Double.NaN). && null is not finite)");
    }

    /**
     * Test of isValid method, of class And.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        this._tester.testIsValid(this._instance, this._values[0], false);
        this._tester.testIsValid(this._instance, this._values[1], true);
        this._tester.testIsValid(this._instance, this._values[2], true);
        this._tester.testIsValid(this._instance, this._values[3], true);
        this._tester.testIsValid(this._instance, this._values[4], false);
        this._tester.testIsValid(this._instance, this._values[5], false);
        this._tester.testIsValid(this._instance, this._values[6], false);
    }
}