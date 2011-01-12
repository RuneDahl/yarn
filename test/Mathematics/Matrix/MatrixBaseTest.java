/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Matrix;

import Mathematics.Vector.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * jUnit-test for the class Mathematics.Matrix.MatrixBase.
 * @author Rune Dahl Iversen
 */
public class MatrixBaseTest {

    public MatrixBaseTest() { // Intentional
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
     * Test of SwitchColumns method, of class MatrixBase.
     */
    public void testSwitchColumns(final MatrixBase matrix,
            final int column1, final int column2, final MatrixBase expResult) {
        matrix.switchColumns(column1, column2);
        assertEquals(expResult, matrix);
    }

    /**
     * Test of SwitchRows method, of class MatrixBase.
     */
    public void testSwitchRows(final MatrixBase matrix,
            final int row1, final int row2, final MatrixBase expResult) {
        matrix.switchRows(row1, row2);
        assertEquals(expResult, matrix);
    }

    /**
     * Test of getFirstColumn method, of class MatrixBase.
     */
    public void testGetFirstColumn(final MatrixBase matrix, final int expResult) {
        int result = matrix.getFirstColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstRow method, of class MatrixBase.
     */
    public void testGetFirstRow(final MatrixBase matrix, final int expResult) {
        int result = matrix.getFirstRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastColumn method, of class MatrixBase.
     */
    public void testGetLastColumn(final MatrixBase matrix, final int expResult) {
        int result = matrix.getLastColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastRow method, of class MatrixBase.
     */
    public void testGetLastRow(final MatrixBase matrix, final int expResult) {
        int result = matrix.getLastRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasSameColumns method, of class MatrixBase.
     */
    public void testHasSameColumns_Vector(final MatrixBase matrix,
            final Vector vector, final boolean expResult) {
        boolean result = matrix.hasSameColumns(vector);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasSameColumns method, of class MatrixBase.
     */
    public void testHasSameColumns_Matrix(final MatrixBase matrix,
            final Matrix matrix2, final boolean expResult) {
        boolean result = matrix.hasSameColumns(matrix2);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasSameDimensions method, of class MatrixBase.
     */
    public void testHasSameDimensions(final MatrixBase matrix,
            final Matrix matrix2, final boolean expResult) {
        boolean result = matrix.hasSameDimensions(matrix2);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasSameRows method, of class MatrixBase.
     */
    public void testHasSameRows_Vector(final MatrixBase matrix,
            final Vector vector, final boolean expResult) {
        boolean result = matrix.hasSameRows(vector);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasSameRows method, of class MatrixBase.
     */
    public void testHasSameRows_Matrix(final MatrixBase matrix,
            final Matrix matrix2, final boolean expResult) {
        boolean result = matrix.hasSameRows(matrix2);
        assertEquals(expResult, result);
    }

    /**
     * Test of isSquare method, of class MatrixBase.
     */
    public void testIsSquare(MatrixBase matrix, boolean expResult) {
        boolean result = matrix.isSquare();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColumn method, of class MatrixBase.
     */
    public void testSetColumn(final MatrixBase matrix,
            final Vector vector, final int column, final Matrix expResult) {
        matrix.setColumn(column, vector);
        assertEquals(expResult, matrix);
    }

    /**
     * Test of setRow method, of class MatrixBase.
     */
    public void testSetRow(final MatrixBase matrix,
            final Vector vector, final int row, final Matrix expResult) {
        matrix.setRow(row, vector);
        assertEquals(expResult, matrix);
    }

    /**
     * Blank test to allow this setup.
     */
    @Test
    public void testBlank() {
        assertTrue(true);
    }
}