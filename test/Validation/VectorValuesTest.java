/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Validation;

import Mathematics.Vector.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit test for the class Validation.VectorValues.
 * @author Rune Dahl Iversen
 */
public class VectorValuesTest {
    private VectorValues<Double> _instance;
    private Vector<Double> _nan;
    private Vector<Double> _inf;
    private Vector<Double> _normal;

    public VectorValuesTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Validation.VectorValues<T>");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._instance = new VectorValues<Double>(Factory.FiniteReal());
        this._nan = new TestVector(Double.NaN);
        this._inf = new TestVector(Double.POSITIVE_INFINITY);
        this._normal = VectorReal.Unit(3, 1);
    }

    @After
    public void tearDown() {
        this._instance = null;
        this._nan = null;
        this._inf = null;
        this._normal = null;
    }

    /**
     * Test of getValueValidator method, of class VectorValues.
     */
    @Test
    public void testGetValueValidator() {
        System.out.println("getValueValidator");
        VectorValues<Double> instance = this._instance;
        Validator<Double> result = instance.getValueValidator();
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> a = (And<Double>)result;
        assertEquals("Wrong number of elements in result.", 3, a.size());
    }

    /**
     * Test of setValueValidator method, of class VectorValues.
     */
    @Test
    public void testSetValueValidator() {
        System.out.println("setValueValidator");
        VectorValues<Double> instance = this._instance;
        Validator<Double> valueValidator = Factory.Real();
        instance.setValueValidator(valueValidator);
        Validator<Double> result = instance.getValueValidator();
        assertTrue("Wrong type of result.", result instanceof And);
        And<Double> a = (And<Double>)result;
        assertEquals("Wrong number of elements in result.", 2, a.size());
    }

    /**
     * Test of setValueValidator method, of class VectorValues, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetValueValidator_Null() {
        System.out.println("setValueValidator(null)");
        VectorValues<Double> instance = this._instance;
        Validator<Double> valueValidator = null;
        instance.setValueValidator(valueValidator);
    }

    /**
     * Test of isValid method, of class VectorValues.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        Validator<Vector<Double>> instance = this._instance;
        Vector<Double> value = null;
        boolean expResult = false;
        boolean result = instance.isValid(value);
        assertEquals("null", expResult, result);

        value = this._nan;
        expResult = false;
        result = instance.isValid(value);
        assertEquals("Vector of Double.NaN", expResult, result);

        value = this._inf;
        expResult = false;
        result = instance.isValid(value);
        assertEquals("Vector of Double.INF", expResult, result);

        value = this._normal;
        expResult = true;
        result = instance.isValid(value);
        assertEquals(value.toString(), expResult, result);

        this._instance.setValueValidator(Factory.FiniteRealLessThan(0.5));
        value = this._normal;
        expResult = false;
        result = instance.isValid(value);
        assertEquals(value.toString(), expResult, result);
    }

    /**
     * Test of message method, of class VectorValues.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        Validator<Vector<Double>> instance = this._instance;
        Vector<Double> value = null;
        String name = null;
        String expResult = "null is null.";
        String result = instance.message(value, name);
        assertEquals("null", expResult, result);

        value = this._nan;
        name = "Vector name";
        expResult = "Vector name (Dimension 0 is not a number (Double.NaN)) (Dimension 1 is not a number (Double.NaN)) (Dimension 2 is not a number (Double.NaN))";
        result = instance.message(value, name);
        assertEquals("Vector of Double.NaN", expResult, result);

        value = this._inf;
        expResult = "Vector name (Dimension 0 is not finite) (Dimension 1 is not finite) (Dimension 2 is not finite)";
        result = instance.message(value, name);
        assertEquals("Vector of Double.INF", expResult, result);

        value = this._normal;
        expResult = "";
        result = instance.message(value, name);
        assertEquals("Normal vector", expResult, result);

        this._instance.setValueValidator(Factory.FiniteRealLessThan(0.5));
        value = this._normal;
        expResult = "Vector name (Dimension 1 must be less than 0.5)";
        result = instance.message(value, name);
        assertEquals(value.toString(), expResult, result);
    }

    /**
     * Helper class to imitate a vector with the values Double.NaN or the like.
     */
    private class TestVector implements Vector<Double> {
        private double _value;

        public TestVector(final double value) {
            this._value = value;
        }

        @Override
        public int getDimensions() {
            return 3;
        }

        @Override
        public int getFirstDimension() {
            return 0;
        }

        @Override
        public int getLastDimension() {
            return 2;
        }

        @Override
        public Double getValue(int dimension) {
            return this._value;
        }

        @Override
        public boolean hasSameDimensions(Vector<Double> vector) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Double> setValue(int dimension, Double value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Double[] toArray() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Double> sum(Vector<Double> value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Double> scale(Double scalar) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vector<Double> subtract(Vector<Double> value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}