/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Mathematics.Function.Differential.DifferentialDirection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate jUnit test of the class Mathematics.Function.Differential.
 * @author Rune Dahl Iversen
 */
public class DifferentialTest<TypeOfInput, TypeOfOutput> {
    public DifferentialTest() { // Intentional
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
     * Test of getDirection method, of class Differential.
     */
    public void testGetDirection(final Differential<TypeOfInput, TypeOfOutput> instance,
            final DifferentialDirection expResult) {
        DifferentialDirection result = instance.getDirection();
        assertEquals(instance.toString(), expResult, result);
    }

    /**
     * Test of getStep method, of class Differential.
     */
    public void testGetStep(final Differential<TypeOfInput, TypeOfOutput> instance,
            final TypeOfInput expResult) {
        TypeOfInput result = instance.getStep();
        assertEquals(instance.toString(), expResult, result);
    }

    /**
     * Test of setDirection method, of class Differential.
     */
    public void testSetDirection(final Differential<TypeOfInput, TypeOfOutput> instance,
            final DifferentialDirection value) {
        instance.setDirection(value);
        this.testGetDirection(instance, value);
    }

    /**
     * Test of setStep method, of class Differential.
     */
    public void testSetStep(final Differential<TypeOfInput, TypeOfOutput> instance,
            final TypeOfInput step) {
        instance.setStep(step);
        this.testGetStep(instance, step);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}