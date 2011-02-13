/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Validation.Validator;
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
     * Test of constructor, of class Differential,
     * for a null stepvalidator.
     */
    @Test (expected=NullPointerException.class)
    public void testConstructor_StepValidatorNull() {
        System.out.println("Differential(null, step, direction)");
        new StepValidatorNull();
    }

    /**
     * Test of getDirection method, of class Differential.
     */
    public void testGetDirection(
            final Differential<TypeOfInput, TypeOfOutput> instance,
            final DifferentialDirections expResult) {
        DifferentialDirections result = instance.getDirection();
        assertEquals(instance.toString(), expResult, result);
    }

    /**
     * Test of getStep method, of class Differential.
     */
    public void testGetStep(
            final Differential<TypeOfInput, TypeOfOutput> instance,
            final TypeOfInput expResult) {
        TypeOfInput result = instance.getStep();
        assertEquals(instance.toString(), expResult, result);
    }

    /**
     * Test of setDirection method, of class Differential.
     */
    public void testSetDirection(
            final Differential<TypeOfInput, TypeOfOutput> instance,
            final DifferentialDirections value) {
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
     * Class to test NullPointerException from constructor the
     * class Mathematics.Function.Differential.
     */
    public class StepValidatorNull extends Differential<Double, Double> {
        public StepValidatorNull() {
            super(null, 1.0, DifferentialDirections.Positive);
        }

        @Override
        public Double value(Double value, Function<Double, Double> function) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}