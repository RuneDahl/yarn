/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A test-setup for the methods of the interface Equals(TypeOfValue).
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public class EqualsTest<TypeOfValue> {
    public EqualsTest() {
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
     * Test of Equal method, of interface Equals(TypeOfValue).
     * @param equals         Instance of Equals class to test.
     * @param a              First value.
     * @param b              Second value.
     * @param expectedResult Expected result.
     */
    public void testEqual(final Equals<TypeOfValue> equals,
            final TypeOfValue a,
            final TypeOfValue b,
            boolean expectedResult) {
        boolean result = equals.Equal(a, b);
        assertEquals(expectedResult, result);
    }

    /**
     * A blank test implemented to allow this test-setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}