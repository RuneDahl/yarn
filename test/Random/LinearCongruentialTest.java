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
 * jUnit test for the class Random.LinearCongruential.
 * @author Rune Dahl Iversen
 */
public class LinearCongruentialTest {
    private LinearCongruential _instance;

    public LinearCongruentialTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Random.LinearCongruential");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        long increment, modulus, multiplier, seed;
        increment = 12345L;
        modulus = 4294967296L;
        multiplier = 1103515245L;
        seed = 5489L;
        this._instance = new LinearCongruential(modulus, multiplier, increment, seed);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of getFactor method, of class LinearCongruential.
     */
    @Test
    public void testGetFactor() {
        System.out.println("getFactor");
        LinearCongruential instance = this._instance;
        double expResult = 4294967296L;
        double result = instance.getFactor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getIncrement method, of class LinearCongruential.
     */
    @Test
    public void testGetIncrement() {
        System.out.println("getIncrement");
        LinearCongruential instance = this._instance;
        long expResult = 12345L;
        long result = instance.getIncrement();
        assertEquals(expResult, result);
    }

    /**
     * Test of getModulus method, of class LinearCongruential.
     */
    @Test
    public void testGetModulus() {
        System.out.println("getModulus");
        LinearCongruential instance = this._instance;
        long expResult = 4294967296L;
        long result = instance.getModulus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMultiplier method, of class LinearCongruential.
     */
    @Test
    public void testGetMultiplier() {
        System.out.println("getMultiplier");
        LinearCongruential instance = this._instance;
        long expResult = 1103515245L;
        long result = instance.getMultiplier();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeed method, of class LinearCongruential.
     */
    @Test
    public void testGetSeed() {
        System.out.println("getSeed");
        LinearCongruential instance = this._instance;
        long expResult = 5489L;
        long result = instance.getSeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIncrement method, of class LinearCongruential.
     */
    @Test
    public void testSetIncrement() {
        System.out.println("setIncrement");
        long increment = 1L;
        LinearCongruential instance = this._instance;
        instance.setIncrement(increment);

        long result = instance.getIncrement();
        assertEquals("Wrong Increment after setIncrement.", increment, result);
    }

    /**
     * Test of setIncrement method, of class LinearCongruential,
     * for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetIncrement_NegativeOne() {
        System.out.println("setIncrement(-1)");
        long increment = -1L;
        LinearCongruential instance = this._instance;
        instance.setIncrement(increment);
    }

    /**
     * Test of setModulus method, of class LinearCongruential.
     */
    @Test
    public void testSetModulus() {
        System.out.println("setModulus");
        long modulus = 23445L;
        LinearCongruential instance = this._instance;
        instance.setModulus(modulus);

        long result = instance.getModulus();
        assertEquals("Wrong Modulus after setModulus.", modulus, result);
    }

    /**
     * Test of setModulus method, of class LinearCongruential,
     * for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetModulus_NegativeOne() {
        System.out.println("setModulus(-1)");
        long modulus = -1L;
        LinearCongruential instance = this._instance;
        instance.setModulus(modulus);
    }

    /**
     * Test of setMultiplier method, of class LinearCongruential.
     */
    @Test
    public void testSetMultiplier() {
        System.out.println("setMultiplier");
        long multiplier = 43534L;
        LinearCongruential instance = this._instance;
        instance.setMultiplier(multiplier);

        long result = instance.getMultiplier();
        assertEquals("Wrong Multiplier after setMultiplier.", multiplier, result);
    }

    /**
     * Test of setMultiplier method, of class LinearCongruential,
     * for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetMultiplier_NegativeOne() {
        System.out.println("setMultiplier(-1)");
        long multiplier = -1L;
        LinearCongruential instance = this._instance;
        instance.setMultiplier(multiplier);
    }

    /**
     * Test of setSeed method, of class LinearCongruential.
     */
    @Test
    public void testSetSeed() {
        System.out.println("setSeed");
        long seed = 54321L;
        LinearCongruential instance = this._instance;
        instance.setSeed(seed);

        long result = instance.getSeed();
        assertEquals("Wrong Seed after setSeed.", seed, result);
    }

    /**
     * Test of setSeed method, of class LinearCongruential, for the value -1.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSeed_NegativeOne() {
        System.out.println("setSeed(-1)");
        Long seed = -1L;
        Seed<Long, Long> instance = this._instance;
        instance.setSeed(seed);
    }

    /**
     * Test of setSeed method, of class LinearCongruential, for the value null.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSeed_Null() {
        System.out.println("setSeed(null)");
        Long seed = null;
        Seed<Long, Long> instance = this._instance;
        instance.setSeed(seed);
    }

    /**
     * Test of getSample method, of class LinearCongruential.
     */
    @Test
    public void testGetSample() {
        System.out.println("getSample");
        Generator<Long> instance = this._instance;
        Long expResult = 1291304790L;
        Long result = instance.getSample();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSample method, of class LinearCongruential.
     */
    @Test
    public void testGetSample_int() {
        System.out.println("getSample(int)");
        int count = 3;
        Generator<Long> instance = this._instance;
        Long[] expResult = new Long[3];
        expResult[0] = 1291304790L;
        expResult[1] = 340581335L;
        expResult[2] = 2935966916L;
        Long[] result = instance.getSample(count);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getSample method, of class LinearCongruential.
     */
    @Test (expected=NegativeArraySizeException.class)
    public void testGetSample_NegativeOne() {
        System.out.println("getSample(-1)");
        Generator<Long> instance = this._instance;
        int count = -1;
        instance.getSample(count);
    }
}