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
 * jUnit test for the class Random.BlumBlumShub.
 * @author Rune Dahl Iversen
 */
public class BlumBlumShubTest {
    private BlumBlumShub _instance;

    public BlumBlumShubTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Random.BlumBlumShub");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new BlumBlumShub(11, 19, 3, 3);
    }

    @After
    public void tearDown() {
        this._instance = null;
    }

    /**
     * Test of getFilter method, of class BlumBlumShub.
     */
    @Test
    public void testGetFilter() {
        System.out.println("getFilter");
        BlumBlumShub instance = this._instance;
        long expResult = 3L;
        long result = instance.getFilter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getP method, of class BlumBlumShub.
     */
    @Test
    public void testGetP() {
        System.out.println("getP");
        BlumBlumShub instance = this._instance;
        long expResult = 11L;
        long result = instance.getP();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQ method, of class BlumBlumShub.
     */
    @Test
    public void testGetQ() {
        System.out.println("getQ");
        BlumBlumShub instance = this._instance;
        long expResult = 19L;
        long result = instance.getQ();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeed method, of class BlumBlumShub.
     */
    @Test
    public void testGetSeed() {
        System.out.println("getSeed");
        BlumBlumShub instance = this._instance;
        long expResult = 3L;
        long result = instance.getSeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFilter method, of class BlumBlumShub.
     */
    @Test
    public void testSetFilter() {
        System.out.println("setFilter");
        long filter = 4L;
        BlumBlumShub instance = this._instance;
        instance.setFilter(filter);
        long result = instance.getFilter();
        assertEquals(filter, result);
    }

    /**
     * Test of setFilter method, of class BlumBlumShub, for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetFilter_Zero() {
        System.out.println("setFilter(0)");
        long filter = 0L;
        BlumBlumShub instance = this._instance;
        instance.setFilter(filter);
    }

    /**
     * Test of setP method, of class BlumBlumShub.
     */
    @Test
    public void testSetP() {
        System.out.println("setP");
        long p = 23L;
        BlumBlumShub instance = this._instance;
        instance.setP(p);
        long result = instance.getP();
        assertEquals(p, result);
    }

    /**
     * Test of setP method, of class BlumBlumShub, for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetP_Zero() {
        System.out.println("setP(0)");
        long p = 0L;
        BlumBlumShub instance = this._instance;
        instance.setP(p);
    }

    /**
     * Test of setQ method, of class BlumBlumShub.
     */
    @Test
    public void testSetQ() {
        System.out.println("setQ");
        long q = 23L;
        BlumBlumShub instance = this._instance;
        instance.setQ(q);
        long result = instance.getQ();
        assertEquals(q, result);
    }

    /**
     * Test of setQ method, of class BlumBlumShub, for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetQ_Zero() {
        System.out.println("setQ(0)");
        long q = 0L;
        BlumBlumShub instance = this._instance;
        instance.setQ(q);
    }

    /**
     * Test of setSeed method, of class BlumBlumShub.
     */
    @Test
    public void testSetSeed() {
        System.out.println("setSeed");
        long seed = 22L;
        BlumBlumShub instance = this._instance;
        instance.setSeed(seed);
        long result = instance.getSeed();
        assertEquals(seed, result);
    }

    /**
     * Test of setSeed method, of class BlumBlumShub, for the value null.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSeed_Null() {
        System.out.println("setSeed(null)");
        Long seed = null;
        BlumBlumShub instance = this._instance;
        instance.setSeed(seed);
    }

    /**
     * Test of setSeed method, of class BlumBlumShub, for the value 0 (zero).
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetSeed_Zero() {
        System.out.println("setSeed(0)");
        Long seed = 0L;
        BlumBlumShub instance = this._instance;
        instance.setSeed(seed);
    }

    /**
     * Test of getSample method, of class BlumBlumShub.
     */
    @Test
    public void testGetSample_0args() {
        System.out.println("getSample");
        Generator<Long> instance = this._instance;
        Long expResult = 1L;
        Long result = instance.getSample();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSample method, of class BlumBlumShub.
     */
    @Test
    public void testGetSample_int() {
        System.out.println("getSample(int)");
        int count = 7;
        Generator<Long> instance = this._instance;
        Long[] expResult = new Long[count];
        expResult[0] = 1L;
        expResult[1] = 1L;
        expResult[2] = 2L;
        expResult[3] = 0L;
        expResult[4] = 2L;
        expResult[5] = 0L;
        expResult[6] = 0L;
        Long[] result = instance.getSample(count);
        assertArrayEquals(expResult, result);
    }
}