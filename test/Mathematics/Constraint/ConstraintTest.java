/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate unit testing for implementations of the interface
 * Mathematics.Constraint.Constraint.
 * @author Rune Dahl Iversen
 */
public class ConstraintTest<TypeOfValue> {
    public ConstraintTest() { // Intentional
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
     * Test of isBinding method, of the specified Constraint.
     */
    public void testIsBinding(final Constraint<TypeOfValue> instance,
            final TypeOfValue value,
            final boolean expResult) {
        boolean result = instance.isBinding(value);
        assertEquals(instance.toString() + " binds at " + value.toString(),
                expResult, result);
    }

    /**
     * Test of isFeasible method, of the specified Constraint.
     */
    public void testIsFeasible(final Constraint<TypeOfValue> instance,
            final TypeOfValue value,
            final boolean expResult) {
        boolean result = instance.isFeasible(value);
        assertEquals(value.toString() + " is feasible for " + instance.toString(),
                expResult, result);
    }

    /**
     * Blank test to allow thi setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}