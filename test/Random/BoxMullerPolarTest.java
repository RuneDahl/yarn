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
 * jUnit test of the class Random.BoxMullerPolar.
 * @author Rune Dahl Iversen
 */
public class BoxMullerPolarTest {
    private GeneratorBasedTest<Generator<Double>, Double> _gb;
    private BoxMullerPolar _instance;

    public BoxMullerPolarTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Random.BoxMullerPolar");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._gb = new GeneratorBasedTest<Generator<Double>, Double>();
        this._instance = new BoxMullerPolar(new NormalizerLongToReal(new MersenneTwister(123456)));
    }

    @After
    public void tearDown() {
        this._gb = null;
        this._instance = null;
    }

    /**
     * Test of getGenerator method, of class BoxMullerPolar.
     */
    @Test
    public void testGetGenerator() {
        System.out.println("getGenerator()");
        BoxMullerPolar instance = this._instance;
        this._gb.testGetGenerator(instance);
    }

    /**
     * Test of setGenerator method, of class BoxMullerPolar.
     */
    @Test
    public void testSetGenerator() {
        System.out.println("setGenerator()");
        BoxMullerPolar instance = this._instance;
        Generator<Double> generator = new NormalizerLongToReal(new LinearCongruential(5, 2, 1, 123));
        this._gb.testSetGenerator(instance, generator);
    }

    /**
     * Test of setGenerator method, of class BoxMullerPolar,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetGenerator_Null() {
        System.out.println("setGenerator(null)");
        BoxMullerPolar instance = this._instance;
        Generator<Double> generator = null;
        this._gb.testSetGenerator(instance, generator);
    }

    /**
     * Test of getSample method, of class BoxMullerPolar.
     */
    @Test
    public void testGetSample() {
        System.out.println("getSample");
        Generator<Double> instance = this._instance;
        Double expResult = 0.6597025945165372;
        Double result = instance.getSample();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSample method, of class BoxMullerPolar.
     */
    @Test
    public void testGetSample_int() {
        System.out.println("getSample(int)");
        int count = 10;
        BoxMullerPolar instance = this._instance;
        Double[] expResult = new Double[count];
        expResult[0] = 0.6597025945165372;
        expResult[1] = -0.2431507902673344;
        expResult[2] = -1.3985797158784448;
        expResult[3] = -1.200080965124874;
        expResult[4] = 0.8735038811020893;
        expResult[5] = 2.146764120421312;
        expResult[6] = 0.38028853873030233;
        expResult[7] = 0.537480859688711;
        expResult[8] = 2.097958246095286;
        expResult[9] = 1.975131431092194;
        Double[] result = instance.getSample(count);
        assertArrayEquals(expResult, result);

        instance.setGenerator(new ZeroGenerator());
        result = instance.getSample(count);
    }

    /**
     * Test of getSample method, of class BoxMullerPolar.
     * Based on a 1,000,000 sample the first 4 moments are
     * computed and compared to their theoretical values
     * from the Gaussian/normal distribution.
     */
    @Test
    public void testGetSample_Moments() {
        System.out.println("Moments 1 through 4");
        int count = 1000000;
        BoxMullerPolar instance = this._instance;
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
            double sample = 0.5;
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
