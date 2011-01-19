/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate jUnit testing of the class Mathematics.Function.Trigonometric.
 * @author Rune Dahl Iversen
 */
public class TrigonometricTest<TypeOfValue> {
    public TrigonometricTest() { // Intentional
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
     * Test of getAmplitude method, of class Trigonometric.
     */
    public void testGetAmplitude(final Trigonometric<TypeOfValue> instance,
            final TypeOfValue expResult) {
        Object result = instance.getAmplitude();
        assertEquals(instance.toString(), expResult, result);
    }

    /**
     * Test of setAmplitude method, of class Trigonometric.
     */
    public void testSetAmplitude(final Trigonometric<TypeOfValue> instance,
            final TypeOfValue amplitude) {
        instance.setAmplitude(amplitude);
        this.testGetAmplitude(instance, amplitude);
    }

    /**
     * Test of getFrequency method, of class Trigonometric.
     */
    public void testGetFrequency(final Trigonometric<TypeOfValue> instance,
            final TypeOfValue expResult) {
        TypeOfValue result = instance.getFrequency();
        assertEquals(instance.toString(), expResult, result);
    }

    /**
     * Test of setFrequency method, of class Trigonometric.
     */
    public void testSetFrequency(final Trigonometric<TypeOfValue> instance,
            final TypeOfValue frequency) {
        instance.setFrequency(frequency);
        this.testGetFrequency(instance, frequency);
    }

    /**
     * Test of getPhase method, of class Trigonometric.
     */
    public void testGetPhase(final Trigonometric<TypeOfValue> instance,
            final TypeOfValue expResult) {
        Object result = instance.getPhase();
        assertEquals(instance.toString(), expResult, result);
    }

    /**
     * Test of setPhase method, of class Trigonometric.
     */
    public void testSetPhase(final Trigonometric<TypeOfValue> instance,
            final TypeOfValue phase) {
        instance.setPhase(phase);
        this.testGetPhase(instance, phase);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}