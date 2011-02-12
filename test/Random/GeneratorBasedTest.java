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
 * Methods to facilitate jUnit test for implementations
 * of the class Random.GeneratorBased.
 * @author Rune Dahl Iversen
 */
public class GeneratorBasedTest<TypeOfGenerator, TypeOfSample> {

    public GeneratorBasedTest() { // Intentional
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
     * Test of getGenerator method, of class GeneratorBased.
     */
    public void testGetGenerator(
            final GeneratorBased<TypeOfGenerator, TypeOfSample> instance) {
        TypeOfGenerator result = instance.getGenerator();
        assertNotNull("Generator not specified.", result);
    }

    /**
     * Test of setGenerator method, of class GeneratorBased.
     */
    public void testSetGenerator(
            final GeneratorBased<TypeOfGenerator, TypeOfSample> instance,
            final TypeOfGenerator generator) {
        instance.setGenerator(generator);
        this.testGetGenerator(instance);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}
