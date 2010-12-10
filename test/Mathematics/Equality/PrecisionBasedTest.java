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
 * A test-setup for the methods of the abstract class PrecisonBased(TypeOfValue).
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public class PrecisionBasedTest<TypeOfValue> {
    public PrecisionBasedTest() { // Intentional
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
     * Test of getPrecision method, of class PrecisionBased.
     * @param equals         Instance of PrecisionBased to test.
     * @param expectedResult Expected result.
     */
    public void testGetPrecision(final PrecisionBased<TypeOfValue> equals,
            final double expectedResult) {
        assertEquals(expectedResult, equals.getPrecision(), 0.0);
    }

    /**
     * Test of setPrecision method, of class PrecisionBased.
     * @param equals       Instance of PrecisionBased to test.
     * @param newPrecision New value to set as precision.
     */
    public void testSetPrecision(final PrecisionBased<TypeOfValue> equals,
            final double newPrecision) {
        equals.setPrecision(newPrecision);
        this.testGetPrecision(equals, newPrecision);
    }

    /**
     * A blank test implemented to allow this test-setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}