/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Equality;

import Mathematics.Metric.Metric;
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
    public NormBasedTest() { // Intentional
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
     * Test of the getMetric method, of class NormBased.
     * @param equals         Instance of NormBased to test.
     * @param expectedResult Expected result.
     */
    public void testGetMetric(final NormBased<TypeOfValue> equals,
            final Metric<TypeOfValue> expectedResult) {
        assertEquals(expectedResult, equals.getMetric());
    }

    /**
     * Test of getNorm method, of class NormBased.
     * @param equals         Instance of NormBased to test.
     * @param expectedResult Expected result.
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