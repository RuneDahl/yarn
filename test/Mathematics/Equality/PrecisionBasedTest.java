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

    public PrecisionBasedTest() {
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
     * Test of getPrecision method, of class PrecisionBased.
     */
    public void testGetPrecision(final PrecisionBased<TypeOfValue> equals,
            final double expectedResult) {
        assertEquals(expectedResult, equals.getPrecision(), 0.0);
    }

    /**
     * Test of setPrecision method, of class PrecisionBased.
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