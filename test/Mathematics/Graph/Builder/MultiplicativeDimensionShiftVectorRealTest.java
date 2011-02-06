/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Builder;

import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Graph.Builder.MultiplicativeDimensionShiftVectorReal.
 * @author Rune Dahl Iversen
 */
public class MultiplicativeDimensionShiftVectorRealTest {
    private MultiplicativeDimensionShiftVectorReal _instance;
    private VectorDimensionShiftBasedTest<Double> _super;

    public MultiplicativeDimensionShiftVectorRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Graph.Builder.MultiplicativeDimensionShiftVectorReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new MultiplicativeDimensionShiftVectorReal(3, 0.5);
        this._super = new VectorDimensionShiftBasedTest<Double>();
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._super = null;
    }

    /**
     * Test of getDimension method, of class MultiplicativeDimensionShiftVectorReal.
     */
    @Test
    public void testGetDimension() {
        System.out.println("getDimension");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        int expResult = 3;
        this._super.testGetDimension(instance, expResult);
    }

    /**
     * Test of getShift method, of class MultiplicativeDimensionShiftVectorReal.
     */
    @Test
    public void testGetShift() {
        System.out.println("getShift");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        Double expResult = 0.5;
        this._super.testGetShift(instance, expResult);
    }

    /**
     * Test of setDimension method, of class MultiplicativeDimensionShiftVectorReal.
     */
    @Test
    public void testSetDimension() {
        System.out.println("setDimension");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        int shift = 5;
        this._super.testSetDimension(instance, shift);
    }

    /**
     * Test of setDimension method, of class MultiplicativeDimensionShiftVectorReal.
     */
    @Test
    public void testSetShift() {
        System.out.println("setShift");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        double shift = 4.65;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of setDimension method, of class MultiplicativeDimensionShiftVectorReal,
     * to a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetShift_Null() {
        System.out.println("setShift(null)");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        Double shift = null;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of setDimension method, of class MultiplicativeDimensionShiftVectorReal,
     * to the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetShift_NaN() {
        System.out.println("setShift(Double.NaN)");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        Double shift = Double.NaN;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of setDimension method, of class MultiplicativeDimensionShiftVectorReal,
     * to the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetShift_PositiveInfinity() {
        System.out.println("setShift(Double.POSITIVE_INFINITY)");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        Double shift = Double.POSITIVE_INFINITY;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of setDimension method, of class MultiplicativeDimensionShiftVectorReal,
     * to the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetShift_NegativeInfinity() {
        System.out.println("setShift(Double.NEGATIVE_INFINITY)");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        Double shift = Double.NEGATIVE_INFINITY;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of value method, of class MultiplicativeDimensionShiftVectorReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        StateShift<Vector<Double>> instance = this._instance;
        Vector<Double> input = VectorReal.Unit(4, 2);
        Vector expResult = input.setValue(3, 0.0);
        Vector result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        input = result;
        expResult = expResult.setValue(3, 0.0);
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        input = VectorReal.Unit(4, 3);
        expResult = input.setValue(3, 0.5);
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        input = result;
        expResult = input.setValue(3, 0.25);
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);
    }

    /**
     * Test of value method, of class MultiplicativeDimensionShiftVectorReal,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        Vector<Double> input = null;
        instance.value(input);
    }

    /**
     * Test of value method, of class MultiplicativeDimensionShiftVectorReal,
     * for a null value.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testValue_DimensionOutOfRange() {
        System.out.println("value(dimension out of range)");
        MultiplicativeDimensionShiftVectorReal instance = this._instance;
        Vector<Double> input = VectorReal.Unit(2, 1);
        instance.value(input);
    }
}
