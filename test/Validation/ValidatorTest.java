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
    public ValidatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Validate method, of a Validator.
     */
    public void testValidate(Validator<TypeOfValue> validator,
            TypeOfValue value,
            boolean expectedResult) {
        //System.out.println("Testing " + validator.getClass().getName() + ".Validate(...).");
        boolean result = validator.Validate(value);
        assertEquals(expectedResult, result);
    }

    /**
     * Test of Message method, of a Validator.
     */
    public void testMessage(Validator<TypeOfValue> validator,
            TypeOfValue value,
            String name,
            String expectedMessage) {
        //System.out.println("Testing " + validator.getClass().getName() + ".Message(...).");
        String message = validator.Message(value, name);
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