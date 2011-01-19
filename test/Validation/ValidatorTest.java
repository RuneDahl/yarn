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
 * A test-setup for the methods of the interface Validator(TypeOfValue).
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public class ValidatorTest<TypeOfValue> {
    public ValidatorTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() { // Intentional
    }

    @After
    public void tearDown() { // Intentional
    }

    /**
     * Test of isValid method, of a Validator.
     */
    public void testIsValid(Validator<TypeOfValue> validator,
            TypeOfValue value,
            boolean expectedResult) {
        //System.out.println("Testing " + validator.getClass().getName() + ".isValid(...).");
        boolean result = validator.isValid(value);
        assertEquals(expectedResult, result);
    }

    /**
     * Test of message method, of a Validator.
     */
    public void testMessage(Validator<TypeOfValue> validator,
            TypeOfValue value,
            String name,
            String expectedMessage) {
        String message = validator.message(value, name);
        assertEquals(expectedMessage, message);
    }

    /**
     * A blank test implemented to allow this test-setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}