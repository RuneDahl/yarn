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
 * jUnit test for the class Validation.LongPrime.
 * @author Rune Dahl Iversen
 */
public class LongPrimeTest {
    private LongPrime _instance;

    public LongPrimeTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.LongPrime");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new LongPrime();
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of message method, of class LongPrime.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        LongPrime instance = this._instance;
        Long value = null;
        String expResult = "null must be prime.";
        String result = instance.message(value, "null");
        assertEquals("Message from null", expResult, result);

        value = -1L;
        expResult = value.toString() + " must be prime.";
        result = instance.message(value, value.toString());
        assertEquals("Message from " + value.toString(), expResult, result);

        value = 0L;
        expResult = value.toString() + " must be prime.";
        result = instance.message(value, value.toString());
        assertEquals("Message from " + value.toString(), expResult, result);

        value = 1L;
        expResult = value.toString() + " must be prime.";
        result = instance.message(value, value.toString());
        assertEquals("Message from " + value.toString(), expResult, result);

        value = 2L;
        expResult = "";
        result = instance.message(value, value.toString());
        assertEquals("Message from " + value.toString(), expResult, result);

        value = 3L;
        expResult = "";
        result = instance.message(value, value.toString());
        assertEquals("Message from " + value.toString(), expResult, result);

        value = 4L;
        expResult = value.toString() + " must be prime.";
        result = instance.message(value, value.toString());
        assertEquals("Message from " + value.toString(), expResult, result);

        value = 5L;
        expResult = "";
        result = instance.message(value, value.toString());
        assertEquals("Message from " + value.toString(), expResult, result);

        value = 6L;
        expResult = value.toString() + " must be prime.";
        result = instance.message(value, value.toString());
        assertEquals("Message from " + value.toString(), expResult, result);

        value = 103L;
        expResult = "";
        result = instance.message(value, value.toString());
        assertEquals("Message from " + value.toString(), expResult, result);
    }

    /**
     * Test of isValid method, of class LongPrime.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        LongPrime instance = this._instance;
        Long value = null;
        boolean expResult = false;
        boolean result = instance.isValid(value);
        assertEquals("null is prime.", expResult, result);

        value = -1L;
        expResult = false;
        result = instance.isValid(value);
        assertEquals(value.toString() + " is prime.", expResult, result);

        value = 0L;
        expResult = false;
        result = instance.isValid(value);
        assertEquals(value.toString() + " is prime.", expResult, result);

        value = 1L;
        expResult = false;
        result = instance.isValid(value);
        assertEquals(value.toString() + " is prime.", expResult, result);

        value = 2L;
        expResult = true;
        result = instance.isValid(value);
        assertEquals(value.toString() + " is prime.", expResult, result);

        value = 3L;
        expResult = true;
        result = instance.isValid(value);
        assertEquals(value.toString() + " is prime.", expResult, result);

        value = 4L;
        expResult = false;
        result = instance.isValid(value);
        assertEquals(value.toString() + " is prime.", expResult, result);

        value = 5L;
        expResult = true;
        result = instance.isValid(value);
        assertEquals(value.toString() + " is prime.", expResult, result);

        value = 6L;
        expResult = false;
        result = instance.isValid(value);
        assertEquals(value.toString() + " is prime.", expResult, result);

        value = 103L;
        expResult = true;
        result = instance.isValid(value);
        assertEquals(value.toString() + " is prime.", expResult, result);
    }
}