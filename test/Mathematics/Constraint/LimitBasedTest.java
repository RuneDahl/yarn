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
 * Methods to facilitate unit testing implementations of the abstract class
 * Mathematics.Constraint.LimitBased.
 * @author Rune Dahl Iversen
 */
public class LimitBasedTest<TypeOfValue, TypeOfLimit> {
    public LimitBasedTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Constraint.LimitBased");
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
     * Test of constructor, of class LimitBased, for a null validator.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_ValidatorNull() {
        System.out.println("LimitBased(null, l)");
        LimitBased<Double, Double> instance = new NullValidator();
    }

    /**
     * Test of getLimit method, of class LimitBased.
     */
    public void testGetLimit(final LimitBased<TypeOfValue, TypeOfLimit> instance,
            final TypeOfLimit expResult) {
        TypeOfLimit result = instance.getLimit();
        assertEquals(instance.toString() + " getLimit", expResult, result);
    }

    /**
     * Test of setLimit method, of class LimitBased.
     */
    public void testSetLimit(final LimitBased<TypeOfValue, TypeOfLimit> instance,
            final TypeOfLimit limit) {
        instance.setLimit(limit);
        this.testGetLimit(instance, limit);
    }

    public final class NullValidator extends LimitBased<Double, Double> {
        public NullValidator() {
            super(null, 0.0);
        }

        @Override
        public boolean isBinding(Double value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean isFeasible(Double value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}