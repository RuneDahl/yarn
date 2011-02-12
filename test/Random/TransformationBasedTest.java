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
 * Methods to facilitate jUnit test for implementations
 * of the class Random.TransformationBased.
 * @author Rune Dahl Iversen
 */
public class TransformationBasedTest<TypeOfSample, TypeOfOutput> {
    public TransformationBasedTest() { // Intentional
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
     * Test of getFunction method, of class TransformationBased.
     */
    public void testGetFunction(
            final TransformationBased<TypeOfSample, TypeOfOutput> instance) {
        Function result = instance.getFunction();
        assertNotNull(result);
    }

    /**
     * Test of setFunction method, of class TransformationBased.
     */
    public void testSetFunction(
            final TransformationBased<TypeOfSample, TypeOfOutput> instance,
            final Function<TypeOfSample, TypeOfOutput> function) {
        instance.setFunction(function);
        this.testGetFunction(instance);
    }

    /**
     * Test of getSample method, of class TransformationBased.
     */
    public void testGetSample(
            final TransformationBased<TypeOfSample, TypeOfOutput> instance,
            final TypeOfOutput expResult) {
        TypeOfOutput result = instance.getSample();
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