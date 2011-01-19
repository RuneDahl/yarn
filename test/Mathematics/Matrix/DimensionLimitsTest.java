/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Matrix.DimensionLimits.
 * @author Rune Dahl Iversen
 */
public class DimensionLimitsTest {
    public DimensionLimitsTest() { // Intentional
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
     * Test of getColumnLimit method, of class DimensionLimits.
     */
    public void testGetColumnLimit(DimensionLimits instance, int expResult) {
        int result = instance.getColumnLimit();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRowLimit method, of class DimensionLimits.
     */
    public void testGetRowLimit(DimensionLimits instance, int expResult) {
        int result = instance.getRowLimit();
        assertEquals(expResult, result);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}