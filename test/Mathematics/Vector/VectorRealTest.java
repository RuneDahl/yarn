/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Time.Periods.GregorianDay;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Vector.VectorReal.
 * @author Rune Dahl Iversen
 */
public class VectorRealTest {
    private double[] _values;
    private VectorReal _vector;
    private VectorReal _dim4;
    private VectorReal _dim1Though4;
    private VectorReal _dim3;

    public VectorRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._values = new double[]{4.0, 3.2, -1.54, -Math.PI};
        this._vector = new VectorReal(this._values);

        double[] values = new double[]{1.0, 2.0, 3.0, 4.0};
        this._dim4 = new VectorReal(values);

        this._dim1Though4 = new VectorReal(1, values);

        values = new double[]{1.0, 2.0, 3.0};
        this._dim3 = new VectorReal(values);
    }

    @After
    public void tearDown() {
        this._values = null;
        this._vector = null;
        this._dim1Though4 = null;
        this._dim3 = null;
        this._dim4 = null;
    }

    /**
     * Test of constructor, of class VectorReal, taking one integer input.
     */
    @Test
    public void testCtor_int() {
        System.out.println("ctor(int)");
        VectorReal vector = new VectorReal(1);
        VectorReal expResult = new VectorReal(new double[] {0.0});
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorReal, taking two integer inputs.
     */
    @Test
    public void testCtor_int_int() {
        System.out.println("ctor(int, int)");
        VectorReal vector = new VectorReal(1, 3);
        VectorReal expResult = new VectorReal(1, new double[] {0.0, 0.0, 0.0});
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorReal,
     * taking two inputs: integer and double.
     */
    @Test
    public void testCtor_int_double() {
        System.out.println("ctor(int, double)");
        VectorReal vector = new VectorReal(1, 3.0);
        VectorReal expResult = new VectorReal(0, new double[] {3.0});
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorReal,
     * taking three inputs: two integers and a double.
     */
    @Test
    public void testCtor_int_int_double() {
        System.out.println("ctor(int, int, double)");
        VectorReal vector = new VectorReal(1, 4, 3.0);
        VectorReal expResult = new VectorReal(1, new double[] {3.0, 3.0, 3.0, 3.0});
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorReal,
     * taking an array of doubles as input.
     */
    @Test
    public void testCtor_array() {
        System.out.println("ctor(double[])");
        VectorReal vector = new VectorReal(new double[] {3.0, 3.0, 3.0, 3.0});
        VectorReal expResult = new VectorReal(4, 3.0);
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorReal,
     * taking two inputs: integer and an array of doubles as input.
     */
    @Test
    public void testCtor_int_array() {
        System.out.println("ctor(int, double[])");
        VectorReal vector = new VectorReal(5, new double[] {3.0, 3.0, 3.0, 3.0});
        VectorReal expResult = new VectorReal(5, 4, 3.0);
        assertEquals(vector, expResult);
    }

    /**
     * Test of getDimensions method, of class VectorReal.
     */
    @Test
    public void testGetDimensions() {
        System.out.println("getDimensions");
        VectorReal instance = this._vector;
        int expResult = 4;
        int result = instance.getDimensions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstDimension method, of class VectorReal.
     */
    @Test
    public void testGetFirstDimension() {
        System.out.println("getFirstDimension");
        VectorReal instance = this._vector;
        int expResult = 0;
        int result = instance.getFirstDimension();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastDimension method, of class VectorReal.
     */
    @Test
    public void testGetLastDimension() {
        System.out.println("getLastDimension");
        VectorReal instance = this._vector;
        int expResult = 3;
        int result = instance.getLastDimension();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class VectorReal.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        VectorReal instance = this._vector;
        for (int dimension = 0; dimension < instance.getDimensions(); dimension++) {
            double expResult = this._values[dimension];
            double result = instance.getValue(dimension);
            assertEquals(expResult, result, 0.0);
        }
        instance = this._dim3;
        for (int dimension = 0; dimension < instance.getDimensions(); dimension++) {
            double expResult = dimension + 1.0;
            double result = instance.getValue(dimension);
            assertEquals(expResult, result, 0.0);
        }
    }

    /**
     * Test of hasSameDimensions method, of class VectorReal.
     */
    @Test
    public void testHasSameDimensions() {
        System.out.println("hasSameDimensions");
        VectorReal instance = this._vector;
        Vector<Double> vector = this._dim4;
        boolean expResult = true;
        boolean result = instance.hasSameDimensions(vector);
        assertEquals("Failed test of hasSameDimensions for having same dimensions.",
                expResult, result);

        vector = this._dim1Though4;
        expResult = false;
        result = instance.hasSameDimensions(vector);
        assertEquals("Failed test of hasSameDimensions for different FirstDimension.",
                expResult, result);

        vector = this._dim3;
        expResult = false;
        result = instance.hasSameDimensions(vector);
        assertEquals("Failed test of hasSameDimensions for different number of dimensions.",
                expResult, result);
    }

    /**
     * Test of hasSameDimensions method, of class VectorReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testHasSameDimensions_Null() {
        System.out.println("hasSameDimensions(null)");
        VectorReal instance = this._vector;
        VectorReal nullValue = null;
        instance.hasSameDimensions(nullValue);
    }

    /**
     * Test of setValue method, of class VectorReal.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int dimension = 0;
        Double value = Math.E;
        VectorReal instance = this._vector;
        double[] values = new double[]{Math.E, 3.2, -1.54, -Math.PI};
        VectorReal expResult = new VectorReal(values);
        Vector<Double> result = instance.setValue(dimension, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class VectorReal, for an index out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testSetValue_IndexOutOfRange() {
        System.out.println("setValue(index out of range, x)");
        int dimension = 22;
        Double value = Math.E;
        VectorReal instance = this._vector;
        instance.setValue(dimension, value);
    }

    /**
     * Test of setValue method, of class VectorReal, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_Null() {
        System.out.println("setValue(n, null)");
        int dimension = 0;
        Double value = null;
        VectorReal instance = this._vector;
        instance.setValue(dimension, value);
    }

    /**
     * Test of setValue method, of class VectorReal, for a Double.NaN value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_NaN() {
        System.out.println("setValue(n, Double.NaN)");
        int dimension = 3;
        Double value = Double.NaN;
        VectorReal instance = this._vector;
        instance.setValue(dimension, value);
    }

    /**
     * Test of setValue method, of class VectorReal, for a Double.POSITIVE_INFINITY value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_PositiveInfinity() {
        System.out.println("setValue(n, Double.POSITIVE_INFINITY)");
        int dimension = 3;
        Double value = Double.POSITIVE_INFINITY;
        VectorReal instance = this._vector;
        instance.setValue(dimension, value);
    }

    /**
     * Test of setValue method, of class VectorReal, for a Double.NEGATIVE_INFINITY value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_NegativeInfinity() {
        System.out.println("setValue(n, Double.NEGATIVE_INFINITY)");
        int dimension = 3;
        Double value = Double.NEGATIVE_INFINITY;
        VectorReal instance = this._vector;
        instance.setValue(dimension, value);
    }

    /**
     * Test of sum method, of class VectorReal.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Vector<Double> value = this._dim4;
        VectorReal instance = this._vector;
        double[] values = new double[]{5.0, 5.2, 1.46, 0.8584073464102069};
        Vector expResult = new VectorReal(values);
        Vector result = instance.sum(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of sum method, of class VectorReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSum_Null() {
        System.out.println("sum(null)");
        Vector<Double> value = null;
        VectorReal instance = this._vector;
        instance.sum(value);
    }

    /**
     * Test of sum method, of class VectorReal, for vector with the wrong number of dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSum_WrongDimensions() {
        System.out.println("sum(wrong dimensions vector)");
        Vector<Double> value = this._dim3;
        VectorReal instance = this._vector;
        instance.sum(value);
    }

    /**
     * Test of sum method, of class VectorReal, for a vector with a wrong first dimension.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSum_WrongFirstDimension() {
        System.out.println("sum(wrong first dimension vector)");
        Vector<Double> value = this._dim1Though4;
        VectorReal instance = this._vector;
        instance.sum(value);
    }

    /**
     * Test of equals method, of class VectorReal, for an object.
     */
    @Test
    public void testEquals_Object() {
        System.out.println("equals(object)");
        Object obj = new GregorianDay(1);
        VectorReal instance = this._vector;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class VectorReal.
     */
    @Test
    public void testEquals_VectorReal() {
        System.out.println("equals");
        VectorReal vector = this._vector;
        VectorReal instance = this._vector;
        boolean expResult = true;
        boolean result = instance.equals(vector);
        assertEquals("Equals self.", expResult, result);

        vector = new VectorReal(this._values);
        result = instance.equals(vector);
        assertEquals("Equals clone.", expResult, result);

        expResult = false;
        vector = this._dim3;
        result = instance.equals(vector);
        assertEquals("Does not equal different dimensions.", expResult, result);

        vector = this._dim4;
        result = instance.equals(vector);
        assertEquals("Does not equal different values.", expResult, result);

        Vector<Double> temp = this._dim1Though4;
        for (int dim = 0; dim < instance.getDimensions(); dim++) {
            temp = temp.setValue(dim+1, instance.getValue(dim));
        }
        result = instance.equals(temp);
        assertEquals("Does not equal different first dimension.", expResult, result);
    }

    /**
     * Test of equals method, of class VectorReal, for a null value.
     */
    @Test
    public void testEquals_Null() {
        System.out.println("equals(null)");
        VectorReal instance = this._vector;
        boolean expResult = false;
        VectorReal nullValue = null;
        boolean result = instance.equals(nullValue);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class VectorReal.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        VectorReal instance = this._vector;
        int expResult = 1389349524;
        int result = instance.hashCode();
        assertEquals(expResult, result);

        instance = this._dim3;
        expResult = 66614367;
        result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class VectorReal.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Vector<Double> value = this._vector;
        VectorReal instance = this._dim4;
        double[] values = new double[]{-3.0, -1.2000000000000002, 4.54, +4.0 + Math.PI};
        Vector<Double> expResult = new VectorReal(values);
        Vector result = instance.subtract(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class VectorReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSubtract_Null() {
        System.out.println("subtract(null)");
        Vector<Double> value = null;
        VectorReal instance = this._vector;
        instance.subtract(value);
    }

    /**
     * Test of subtract method, of class VectorReal, for vector with the wrong number of dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSubtract_WrongDimensions() {
        System.out.println("subtract(wrong dimensions vector)");
        Vector<Double> value = this._dim3;
        VectorReal instance = this._vector;
        instance.subtract(value);
    }

    /**
     * Test of subtract method, of class VectorReal, for a vector with a wrong first dimension.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSubtract_WrongFirstDimension() {
        System.out.println("subtract(wrong first dimension vector)");
        Vector<Double> value = this._dim1Though4;
        VectorReal instance = this._vector;
        instance.subtract(value);
    }

    /**
     * Test of scale method, of class VectorReal.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        Double scalar = Math.E;
        VectorReal instance = this._vector;
        double[] values = new double[]{4.0*Math.E, 3.2*Math.E, -1.54*Math.E, -Math.PI*Math.E};
        Vector<Double> expResult = new VectorReal(values);
        Vector result = instance.scale(scalar);
        assertEquals(expResult, result);
    }

    /**
     * Test of scale method, of class VectorReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testScale_Null() {
        System.out.println("scale(null)");
        Double scalar = null;
        VectorReal instance = this._vector;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class VectorReal, for a Double.NaN value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_NaN() {
        System.out.println("scale(Double.NaN)");
        Double scalar = Double.NaN;
        VectorReal instance = this._vector;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class VectorReal, for a Double.POSITIVE_INFINITY value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_PositiveInfinity() {
        System.out.println("scale(Double.POSITIVE_INFINITY)");
        Double scalar = Double.POSITIVE_INFINITY;
        VectorReal instance = this._vector;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class VectorReal, for a Double.NEGATIVE_INFINITY value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_NegativeInfinity() {
        System.out.println("scale(Double.NEGATIVE_INFINITY)");
        Double scalar = Double.NEGATIVE_INFINITY;
        VectorReal instance = this._vector;
        instance.scale(scalar);
    }

    /**
     * Test of toArray method, of class VectorReal.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        VectorReal instance = this._vector;
        double[] expResult = new double[]{4.0, 3.2, -1.54, -Math.PI};
        Double[] result = instance.toArray();
        assertEquals("Wrong lenght of array.", expResult.length, result.length);
        for (int index = 0; index < result.length; index++)
            assertEquals("Wrong value for index " + Integer.toString(index),
                    expResult[index], result[index], 0.0);
    }

    /**
     * Test of toString method, of class VectorReal.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VectorReal instance = this._vector;
        String expResult = "[4.0 ; 3.2 ; -1.54 ; -3.141592653589793]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of Unit method, of class VectorReal.
     */
    @Test
    public void testUnit_int_int() {
        System.out.println("Unit(int, int)");
        int dimensions = 5;
        int unitDimension = 2;
        double[] values = new double[] {0.0, 0.0, 1.0, 0.0, 0.0};
        VectorReal expResult = new VectorReal(values);
        VectorReal result = VectorReal.Unit(dimensions, unitDimension);
        assertEquals(expResult, result);

        dimensions = 5;
        unitDimension = 4;
        values = new double[] {0.0, 0.0, 0.0, 0.0, 1.0};
        expResult = new VectorReal(values);
        result = VectorReal.Unit(dimensions, unitDimension);
        assertEquals(expResult, result);
    }

    /**
     * Test of Unit method, of class VectorReal, for a unit dimension out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testUnit_int_int_UnitDimensionOutOfRange() {
        System.out.println("Unit(int, index out of )");
        int dimensions = 5;
        int unitDimension = 5;
        double[] values = new double[] {0.0, 0.0, 1.0, 0.0, 0.0};
        VectorReal expResult = new VectorReal(values);
        VectorReal result = VectorReal.Unit(dimensions, unitDimension);
        assertEquals(expResult, result);
    }

    /**
     * Test of Unit method, of class VectorReal, for a negative number of dimensions.
     */
    @Test (expected=NegativeArraySizeException.class)
    public void testUnit_int_int_NegativeDimensions() {
        System.out.println("Unit(int, index out of )");
        int dimensions = -3;
        int unitDimension = 5;
        VectorReal.Unit(dimensions, unitDimension);
    }

    /**
     * Test of Unit method, of class VectorReal.
     */
    @Test
    public void testUnit_3args() {
        System.out.println("Unit(int, int, int)");
        int firstDimension = 5;
        int dimensions = 3;
        int unitDimension = 6;
        double[] values = new double[] {0.0, 1.0, 0.0};
        VectorReal expResult = new VectorReal(5, values);
        VectorReal result = VectorReal.Unit(firstDimension, dimensions, unitDimension);
        assertEquals(expResult, result);

        firstDimension = 3;
        dimensions = 10;
        unitDimension = 8;
        values = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
        expResult = new VectorReal(3, values);
        result = VectorReal.Unit(firstDimension, dimensions, unitDimension);
        assertEquals(expResult, result);
    }

    /**
     * Test of Unit method, of class VectorReal, for a unit dimension out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testUnit_3args_UnitDimensionOutOfRange() {
        System.out.println("Unit(int, int, int)");
        int firstDimension = 5;
        int dimensions = 10;
        int unitDimension = 2;
        VectorReal.Unit(firstDimension, dimensions, unitDimension);
    }

    /**
     * Test of Unit method, of class VectorReal, for a negative number of dimensions.
     */
    @Test (expected=NegativeArraySizeException.class)
    public void testUnit_3args_NegativeDimensions() {
        System.out.println("Unit(int, int, int)");
        int firstDimension = 5;
        int dimensions = -1;
        int unitDimension = 6;
        VectorReal.Unit(firstDimension, dimensions, unitDimension);
    }
}