/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Constraint;

import Mathematics.Matrix.Matrix;
import Mathematics.Vector.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Methods to facilitate unit testing for implementations of the interface
 * Mathematics.Constraint.Affine.
 * @author Rune Dahl Iversen
 */
public class AffineTest {
    public AffineTest() { // Intentional
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
     * Test of getMatrix method, of class Affine.
     */
    public void testGetMatrix(final Affine instance,
            final Matrix<Double> expResult) {
        Matrix result = instance.getMatrix();
        assertEquals("getMatrix of " + instance.toString(), expResult, result);
    }

    /**
     * Test of getVector method, of class Affine.
     */
    public void testGetVector(final Affine instance,
            final Vector<Double> expResult) {
        Vector result = instance.getVector();
        assertEquals("getVector of " + instance.toString(), expResult, result);
    }

    /**
     * Test of setMatrix method, of class Affine.
     */
    public void testSetMatrix(final Affine instance,
            final Matrix<Double> matrix) {
        instance.setMatrix(matrix);
        this.testGetMatrix(instance, matrix);
    }

    /**
     * Test of setVector method, of class Affine.
     */
    public void testSetVector(final Affine instance,
            final Vector<Double> vector) {
        instance.setVector(vector);
        this.testGetVector(instance, vector);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}