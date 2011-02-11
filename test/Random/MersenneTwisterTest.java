/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Random.MersenneTwister.
 * @author Rune Dahl Iversen
 */
public class MersenneTwisterTest {
    private MersenneTwister _instance;

    public MersenneTwisterTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Random.MersenneTwister");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new MersenneTwister(54321);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of getFactor method, of class MersenneTwister.
     */
    @Test
    public void testGetFactor() {
        System.out.println("getFactor");
        MersenneTwister instance = this._instance;
        double expResult = 4294967296L;
        double result = instance.getFactor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSample method, of class MersenneTwister.
     */
    @Test
    public void testGetSample() {
        System.out.println("getSample");
        Generator<Long> instance = this._instance;
        Long expResult = 1617746096L;
        Long result = instance.getSample();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSample method, of class MersenneTwister.
     */
    @Test
    public void testGetSample_int() {
        System.out.println("getSample(int)");
        Generator<Long> instance = this._instance;
        int count = 3;
        Long[] expResult = new Long[count];
        expResult[0] = 1617746096L;
        expResult[1] = -1297498142L;
        expResult[2] = 1162986294L;
        Long[] result = instance.getSample(count);
        assertArrayEquals(expResult, result);

        result = instance.getSample(700); // Invoked to ensure 100% code coverage.
    }

    /**
     * Test of getSample method, of class MersenneTwister.
     */
    @Test (expected=NegativeArraySizeException.class)
    public void testGetSample_NegativeOne() {
        System.out.println("getSample(-1)");
        MersenneTwister instance = this._instance;
        int count = -1;
        instance.getSample(count);
    }

    /**
     * Test of setSeed method, of class MersenneTwister.
     */
    @Test
    public void testSetSeed() {
        System.out.println("setSeed");
        Long seed = 12345L;
        MersenneTwister instance = this._instance;
        instance.setSeed(seed);
        Long result = instance.getSample();
        Long expResult = 55453292L;
        assertEquals("Wrong sample value after setSeed(Long).",
                expResult, result);
    }

    /**
     * Test of setSeed method, of class MersenneTwister, for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSeed_NegativeOne() {
        System.out.println("setSeed(-1)");
        Long seed = -1L;
        MersenneTwister instance = this._instance;
        instance.setSeed(seed);
    }

    /**
     * Test of setSeed method, of class MersenneTwister, for the value 4294967297.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSeed_TooLarge() {
        System.out.println("setSeed(4294967297)");
        Long seed = 4294967297L;
        MersenneTwister instance = this._instance;
        instance.setSeed(seed);
    }
    /**
     * Test of setSeed method, of class MersenneTwister, for the value null.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSeed_Null() {
        System.out.println("setSeed(null)");
        Long seed = null;
        MersenneTwister instance = this._instance;
        instance.setSeed(seed);
    }
}