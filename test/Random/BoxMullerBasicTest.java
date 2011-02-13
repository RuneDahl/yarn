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
 * jUnit test of the class Random.BoxMullerBasic.
 * @author Rune Dahl Iversen
 */
public class BoxMullerBasicTest {
    private GeneratorBasedTest<Generator<Double>, Double> _gb;
    private BoxMullerBasic _instance;

    public BoxMullerBasicTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Random.BoxMullerBasic");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._gb = new GeneratorBasedTest<Generator<Double>, Double>();
        this._instance = new BoxMullerBasic(new NormalizerLongToReal(new MersenneTwister(123456)));
    }

    @After
    public void tearDown() {
        this._gb = null;
        this._instance = null;
    }

    /**
     * Test of getGenerator method, of class BoxMullerBasic.
     */
    @Test
    public void testGetGenerator() {
        System.out.println("getGenerator()");
        BoxMullerBasic instance = this._instance;
        this._gb.testGetGenerator(instance);
    }

    /**
     * Test of setGenerator method, of class BoxMullerBasic.
     */
    @Test
    public void testSetGenerator() {
        System.out.println("setGenerator()");
        BoxMullerBasic instance = this._instance;
        Generator<Double> generator = new NormalizerLongToReal(new LinearCongruential(5, 2, 1, 123));
        this._gb.testSetGenerator(instance, generator);
    }

    /**
     * Test of setGenerator method, of class BoxMullerBasic,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetGenerator_Null() {
        System.out.println("setGenerator(null)");
        BoxMullerBasic instance = this._instance;
        Generator<Double> generator = null;
        this._gb.testSetGenerator(instance, generator);
    }

    /**
     * Test of getSample method, of class BoxMullerBasic.
     */
    @Test
    public void testGetSample() {
        System.out.println("getSample");
        Generator<Double> instance = this._instance;
        Double expResult = -0.24226262914904412;
        Double result = instance.getSample();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSample method, of class BoxMullerBasic.
     */
    @Test
    public void testGetSample_int() {
        System.out.println("getSample(int)");
        int count = 10;
        BoxMullerBasic instance = this._instance;
        Double[] expResult = new Double[count];
        expResult[0] = -0.24226262914904412;
        expResult[1] = 0.346159366333438;
        expResult[2] = 0.2853840324963741;
        expResult[3] = -0.09619096809167156;
        expResult[4] = -0.9442945589828963;
        expResult[5] = 1.131249760896925;
        expResult[6] = 0.3733243295561866;
        expResult[7] = -0.3078595239140827;
        expResult[8] = -0.7937421640768146;
        expResult[9] = -0.7540274002743971;
        Double[] result = instance.getSample(count);
        assertArrayEquals(expResult, result);

        instance.setGenerator(new ZeroGenerator());
        result = instance.getSample(count);
    }

    /**
     * Test of getSample method, of class BoxMullerBasic.
     * Based on a 1,000,000 sample the first 4 moments are
     * computed and compared to their theoretical values
     * from the Gaussian/normal distribution.
     */
    @Test
    public void testGetSample_Moments() {
        System.out.println("Moments 1 through 4");
        int count = 1000000;
        BoxMullerBasic instance = this._instance;
        Double[] result = instance.getSample(count);
        double mean = 0.0;
        double variance = 0.0;
        double skewness = 0.0;
        double kurtosis = 0.0;
        for (int i = 0; i < result.length; i++) {
            double value = result[i];
            mean += value;
            variance += value*value;
            skewness += value*value*value;
            kurtosis += value*value*value*value;
        }
        mean /= result.length;
        variance /= result.length;
        skewness /= result.length;
        kurtosis /= result.length;
        assertEquals("Wrong mean value.", 0.0, mean, Math.pow(10.0, -3.0));
        assertEquals("Wrong variance value.", 1.0, variance, Math.pow(10.0, -3.0));
        assertEquals("Wrong skewness value.", 0.0, skewness, Math.pow(10.0, -2.0));
        assertEquals("Wrong kurtosis value.", 3.0, kurtosis, Math.pow(10.0, -2.0));
    }

    private class ZeroGenerator implements Generator<Double> {
        private int _count = 2;
        private Generator<Double> _generator = new NormalizerLongToReal(new MersenneTwister(123456));

        @Override
        public Double getSample() {
            double sample = 0.0;
            if (0 < this._count) {
                this._count--;
            }
            else {
                sample = this._generator.getSample();
            }
            return sample;
        }

        @Override
        public Double[] getSample(int count) {
            Double[] samples = new Double[count];
            for (int index = 0; index < count; index++)
                samples[index] = this.getSample();
            return samples;
        }
    }
}
