/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Builder;

import Mathematics.Vector.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate jUnit tests of the implementations the
 * class Mathematics.Graph.Builder.VectorDimensionShiftBased.
 * @author Rune Dahl Iversen
 */
public class VectorDimensionShiftBasedTest<TypeOfValue> {
    public VectorDimensionShiftBasedTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Graph.Builder.VectorDimensionShiftBased");
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
     * Test of getDimension method, of class VectorDimensionShiftBased.
     */
    public void testGetDimension(
            final VectorDimensionShiftBased<TypeOfValue> instance,
            final int expResult) {
        int result = instance.getDimension();
        assertEquals(instance.getClass().getName() + ".getDimension",
                expResult, result);
    }

    /**
     * Test of getShift method, of class VectorDimensionShiftBased.
     */
    public void testGetShift(
            final VectorDimensionShiftBased<TypeOfValue> instance,
            final TypeOfValue expResult) {
        TypeOfValue result = instance.getShift();
        assertEquals(instance.getClass().getName() + ".getShift",
                expResult, result);
    }

    /**
     * Test of setDimension method, of class VectorDimensionShiftBased.
     */
    public void testSetDimension(
            final VectorDimensionShiftBased<TypeOfValue> instance,
            final int dimension) {
        instance.setDimension(dimension);
        this.testGetDimension(instance, dimension);
    }

    /**
     * Test of setShift method, of class VectorDimensionShiftBased.
     */
    public void testSetShift(
            final VectorDimensionShiftBased<TypeOfValue> instance,
            final TypeOfValue shift) {
        instance.setShift(shift);
        this.testGetShift(instance, shift);
    }

    /**
     * Test of constructor, of class VectorDimensionShiftBased,
     * for a null valued valueValidator.
     */
    @Test (expected=NullPointerException.class)
    public void testCtor_NullValueValidator() {
        System.out.println("ctor(dimension, null, value)");
        new NullValueValidator();
    }

    /**
     * Helper class to test the exception thrown when specifying the
     * value validator as null in the construtor of VectorDimensionShiftBased.
     */
    private class NullValueValidator extends VectorDimensionShiftBased<Double> {

        public NullValueValidator() {
            super(0, null, 0.0);
        }

        @Override
        public Vector<Double> value(Vector<Double> input) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
