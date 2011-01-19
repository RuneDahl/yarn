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
 * jUnit test for the class Validation.NotNull.
 * @author Rune Dahl Iversen
 */
public class NotNullTest {
    private NotNull<Double> _notNull;

    public NotNullTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.NotNull<T>");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._notNull = new NotNull<Double>();
    }

    @After
    public void tearDown() {
        this._notNull = null;
    }

    /**
     * Test of message method, of class NotNull.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        Double value = null;
        String name = "Value";
        NotNull instance = this._notNull;
        String expResult = "Value is null.";
        String result = instance.message(value, name);
        assertEquals(expResult, result);

        value = 7.3;
        expResult = "";
        result = instance.message(value, name);
        assertEquals(expResult, result);

        value = null;
        name = null;
        result = instance.message(value, name);
        expResult = "null is null.";
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, of class NotNull.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        Double value = null;
        NotNull instance = this._notNull;
        boolean expResult = false;
        boolean result = instance.isValid(value);
        assertEquals(expResult, result);

        value = 7.3;
        expResult = true;
        result = instance.isValid(value);
        assertEquals(expResult, result);
    }
}