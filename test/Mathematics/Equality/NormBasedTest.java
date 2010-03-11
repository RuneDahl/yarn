/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import Mathematics.Norm.Norm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A test-setup for the methods of the abstract class NormBased(TypeOfValue).
 * @author Rune Dahl Iversen
 * @param <TypeOfValue> Type of value.
 */
public class NormBasedTest<TypeOfValue> {
    public NormBasedTest() {
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
     * Test of getNorm method, of class NormBased.
     * @param equals         Instance of NormBased to test.
     * @param expectedResult Expected result..
     */
    public void testGetNorm(final NormBased<TypeOfValue> equals,
            final Norm<TypeOfValue> expectedResult) {
        assertEquals(expectedResult, equals.getNorm());
    }

    /**
     * Test of setNorm method, of class NormBased.
     * @param equals  Instance of NormBased to test.
     * @param newNorm New Norm to set.
     */
    public void testSetNorm(final NormBased<TypeOfValue> equals,
            final Norm<TypeOfValue> newNorm) {
        equals.setNorm(newNorm);
        this.testGetNorm(equals, newNorm);
    }

    /**
     * A blank test implemented to allow this test-setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}