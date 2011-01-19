/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Vector.DimensionLimit.
 * @author Rune Dahl Iversen
 */
public class DimensionLimitTest {
    private DimensionLimit _instance;

    public DimensionLimitTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Vector.DimensionLimit");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new DimensionLimitImpl(7);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of getDimensionLimit method, of class DimensionLimit.
     */
    @Test
    public void testGetDimensionLimit() {
        System.out.println("getDimensionLimit");
        DimensionLimit instance = this._instance;
        int expResult = 7;
        int result = instance.getDimensionLimit();
        assertEquals(expResult, result);
    }

    public class DimensionLimitImpl extends DimensionLimit {
        public DimensionLimitImpl(final int limit) {
            super(limit);
        }
    }
}