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

    public LimitBasedTest() {
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
     * Test of getLimit method, of a LimitBased validator.
     */
    public void testGetLimit(LimitBased<TypeOfValue> validator,
            TypeOfValue expectedValue) {
        //System.out.println("Testing " + validator.getClass().getName() +
        //        ".getLimit().");
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
        //System.out.println("Testing " + validator.getClass().getName() +
        //        ".setLimit(" + newLimit.getClass().getName() +").");
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