/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Vector;

import Mathematics.Complex;
import Mathematics.Norm.ComplexPower;
import Mathematics.Norm.VectorComplexPower;
import Time.Periods.GregorianDay;
import org.hamcrest.Description;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Vector.VectorComplex.
 * @author Rune Dahl Iversen
 */
public class VectorComplexTest {
    private Complex[] _values;
    private VectorComplex _vector;
    private VectorComplex _dim4;
    private VectorComplex _dim1Though4;
    private VectorComplex _dim3;

    public VectorComplexTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception { // Intentional
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._values = new Complex[]{Complex.RealNumber(4.0), Complex.Cartesian(3.2, -2.0), Complex.Cartesian(-1.54, 1.5), Complex.RealNumber(-Math.PI)};
        this._vector = new VectorComplex(this._values);

        Complex[] values = new Complex[]{Complex.RealNumber(1.0), Complex.RealNumber(2.0), Complex.RealNumber(3.0), Complex.RealNumber(4.0)};
        this._dim4 = new VectorComplex(values);

        this._dim1Though4 = new VectorComplex(1, values);

        values = new Complex[]{Complex.RealNumber(1.0), Complex.RealNumber(2.0), Complex.RealNumber(3.0)};
        this._dim3 = new VectorComplex(values);
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
     * Test of constructor, of class VectorComplex, taking one integer input.
     */
    @Test
    public void testCtor_int() {
        System.out.println("ctor(int)");
        VectorComplex vector = new VectorComplex(1);
        VectorComplex expResult = new VectorComplex(new Complex[] {Complex.Origin});
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorComplex, taking two integer inputs.
     */
    @Test
    public void testCtor_int_int() {
        System.out.println("ctor(int, int)");
        VectorComplex vector = new VectorComplex(1, 3);
        VectorComplex expResult = new VectorComplex(1, new Complex[] {Complex.Origin, Complex.Origin, Complex.Origin});
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorComplex,
     * taking two inputs: integer and Complex.
     */
    @Test
    public void testCtor_int_Complex() {
        System.out.println("ctor(int, Complex)");
        VectorComplex vector = new VectorComplex(1, Complex.RealNumber(3.0));
        VectorComplex expResult = new VectorComplex(0, new Complex[] {Complex.RealNumber(3.0)});
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorComplex,
     * taking three inputs: two integers and a Complex.
     */
    @Test
    public void testCtor_int_int_Complex() {
        System.out.println("ctor(int, int, Complex)");
        VectorComplex vector = new VectorComplex(1, 4, Complex.RealNumber(3.0));
        VectorComplex expResult = new VectorComplex(1, new Complex[] {Complex.RealNumber(3.0), Complex.RealNumber(3.0), Complex.RealNumber(3.0), Complex.RealNumber(3.0)});
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorComplex,
     * taking an array of Complex as input.
     */
    @Test
    public void testCtor_array() {
        System.out.println("ctor(Complex[])");
        VectorComplex vector = new VectorComplex(new Complex[] {Complex.RealNumber(3.0), Complex.RealNumber(3.0), Complex.RealNumber(3.0), Complex.RealNumber(3.0)});
        VectorComplex expResult = new VectorComplex(4, Complex.RealNumber(3.0));
        assertEquals(vector, expResult);
    }

    /**
     * Test of constructor, of class VectorComplex,
     * taking two inputs: integer and an array of doubles as input.
     */
    @Test
    public void testCtor_int_array() {
        System.out.println("ctor(int, Complex[])");
        VectorComplex vector = new VectorComplex(5, new Complex[] {Complex.RealNumber(3.0), Complex.RealNumber(3.0), Complex.RealNumber(3.0), Complex.RealNumber(3.0)});
        VectorComplex expResult = new VectorComplex(5, 4, Complex.RealNumber(3.0));
        assertEquals(vector, expResult);
    }

    /**
     * Test of getDimensions method, of class VectorComplex.
     */
    @Test
    public void testGetDimensions() {
        System.out.println("getDimensions");
        VectorComplex instance = this._vector;
        int expResult = 4;
        int result = instance.getDimensions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstDimension method, of class VectorComplex.
     */
    @Test
    public void testGetFirstDimension() {
        System.out.println("getFirstDimension");
        VectorComplex instance = this._vector;
        int expResult = 0;
        int result = instance.getFirstDimension();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastDimension method, of class VectorComplex.
     */
    @Test
    public void testGetLastDimension() {
        System.out.println("getLastDimension");
        VectorComplex instance = this._vector;
        int expResult = 3;
        int result = instance.getLastDimension();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class VectorComplex.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        VectorComplex instance = this._vector;
        for (int dimension = 0; dimension < instance.getDimensions(); dimension++) {
            Complex expResult = this._values[dimension];
            Complex result = instance.getValue(dimension);
            assertEquals(expResult, result);
        }
        instance = this._dim3;
        for (int dimension = 0; dimension < instance.getDimensions(); dimension++) {
            Complex expResult = Complex.RealNumber(dimension + 1.0);
            Complex result = instance.getValue(dimension);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of hasSameDimensions method, of class VectorComplex.
     */
    @Test
    public void testHasSameDimensions() {
        System.out.println("hasSameDimensions");
        VectorComplex instance = this._vector;
        Vector<Complex> vector = this._dim4;
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
     * Test of hasSameDimensions method, of class VectorComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testHasSameDimensions_Null() {
        System.out.println("hasSameDimensions(null)");
        VectorComplex instance = this._vector;
        VectorComplex nullValue = null;
        instance.hasSameDimensions(nullValue);
    }

    /**
     * Test of setValue method, of class VectorComplex.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int dimension = 0;
        Complex value = Complex.RealNumber(Math.E);
        VectorComplex instance = this._vector;
        Complex[] values = new Complex[]{Complex.RealNumber(Math.E), Complex.Cartesian(3.2, -2.0), Complex.Cartesian(-1.54, 1.5), Complex.RealNumber(-Math.PI)};
        VectorComplex expResult = new VectorComplex(values);
        Vector<Complex> result = instance.setValue(dimension, value);
        assertThat(result, new VectorComplexMatcher(expResult, Math.pow(10.0, -8.0)));
    }

    /**
     * Test of setValue method, of class VectorComplex, for an index out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testSetValue_IndexOutOfRange() {
        System.out.println("setValue(index out of range, x)");
        int dimension = 22;
        Complex value = Complex.RealNumber(Math.E);
        VectorComplex instance = this._vector;
        instance.setValue(dimension, value);
    }

    /**
     * Test of setValue method, of class VectorComplex, for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_Null() {
        System.out.println("setValue(n, null)");
        int dimension = 0;
        Complex value = null;
        VectorComplex instance = this._vector;
        instance.setValue(dimension, value);
    }

    /**
     * Test of setValue method, of class VectorComplex, for a Complex.NaN value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_NaN() {
        System.out.println("setValue(n, Complex.NaN)");
        int dimension = 3;
        Complex value = Complex.NaN;
        VectorComplex instance = this._vector;
        instance.setValue(dimension, value);
    }

    /**
     * Test of setValue method, of class VectorComplex, for a Complex.Infinity value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetValue_Infinity() {
        System.out.println("setValue(n, Complex.Infinity)");
        int dimension = 3;
        Complex value = Complex.Infinity;
        VectorComplex instance = this._vector;
        instance.setValue(dimension, value);
    }

    /**
     * Test of sum method, of class VectorComplex.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Vector<Complex> value = this._dim4;
        VectorComplex instance = this._vector;
        Complex[] values = new Complex[]{Complex.RealNumber(5.0), Complex.RealNumber(5.2), Complex.RealNumber(1.46), Complex.RealNumber(0.8584073464102069)};
        Vector expResult = new VectorComplex(values);
        Vector result = instance.sum(value);
    }

    /**
     * Test of sum method, of class VectorComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSum_Null() {
        System.out.println("sum(null)");
        Vector<Complex> value = null;
        VectorComplex instance = this._vector;
        instance.sum(value);
    }

    /**
     * Test of sum method, of class VectorComplex, for vector with the wrong number of dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSum_WrongDimensions() {
        System.out.println("sum(wrong dimensions vector)");
        Vector<Complex> value = this._dim3;
        VectorComplex instance = this._vector;
        instance.sum(value);
    }

    /**
     * Test of sum method, of class VectorComplex, for a vector with a wrong first dimension.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSum_WrongFirstDimension() {
        System.out.println("sum(wrong first dimension vector)");
        Vector<Complex> value = this._dim1Though4;
        VectorComplex instance = this._vector;
        instance.sum(value);
    }

    /**
     * Test of equals method, of class VectorComplex, for an object.
     */
    @Test
    public void testEquals_Object() {
        System.out.println("equals(object)");
        Object obj = new GregorianDay(1);
        VectorComplex instance = this._vector;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class VectorComplex.
     */
    @Test
    public void testEquals_VectorComplex() {
        System.out.println("equals");
        VectorComplex vector = this._vector;
        VectorComplex instance = this._vector;
        boolean expResult = true;
        boolean result = instance.equals(vector);
        assertEquals("Equals self.", expResult, result);

        vector = new VectorComplex(this._values);
        result = instance.equals(vector);
        assertEquals("Equals clone.", expResult, result);

        expResult = false;
        vector = this._dim3;
        result = instance.equals(vector);
        assertEquals("Does not equal different dimensions.", expResult, result);

        vector = this._dim4;
        result = instance.equals(vector);
        assertEquals("Does not equal different values.", expResult, result);

        Vector<Complex> temp = this._dim1Though4;
        for (int dim = 0; dim < instance.getDimensions(); dim++) {
            temp = temp.setValue(dim+1, instance.getValue(dim));
        }
        result = instance.equals(temp);
        assertEquals("Does not equal different first dimension.", expResult, result);
    }

    /**
     * Test of equals method, of class VectorComplex, for a null value.
     */
    @Test
    public void testEquals_Null() {
        System.out.println("equals(null)");
        VectorComplex instance = this._vector;
        boolean expResult = false;
        VectorComplex nullValue = null;
        boolean result = instance.equals(nullValue);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class VectorComplex.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        VectorComplex instance = this._vector;
        int expResult = 726099782;
        int result = instance.hashCode();
        assertEquals(expResult, result);

        instance = this._dim3;
        expResult = -587172769;
        result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class VectorComplex.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Vector<Complex> value = this._vector;
        VectorComplex instance = this._dim4;
        Complex[] values = new Complex[]{Complex.RealNumber(-3.0), Complex.Cartesian(-1.2000000000000002, 2.0), Complex.Cartesian(4.54, -1.5), Complex.RealNumber(+4.0 + Math.PI)};
        Vector<Complex> expResult = new VectorComplex(values);
        Vector<Complex> result = instance.subtract(value);
        assertThat(result, new VectorComplexMatcher(expResult, Math.pow(10.0, -8.0)));
    }

    /**
     * Test of subtract method, of class VectorComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSubtract_Null() {
        System.out.println("subtract(null)");
        Vector<Complex> value = null;
        VectorComplex instance = this._vector;
        instance.subtract(value);
    }

    /**
     * Test of subtract method, of class VectorComplex, for vector with the wrong number of dimensions.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSubtract_WrongDimensions() {
        System.out.println("subtract(wrong dimensions vector)");
        Vector<Complex> value = this._dim3;
        VectorComplex instance = this._vector;
        instance.subtract(value);
    }

    /**
     * Test of subtract method, of class VectorComplex, for a vector with a wrong first dimension.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSubtract_WrongFirstDimension() {
        System.out.println("subtract(wrong first dimension vector)");
        Vector<Complex> value = this._dim1Though4;
        VectorComplex instance = this._vector;
        instance.subtract(value);
    }

    /**
     * Test of scale method, of class VectorComplex.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        Complex scalar = Complex.RealNumber(Math.E);
        VectorComplex instance = this._vector;
        Complex[] values = new Complex[]{Complex.RealNumber(4.0*Math.E), Complex.Cartesian(3.2*Math.E, -2.0*Math.E), Complex.Cartesian(-1.54*Math.E, 1.5*Math.E), Complex.RealNumber(-Math.PI*Math.E)};
        Vector<Complex> expResult = new VectorComplex(values);
        Vector<Complex> result = instance.scale(scalar);
        assertThat(result, new VectorComplexMatcher(expResult, Math.pow(10.0, -5.0)));
    }

    /**
     * Test of scale method, of class VectorComplex, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testScale_Null() {
        System.out.println("scale(null)");
        Complex scalar = null;
        VectorComplex instance = this._vector;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class VectorComplex, for a Complex.NaN value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_NaN() {
        System.out.println("scale(Complex.NaN)");
        Complex scalar = Complex.NaN;
        VectorComplex instance = this._vector;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class VectorComplex, for a Complex.Infinity value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_Infinity() {
        System.out.println("scale(Complex.Infinity)");
        Complex scalar = Complex.Infinity;
        VectorComplex instance = this._vector;
        instance.scale(scalar);
    }

    /**
     * Test of toArray method, of class VectorComplex.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        VectorComplex instance = this._vector;
        Complex[] expResult = new Complex[]{Complex.RealNumber(4.0), Complex.Cartesian(3.2, -2.0), Complex.Cartesian(-1.54, 1.5), Complex.RealNumber(-Math.PI)};
        Complex[] result = instance.toArray();
        assertEquals("Wrong lenght of array.", expResult.length, result.length);
        for (int index = 0; index < result.length; index++)
            assertEquals("Wrong value for index " + Integer.toString(index),
                    expResult[index], result[index]);
    }

    /**
     * Test of toString method, of class VectorComplex.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VectorComplex instance = this._vector;
        String expResult = "[(4.0 + î 0.0) ; (3.2 + î -2.0) ; (-1.54 + î 1.5) ; (-3.141592653589793 + î 0.0)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of Unit method, of class VectorComplex.
     */
    @Test
    public void testUnit_int_int() {
        System.out.println("Unit(int, int)");
        int dimensions = 5;
        int unitDimension = 2;
        Complex[] values = new Complex[] {Complex.Origin, Complex.Origin, Complex.RealNumber(1.0), Complex.Origin, Complex.Origin};
        VectorComplex expResult = new VectorComplex(values);
        VectorComplex result = VectorComplex.Unit(dimensions, unitDimension);
        assertThat(result, new VectorComplexMatcher(expResult, Math.pow(10.0, -8.0)));

        dimensions = 5;
        unitDimension = 4;
        values = new Complex[] {Complex.Origin, Complex.Origin, Complex.Origin, Complex.Origin, Complex.RealNumber(1.0)};
        expResult = new VectorComplex(values);
        result = VectorComplex.Unit(dimensions, unitDimension);
        assertThat(result, new VectorComplexMatcher(expResult, Math.pow(10.0, -8.0)));
    }

    /**
     * Test of Unit method, of class VectorComplex, for a unit dimension out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testUnit_int_int_UnitDimensionOutOfRange() {
        System.out.println("Unit(int, index out of )");
        int dimensions = 5;
        int unitDimension = 5;
        Complex[] values = new Complex[] {Complex.Origin, Complex.Origin, Complex.RealNumber(1.0), Complex.Origin, Complex.Origin};
        VectorComplex expResult = new VectorComplex(values);
        VectorComplex result = VectorComplex.Unit(dimensions, unitDimension);
        assertEquals(expResult, result);
    }

    /**
     * Test of Unit method, of class VectorComplex, for a negative number of dimensions.
     */
    @Test (expected=NegativeArraySizeException.class)
    public void testUnit_int_int_NegativeDimensions() {
        System.out.println("Unit(int, index out of )");
        int dimensions = -3;
        int unitDimension = 5;
        VectorComplex.Unit(dimensions, unitDimension);
    }

    /**
     * Test of Unit method, of class VectorComplex.
     */
    @Test
    public void testUnit_3args() {
        System.out.println("Unit(int, int, int)");
        int firstDimension = 5;
        int dimensions = 3;
        int unitDimension = 6;
        Complex[] values = new Complex[] {Complex.Origin, Complex.RealNumber(1.0), Complex.Origin};
        VectorComplex expResult = new VectorComplex(5, values);
        VectorComplex result = VectorComplex.Unit(firstDimension, dimensions, unitDimension);
        assertThat(result, new VectorComplexMatcher(expResult, Math.pow(10.0, -8.0)));

        firstDimension = 3;
        dimensions = 10;
        unitDimension = 8;
        values = new Complex[] {Complex.Origin, Complex.Origin, Complex.Origin, Complex.Origin, Complex.Origin, Complex.RealNumber(1.0), Complex.Origin, Complex.Origin, Complex.Origin, Complex.Origin};
        expResult = new VectorComplex(3, values);
        result = VectorComplex.Unit(firstDimension, dimensions, unitDimension);
        assertThat(result, new VectorComplexMatcher(expResult, Math.pow(10.0, -8.0)));
    }

    /**
     * Test of Unit method, of class VectorComplex, for a unit dimension out of range.
     */
    @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testUnit_3args_UnitDimensionOutOfRange() {
        System.out.println("Unit(int, int, int)");
        int firstDimension = 5;
        int dimensions = 10;
        int unitDimension = 2;
        VectorComplex.Unit(firstDimension, dimensions, unitDimension);
    }

    /**
     * Test of Unit method, of class VectorComplex, for a negative number of dimensions.
     */
    @Test (expected=NegativeArraySizeException.class)
    public void testUnit_3args_NegativeDimensions() {
        System.out.println("Unit(int, int, int)");
        int firstDimension = 5;
        int dimensions = -1;
        int unitDimension = 6;
        VectorComplex.Unit(firstDimension, dimensions, unitDimension);
    }

    private class VectorComplexMatcher extends org.hamcrest.BaseMatcher<Vector<Complex>> {
        private Vector<Complex> _expResult;
        private Mathematics.Equality.NormAbsolute<Vector<Complex>> _equals;
        public VectorComplexMatcher(final Vector<Complex> expResult, final double precision) {
            VectorComplexPower norm = new VectorComplexPower(2.0, new ComplexPower(2.0));
            this._equals = new Mathematics.Equality.NormAbsolute<Vector<Complex>>(precision, norm);
            this._expResult = expResult;
        }

        @Override
        public boolean matches(Object o) {
            if (o instanceof Vector) {
                Vector<Complex> c = (Vector<Complex>)o;
                return this._equals.value(c, this._expResult);
            }
            else
                return false;
        }

        @Override
        public void describeTo(Description d) {
            d.appendText(this._expResult.toString());
        }
    }
}