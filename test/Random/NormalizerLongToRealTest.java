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
 * jUnit test of the class Random.NormalizerLongToReal
 * @author Rune Dahl Iversen
 */
public class NormalizerLongToRealTest {
    private GeneratorBasedTest<Normalization<Long, Double>, Double> _gb;
    private NormalizerLongToReal _instance;
    private MersenneTwister _mt;

    public NormalizerLongToRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Random.NormalizerLongToReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._gb = new GeneratorBasedTest<Normalization<Long, Double>, Double>();
        this._mt = new MersenneTwister(123456);
        this._instance = new NormalizerLongToReal(this._mt);
    }

    @After
    public void tearDown() {
        this._gb = null;
        this._instance = null;
        this._mt = null;
    }

    /**
     * Test of getGenerator method, of class NormalizerLongToReal.
     */
    @Test
    public void testGetGenerator() {
        System.out.println("getGenerator");
        this._gb.testGetGenerator(this._instance);
    }

    /**
     * Test of setGenerator method, of class NormalizerLongToReal.
     */
    @Test
    public void testSetGenerator() {
        System.out.println("setGenerator");
        LinearCongruential lc = new LinearCongruential(4294967296L, 1664525, 1013904223, 123456);
        this._gb.testSetGenerator(this._instance, lc);
    }

    /**
     * Test of setGenerator method, of class NormalizerLongToReal,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetGenerator_Null() {
        System.out.println("setGenerator(null)");
        LinearCongruential lc = null;
        this._gb.testSetGenerator(this._instance, lc);
    }

    /**
     * Test of getSample method, of class NormalizerLongToReal.
     */
    @Test
    public void testGetSample() {
        System.out.println("getSample");
        NormalizerLongToReal instance = this._instance;
        double expResult = 0.9146088932175189;
        double result = instance.getSample();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSample method, of class NormalizerLongToReal.
     */
    @Test
    public void testGetSample_int() {
        System.out.println("getSample(int)");
        int count = 10;
        Generator<Double> instance = this._instance;
        Double[] expResult = new Double[count];
        expResult[0] = 0.9146088932175189;
        expResult[1] = 0.34718495747074485;
        expResult[2] = 0.9556644950062037;
        expResult[3] = 0.9482588886748999;
        expResult[4] = 0.33766225865110755;
        expResult[5] = 0.36070266063325107;
        expResult[6] = 0.8895191254559904;
        expResult[7] = 0.8902486688457429;
        expResult[8] = 0.5492003478575498;
        expResult[9] = 0.6209170832298696;
        Double[] result = instance.getSample(count);
        assertArrayEquals(expResult, result);
    }
}
