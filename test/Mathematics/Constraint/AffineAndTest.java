/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import Mathematics.Matrix.Matrix;
import Mathematics.Matrix.MatrixReal;
import Mathematics.Vector.Vector;
import Mathematics.Vector.VectorReal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * jUnit test for the class Mathematics.Constraint.AffineAnd.
 * @author Rune Dahl Iversen
 */
public class AffineAndTest {
    private AffineAnd _instance;
    private AffineTest _affine;
    private ConstraintTest<Vector<Double>> _constraint;

    public AffineAndTest() { // Intentional
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Mathematics.Constraint.AffineAnd");
    }

    @AfterClass
    public static void tearDownClass() throws Exception { // Intentional
    }

    @Before
    public void setUp() {
        this._affine = new AffineTest();
        this._constraint = new ConstraintTest<Vector<Double>>();
        Matrix<Double> m = MatrixReal.Identity(0, 2);
        m.setValue(0, 1, 1.0);
        Vector<Double> v = VectorReal.Unit(2, 0);
        this._instance = new AffineAnd(m, v);
    }

    @After
    public void tearDown() {
        this._affine = null;
        this._constraint = null;
        this._instance = null;
    }

    /**
     * Test of getMatrix method, of class AffineAnd.
     */
    @Test
    public void testGetMatrix() {
        System.out.println("getMatrix");
        double[][] values = new double[2][2];
        values[0][0] = 1.0;
        values[0][1] = 1.0;
        values[1][1] = 1.0;
        Matrix<Double> expResult = new MatrixReal(values);
        this._affine.testGetMatrix(this._instance, expResult);
    }

    /**
     * Test of getVector method, of class AffineAnd.
     */
    @Test
    public void testGetVector() {
        System.out.println("getVector");
        double[] values = new double[2];
        values[0] = 1.0;
        Vector<Double> expResult = new VectorReal(values);
        this._affine.testGetVector(this._instance, expResult);
    }

    /**
     * Test of setMatrix method, of class AffineAnd.
     */
    @Test
    public void testSetMatrix() {
        System.out.println("setMatrix");
        double[][] values = new double[2][2];
        values[0][0] = 1.0;
        values[1][0] = 1.0;
        values[1][1] = 1.0;
        Matrix<Double> expResult = new MatrixReal(values);
        this._affine.testSetMatrix(this._instance, expResult);
    }

    /**
     * Test of setMatrix method, of class AffineAnd, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetMatrix_Null() {
        System.out.println("setMatrix(null)");
        Matrix<Double> expResult = null;
        this._affine.testSetMatrix(this._instance, expResult);
    }

    /**
     * Test of setVector method, of class AffineAnd.
     */
    @Test
    public void testSetVector() {
        System.out.println("setVector");
        double[] values = new double[2];
        values[1] = 1.0;
        Vector<Double> expResult = new VectorReal(values);
        this._affine.testSetVector(this._instance, expResult);
    }

    /**
     * Test of setVector method, of class AffineAnd, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testSetVector_Null() {
        System.out.println("setVector(null)");
        Vector<Double> expResult = null;
        this._affine.testSetVector(this._instance, expResult);
    }

    /**
     * Test of isBinding method, of class AffineAnd.
     */
    @Test
    public void testIsBinding() {
        System.out.println("isBinding");
        AffineAnd instance = this._instance;

        Vector<Double> value = new VectorReal(2);
        boolean expResult = true;
        this._constraint.testIsBinding(instance, value, expResult);

        value = value.setValue(0, 1.0);
        this._constraint.testIsBinding(instance, value, expResult);

        expResult = false;
        value = new VectorReal(2, 2.0);
        this._constraint.testIsBinding(instance, value, expResult);
    }

    /**
     * Test of isBinding method, of class AffineAnd, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsBinding_Null() {
        System.out.println("isBinding(null)");
        Vector<Double> value = null;
        this._constraint.testIsBinding(this._instance, value, false);
    }

    /**
     * Test of isFeasible method, of class AffineAnd.
     */
    @Test
    public void testIsFeasible() {
        System.out.println("isFeasible");
        AffineAnd instance = this._instance;

        Vector<Double> value = new VectorReal(2);
        boolean expResult = true;
        this._constraint.testIsFeasible(instance, value, expResult);

        expResult = false;
        value = new VectorReal(2, -2.0);
        this._constraint.testIsFeasible(instance, value, expResult);
    }

    /**
     * Test of isFeasible method, of class AffineAnd, for a null value.
     */
    @Test (expected=NullPointerException.class)
    public void testIsFeasible_Null() {
        System.out.println("isFeasible(null)");
        Vector<Double> value = null;
        this._constraint.testIsFeasible(this._instance, value, false);
    }
}