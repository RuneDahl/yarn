/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Function;

import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Mathematics.Function.PolynomialReal.
 * @author Rune Dahl Iversen
 */
public class PolynomialRealTest {
    private PolynomialTest<Double, Double, Double> _tester;
    private Polynomial<Double, Double, Double> _instance;

    public PolynomialRealTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Function.PolynomialReal");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._tester = new PolynomialTest<Double, Double, Double>();
        this._instance = new PolynomialReal(3);
        for (int i = 0; i < 4; i++)
            this._instance = this._instance.setCoefficient(i, i + 1.0);
    }

    @After
    public void tearDown() {
        this._tester = null;
        this._instance = null;
    }

    /**
     * Test of constructor, of class PolynomialReal, that take a vector.
     */
    @Test
    public void testCtor_Vector() {
        System.out.println("PolynomialReal(Vector<Double>)");
        Vector<Double> vector = new VectorReal(7);
        for (int d = 0; d <= vector.getLastDimension(); d++)
            vector = vector.setValue(d, Math.pow(-1.0, d) * (d + 2));
        PolynomialReal instance = new PolynomialReal(vector);

        assertNotNull("Result from ctor(Vector).", vector);
        assertEquals("Degree of result from ctor(Vector).", 6, instance.getDegree());
        for (int d = 0; d <= instance.getDegree(); d++)
            this._tester.testGetCoefficient(instance, d, vector.getValue(d));
    }

    /**
     * Test of constructor, of class PolynomialReal,
     * that take a vector of the wrong first dimension.
     */
    @Test (expected=IndexOutOfBoundsException.class)
    public void testCtor_Vector_WrongFirstDimension() {
        System.out.println("PolynomialReal(Vector<Double> wrong first dim)");
        Vector<Double> vector = new VectorReal(1, 7);
        for (int d = 1; d <= vector.getLastDimension(); d++)
            vector = vector.setValue(d, Math.pow(-1.0, d) * (d + 2));
        new PolynomialReal(vector);
    }

    /**
     * Test of getCoefficient method, of class PolynomialReal.
     */
    @Test
    public void testGetCoefficient() {
        System.out.println("getCoefficient");
        Polynomial<Double, Double, Double> instance = this._instance;
        for (int degree = 0; degree < instance.getDegree() + 1; degree++) {
            this._tester.testGetCoefficient(instance, degree, degree + 1.0);
        }
    }

    /**
     * Test of getDegree method, of class PolynomialReal.
     */
    @Test
    public void testGetDegree() {
        System.out.println("getDegree");
        Polynomial<Double, Double, Double> instance = this._instance;
        int expResult = 3;
        this._tester.testGetDegree(instance, expResult);
    }

    /**
     * Test of setCoefficient method, of class PolynomialReal.
     */
    @Test
    public void testSetCoefficient() {
        System.out.println("setCoefficient");
        Polynomial<Double, Double, Double> instance = this._instance;
        for (int degree = 0; degree < instance.getDegree() + 1; degree++) {
            Double value = 17.0;
            double[] values = new double[4];
            for (int i = 0; i < values.length; i++)
                values[i] = i + 1.0;
            values[degree] = value;
            Polynomial<Double, Double, Double> expResult = new PolynomialReal(values);
            this._tester.testSetCoefficient(instance, degree, value, expResult);
        }
    }

    /**
     * Test of setCoefficient method, of class PolynomialReal,
     * for a negative degree.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCoefficient_DegreeNegative() {
        System.out.println("setCoefficient(-1, v)");
        Polynomial<Double, Double, Double> instance = this._instance;
        int degree = -1;
        Double value = 17.0;
        this._tester.testSetCoefficient(instance, degree, value, null);
    }

    /**
     * Test of setCoefficient method, of class PolynomialReal,
     * for a too high degree.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCoefficient_DegreeTooHigh() {
        System.out.println("setCoefficient(5, v)");
        Polynomial<Double, Double, Double> instance = this._instance;
        int degree = 5;
        Double value = 17.0;
        this._tester.testSetCoefficient(instance, degree, value, null);
    }

    /**
     * Test of setCoefficient method, of class PolynomialReal,
     * for a null value.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCoefficient_NullValue() {
        System.out.println("setCoefficient(d, null)");
        Polynomial<Double, Double, Double> instance = this._instance;
        int degree = 0;
        Double value = null;
        this._tester.testSetCoefficient(instance, degree, value, null);
    }

    /**
     * Test of setCoefficient method, of class PolynomialReal,
     * for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCoefficient_NaN() {
        System.out.println("setCoefficient(d, Double.NaN)");
        Polynomial<Double, Double, Double> instance = this._instance;
        int degree = 0;
        Double value = Double.NaN;
        this._tester.testSetCoefficient(instance, degree, value, null);
    }

    /**
     * Test of setCoefficient method, of class PolynomialReal,
     * for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCoefficient_NegativeInfinity() {
        System.out.println("setCoefficient(d, Double.NEGATIVE_INFINITY)");
        Polynomial<Double, Double, Double> instance = this._instance;
        int degree = 0;
        Double value = Double.NEGATIVE_INFINITY;
        this._tester.testSetCoefficient(instance, degree, value, null);
    }

    /**
     * Test of setCoefficient method, of class PolynomialReal,
     * for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetCoefficient_PositiveInfinity() {
        System.out.println("setCoefficient(d, Double.POSITIVE_INFINITY)");
        Polynomial<Double, Double, Double> instance = this._instance;
        int degree = 0;
        Double value = Double.POSITIVE_INFINITY;
        this._tester.testSetCoefficient(instance, degree, value, null);
    }

    /**
     * Test of getDifferential method, of class PolynomialReal.
     */
    @Test
    public void testGetDifferential() {
        System.out.println("getDifferential");
        Polynomial<Double, Double, Double> instance = this._instance;
        double[] values = new double[3];
        for (int i = 0; i < values.length; i++)
            values[i] = (i + 2.0) * (i + 1.0);
        Function expResult = new PolynomialReal(values);
        this._tester.testGetDifferential(instance, expResult);
    }

    /**
     * Test of getDifferential method, of class PolynomialReal.
     */
    @Test
    public void testGetDifferential_Double() {
        System.out.println("getDifferential(Double)");
        Double input = 7.4;
        Polynomial<Double, Double, Double> instance = this._instance;
        Double expResult = 703.5200000000001;
        this._tester.testGetDifferential_Value(instance, input, expResult);
    }

    /**
     * Test of getDifferential method, of class PolynomialReal,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testGetDifferential_Null() {
        System.out.println("getDifferential(null)");
        Double input = null;
        Polynomial<Double, Double, Double> instance = this._instance;
        instance.getDifferential(input);
    }

    /**
     * Test of value method, of class PolynomialReal.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        Polynomial<Double, Double, Double> instance = this._instance;

        Double input = Double.NaN;
        Double expResult = Double.NaN;
        this._tester.testValue(instance, input, expResult);

        input = Double.NEGATIVE_INFINITY;
        expResult = Double.NaN;
        this._tester.testValue(instance, input, expResult);

        input = Double.POSITIVE_INFINITY;
        expResult = Double.NaN;
        this._tester.testValue(instance, input, expResult);

        input = 0.0;
        expResult = 1.0;
        this._tester.testValue(instance, input, expResult);

        input = 1.0;
        expResult = 10.0;
        this._tester.testValue(instance, input, expResult);

        input = -1.0;
        expResult = -2.0;
        this._tester.testValue(instance, input, expResult);
    }

    /**
     * Test of value method, of class PolynomialReal,
     * for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testValue_Null() {
        System.out.println("value");
        Double input = null;
        Polynomial<Double, Double, Double> instance = this._instance;
        instance.value(input);
    }

    /**
     * Test of sum method, of class PolynomialReal.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Polynomial<Double, Double, Double> instance = this._instance;

        double[] values;

        values = new double[4];
        for (int i = 0; i < values.length; i++)
            values[i] = i + 1.0;
        Polynomial<Double, Double, Double> value = new PolynomialReal(values);
        values = new double[4];
        for (int i = 0; i < values.length; i++)
            values[i] = (i + 1.0);
        for (int i = 0; i < Math.min(values.length, instance.getDegree() + 1); i++)
            values[i] += instance.getCoefficient(i);
        Polynomial<Double, Double, Double> expResult = new PolynomialReal(values);

        this._tester.testSum(instance, value, expResult);

        values = new double[5];
        for (int i = 0; i < values.length; i++)
            values[i] = i + 1.0;
        value = new PolynomialReal(values);
        values = new double[5];
        for (int i = 0; i < values.length; i++)
            values[i] = (i + 1.0);
        for (int i = 0; i < Math.min(values.length, instance.getDegree() + 1); i++)
            values[i] += instance.getCoefficient(i);
        expResult = new PolynomialReal(values);

        this._tester.testSum(instance, value, expResult);

        values = new double[3];
        for (int i = 0; i < values.length; i++)
            values[i] = i + 1.0;
        value = new PolynomialReal(values);
        values = new double[Math.max(values.length, instance.getDegree() + 1)];
        for (int i = 0; i < 3; i++)
            values[i] = (i + 1.0);
        for (int i = 0; i < Math.min(values.length, instance.getDegree() + 1); i++)
            values[i] += instance.getCoefficient(i);
        expResult = new PolynomialReal(values);

        this._tester.testSum(instance, value, expResult);
    }

    /**
     * Test of sum method, of class PolynomialReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSum_Null() {
        System.out.println("sum(null)");
        Polynomial<Double, Double, Double> value = null;
        Polynomial<Double, Double, Double> instance = this._instance;
        instance.sum(value);
    }

    /**
     * Test of subtract method, of class PolynomialReal.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Polynomial<Double, Double, Double> instance = this._instance;

        double[] values;

        values = new double[4];
        for (int i = 0; i < values.length; i++)
            values[i] = i + 1.0;
        Polynomial<Double, Double, Double> value = new PolynomialReal(values);
        values = new double[4];
        for (int i = 0; i < values.length; i++)
            values[i] = -(i + 1.0);
        for (int i = 0; i < Math.min(values.length, instance.getDegree() + 1); i++)
            values[i] += instance.getCoefficient(i);
        Polynomial<Double, Double, Double> expResult = new PolynomialReal(values);

        this._tester.testSubtract(instance, value, expResult);

        values = new double[5];
        for (int i = 0; i < values.length; i++)
            values[i] = i + 1.0;
        value = new PolynomialReal(values);
        values = new double[5];
        for (int i = 0; i < values.length; i++)
            values[i] = -(i + 1.0);
        for (int i = 0; i < Math.min(values.length, instance.getDegree() + 1); i++)
            values[i] += instance.getCoefficient(i);
        expResult = new PolynomialReal(values);

        this._tester.testSubtract(instance, value, expResult);

        values = new double[3];
        for (int i = 0; i < values.length; i++)
            values[i] = i + 1.0;
        value = new PolynomialReal(values);
        values = new double[Math.max(values.length, instance.getDegree() + 1)];
        for (int i = 0; i < 3; i++)
            values[i] = -(i + 1.0);
        for (int i = 0; i < Math.min(values.length, instance.getDegree() + 1); i++)
            values[i] += instance.getCoefficient(i);
        expResult = new PolynomialReal(values);

        this._tester.testSubtract(instance, value, expResult);
    }

    /**
     * Test of subtract method, of class PolynomialReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSubtract_Null() {
        System.out.println("subtract(null)");
        Polynomial<Double, Double, Double> value = null;
        Polynomial<Double, Double, Double> instance = this._instance;
        instance.subtract(value);
    }

    /**
     * Test of product method, of class PolynomialReal.
     */
    @Test
    public void testProduct() {
        System.out.println("product");
        Polynomial<Double, Double, Double> factor = this._instance;
        Polynomial<Double, Double, Double> instance = this._instance;
        double[] values = new double[7];
        values[0] = 1.0;
        values[1] = 4.0;
        values[2] = 10.0;
        values[3] = 20.0;
        values[4] = 25.0;
        values[5] = 24.0;
        values[6] = 16.0;
        Polynomial<Double, Double, Double> expResult = new PolynomialReal(values);
        this._tester.testProduct(instance, factor, expResult);
    }

    /**
     * Test of product method, of class PolynomialReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testProduct_Null() {
        System.out.println("product(null)");
        Polynomial<Double, Double, Double> factor = null;
        Polynomial<Double, Double, Double> instance = this._instance;
        instance.product(factor);
    }

    /**
     * Test of scale method, of class PolynomialReal.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        Double scalar = 0.0;
        Polynomial<Double, Double, Double> instance = this._instance;
        Polynomial<Double, Double, Double> expResult = new PolynomialReal(3);

        this._tester.testScale(instance, scalar, expResult);

        scalar = 1.0;
        expResult = this._instance;

        this._tester.testScale(instance, scalar, expResult);

        scalar = -1.0;
        double[] values;
        values = new double[4];
        for (int i = 0; i < values.length; i++)
            values[i] = -(i + 1.0);
        expResult = new PolynomialReal(values);

        this._tester.testScale(instance, scalar, expResult);
    }

    /**
     * Test of scale method, of class PolynomialReal, for the value Double.NaN.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_NaN() {
        System.out.println("scale(Double.NaN)");
        Double scalar = Double.NaN;
        Polynomial<Double, Double, Double> instance = this._instance;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class PolynomialReal, for the value Double.NEGATIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_NegativeInfinity() {
        System.out.println("scale(Double.NEGATIVE_INFINITY)");
        Double scalar = Double.NEGATIVE_INFINITY;
        Polynomial<Double, Double, Double> instance = this._instance;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class PolynomialReal, for the value Double.POSITIVE_INFINITY.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testScale_PositiveInfinity() {
        System.out.println("scale(Double.POSITIVE_INFINITY)");
        Double scalar = Double.POSITIVE_INFINITY;
        Polynomial<Double, Double, Double> instance = this._instance;
        instance.scale(scalar);
    }

    /**
     * Test of scale method, of class PolynomialReal, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testScale_Null() {
        System.out.println("scale(null)");
        Double scalar = null;
        Polynomial<Double, Double, Double> instance = this._instance;
        instance.scale(scalar);
    }

    /**
     * Test of equals method, of class PolynomialReal.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Polynomial<Double, Double, Double> instance = this._instance;
        boolean expResult = true;

        Object o = this._instance;
        this._tester.testEquals(instance, o, expResult);

        double[] values = new double[4];
        for (int i = 0; i < values.length; i++)
            values[i] = (i + 1.0);
        o = new PolynomialReal(values);
        this._tester.testEquals(instance, o, expResult);

        expResult = false;

        o = null;
        this._tester.testEquals(instance, o, expResult);

        o = 7.5;
        this._tester.testEquals(instance, o, expResult);

        values = new double[5];
        for (int i = 0; i < values.length; i++)
            values[i] = (i + 1.0);
        o = new PolynomialReal(values);
        this._tester.testEquals(instance, o, expResult);

        values = new double[3];
        for (int i = 0; i < values.length; i++)
            values[i] = (i + 1.0);
        o = new PolynomialReal(values);
        this._tester.testEquals(instance, o, expResult);

        values = new double[4];
        for (int i = 0; i < values.length; i++)
            values[i] = (i + 1.0004);
        o = new PolynomialReal(values);
        this._tester.testEquals(instance, o, expResult);
    }

    /**
     * Test of hashCode method, of class PolynomialReal.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Polynomial<Double, Double, Double> instance = this._instance;
        int expResult = -1155131316;
        this._tester.testHashCode(instance, expResult);
    }

    /**
     * Test of toString method, of class PolynomialReal.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polynomial<Double, Double, Double> instance = this._instance;
        String expResult = "{Mathematics.Function.PolynomialReal[ +4.0*x^3 +3.0*x^2 +2.0*x^1 +1.0]}";
        this._tester.testToString(instance, expResult);

        instance = this._instance.scale(-1.0);
        expResult = "{Mathematics.Function.PolynomialReal[ -4.0*x^3 -3.0*x^2 -2.0*x^1 -1.0]}";
        this._tester.testToString(instance, expResult);
    }
}