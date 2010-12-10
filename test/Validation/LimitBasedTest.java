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
 * A test-setup for the methods of the abstract class LimitBased(TypeOfValue).
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of Value.
 */
public class LimitBasedTest<TypeOfValue> {
    public LimitBasedTest() { // Intentional
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
     * Test of getLimit method, of a LimitBased validator.
     * @param validator     Validator.
     * @param expectedValue Expected limit value.
     */
    public void testGetLimit(LimitBased<TypeOfValue> validator,
            TypeOfValue expectedValue) {
        TypeOfValue result = validator.getLimit();
        assertEquals(expectedValue, result);
    }

    /**
     * Test of setLimit method, of a LimitBased validator.
     * @param validator Validator.
     * @param newLimit  New limit value.
     */
    public void testSetLimit(LimitBased<TypeOfValue> validator,
            TypeOfValue newLimit) {
        validator.setLimit(newLimit);
        assertEquals(newLimit, validator.getLimit());
    }

    /**
     * Test of setLimit method, of a LimitBased validator.
     * Setting the limit to null.
     * @param validator Validator.
     */
    public void testSetLimitToNull(LimitBased<TypeOfValue> validator) {
        validator.setLimit(null);
    }

    /**
     * A blank test implemented to allow this test-setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}