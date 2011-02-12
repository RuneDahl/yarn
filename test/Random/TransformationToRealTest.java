/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Random;

import Mathematics.Function.Function;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test of the class Random.TransformationToReal.
 * @author Rune Dahl Iversen
 */
public class TransformationToRealTest {
    GeneratorBasedTest<Generator<Long>, Long> _gb;
    TransformationBasedTest<Long, Double> _tb;
    TransformationToReal<Long> _instance;

    public TransformationToRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Random.TransformationToReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._gb = new GeneratorBasedTest<Generator<Long>, Long>();
        this._tb = new TransformationBasedTest<Long, Double>();
        Function<Long, Double> function = new Sine();
        this._instance = new TransformationToReal<Long>(new MersenneTwister(123456), function);
    }

    @After
    public void tearDown() {
        this._gb = null;
        this._tb = null;
        this._instance = null;
    }

    /**
     * Test of getFunction method, of class TransformationToReal.
     */
    @Test
    public void testGetFunction() {
        System.out.println("getFunction()");
        TransformationToReal instance = this._instance;
        this._tb.testGetFunction(instance);
    }

    /**
     * Test of setFunction method, of class TransformationToReal.
     */
    @Test
    public void testSetFunction() {
        System.out.println("setFunction()");
        TransformationToReal instance = this._instance;
        Function<Long, Double> function = new Thrower();
        this._tb.testSetFunction(instance, function);
    }

    /**
     * Test of setFunction method, of class TransformationToReal,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetFunction_Null() {
        System.out.println("setFunction(null)");
        TransformationToReal instance = this._instance;
        Function<Long, Double> function = null;
        this._tb.testSetFunction(instance, function);
    }

    /**
     * Test of getGenerator method, of class TransformationToReal.
     */
    @Test
    public void testGetGenerator() {
        System.out.println("getGenerator()");
        TransformationToReal instance = this._instance;
        this._gb.testGetGenerator(instance);
    }

    /**
     * Test of setGenerator method, of class TransformationToReal.
     */
    @Test
    public void testSetGenerator() {
        System.out.println("setGenerator()");
        TransformationToReal instance = this._instance;
        Generator<Long> generator = new LinearCongruential(5, 2, 1, 123);
        this._gb.testSetGenerator(instance, generator);
    }

    /**
     * Test of setGenerator method, of class TransformationToReal,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetGenerator_Null() {
        System.out.println("setGenerator(null)");
        TransformationToReal instance = this._instance;
        Generator<Long> generator = null;
        this._gb.testSetGenerator(instance, generator);
    }

    /**
     * Test of getSample method, of class TransformationToReal.
     */
    @Test
    public void testGetSample() {
        System.out.println("getSample()");
        TransformationToReal instance = this._instance;
        Double expResult = 0.7579047329014654;
        Object result = instance.getSample();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSample method, of class TransformationToReal.
     */
    @Test
    public void testGetSample_Int() {
        System.out.println("getSample(int)");
        int count = 4;
        TransformationToReal instance = this._instance;
        Double[] expResult = new Double[count];
        expResult[0] = 0.7579047329014654;
        expResult[1] = 0.726734121503021;
        expResult[2] = -0.6493193743641417;
        expResult[3] = -0.3379026896007484;
        Double[] result = instance.getSample(count);
        assertArrayEquals(expResult, result);
    }

    private class Thrower implements Function<Long, Double> {
        @Override
        public Double value(Long input) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private class Sine implements Function<Long, Double> {
        @Override
        public Double value(Long input) {
            long value = input;
            return Math.sin(value);
        }
    }
}
