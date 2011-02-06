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
 * jUnit test for the class Mathematics.Graph.Builder.AdditiveDimensionShiftVectorReal.
 * @author Rune Dahl Iversen
 */
public class AdditiveDimensionShiftVectorRealTest {
    private AdditiveDimensionShiftVectorReal _instance;
    private VectorDimensionShiftBasedTest<Double> _super;

    public AdditiveDimensionShiftVectorRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Graph.Builder.AdditiveDimensionShiftVectorReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new AdditiveDimensionShiftVectorReal(3, 0.5);
        this._super = new VectorDimensionShiftBasedTest<Double>();
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._super = null;
    }

    /**
     * Test of getDimension method, of class AdditiveDimensionShiftVectorReal.
     */
    @Test
    public void testGetDimension() {
        System.out.println("getDimension");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        int expResult = 3;
        this._super.testGetDimension(instance, expResult);
    }

    /**
     * Test of getShift method, of class AdditiveDimensionShiftVectorReal.
     */
    @Test
    public void testGetShift() {
        System.out.println("getShift");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        Double expResult = 0.5;
        this._super.testGetShift(instance, expResult);
    }

    /**
     * Test of setDimension method, of class AdditiveDimensionShiftVectorReal.
     */
    @Test
    public void testSetDimension() {
        System.out.println("setDimension");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        int shift = 5;
        this._super.testSetDimension(instance, shift);
    }

    /**
     * Test of setDimension method, of class AdditiveDimensionShiftVectorReal.
     */
    @Test
    public void testSetShift() {
        System.out.println("setShift");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        double shift = 4.65;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of setDimension method, of class AdditiveDimensionShiftVectorReal,
     * to a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetShift_Null() {
        System.out.println("setShift(null)");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        Double shift = null;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of setDimension method, of class AdditiveDimensionShiftVectorReal,
     * to the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetShift_NaN() {
        System.out.println("setShift(Double.NaN)");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        Double shift = Double.NaN;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of setDimension method, of class AdditiveDimensionShiftVectorReal,
     * to the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetShift_PositiveInfinity() {
        System.out.println("setShift(Double.POSITIVE_INFINITY)");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        Double shift = Double.POSITIVE_INFINITY;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of setDimension method, of class AdditiveDimensionShiftVectorReal,
     * to the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetShift_NegativeInfinity() {
        System.out.println("setShift(Double.NEGATIVE_INFINITY)");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        Double shift = Double.NEGATIVE_INFINITY;
        this._super.testSetShift(instance, shift);
    }

    /**
     * Test of value method, of class AdditiveDimensionShiftVectorReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        StateShift<Vector<Double>> instance = this._instance;
        Vector<Double> input = VectorReal.Unit(4, 2);
        Vector expResult = input.setValue(3, 0.5);
        Vector result = instance.value(input);
        assertEquals(input.toString(), expResult, result);

        input = result;
        expResult = expResult.setValue(3, 1.0);
        result = instance.value(input);
        assertEquals(input.toString(), expResult, result);
    }

    /**
     * Test of value method, of class AdditiveDimensionShiftVectorReal,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value(null)");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        Vector<Double> input = null;
        instance.value(input);
    }

    /**
     * Test of value method, of class AdditiveDimensionShiftVectorReal,
     * for a null value.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testValue_DimensionOutOfRange() {
        System.out.println("value(dimension out of range)");
        AdditiveDimensionShiftVectorReal instance = this._instance;
        Vector<Double> input = VectorReal.Unit(2, 1);
        instance.value(input);
    }
}
